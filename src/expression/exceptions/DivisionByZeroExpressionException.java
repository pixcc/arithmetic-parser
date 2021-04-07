package expression.exceptions;

public class DivisionByZeroExpressionException extends InvalidArgumentsExpressionException {

    public DivisionByZeroExpressionException() {
        super("Division by zero");
    }

}
