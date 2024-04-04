import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Lecture lecture = new Lecture(EventCategory.ACADEMIC, "Aula C703", 120,
                "Objectgericht Programmeren", "Selected Topics");

        String description = lecture.getSummary();
        System.out.println(description);

        lecture.sendNotification();

        BasicDate session5 = new BasicDate(2022, 3, 22, 9, 0, 0);
        System.out.println(session5.toString());

        BasicDate session4 = new BasicDate(2022, 3, 9, 16, 30, 0);

        // Should print true
        System.out.println(session4.comesBefore(session5));

        AdvancedDate advDate = new AdvancedDate(
                Date.from(Instant.from(DateTimeFormatter.ISO_INSTANT.parse(
                        "2022-03-21T09:00:00.000Z")))
        );

        Agenda<Lecture, BasicDate> myAgenda = new Agenda<>();
        myAgenda.addEvent(new Lecture(EventCategory.ACADEMIC, "Aula C703", 120,
                        "Objectgericht Programmeren", "Selected Topics"),
        new BasicDate(2022, 3, 22, 9, 0, 0));
        myAgenda.addEvent(new Lecture(EventCategory.ACADEMIC, "Aula A210", 60,
                        "Technieken voor de wiskundige analyse", "Differentiaal vergelijkingen"),
        new BasicDate(2022, 3, 9, 16, 30, 0));
        List<Lecture> lectures = myAgenda.getUpcomingEvents(
                new BasicDate(2022, 4, 1, 0, 0, 0));
        for (Lecture l : lectures) {
            System.out.println(l.getSummary());
        }
        myAgenda.sendNextReminder(new BasicDate(2022, 4, 1, 0, 0, 0));

        System.exit(0);
    }
}
