package expression.operations;

public class CheckedSubtract extends AbstractBinaryOperation {

    public CheckedSubtract(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public int calculate(int left, int right) {
        return CheckedMath.subtract(left, right);
    }

}
