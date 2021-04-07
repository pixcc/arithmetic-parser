package expression.parser;

import expression.operations.Expression;
import expression.exceptions.ParsingExpressionException;

public interface Parser {
    Expression parse(String expression) throws ParsingExpressionException;
}