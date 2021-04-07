package expression.exceptions;

public class MissingOperandExpressionException extends ParsingExpressionException {

    public MissingOperandExpressionException(String message) {
        super(message);
    }
}
