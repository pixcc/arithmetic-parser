package expression.exceptions;

public class ParsingExpressionException extends Exception {

    public ParsingExpressionException(String message) {
        super(message);
    }

    public ParsingExpressionException(String message, Throwable cause) {
        super(message, cause);
    }
}
