package oefening2;

/**
 * A class representing card with value Jack.
 */
public class Jack extends Card {

    public Jack(Type kind) {
        super(11, kind);
    }

    @Override
    public String toString() {
        return "Jack of " + getKind();
    }
}
