import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void addAdventurer() {
        Main.adventurers.clear();
        int idAdv = 123;
        String advName = "advName";
        Adventurer adventurer = new Adventurer(idAdv,advName);
        Main.adventurers.put(idAdv,adventurer);
        assertEquals(1,Main.adventurers.size());
        Adventurer addedAdventurer  =Main.adventurers.get(idAdv);
        assertEquals(idAdv,addedAdventurer.getID());
        assertEquals(advName,addedAdventurer.getName());
    }

    @Test
    public void giveBottle() {
        Main.adventurers.clear();
        int idAdv = 123;
        String advName = "advName";
        Adventurer adventurer = new Adventurer(idAdv,advName);
        Main.adventurers.put(idAdv,adventurer);
        int idBol = 456;
        String bolName = "bolName";
        int capacity = 50;
        String type = "HpBottle";
        int bolCe = 0;
        Item item = new Item(idBol,bolName,type);
        HpBottle hpBottle = new HpBottle(idBol,bolName,capacity,type,bolCe);
        item.getHpBottleHashMap().put(idBol,hpBottle);
        adventurer.getItems().put(idBol,item);
        assertEquals(1,adventurer.getItems().size());
        Item addedItem = adventurer.getItems().get(idBol);
        assertEquals(idBol,addedItem.getItemId());
        assertEquals(bolName,addedItem.getItemName());
        assertTrue(addedItem.getHpBottleHashMap().containsKey(idBol));
        HpBottle addedHpBottle = addedItem.getHpBottleHashMap().get(idBol);
        assertEquals(capacity,addedHpBottle.getCapacity());
        assertEquals(bolCe,addedHpBottle.getBolCe());
    }

    @Test
    public void giveEquipment() {
        Main.adventurers.clear();
        int idAdv = 123;
        String advName = "advName";
        Adventurer adventurer = new Adventurer(idAdv,advName);
        Main.adventurers.put(idAdv,adventurer);
        int idEqu = 456;
        String equName = "equName";
        int durability = 50;
        int equCe = 20;
        Equipment equipment = new Equipment(idEqu,equName,durability,equCe);
        Item item = new Item(idEqu,equName,"Equipment");
        item.getEquipmentHashMap().put(idEqu,equipment);
        adventurer.getEquipments().add(equipment);
        adventurer.getItems().put(idEqu,item);
        assertEquals(1, adventurer.getEquipments().size());
        Equipment addedEquipment = adventurer.getEquipments().get(0);
        assertEquals(idEqu, addedEquipment.getID());
        assertEquals(equName, addedEquipment.getName());
        assertEquals(durability, addedEquipment.getDurability());
        assertEquals(1, adventurer.getItems().size());
        Item addedItem = adventurer.getItems().get(idEqu);
        assertEquals(idEqu, addedItem.getItemId());
        assertEquals(equName, addedItem.getItemName());
        assertTrue(addedItem.getEquipmentHashMap().containsKey(idEqu));
        Equipment itemEquipment = addedItem.getEquipmentHashMap().get(idEqu);
        assertEquals(durability, itemEquipment.getDurability());
        assertEquals(equCe, itemEquipment.getEquCe());
    }

    @Test
    public void increaseDurability() {
        Main.adventurers.clear();
        Adventurer adventurer = new Adventurer(123,"advName");
        Main.adventurers.put(123,adventurer);
        int idEqu = 111;
        Equipment equipment = new Equipment(idEqu,"equName",50,30);
        adventurer.getEquipments().add(equipment);
        equipment.durabilityIncrease();
        assertEquals(51,equipment.getDurability());
    }

    @Test
    public void deleteItem() {
    }

    @Test
    public void takeItem() {
    }

    @Test
    public void useBottle() {
    }
}