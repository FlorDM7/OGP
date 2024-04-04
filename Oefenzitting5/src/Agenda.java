import be.kuleuven.cs.som.annotate.*;
import java.util.*;

public class Agenda<T extends Event, U extends ComparableDate<U>> {
    private List<DatedEvent> events = new ArrayList<>();

    /**
     * A empty constructor
     */
    public Agenda(){
    }

    public void addEvent(T event, U date){
        events.add(new DatedEvent(event, date));
    }

    public List<T> getUpcomingEvents(U date){
        List<T> upcoming = new ArrayList<T>();
        for (DatedEvent event : events){
            if (event.getDate().comesBefore(date))
                upcoming.add(event.getEvent());
        }
        return upcoming;
    }

    public T getFirstUpcomingEvent(U date){
        T upcoming = null;
        U upcomingDate = null;
        for (DatedEvent event : events){
            if (event.getDate().comesBefore(date))
                if (upcoming == null || event.getDate().comesBefore(upcomingDate)) {
                    upcoming = event.getEvent();
                    upcomingDate = event.getDate();
                }
        }
        return upcoming;
    }

    public void sendNextReminder(U date){
        T event = getFirstUpcomingEvent(date);
        event.sendNotification();
    }

    private class DatedEvent {

        private T event;
        private U date;

        public DatedEvent(T event, U date) {
            setEvent(event);
            setDate(date);
        }

        @Basic
        public T getEvent() {
            return event;
        }

        @Basic
        public void setEvent(T event) {
            this.event = event;
        }

        @Basic
        public U getDate() {
            return date;
        }

        @Basic
        public void setDate(U date) {
            this.date = date;
        }
    }
}