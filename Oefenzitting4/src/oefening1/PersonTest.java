package oefening1;

import oefening1.Dog;
import oefening1.Painting;
import oefening1.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

/**
 * A class with tests.
 * @author Flor De Meulemeester
 */
public class PersonTest {
    private static Person dude, guy;
    private static Car car1, car2, car3;
    private static Dog dog1, dog2, dog3;
    private static Painting painting1, painting2, painting3;

    @BeforeEach
    public void setUpMutableFixture(){
        dude = new Person("Jan");
        guy = new Person("Peter");
        car1 = new Car(1000, dude,23);
        car2 = new Car(2000, dude,45);
        car3 = new Car(1000, dude, 20);
        dog1 = new Dog(100, dude, "Golden Retriever", "Max", 20);
        dog2 = new Dog(50, dude, "Dalmatian", "Bas", 10);
        dog3 = new Dog(200, dude, "Poodle", "Basil", 5);
        painting1 = new Painting(5000, dude, "De Nachtwacht", "Rembrandt van Rijn");
        painting2 = new Painting(3000, dude, "Zonnebloemen", "Van Gogh");
        painting1 = new Painting(10000, dude, "Mona Lisa", "Leonardo de Vinci");
    }

    @Test
    public void totalValue(){
        Assertions.assertEquals(dude.totalValue(), 18350);
    }

    @Test
    public void amountOfDogFood(){
        Assertions.assertEquals(dude.minimumDogFood(1),35);
        Assertions.assertEquals(dude.minimumDogFood(3),105);
    }

    @Test
    public void thingHasOwner(){
        Assertions.assertEquals(car1.getOwner(),dude);
        Assertions.assertEquals(car2.getOwner(),dude);
        Assertions.assertEquals(car3.getOwner(),dude);
        Assertions.assertEquals(dog1.getOwner(),dude);
        // ...
    }

    @Test
    public void changeOwner(){
        dog1.setOwner(guy);
        Assertions.assertEquals(dog1.getOwner(),guy);
        Assertions.assertFalse(dude.getThings().contains(dog1));
        Assertions.assertTrue(guy.getThings().contains(dog1));
    }

    @Test
    public void hasPaintingOf(){
        Assertions.assertTrue(dude.hasPaintingOf("Van Gogh"));
        Assertions.assertFalse(dude.hasPaintingOf("Flor De Meulemeester"));
    }

    @Test
    public void biggestCar(){
        Assertions.assertEquals(dude.biggestCar(),car2);
    }

    @Test
    public void valueOverTimeCase1(){
        Car car4 = new Car(1000, dude, 25);
        LocalDate previousYear = LocalDate.now().plusYears(-1);
        car4.setBuyDate(previousYear);
        Assertions.assertEquals(car4.getValue(),900);
    }

    @Test
    public void valueOverTimeCase2(){
        Car car4 = new Car(1000, dude, 25);
        LocalDate previousYear = LocalDate.now().plusYears(-2);
        car4.setBuyDate(previousYear);
        Assertions.assertEquals(car4.getValue(),800);
    }

    @Test
    public void valueOverTimeCase3(){
        Car car4 = new Car(1000, dude, 25);
        LocalDate previousYear = LocalDate.now().plusYears(-6);
        car4.setBuyDate(previousYear);
        Assertions.assertEquals(car4.getValue(),500);
    }

}
