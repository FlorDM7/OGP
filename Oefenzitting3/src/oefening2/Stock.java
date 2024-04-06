package oefening2;

import be.kuleuven.cs.som.annotate.*;

import java.util.*;

/**
 * A class for stocks.
 * @invar   The company has to be represented by a code of 4 uppercase letters.
 *          | canHaveAsName()
 * @invar   The current price is always positive.
 *          | getCurrentPrice() >= 0
 * @author  Flor De Meulemeester
 */
public class Stock {
    /**
     * The order that are part of the stock
     */
    private List<Order> orders = new ArrayList<>();

    /**
     * The current price of the stock (sum of all orders)
     */
    public int currentPrice = 0;

    /**
     * The name of the company
     */
    public String companyName;

    public Wallet wallet;

    public Stock(String companyName, Wallet wallet) {
        changeCompanyName(companyName);
        setWallet(wallet);
        wallet.addStock(this);
    }

    /**
     * A method to check if the name of a company is represented by a 4 uppercase letter code.
     * @param   name
     *          The string representing the company
     * @return  If the company is represented as code of 4 uppercase letters, true. Else false
     *          | result == name.length() == 4 && name.toUpperCase().equals(name)
     */
    public boolean canHaveAsName(String name){
        return name.length() == 4 && name.toUpperCase().equals(name);
    }

    public void addOrder(Order order){
        orders.add(order);
        setCurrentPrice(getCurrentPrice() + order.getCurrentPrice());
    }

    public void removeOrder(Order order){
        orders.remove(order);
        setCurrentPrice(getCurrentPrice() - order.getCurrentPrice());
    }

    public void terminate(){
        wallet.removeStock(this);
        setWallet(null);
        for (Order order: orders){
            order.resign();
        }
        setCurrentPrice(0);
        setCompanyName(null);
    }

    @Basic
    public List<Order> getOrders() {
        return orders;
    }

    @Basic
    public String getCompanyName() {
        return companyName;
    }

    @Basic
    private void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void changeCompanyName(String companyName) {
        if (!canHaveAsName(companyName)) {
            throw new IllegalNameException(this);
        }
        setCompanyName(companyName);
    }

    @Basic
    public int getCurrentPrice() {
        return currentPrice;
    }

    @Basic
    private void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Basic
    public Wallet getWallet() {
        return wallet;
    }

    @Basic
    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}