package expression.parser;

public abstract class BaseParser {

    protected final static char EOF = '\0';

    protected ExpressionSource source;
    protected char ch;

    protected void nextChar() {
        ch = source.hasNext() ? source.next() : EOF;
    }

    protected boolean test(char expected) {
        if (ch == expected) {
            nextChar();
            return true;
        }
        return false;
    }

    protected boolean test(String expected) {
        for (int i = 0; i < expected.length(); i++) {
            if (!test(expected.charAt(i))) {
                for (int j = 0; j < i; j++) {
                    ch = source.prev();
                }
                return false;
            }
        }
        return true;
    }

    protected boolean between(final char from, final char to) {
        return from <= ch && ch <= to;
    }

    protected void skipWhitespace() {
        while (test(' ') || test('\r') || test('\n') || test('\t')) {
        }
    }

    protected void setSource(ExpressionSource source) {
        this.source = source;
        nextChar();
    }
}
