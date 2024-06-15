package oefening2;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Immutable;
import be.kuleuven.cs.som.annotate.Model;

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

    private int size;

    private Stack<Card> stack;

    public StackOfCards(int capacity, int size, Stack<Card> stack) {
        if (!isValidCapacity(capacity)) {
            throw new IllegalArgumentException("The capacity is invalid!");
        }
        this.capacity = capacity;
        setSize(size);
        setStack(stack);
    }

    public StackOfCards(int capacity, int size) {
        this(capacity, size, new Stack<Card>());
    }

    public StackOfCards(int capacity) {
        this(capacity, 0, new Stack<Card>());
    }

    @Model
    public boolean isValidCapacity(int capacity) {
        return capacity > 0;
    }

    @Basic @Immutable
    public int getCapacity() {
        return capacity;
    }

    @Model
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

    protected void add(Card card) {
        if (!isFull()) {
            setSize(getSize() + 1);
            stack.add(card);
        }
    }

    protected Card pop() {
        if (!isEmpty()) {
            setSize(getSize() - 1);
            return stack.pop();
        }
        return null;
    }

    protected Card peek() {
        if (!isEmpty()){
            return stack.peek();
        }
        return null;
    }

    public ArrayList<Card> getAllCards() {
        return new ArrayList<>(stack);
    }

    public void printAllCards() {
        ArrayList<Card> list = getAllCards();
        for (Card card : list) {
            System.out.println(card.toString());
        }
    }

    public void fromMoveTo(StackOfCards other) {
        if (isFull()) {
            throw new RuntimeException("Stack is full!");
        }
        Card card1 = peek();
        Card card2 = other.peek();
        if (card1 == null || !card1.canPutCardOn(card2)) {
            throw new RuntimeException("Cards cannot be on each other.");
        } else {
            Card card = pop();
            other.add(card);
        }
    }

    public boolean isFull() {
        return getCapacity() == getSize();
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

}
