package oefening2;

public class Main {
    public static void main(String[] args) {
        Card card = new NumberedCard(10, Type.HEARTS);
        System.out.println(card.getValue());
        System.out.println(card.getKind());
    }
}
