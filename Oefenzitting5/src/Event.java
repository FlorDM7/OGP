import be.kuleuven.cs.som.annotate.*;

import java.util.List;

/**
 * An abstract class representing events.
 *
 * @author Flor De Meulemeester
 * @version 1.0
 */
public abstract class Event {

    /**
     * The location of the event.
     */
    private String location = null;

    /**
     * The duration of the event represented in minutes.
     */
    private int duration = 0;

    /**
     * A list containing notes regarding the event.
     */
    private List<String> notes;

    /**
     * The category of the event.
     */
    private EventCategory eventCategory;

    /**
     * The constructor for an event.
     * @param   eventCategory
     *          The given event category.
     * @param   location
     *          The given location of the event.
     * @param   duration
     *          The given duration of the event.
     */
    public Event(EventCategory eventCategory ,String location, int duration) {
        setEventCategory(eventCategory);
        setLocation(location);
        setDuration(duration);
    }

    @Basic
    public String getLocation() {
        return location;
    }

    @Basic
    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    public int getDuration() {
        return duration;
    }

    @Basic
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Basic
    public List<String> getNotes() {
        return notes;
    }

    @Basic
    public void setNotes(List<String> notes) {
        this.notes = notes;
    }

    @Basic
    public EventCategory getEventCategory() {
        return eventCategory;
    }

    @Basic
    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    public String getSummary(){
        String description = "The event will take place at " + getLocation() + ".\n";
        description += "The category of the event is " + getEventCategory().getCategory() + ".\n";
        description += "The event has a duration of " + getDuration() + ".\n";
        description += "These are the notes regarding the event: \n";
        if (getNotes() == null) {
           description += "There are no notes.\n";
        } else {
            for (String note : getNotes()) {
                description += note + "\n";
            }
        }
        return description;
    }

    public void sendNotification(){
    }

}
