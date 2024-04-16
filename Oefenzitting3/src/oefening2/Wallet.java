package oefening2;
import be.kuleuven.cs.som.annotate.*;
import java.util.*;

/**
 * A class for wallets
 * @author Flor De Meulemeester
 */
public class Wallet {

    /**
     * The owner of the wallet.
     */
    public String owner;

    /**
     * A set of the stock that are part of the wallet.
     */
    public Set<Stock> stocks = new HashSet<>();

    /**
     * A list of the running orders
     */
    public List<Order> runningOrders = new ArrayList<>();

    /**
     * A list of the running orders
     */
    public List<Order> completedOrders = new ArrayList<>();

    public Wallet(String owner) {
        setOwner(owner);
    }

    public void terminate(){
        for (Stock stock: stocks){
            stock.terminate();
        }
    }

    public void addStock(Stock stock){
        stocks.add(stock);
        for (Order order : stock.getOrders()){
            if (order.isCompleted()){
                completedOrders.add(order);
            }
            if (order.isRunningOrder()){
                runningOrders.add(order);
            }
        }
    }

    public void removeStock(Stock stock){
        stocks.remove(stock);
        for (Order order : stock.getOrders()){
            completedOrders.remove(order);
            runningOrders.remove(order);
        }
    }

    @Basic
    public Set<Stock> getStocks() {
        return stocks;
    }

    @Basic
    private void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }

    @Basic
    public String getOwner() {
        return owner;
    }

    @Basic
    private void setOwner(String owner) {
        this.owner = owner;
    }

    @Basic
    public List<Order> getRunningOrders() {
        return runningOrders;
    }

    @Basic
    private void setRunningOrders(List<Order> runningOrders) {
        this.runningOrders = runningOrders;
    }

    @Basic
    public List<Order> getCompletedOrders() {
        return completedOrders;
    }

    @Basic
    private void setCompletedOrders(List<Order> completedOrders) {
        this.completedOrders = completedOrders;
    }
}
