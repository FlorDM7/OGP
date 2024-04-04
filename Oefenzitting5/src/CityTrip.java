import be.kuleuven.cs.som.annotate.*;

/**
 * A class CityTrip inheriting from Event, representing city trips.
 *
 * @author Flor De Meulemeester
 * @version 1.0
 */
public class CityTrip extends Event {

    /**
     * The cost price to travel.
     */
    private int costPrice;

    /**
     * The means of transport used to get to the city.
     */
    private Transport meansOfTransport;

    public CityTrip(EventCategory eventCategory, String location, int duration, int costPrice, Transport meansOfTransport) {
        super(eventCategory, location, duration);
        setCostPrice(costPrice);
        setMeansOfTransport(meansOfTransport);
    }

    @Override
    public String getSummary(){
        String description = super.getSummary();
        description += "The cost price to travel is " + getCostPrice() + ".\n";
        description += "The means of transport used is " +getMeansOfTransport() + ".\n";
        return description;
    }

    @Override
    public void sendNotification(){
        System.out.println("The trip to " + getLocation() + " will start soon.");
    }

    @Basic
    public Transport getMeansOfTransport() {
        return meansOfTransport;
    }

    @Basic
    public void setMeansOfTransport(Transport meansOfTransport) {
        this.meansOfTransport = meansOfTransport;
    }

    @Basic
    public int getCostPrice() {
        return costPrice;
    }

    @Basic
    public void setCostPrice(int costPrice) {
        this.costPrice = costPrice;
    }


}
