import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * A class representing cars.
 * @author Flor De Meulemeester
 */
public class Car extends Thing{

    /**
     * The date of purchase of the car.
     */
    public LocalDate buyDate;

    /**
     * The cylinderCapacity of the car.
     */
    public int cylinderCapacity;

    public Car(int value, Person owner, int cylinderCapacity) {
        super(value, owner);
        this.cylinderCapacity = cylinderCapacity;
        this.buyDate = LocalDate.now();
    }

    public LocalDate getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(LocalDate buyDate) {
        this.buyDate = buyDate;
    }

    public int getCylinderCapacity() {
        return cylinderCapacity;
    }

    public void setCylinderCapacity(int cylinderCapacity) {
        this.cylinderCapacity = cylinderCapacity;
    }

    /**
     * As the car gets older the value of the car decreases so we override the getter for the value.
     */
    @Override
    public int getValue(){
        LocalDate currentTime = LocalDate.now();
        double half = (double) this.value / 2;
        double newValue = this.value - (getBuyDate().until(currentTime, ChronoUnit.YEARS)) * 100;
        return (int) Math.max(newValue,half);
    }

}
