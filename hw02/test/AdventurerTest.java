import org.junit.Test;

import static org.junit.Assert.*;

public class AdventurerTest {

    @Test
    public void getID() {
        Adventurer adventurer = new Adventurer(123,"abc");
        assertEquals(adventurer.getID(),123);
    }

    @Test
    public void getName() {
        Adventurer adventurer = new Adventurer(123,"abc");
        assertEquals(adventurer.getName(),"abc");
    }

    @Test
    public void getBottles() {
        Adventurer adventurer = new Adventurer(123,"abc");
        Bottle bottle = new Bottle(456,"efg",5);
        adventurer.getBottles().add(bottle);
        assertEquals(adventurer.getBottles().get(0).getIdBol(),456);
    }

    @Test
    public void getEquipments() {
        Adventurer adventurer = new Adventurer(123,"abc");
        Equipment equipment = new Equipment(456,"efg",5);
        adventurer.getEquipments().add(equipment);
        assertEquals(adventurer.getEquipments().get(0).getID(),456);
    }
}