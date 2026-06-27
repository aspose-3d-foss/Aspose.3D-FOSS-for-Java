package com.aspose.threed;

/**
 * Boolean operator allows you to apply Boolean operation on two IMeshConvertible instances.
 */
public class BooleanOperator extends Entity implements IMeshConvertible {
    private BooleanOperation operator;
    private BooleanOperand first;
    private BooleanOperand second;

    /**
     * Constructor of BooleanOperator.
     */
    public BooleanOperator() {
        super("BooleanOperator");
    }

    /**
     * The Boolean operator used in the operation to create the result mesh.
     * @return The Boolean operator used in the operation to create the result mesh.
     */
    public BooleanOperation getOperator() {
        return operator;
    }

    /**
     * The Boolean operator used in the operation to create the result mesh.
     * @param value New value
     */
    public void setOperator(BooleanOperation value) {
        this.operator = value;
    }

    /**
     * The first operand of the Boolean operator.
     * @return The first operand of the Boolean operator.
     */
    public BooleanOperand getFirst() {
        return first;
    }

    /**
     * The first operand of the Boolean operator.
     * @param value New value
     */
    public void setFirst(BooleanOperand value) {
        this.first = value;
    }

    /**
     * The second operand of the Boolean operator.
     * @return The second operand of the Boolean operator.
     */
    public BooleanOperand getSecond() {
        return second;
    }

    /**
     * The second operand of the Boolean operator.
     * @param value New value
     */
    public void setSecond(BooleanOperand value) {
        this.second = value;
    }

    /**
     * Perform the Boolean operation on two operands.
     * @return The mesh.
     */
    public Mesh toMesh() {
        return null;
    }
}
