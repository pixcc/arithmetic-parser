package expression.operations;

import expression.exceptions.DivisionByZeroExpressionException;
import expression.exceptions.LogInvalidArgumentsExpressionException;
import expression.exceptions.OverflowExpressionException;
import expression.exceptions.PowInvalidArgumentsExpressionException;

public class CheckedMath {

    public static int add(int left, int right) {
        if ((right > 0 && left > Integer.MAX_VALUE - right) || (right <= 0 && left < Integer.MIN_VALUE - right)) {
            throw new OverflowExpressionException();
        }
        return left + right;
    }

    public static int subtract(int left, int right) {
        if ((right < 0 && Integer.MAX_VALUE + right < left) || (right > 0 && Integer.MIN_VALUE + right > left)) {
            throw new OverflowExpressionException();
        }
        return left - right;
    }

    public static int divide(int left, int right) {
        if (right == -1 && left == Integer.MIN_VALUE) {
            throw new OverflowExpressionException();
        } else if (right == 0) {
            throw new DivisionByZeroExpressionException();
        }
        return left / right;
    }

    public static int multiply(int left, int right) {
        if (isMultiplyOverflow(left, right)) {
            throw new OverflowExpressionException();
        }
        return left * right;
    }

    private static boolean isMultiplyOverflow(int left, int right) {
        return (
                left > 0 && right > 0 && Integer.MAX_VALUE / left < right
                || left < 0 && right < 0 && Integer.MAX_VALUE / left > right
                || left < 0 && right > 0 && Integer.MIN_VALUE / right > left
                || left > 0 && right < 0 && Integer.MIN_VALUE / left > right
        );
    }

    public static int log(int left, int right) {
        if (left <= 0) {
            throw new LogInvalidArgumentsExpressionException("Argument of log <= 0");
        } else if (right == 1) {
            throw new LogInvalidArgumentsExpressionException("Base of log = 1");
        } else if (right <= 0) {
            throw new LogInvalidArgumentsExpressionException("Base of log <= 0");
        }
        int i = 0;
        int tmp = 1;
        while (!isMultiplyOverflow(tmp, right) && tmp * right <= left) {
            i++;
            tmp = tmp * right;
        }
        return i;
    }

    public static int pow(int left, int right) {
        if (right == 0 && left == 0) {
            throw new PowInvalidArgumentsExpressionException("0 ** 0 is not allowed");
        } else if (right < 0) {
            throw new PowInvalidArgumentsExpressionException("Exponent < 0");
        }
        return fastPow(left, right);
    }

    private static int fastPow(int a, int n) {
        if (n == 0 || a == 1) {
            return 1;
        } else if (n % 2 == 0) {
            int x = fastPow(a, n / 2);
            return multiply(x, x);
        } else {
            int x = fastPow(a, n - 1);
            return multiply(x, a);
        }
    }

    public static int negate(int val) {
        if (val == Integer.MIN_VALUE) {
            throw new OverflowExpressionException();
        }
        return -val;
    }
}
