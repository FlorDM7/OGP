package oefening2;

public class HelpStack extends StackOfCards {

    private final static int MAX_VALUE = Integer.MAX_VALUE;

    public HelpStack(Card[] list) {
        super(MAX_VALUE);
        for (Card card : list) {
            add(card);
        }
    }
}
