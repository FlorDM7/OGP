import be.kuleuven.cs.som.annotate.Basic;

/**
 * A class representing paintings. Each painting can have a title and a painter.
 * @author Flor De Meulemeester
 */
public class Painting extends Thing{

    /**
     * The title of the painting.
     */
    public String title;

    /**
     * The painter of the painting.
     */
    public String painter;

    public Painting(int value, Person owner, String title, String painter) {
        super(value, owner);
        this.title = title;
        this.painter = painter;
    }

    @Basic
    public String getTitle() {
        return title;
    }

    @Basic
    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    public String getPainter() {
        return painter;
    }

    @Basic
    public void setPainter(String painter) {
        this.painter = painter;
    }
}
