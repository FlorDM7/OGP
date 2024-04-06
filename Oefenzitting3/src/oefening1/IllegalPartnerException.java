package oefening1;

/**
 * A class of exceptions.
 * @author Flor De Meulemeester
 */
public class IllegalPartnerException extends RuntimeException {

    private final Person person;

    public IllegalPartnerException(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }
}
