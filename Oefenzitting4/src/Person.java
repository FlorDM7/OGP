import be.kuleuven.cs.som.annotate.Basic;

import java.util.List;

/**
 * A class that represents person who can own animals or things.
 */
public class Person {

    /**
     * Name of the person.
     */
    public String name;

    /**
     * A list with the things that the person owns.
     */
    public List<Thing> things;

    public Person(String name) {
        this.name = name;
    }

    /**
     * A method to get the total value of all the dogs and the paintings that a person owns.
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
     */
    public int minimumDogFood(int days){
        int amount = 0;
        for (Thing dog: things){
            if (dog instanceof Dog){
                amount += ((Dog) dog).getFoodPerDay();
            }
        }
        return amount;
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
        Car maximum = null;
        for (Thing car: things){
            if (car instanceof Car){
                if (((Car) car).getCylinderCapacity() > maximum.getCylinderCapacity()){
                    maximum = (Car) car;
                }
            }
        }
        return maximum;
    }

}
