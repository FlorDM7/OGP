import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OiltankTest {

    Oiltank oiltank1 = new Oiltank(500,40);
    Oiltank oiltank2 = new Oiltank(5000,0);
    Oiltank oiltank3 = new Oiltank(100,84);
    Oiltank oiltank4 = new Oiltank(-200,-2);


    @Test
    public void testConstructors(){
        Assertions.assertEquals(500,oiltank1.getCapacity());
        Assertions.assertEquals(40,oiltank1.getContent());
        Assertions.assertEquals(5000,oiltank2.getCapacity());
        Assertions.assertEquals(0,oiltank2.getContent());
        Assertions.assertEquals(100,oiltank3.getCapacity());
        Assertions.assertEquals(84,oiltank3.getContent());
        Assertions.assertEquals(0,oiltank4.getCapacity());
        Assertions.assertEquals(0,oiltank4.getContent());
    }

    @Test
    public void testTransferTank(){
        oiltank2.transferTank(oiltank3);
        Assertions.assertEquals(84,oiltank2.getContent());
        Assertions.assertEquals(0,oiltank3.getContent());
    }

    @Test
    public void testIsMoreFillThen(){
        Assertions.assertTrue(oiltank1.isMoreFillThen(oiltank2));
    }

    @Test
    public void testBiggestButNotFull(){
        Assertions.assertEquals(oiltank2, oiltank1.biggestCapacityButNotFull(oiltank2,oiltank3));
    }
}
