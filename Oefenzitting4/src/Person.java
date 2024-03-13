import be.kuleuven.cs.som.annotate.Basic;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents person who can own animals or things.
 * @author Flor De Meulemeester
 */
public class Person {

    /**
     * Name of the person.
     */
    public String name;

    /**
     * A list with the things that the person owns.
     * We make one list with all things so that we can easily extend the program.
     */
    public List<Thing> things;

    /**
     * A constructor
     */
    public Person(String name) {
        this.name = name;
        this.things = new ArrayList<Thing>();
    }

    /**
     * A method to get the total value of all the dogs and the paintings that a person owns.
     * @return total
     */
    public int totalValue(){
        int total = 0;
        for (Thing thing : things){
            if (thing instanceof Dog || thing instanceof Painting)
                total += thing.getValue();
        }
        return total;
    }

    /**
     * A method to calculate the minimum amount of dog that a person should buy
     * for a certain amount of days so that his/her dogs don't die.
     * @return amount
     */
    public int minimumDogFood(int days){
        int amount = 0;
        for (Thing dog: things){
            if (dog instanceof Dog){
                amount += ((Dog) dog).getFoodPerDay();
            }
        }
        return amount*days;
    }

    @Basic
    public String getName() {
        return name;
    }

    @Basic
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method allows us to check if a person has a certain painting of a certain painter.
     * @return boolean
     */
    public boolean hasPaintingOf(String painter){
        for (Thing painting : things){
            if (painting instanceof Painting){
                if (((Painting) painting).getPainter().equals(painter))
                    return true;
            }
        }
        return false;
    }

    /**
     * This method removes a thing for the list.
     */
    public void removeThing(Thing thing){
        things.remove(thing);
    }

    @Basic
    public List<Thing> getThings() {
        return things;
    }

    @Basic
    private void setThings(List<Thing> things) {
        this.things = things;
    }

    /**
     * Returns the car with the biggest cylinder capacity that a person owns.
     */
    public Car biggestCar(){
        Person dummy = new Person("dummy");
        Car maximum = new Car(0,dummy,0);
        for (Thing car: things){
            if (car instanceof Car){
                if (((Car) car).getCylinderCapacity() > maximum.getCylinderCapacity()) {
                    maximum = (Car) car;
                }
            }
        }
        return maximum;
    }

    /**
     * Adds an item to the list of things.
     */
    public void addThingToList(Thing thing){
        things.add(thing);
    }

}
