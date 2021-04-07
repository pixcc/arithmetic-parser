package expression.operations;

import java.util.Map;

public abstract class AbstractUnaryOperation implements Expression {

    protected final Expression operand;

    protected AbstractUnaryOperation(Expression operand) {
        this.operand = operand;
    }

    abstract int calculate(int val);

    @Override
    public int evaluate(Map<String, Integer> values) {
        int val = operand.evaluate(values);
        return calculate(val);
    }

}
