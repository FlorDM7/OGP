import be.kuleuven.cs.som.annotate.Basic;

/**
 * A class Lecture inheriting from Event, representing lectures.
 *
 * @author Flor De Meulemeester
 * @version 1.0
 */
public class Lecture extends Event{

    /**
     * The course for which the lecture is given.
     */
    private String course;

    /**
     * The subject of the lecture.
     */
    private String subject;

    /**
     * The constructor for a lecture
     * @param   eventCategory
     *          The given event category.
     * @param   location
     *          The given location of the event.
     * @param   duration
     *          The given duration of the event.
     * @param   course
     *          The course in which the lecture is given.
     * @param   subject
     *          The given subject of the lecture
     */
    public Lecture(EventCategory eventCategory, String location, int duration, String course, String subject) {
        super(eventCategory, location, duration);
        setCourse(course);
        setSubject(subject);
    }

    @Override
    public String getSummary(){
        String description =  super.getSummary();
        description += "The course is " + getCourse() + ".\n";
        description += "The subject is " + getSubject() + ".\n";
        return description;
    }

    @Override
    public void sendNotification(){
        SystemNotification.sendNotification(getCourse(),"The lecture about " + getSubject() + " is about to start!");
    }

    @Basic
    public String getCourse() {
        return course;
    }

    @Basic
    public void setCourse(String course) {
        this.course = course;
    }

    @Basic
    public String getSubject() {
        return subject;
    }

    @Basic
    public void setSubject(String subject) {
        this.subject = subject;
    }
}
