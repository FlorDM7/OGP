import be.kuleuven.cs.som.annotate.*;
import java.util.Date;

public class AdvancedDate implements ComparableDate<AdvancedDate> {

    Date date;

    public AdvancedDate(Date date) {
        setDate(date);
    }

    @Override
    public boolean comesBefore(AdvancedDate other) {
        return getDate().before(other.getDate());
    }

    @Basic
    public Date getDate() {
        return date;
    }

    @Basic
    private void setDate(Date date) {
        this.date = date;
    }
}
