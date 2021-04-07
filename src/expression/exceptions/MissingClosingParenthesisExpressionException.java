package expression.exceptions;

public class MissingClosingParenthesisExpressionException extends ParsingExpressionException {

    public MissingClosingParenthesisExpressionException(String message) {
        super(message);
    }
}
