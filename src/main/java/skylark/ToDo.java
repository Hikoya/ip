package skylark;

public class ToDo extends Task {
    private static final char SYMBOL = 'T';

    public ToDo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return String.format("[%c] %s", SYMBOL, super.toString());
    }

    @Override
    public String toStringFile() {
        return String.format("%c | %d | %s", SYMBOL,
                super.getStatusIcon().equals("X") ? 1 : 0, super.getDescription());
    }
}
