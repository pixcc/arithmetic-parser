package expression.operations;

import java.util.Map;

public abstract class AbstractBinaryOperation implements Expression {

    protected final Expression leftOperand;
    protected final Expression rightOperand;

    protected AbstractBinaryOperation(Expression leftOperand, Expression rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    abstract int calculate(int left, int right);

    @Override
    public int evaluate(Map<String, Integer> values) {
        int left = leftOperand.evaluate(values);
        int right = rightOperand.evaluate(values);
        return calculate(left, right);
    }

}
