import be.kuleuven.cs.som.annotate.*;

/**
 * An enum class containing the event categories.
 *
 * @author Flor De Meulemeester
 * @version 1.0
 */
public enum EventCategory {
    ACADEMIC("academic"), RECREATIONAL("recreational");

    private final String category;

    EventCategory(String category) {
        this.category = category;
    }

    @Basic
    public String getCategory() {
        return category;
    }

}
