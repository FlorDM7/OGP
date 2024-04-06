package oefening2;

import be.kuleuven.cs.som.annotate.*;

/**
 * A class for orders.
 * @invar   The remaining amount will always be lower than or equal to
 *          the total amount. And both values are always positive.
 *          | 0 <= getRemainingAmount() <= getTotalAmount()
 * @invar   The total amount is always bigger than zero
 *          | 0 < getTotalAmount()
 * @author  Flor De Meulemeester
 */
public class Order {
    /**
     * The total amount of pieces.
     */
    public int totalAmount = 0;

    /**
     * The remaining amount of pieces to be bought.
     */
    private int remainingAmount = 0;

    /**
     * The maximum price.
     */
    public int maximumPrice = 0;

    /**
     * A boolean to check if all pieces are bought.
     */
    public boolean isBought = false;

    /**
     * A boolean to check if the order is resigned.
     */
    public boolean isResigned = false;

    /**
     * The name of the product.
     */
    public String productName;

    /**
     * The stock were this order belongs too.
     */
    public Stock stock;

    /**********************************************************
     * Constructors
     **********************************************************/

    /**
     * Extended constructor.
     */
    public Order(int totalAmount, int maximumPrice, String productName, Stock stock){
        setTotalAmount(totalAmount);
        setRemainingAmount(totalAmount);
        setMaximumPrice(maximumPrice);
        setProductName(productName);
        setStock(stock);
        stock.addOrder(this);
        setResigned(false);
        setBought(false);
    }

    /**
     * Basic constructor.
     */
    public Order(int totalAmount, int maximumPrice, Stock stock){
        this(totalAmount, maximumPrice, null, stock);
    }

    /**********************************************************
     * Destructors
     **********************************************************/

    public void resign(){
        if (!isResigned()){
            setResigned(true);
            setTotalAmount(0);
            setRemainingAmount(0);
            setMaximumPrice(0);
            setProductName(null);
            stock.removeOrder(this);
            setStock(null);
        }
    }

    public boolean isRunningOrder(){
        return getRemainingAmount() > 0 && getRemainingAmount() != getTotalAmount();
    }

    public boolean isCompleted(){
        return getRemainingAmount() == 0;
    }

    /**
     * A method to some of the pieces that are left.
     * @param   amount
     *          The amount of pieces you want to buy.
     */
    public void buy(int amount){
        if (amount > getRemainingAmount()){
            throw new IllegalArgumentException("You are buying too much.");
        }
        setRemainingAmount(getRemainingAmount() - amount);
        if (isCompleted()){
            setBought(true);
        }
    }

    /**
     * A method to buy all the remaining pieces of an order.
     */
    public void buyAll(){
        int amount = getRemainingAmount();
        buy(amount);
    }

    @Basic
    public int getTotalAmount() {
        return totalAmount;
    }

    @Basic
    private void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Basic
    public int getRemainingAmount() {
        return remainingAmount;
    }

    @Basic
    private void setRemainingAmount(int remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    @Basic
    public int getMaximumPrice() {
        return maximumPrice;
    }

    /**
     * A method to publicly change the maximum price before the order is effective.
     * @param   newPrice
     *          The new price.
     */
    public void changeMaximumPrice(int newPrice){
        if (isBought() || isRunningOrder()){
            throw new AlreadyBoughtException(this);
        }
        setMaximumPrice(newPrice);
    }

    @Basic
    private void setMaximumPrice(int maximumPrice) {
        this.maximumPrice = maximumPrice;
    }

    @Basic
    public boolean isBought() {
        return isBought;
    }

    @Basic
    private void setBought(boolean bought) {
        isBought = bought;
    }

    @Basic
    public String getProductName() {
        return productName;
    }

    @Basic
    private void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    public boolean isResigned() {
        return isResigned;
    }

    @Basic
    public void setResigned(boolean resigned) {
        isResigned = resigned;
    }

    @Basic
    public Stock getStock() {
        return stock;
    }

    @Basic
    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public int getCurrentPrice(){
        return getMaximumPrice() * getRemainingAmount();
    }

}