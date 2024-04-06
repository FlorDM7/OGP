package oefening2;

public class IllegalNameException extends RuntimeException {
    private final Stock stock;

    public IllegalNameException(Stock stock) {
        this.stock = stock;
    }

    public Stock getStock() {
        return stock;
    }
}
