package expression.operations;

import java.util.Map;

public class Const implements Expression {

    private final int value;

    public Const(int value) {
        this.value = value;
    }

    @Override
    public int evaluate(Map<String, Integer> values) {
        return value;
    }

}
