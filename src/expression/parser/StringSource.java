package expression.parser;

public class StringSource implements ExpressionSource {

    private final String data;
    private int pos;
    private boolean isEOF;

    public StringSource(final String data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        isEOF = pos >= data.length();
        return !isEOF;
    }

    @Override
    public char next() {
        return data.charAt(pos++);
    }

    @Override
    public char prev() {
        pos--;
        return data.charAt(pos - 1);
    }

    @Override
    public String getCharPositionMessage() {
        if (isEOF) {
            return " at the end of \"" + data + "\"";
        }
        return " at position " + (pos - 1) + " in \"" + data + "\"";
    }
}
