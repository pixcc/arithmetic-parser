package expression.operations;

public class CheckedNegate extends AbstractUnaryOperation {

    public CheckedNegate(Expression operand) {
        super(operand);
    }

    @Override
    public int calculate(int val) {
        return CheckedMath.negate(val);
    }

}
