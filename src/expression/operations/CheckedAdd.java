package expression.operations;

public class CheckedAdd extends AbstractBinaryOperation {

    public CheckedAdd(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public int calculate(int left, int right) {
       return CheckedMath.add(left, right);
    }
}
