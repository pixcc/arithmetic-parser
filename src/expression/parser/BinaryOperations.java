package expression.parser;

import expression.operations.*;

public enum BinaryOperations {
    ADD("+", 1){
        @Override
        public Expression makeOperation(Expression left, Expression right) {
            return new CheckedAdd(left, right);
        }
    },
    SUB("-", 1){
        @Override
        public Expression makeOperation(Expression left, Expression right) {
            return new CheckedSubtract(left, right);
        }
    },
    MUL("*", 2){
        @Override
        public Expression makeOperation(Expression left, Expression right) {
            return new CheckedMultiply(left, right);
        }
    },
    DIV("/", 2){
        @Override
        public Expression makeOperation(Expression left, Expression right) {
            return new CheckedDivide(left, right);
        }
    },
    LOG("//", 3){
        @Override
        public Expression makeOperation(Expression left, Expression right) {
            return new CheckedLog(left, right);
        }
    },
    POW("**", 3) {
        @Override
        public Expression makeOperation(Expression left, Expression right) {
            return new CheckedPow(left, right);
        }
    };

    private String operator;
    private int priority;

    BinaryOperations(String operator, int priority) {
        this.operator = operator;
        this.priority = priority;
    }

    public String getOperator() {
        return operator;
    }

    public int getPriority() {
        return priority;
    }

    public abstract Expression makeOperation(Expression left, Expression right);

}
