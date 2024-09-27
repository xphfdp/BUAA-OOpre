import org.junit.Test;

import static org.junit.Assert.*;
public class BottleTest {

    @Test
    public void getIdBol() {
        Bottle bottle = new Bottle(123,"abc",5,"HpBottle",0);
        assertEquals(bottle.getIdBol(),123);
    }

    @Test
    public void getName() {
        Bottle bottle = new Bottle(123,"abc",5,"HpBottle",0);
        assertEquals(bottle.getName(),"abc");
    }

    @Test
    public void getCapacity() {
        Bottle bottle = new Bottle(123,"abc",5,"HpBottle",0);
        assertEquals(bottle.getCapacity(),5);
    }

    @Test
    public void getBolCe() {
        Bottle bottle = new Bottle(123,"bottle",30,"AtkBottle",30);
        assertEquals(bottle.getBolCe(),30);
    }

    @Test
    public void getIsFull() {
        Bottle bottle = new Bottle(123,"bottle",30,"AtkBottle",30);
        assertTrue(bottle.getIsFull());
    }

    @Test
    public void setIsFull() {
        boolean isFull = false;
        Bottle bottle = new Bottle(123,"bottle",30,"AtkBottle",30);
        bottle.setIsFull(isFull);
        assertFalse(bottle.getIsFull());
    }
}