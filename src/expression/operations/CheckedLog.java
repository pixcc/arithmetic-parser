package expression.operations;

public class CheckedLog extends AbstractBinaryOperation {

    public CheckedLog(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public int calculate(int left, int right) {
       return CheckedMath.log(left, right);
    }

}
