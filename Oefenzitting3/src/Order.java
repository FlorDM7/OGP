import be.kuleuven.cs.som.annotate.Basic;

/**
 * A class for orders.
 * @invar   The remaining amount will always be lower than or equal to
 *          the total amount. And both values are always positive.
 *          | 0 <= remainingAmount <= totalAmount
 */
public class Order {
    /**
     * The total amount of pieces.
     */
    public int totalAmount;
    /**
     * The remaining amount of pieces to be bought.
     */
    public int remainingAmount;
    /**
     * The maximum price.
     */
    public int maximumPrice;
    /**
     * A boolean the check if all pieces are bought.
     */
    public boolean isBought;
    /**
     * The name of the product.
     */
    public String productName;

    /**
     * Private extended constructor.
     */
    private Order(int totalAmount, int remainingAmount, int maximumPrice, boolean isBought, String productName) {
        this.totalAmount = totalAmount;
        this.remainingAmount = remainingAmount;
        this.maximumPrice = maximumPrice;
        this.isBought = isBought;
        this.productName = productName;
    }

    /**
     * Public extended constructor.
     */
    public Order(int totalAmount, int maximumPrice, String productName){
        this(totalAmount, totalAmount, maximumPrice, false, productName);
    }

    /**
     * Basic constructor.
     */
    public Order(int totalAmount, int maximumPrice) {
        this(totalAmount,totalAmount,maximumPrice,false,null);
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
}
