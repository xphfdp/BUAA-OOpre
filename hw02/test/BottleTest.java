import org.junit.Test;

import static org.junit.Assert.*;
public class BottleTest {

    @Test
    public void getIdBol() {
        Bottle bottle = new Bottle(123,"abc",5);
        assertEquals(bottle.getIdBol(),123);
    }

    @Test
    public void getName() {
        Bottle bottle = new Bottle(123,"abc",5);
        assertEquals(bottle.getName(),"abc");
    }

    @Test
    public void getCapacity() {
        Bottle bottle = new Bottle(123,"abc",5);
        assertEquals(bottle.getCapacity(),5);
    }
}