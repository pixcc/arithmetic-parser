package expression.parser;

public interface ExpressionSource {
    boolean hasNext();
    char next();
    char prev();
    String getCharPositionMessage();
}
