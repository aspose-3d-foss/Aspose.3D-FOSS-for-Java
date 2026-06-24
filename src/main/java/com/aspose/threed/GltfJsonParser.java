package com.aspose.threed;

import com.aspose.threed.*;
import java.util.*;

class GltfJsonParser {
    private String json;
    private int pos;

    GltfJsonParser(String json) {
        this.json = json;
        this.pos = 0;
    }

    Object parse() {
        skipWhitespace();
        if (pos >= json.length()) {
            return null;
        }
        char c = json.charAt(pos);
        if (c == '{') {
            return parseObject();
        } else if (c == '[') {
            return parseArray();
        } else if (c == '"') {
            return parseString();
        } else if (c == '-' || Character.isDigit(c)) {
            return parseNumber();
        } else if (json.startsWith("true", pos)) {
            pos += 4;
            return true;
        } else if (json.startsWith("false", pos)) {
            pos += 5;
            return false;
        } else if (json.startsWith("null", pos)) {
            pos += 4;
            return null;
        }
        return null;
    }

    private Map<String, Object> parseObject() {
        Map<String, Object> obj = new LinkedHashMap<>();
        pos++;

        while (pos < json.length()) {
            skipWhitespace();
            if (pos >= json.length()) break;
            if (json.charAt(pos) == '}') {
                pos++;
                return obj;
            }

            String key = parseString();
            skipWhitespace();
            if (pos < json.length() && json.charAt(pos) == ':') {
                pos++;
                skipWhitespace();
                Object value = parse();
                obj.put(key, value);
            }

            skipWhitespace();
            if (pos < json.length() && json.charAt(pos) == ',') {
                pos++;
            }
        }

        return obj;
    }

    private List<Object> parseArray() {
        List<Object> arr = new ArrayList<>();
        pos++;

        while (pos < json.length()) {
            skipWhitespace();
            if (pos >= json.length()) break;
            if (json.charAt(pos) == ']') {
                pos++;
                return arr;
            }

            Object value = parse();
            arr.add(value);

            skipWhitespace();
            if (pos < json.length() && json.charAt(pos) == ',') {
                pos++;
            }
        }

        return arr;
    }

    private String parseString() {
        pos++;
        StringBuilder sb = new StringBuilder();
        while (pos < json.length()) {
            char c = json.charAt(pos);
            if (c == '"') {
                pos++;
                return sb.toString();
            }
            if (c == '\\' && pos + 1 < json.length()) {
                pos++;
                char next = json.charAt(pos);
                switch (next) {
                    case '"': sb.append('"'); break;
                    case '\\': sb.append('\\'); break;
                    case '/': sb.append('/'); break;
                    case 'b': sb.append('\b'); break;
                    case 'f': sb.append('\f'); break;
                    case 'n': sb.append('\n'); break;
                    case 'r': sb.append('\r'); break;
                    case 't': sb.append('\t'); break;
                    case 'u':
                        if (pos + 4 < json.length()) {
                            String hex = json.substring(pos + 1, pos + 5);
                            pos += 4;
                            sb.append((char) Integer.parseInt(hex, 16));
                        }
                        break;
                    default: sb.append(next); break;
                }
                pos++;
            } else {
                sb.append(c);
                pos++;
            }
        }
        return sb.toString();
    }

    private Number parseNumber() {
        int start = pos;
        if (json.charAt(pos) == '-') pos++;
        while (pos < json.length()) {
            char c = json.charAt(pos);
            if (Character.isDigit(c) || c == '.' || c == 'e' || c == 'E' || c == '+' || c == '-') {
                pos++;
            } else {
                break;
            }
        }
        String numStr = json.substring(start, pos);
        if (numStr.contains(".") || numStr.toLowerCase().contains("e")) {
            return Double.parseDouble(numStr);
        } else {
            return Long.parseLong(numStr);
        }
    }

    private void skipWhitespace() {
        while (pos < json.length()) {
            char c = json.charAt(pos);
            if (c == ' ' || c == '\t' || c == '\n' || c == '\r') {
                pos++;
            } else {
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    static Map<String, Object> parseJson(String json) {
        GltfJsonParser parser = new GltfJsonParser(json);
        Object result = parser.parse();
        if (result instanceof Map) {
            return (Map<String, Object>) result;
        }
        return new LinkedHashMap<>();
    }
}
