package expression.operations;

import java.util.Map;

public interface Expression {
    int evaluate(Map<String, Integer> values);
}
