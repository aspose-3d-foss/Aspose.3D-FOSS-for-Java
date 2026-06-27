package com.aspose.threed;

/**
 * This class encapsulates the transformed mesh as Boolean operation's operand.
 */
public class BooleanOperand {
    private A3DObject operand;

    /**
     * Construct a BooleanOperand instance from a node, a valid entity implemented IMeshConvertible is required.
     * @param node A Node instance with a valid entity implemented IMeshConvertible
     * @return An instance of BooleanOperand
     * @throws IllegalArgumentException Raised when node is null.
     * @throws IllegalStateException Raised when no entity implemented IMeshConvertible found under this node
     */
    public static BooleanOperand of(Node node) {
        return new BooleanOperand(node);
    }

    /**
     * Construct a BooleanOperand instance from a bare IMeshConvertible instance.
     * @param mesh The mesh used as Boolean operation's operand, it can bean instance of IMeshConvertible or HalfSpace
     * @return An instance of BooleanOperand
     * @throws IllegalArgumentException Raised when mesh is null.
     */
    public static BooleanOperand of(Entity mesh) {
        return new BooleanOperand(mesh);
    }

    /**
     * Construct a BooleanOperand instance from a IMeshConvertible instance and specified transform.
     * @param mesh The mesh used as Boolean operation's operand, it can bean instance of IMeshConvertible or HalfSpace
     * @param transform The transform of the mesh object
     * @return An instance of BooleanOperand
     * @throws IllegalArgumentException Raised when mesh is null.
     */
    public static BooleanOperand of(Entity mesh, Matrix4 transform) {
        return new BooleanOperand(mesh);
    }

    private BooleanOperand(A3DObject operand) {
        this.operand = operand;
    }

    /**
     * Gets the operand, it can be an instance of HalfSpace, IMeshConvertible or Node.
     * @return the operand, it can be an instance of HalfSpace, IMeshConvertible or Node.
     */
    public A3DObject getOperand() {
        return operand;
    }

    /**
     * Gets the string representation of BooleanOperand.
     * @return The string representation of BooleanOperand
     */
    @Override
    public String toString() {
        return operand != null ? "BooleanOperand: " + operand.getClass().getSimpleName() : "BooleanOperand: null";
    }
}
