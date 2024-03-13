import be.kuleuven.cs.som.annotate.Basic;

/**
 * A more abstract class representing things that a person could own.
 */
public class Thing {

    /**
     * The value of the thing represented in euros.
     */
    public int value;

    /**
     * The person that owns the thing.
     */
    public Person owner;

    public Thing(int value, Person owner) {
        this.value = value;
        this.owner = owner;
    }

    @Basic
    public int getValue() {
        return value;
    }

    @Basic
    private void setValue(int value) {
        this.value = value;
    }

    @Basic
    public Person getOwner() {
        return owner;
    }

    /**
     * Sets a new owner by remove the thing for the properties of the old owner.
     */
    @Basic
    public void setOwner(Person owner) {
        owner.removeThing(this);
        this.owner = owner;
    }
}
