package skylark.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import skylark.main.SkylarkException;

/** Represents a Deadline Task. */
public class Event extends Task {
    /** Symbol that represents a Deadline task. */
    private static final char SYMBOL_EVENT = 'E';

    /** Input format required when parsing input from the user. */
    private final String inputFormat = "yyyy-MM-dd HHmm"; // 2019-10-15 1800

    /** Date-time object that represents the end date of the task. */
    private final LocalDateTime timing;

    /**
     * Returns an Event object.
     * Throws a SkylarkException if the timing is not parsable.
     *
     * @param description Description of the Task
     * @param timing Date in yyyy-MM-dd HHmm format
     * @throws SkylarkException If date is not parsable
     */
    public Event(String description, String timing) throws SkylarkException {
        super(description);
        try {
            this.timing = LocalDateTime.parse(timing, DateTimeFormatter.ofPattern(inputFormat));
        } catch (DateTimeParseException dateTimeParseException) {
            throw new SkylarkException("Cannot parse date");
        }
    }

    @Override
    public String toString() {
        String outputFormat = "MMM dd yyyy"; // Oct 15 2019
        return String.format("[%c] %s (at: %s)", Event.SYMBOL_EVENT,
                super.toString(), this.timing.format(DateTimeFormatter.ofPattern(outputFormat)));
    }

    @Override
    public String toStringFile() {
        return String.format("%c | %d | %s | %s", Event.SYMBOL_EVENT,
                super.getStatusIcon().equals("X") ? 1 : 0,
                super.getDescription(), this.timing.format(DateTimeFormatter.ofPattern(inputFormat)));
    }
}
