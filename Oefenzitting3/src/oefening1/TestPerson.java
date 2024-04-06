package oefening1;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A class to test the public methods of oefening1.Person.
 *
 * @author Flor De Meulemeester
 * @version 1.0
 */
public class TestPerson {
    private Person husband1, husband2, wife1, wife2;

    /**
     * Set up a mutable test fixture.
     */
    @BeforeEach
    public void setUpMutableFixture(){
        husband1 = new Person("husband1");
        husband2 = new Person("husband2");
        wife1 = new Person("wife1");
        wife2 = new Person("wife2");
    }

    @Test
    public void testSwitchPartners_LegalCase(){
        husband1.marry(wife1);
        husband2.marry(wife2);
        husband1.switchPartners(husband2);
        Assertions.assertEquals(wife2, husband1.getPartner());
        Assertions.assertEquals(wife1, husband2.getPartner());
    }

    @Test
    public void testSwitchPartners_IllegalCase(){
        husband1.marry(wife1);
        assertThrows(IllegalPartnerException.class, () -> {
            husband1.switchPartners(husband2);
        });
    }
}
