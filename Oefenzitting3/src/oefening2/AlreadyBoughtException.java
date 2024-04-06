package oefening2;

/**
 * A class of exceptions.
 * @author Flor De Meulemeester
 */
public class AlreadyBoughtException extends RuntimeException{
    private final Order order;

    public AlreadyBoughtException(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}
