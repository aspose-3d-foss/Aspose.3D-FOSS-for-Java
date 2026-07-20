package com.aspose.threed;

import java.util.ArrayList;
import java.util.List;

public class NurbsDirection {
    private final List<Double> knotVectors = new ArrayList<>();
    private final List<Integer> multiplicity = new ArrayList<>();
    private int order = 3;
    private int degree = 2;
    private int divisions = 10;
    private NurbsType type = NurbsType.OPEN;
    private int count = 4;

    public List<Double> getKnotVectors() {
        return knotVectors;
    }

    public List<Integer> getMultiplicity() {
        return multiplicity;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int value) {
        this.order = value;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int value) {
        this.degree = value;
    }

    public int getDivisions() {
        return divisions;
    }

    public void setDivisions(int value) {
        this.divisions = value;
    }

    public NurbsType getType() {
        return type;
    }

    public void setType(NurbsType value) {
        this.type = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int value) {
        this.count = value;
    }
}
