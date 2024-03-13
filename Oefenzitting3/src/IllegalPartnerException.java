/**
 * A class of exceptions.
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
