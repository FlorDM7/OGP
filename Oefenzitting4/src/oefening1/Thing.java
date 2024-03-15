package oefening1;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Raw;
import oefening1.IllegalValueException;
import oefening1.Person;

/**
 * A more abstract class representing things that a person could own.
 * @author Flor De Meulemeester
 * @invar A value must always be positive.
 *        | value > 0
 * @invar A thing is always assigned to one person.
 *        | owner != null
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

    /**
     * General constructor for a thing. When a thing is created it is assigned to a person.
     */
    public Thing(int value, Person owner) throws IllegalValueException {
        if (value < 0){
            throw new IllegalValueException(this);
        }
        this.value = value;
        this.owner = owner;
        owner.addThingToList(this);
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
     * Sets a new owner by removing the thing for the properties of the old owner.
     */
    @Basic @Raw
    public void setOwner(Person owner) {
        getOwner().removeThing(this);
        this.owner = owner;
        owner.addThingToList(this);
    }
}
