package oefening2;

import be.kuleuven.cs.som.annotate.Basic;

import java.util.ArrayList;
import java.util.Stack;

/**
 * A class for stacks of cards.
 *
 * @invar   The capacity must be positive.
 *          | isValidCapacity(getCapacity())
 * @invar   The size must be lower than the capacity and positive.
 *          | isValidSize(getSize())
 */
abstract public class StackOfCards {

    private final int capacity;

    private int size = 0;

    private Stack<Card> stack = new Stack<Card>();

    private StackOfCards(int capacity) {
        if (!isValidCapacity(capacity)) {
            throw new IllegalArgumentException("The capacity is invalid!");
        }
        this.capacity = capacity;
    }

    public boolean isValidCapacity(int capacity) {
        return capacity > 0;
    }

    @Basic
    public int getCapacity() {
        return capacity;
    }

    public boolean isValidSize(int size) {
        return size >= 0 && getCapacity() >= size;
    }

    @Basic
    public int getSize() {
        return size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    private Stack<Card> getStack() {
        return stack;
    }

    private void setStack(Stack<Card> stack) {
        this.stack = stack;
    }

    public void add(Card card) {
        if (!isFull()) {
            stack.add(card);
        }
    }

    public Card pop() {
        return stack.pop();
    }

    protected Card peek() {
        return stack.peek();
    }

    public ArrayList<Card> getAllCards() {
        return new ArrayList<>(stack);
    }

    public void fromMoveTo(StackOfCards other) {
        if (isFull()) {
            throw new RuntimeException("Stack is full!");
        }
        Card card1 = peek();
        Card card2 = other.peek();
        if (!card1.canPutCardOn(card2)) {
            throw new RuntimeException("Cards cannot be on each other.");
        } else {

        }
    }

    public boolean isFull() {
        return getCapacity() == getSize();
    }

}
