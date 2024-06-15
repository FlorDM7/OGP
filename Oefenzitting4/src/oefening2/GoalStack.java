package oefening2;

public class GoalStack extends StackOfCards {

    private final static int MAX_VALUE = Integer.MAX_VALUE;

    public GoalStack(Card startCard) {
        super(MAX_VALUE);
        add(startCard);
    }
}
