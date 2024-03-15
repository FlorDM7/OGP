package oefening1;

import be.kuleuven.cs.som.annotate.Basic;

/**
 * A class representing dogs.
 * @author Flor De Meulemeester
 */
public class Dog extends Thing {

    /**
     * The breed of the dog.
     */
    public String breed;

    /**
     * The name of the dog.
     */
    public String name;

    /**
     * The amount of dog food that the dog can have each day in grams.
     */
    public int foodPerDay;

    public Dog(int value, Person owner, String breed, String name, int foodPerDay) {
        super(value, owner);
        this.breed = breed;
        this.name = name;
        this.foodPerDay = foodPerDay;
    }

    @Basic
    public int getFoodPerDay() {
        return foodPerDay;
    }

    @Basic
    public void setFoodPerDay(int foodPerDay) {
        this.foodPerDay = foodPerDay;
    }

    @Basic
    public String getBreed() {
        return breed;
    }

    @Basic
    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Basic
    public String getName() {
        return name;
    }

    @Basic
    public void setName(String name) {
        this.name = name;
    }
}
