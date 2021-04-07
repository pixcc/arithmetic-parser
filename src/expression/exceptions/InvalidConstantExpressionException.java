package expression.exceptions;

public class InvalidConstantExpressionException extends ParsingExpressionException {

    public InvalidConstantExpressionException(String message) {
        super(message);
    }

    public InvalidConstantExpressionException(String message, Throwable cause) {
        super(message, cause);
    }
}
