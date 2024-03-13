import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

/**
 * A class with tests.
 */
public class CarTest {
    private static Person dude;
    private static Car car1, car2, car3;

    @BeforeEach
    public void setUpMutableFixture(){
        dude = new Person("Jan");
        car1 = new Car(1000,dude,23);
        car2 = new Car(2000,dude,45);
        car3 = new Car(1000,dude, 20);
    }

    @Test
    public void biggestCar(){
        Assertions.assertEquals(dude.biggestCar(),car2);
    }

    @Test
    public void valueOverTime(){
        Car car4 = new Car(1000, dude, 25);
        LocalDate previousYear = LocalDate.now().plusYears(-1);
        car4.setBuyDate(previousYear);
        Assertions.assertEquals(car4.getValue(),900);

        car4 = new Car(1000, dude, 25);
        previousYear = LocalDate.now().plusYears(-2);
        car4.setBuyDate(previousYear);
        Assertions.assertEquals(car4.getValue(),800);

        car4 = new Car(1000, dude, 25);
        previousYear = LocalDate.now().plusYears(-6);
        car4.setBuyDate(previousYear);
        Assertions.assertEquals(car4.getValue(),500);

    }

}
