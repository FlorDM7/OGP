package oefening2;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Immutable;

/**
 * A class representing cards.
 *
 * @invar   Each card must have a valid value.
 *          | isValidValue(getValue())
 *
 * @author Flor De Meulemeester
 */
abstract public class Card {

    /**
     * The value of a card.
     */
    private final int value;

    /**
     * The type of the card.
     */
    private final Type kind;

    private final static int MAX_VALUE = 11;

    /**
     * A constructor for a card.
     *
     * @param   value
     *          The value to set.
     * @param   kind
     *          The kind to set.
     */
    protected Card(int value, Type kind) {
        if (!isValidValue(value)){
            throw new IllegalArgumentException("The value is not legal!");
        }
        this.value = value;
        this.kind = kind;
    }

    /**
     * Get the kind of the card.
     */
    @Basic @Immutable
    public Type getKind() {
        return kind;
    }

    /**
     * Get the numeric value of the card.
     */
    @Basic @Immutable
    public int getValue() {
        return value;
    }

    /**
     * Check if the given value is legal.
     *
     * @param   value
     *          The given value
     * @return  True if the value is between 0 and the maximum value.
     *          | result == !(0 <= value && value < MAX_VALUE)
     */
    public boolean isValidValue(int value) {
        return 0 <= value && value <= MAX_VALUE;
    }

    public boolean canPutCardOn(Card other) {
        if (other == null) {
            return false;
        }
        if (this instanceof Joker || other instanceof Joker) {
            return true;
        }
        if (getValue() == other.getValue()){
            return false;
        } else {
            return getValue() + 1 == other.getValue() || getValue() == other.getValue() + 1;
        }
    }

    public String toString() {
        return getValue() + " of " + getKind();
    }
}
