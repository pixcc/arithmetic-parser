package expression.operations;

public class CheckedPow extends AbstractBinaryOperation {

    public CheckedPow(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public int calculate(int left, int right) {
        return CheckedMath.pow(left, right);
    }

}
