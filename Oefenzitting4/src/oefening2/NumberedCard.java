package oefening2;

/**
 * A class representing numbered cards.
 *
 * @invar   Each card must have a valid value.
 *          | isValidValue(getValue())
 *
 * @author Flor De Meulemeester
 */
public class NumberedCard extends Card {

    private final static int MAX_NUMBER_VALUE = 10;

    public NumberedCard(int value, Type kind) {
        super(value, kind);
    }

    @Override
    public boolean isValidValue(int value) {
        return 0 <= value && value <= MAX_NUMBER_VALUE;
    }
}
