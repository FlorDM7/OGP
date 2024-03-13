import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClockTest {

    private static Clock clock1, clock2, clock3, clock4, clock5, clock6;

    @BeforeEach
    public void setUpMutableFixture() {
        clock1 = new Clock();
        clock2 = new Clock(23,45,59);
        clock3 = new Clock(-34,2323,23);
        clock4 = new Clock(-34,2323,23,true);
        clock5 = new Clock(23,59,59);
        clock6 = new Clock(11,59,59,true);
    }

    @Test
    public void smallConstructor(){
        Assertions.assertEquals(0,clock1.getHours());
        Assertions.assertEquals(0,clock1.getMinutes());
        Assertions.assertEquals(0,clock1.getMinutes());
        Assertions.assertFalse(clock1.isNotationWith12Hours());
    }

    @Test
    public void intermediateConstructors_LegalCases(){
        Assertions.assertEquals(23,clock2.getHours());
        Assertions.assertEquals(45,clock2.getMinutes());
        Assertions.assertEquals(59,clock2.getSeconds());
        Assertions.assertFalse(clock2.isNotationWith12Hours());
        Assertions.assertEquals(23,clock5.getHours());
        Assertions.assertEquals(59,clock5.getMinutes());
        Assertions.assertEquals(59,clock5.getSeconds());
        Assertions.assertFalse(clock5.isNotationWith12Hours());
    }

    @Test
    public void intermediateConstructors_IllegalCases(){
        Assertions.assertFalse(clock3.isNotationWith12Hours());
        Assertions.assertFalse(clock3.isIndicatorFor12Hours());
        Assertions.assertEquals(14,clock3.getHours());
        Assertions.assertEquals(43,clock3.getMinutes());
        Assertions.assertEquals(23,clock3.getSeconds());
    }

    @Test
    public void completeConstructor_LegalCases(){
        Assertions.assertTrue(clock6.isNotationWith12Hours());
        Assertions.assertTrue(clock6.isIndicatorFor12Hours());
        Assertions.assertEquals(11,clock6.getHours());
        Assertions.assertEquals(59,clock6.getMinutes());
        Assertions.assertEquals(59,clock6.getSeconds());
    }

    @Test
    public void completeConstructor_IllegalCases(){
        Assertions.assertTrue(clock4.isNotationWith12Hours());
        Assertions.assertFalse(clock4.isIndicatorFor12Hours());
        Assertions.assertEquals(2,clock4.getHours());
        Assertions.assertEquals(43,clock4.getMinutes());
        Assertions.assertEquals(23,clock4.getSeconds());
    }

    @Test
    public void testAddOneSecond_legalCases(){
        clock1.addOneSecond();
        Assertions.assertEquals(0,clock1.getHours());
        Assertions.assertEquals(0,clock1.getMinutes());
        Assertions.assertEquals(1,clock1.getSeconds());

        clock2.addOneSecond();
        Assertions.assertEquals(23,clock2.getHours());
        Assertions.assertEquals(46,clock2.getMinutes());
        Assertions.assertEquals(0,clock2.getSeconds());

        clock4.addOneSecond();
        Assertions.assertEquals(2,clock4.getHours());
        Assertions.assertEquals(43,clock4.getMinutes());
        Assertions.assertEquals(24,clock4.getSeconds());
    }

    @Test
    public void testAddOneSecond_trickyCases(){
        clock5.addOneSecond();
        Assertions.assertEquals(0,clock5.getHours());
        Assertions.assertEquals(0,clock5.getMinutes());
        Assertions.assertEquals(0,clock5.getSeconds());
        Assertions.assertFalse(clock5.isNotationWith12Hours());
        Assertions.assertTrue(clock5.isIndicatorFor12Hours());

        clock6.addOneSecond();
        Assertions.assertEquals(12,clock6.getHours());
        Assertions.assertEquals(0,clock6.getMinutes());
        Assertions.assertEquals(0,clock6.getSeconds());
        Assertions.assertTrue(clock6.isNotationWith12Hours());
        Assertions.assertFalse(clock6.isIndicatorFor12Hours());
    }
}
