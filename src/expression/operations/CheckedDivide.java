package expression.operations;

public class CheckedDivide extends AbstractBinaryOperation {

    public CheckedDivide(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public int calculate(int left, int right) {
       return CheckedMath.divide(left, right);
    }
}