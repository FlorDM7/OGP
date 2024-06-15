package oefening2;

public class Main {
    public static void main(String[] args) {
        Card card1 = new NumberedCard(10, Type.HEARTS);
        Card card2 = new Jack(Type.CLUBS);
        Card card3 = new Joker();

        StackOfCards stack = new SourceStack(new Card[] {card1, card2, card3});
        StackOfCards otherStack = new GoalStack(card1);

        Main.printStack(stack, otherStack);

        stack.fromMoveTo(otherStack);
        stack.fromMoveTo(otherStack);

        Main.printStack(stack, otherStack);
    }

    public static void printStack(StackOfCards stack, StackOfCards otherStack) {
        stack.printAllCards();
        System.out.println();
        otherStack.printAllCards();
        System.out.println();
    }

}
