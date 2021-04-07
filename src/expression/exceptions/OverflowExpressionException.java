package expression.exceptions;

public class OverflowExpressionException extends EvaluatingExpressionException {

    public OverflowExpressionException() {
        super("Overflow");
    }
}
