package oefening2;

public class SourceStack extends StackOfCards{

    /**
     * A constructor for a source stack.
     *
     * @param   list
     *          A list with the cards that should be on the stack.
     *
     * @pre     The list must have exact 5 cards in it.
     *          | list.length() == 5
     */
    public SourceStack(Card[] list) {
        super(5);
        for (Card card : list) {
            add(card);
        }
    }

}
