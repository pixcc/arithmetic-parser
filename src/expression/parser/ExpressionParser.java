package expression.parser;

import expression.exceptions.*;
import expression.operations.CheckedNegate;
import expression.operations.Const;
import expression.operations.Expression;

import java.util.Map;
import java.util.Set;

public class ExpressionParser extends BaseParser implements Parser {

    private static final int MIN_PRIORITY = 1;
    private static final int MAX_PRIORITY = 4;
    private final Set<String> vars;

    public ExpressionParser(Set<String> vars) {
        this.vars = vars;
    }


    @Override
    public Expression parse(String expression) throws ParsingExpressionException {
        setSource(new StringSource(expression));
        Expression parsed = parseByPriority(MIN_PRIORITY);
        if (ch == ')') {
            String msg = "No opening parenthesis for closing parenthesis" + source.getCharPositionMessage();
            throw new InvalidClosingParenthesisExpressionException(msg);
        } else if (ch != EOF) {
            String msg = "Invalid operation" + source.getCharPositionMessage();
            throw new InvalidOperationExpressionException(msg);
        }
        return parsed;
    }

    private Expression parseByPriority(int priority) throws ParsingExpressionException {
        if (priority == MAX_PRIORITY) {
            return parseValue();
        }
        Expression left = parseByPriority(priority + 1);
        outer:
        while (true) {
            skipWhitespace();
            for (BinaryOperations op : BinaryOperations.values()) {
                if (op.getPriority() == priority && test(op.getOperator())) {
                    left = op.makeOperation(left, parseByPriority(priority + 1));
                    continue outer;
                }
            }
            return left;
        }
    }

    private Expression parseValue() throws ParsingExpressionException {
        skipWhitespace();
        if (test('(')) {
            return parseParenthesis();
        } else if (test('-')) {
            if (between('0', '9')) {
                return parseNumber(true);
            }
            return new CheckedNegate(parseValue());
        } else if (between('0', '9')) {
            return parseNumber(false);
        } else if (ch == EOF) {
            throw new MissingOperandExpressionException("Missing operand" + source.getCharPositionMessage());
        } else {
            return parseVariable();
        }
    }

    private Expression parseNumber(boolean minus) throws ParsingExpressionException {
        StringBuilder sb = new StringBuilder();
        if (minus) {
            sb.append("-");
        }
        while (between('0', '9')) {
            sb.append(ch);
            nextChar();
        }
        try {
            return new Const(Integer.parseInt(sb.toString()));
        } catch (NumberFormatException e) {
            throw new InvalidConstantExpressionException("Invalid constant: " + sb.toString(), e);
        }
    }

    private Expression parseVariable() throws InvalidOperandExpressionException {
        for (String var : vars) {
            if (test(var)) {
                return new Variable(var);
            }
        }
        throw new InvalidOperandExpressionException("Invalid operand" + source.getCharPositionMessage());
    }

    private Expression parseParenthesis() throws ParsingExpressionException {
        Expression inside = parseByPriority(MIN_PRIORITY);
        if (ch == EOF) {
            String message = "Missing closing parenthesis" + source.getCharPositionMessage();
            throw new MissingClosingParenthesisExpressionException(message);
        } else if (!test(')')) {
            String message = "Invalid closing parenthesis" + source.getCharPositionMessage();
            throw new InvalidClosingParenthesisExpressionException(message);
        }
        return inside;
    }

    public class Variable implements Expression {

        private final String name;

        public Variable(String name) {
            this.name = name;
        }

        @Override
        public int evaluate(Map<String, Integer> values) {
            if (values.containsKey(name)) {
                return values.get(name);
            }
            throw new InvalidArgumentsExpressionException("Value for variable " + name + " not provided");
        }
    }
}
