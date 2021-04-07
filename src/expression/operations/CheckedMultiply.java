package expression.operations;

public class CheckedMultiply extends AbstractBinaryOperation {

    public CheckedMultiply(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public int calculate(int left, int right) {
        return CheckedMath.multiply(left, right);
    }
}

