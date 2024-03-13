import be.kuleuven.cs.som.annotate.Basic;

public class Dog extends Thing {

    /**
     * The race of the dog.
     */
    public String race;

    /**
     * The name of the dog.
     */
    public String name;

    /**
     * The amount of dog food that the dog can have each day in grams.
     */
    public int foodPerDay;

    public Dog(int value, Person owner, String race, String name, int foodPerDay) {
        super(value, owner);
        this.race = race;
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
}
