package oefening1;

/**
 * A class of exceptions.
 */
public class IllegalValueException extends RuntimeException {
    private final Thing thing;
    public IllegalValueException(Thing thing) {
            this.thing = thing;
    }
    public Thing getPerson() {
            return thing;
    }
}
