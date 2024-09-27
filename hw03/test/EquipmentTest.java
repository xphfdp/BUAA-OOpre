import org.junit.Test;

import static org.junit.Assert.*;
public class EquipmentTest {

    @Test
    public void durabilityIncrease() {
        Equipment equipment = new Equipment(123,"abc",5,40);
        equipment.durabilityIncrease();
        assertEquals(equipment.getDurability(),6);
    }

    @Test
    public void getID() {
        Equipment equipment = new Equipment(123,"abc",5,40);
        assertEquals(equipment.getID(),123);
    }

    @Test
    public void getName() {
        Equipment equipment = new Equipment(123,"abc",5,40);
        assertEquals(equipment.getName(),"abc");
    }

    @Test
    public void getDurability() {
        Equipment equipment = new Equipment(123,"abc",5,40);
        assertEquals(equipment.getDurability(),5);
    }

    @Test
    public void getEquCe() {
        Equipment equipment = new Equipment(123,"abc",5,40);
        assertEquals(equipment.getEquCe(),40);
    }
}