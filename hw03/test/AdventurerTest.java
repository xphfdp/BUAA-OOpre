import org.junit.Test;

import static org.junit.Assert.*;

public class AdventurerTest {

    @Test
    public void getID() {
        Adventurer adventurer = new Adventurer(123, "abc");
        assertEquals(adventurer.getID(), 123);
    }

    @Test
    public void getName() {
        Adventurer adventurer = new Adventurer(123, "abc");
        assertEquals(adventurer.getName(), "abc");
    }

    @Test
    public void getHitPoint() {
        Adventurer adventurer = new Adventurer(123, "abc");
        assertEquals(adventurer.getHitPoint(), 500);
    }

    @Test
    public void getAtk() {
        Adventurer adventurer = new Adventurer(123, "abc");
        assertEquals(adventurer.getAtk(), 1);
    }

    @Test
    public void getDef() {
        Adventurer adventurer = new Adventurer(123, "abc");
        assertEquals(adventurer.getDef(), 0);
    }

    @Test
    public void getAdvCe() {
        Adventurer adventurer = new Adventurer(123, "abc");
        assertEquals(adventurer.getAdvCe(), 1);
    }

    @Test
    public void setHitPoint() {
        int expectedHitPoint = 600;
        Adventurer adventurer = new Adventurer(123, "abc");
        adventurer.setHitPoint(expectedHitPoint);
        assertEquals(adventurer.getHitPoint(), expectedHitPoint);
    }

    @Test
    public void setAtk() {
        int expectedAtk = 50;
        Adventurer adventurer = new Adventurer(123, "abc");
        adventurer.setAtk(expectedAtk);
        assertEquals(adventurer.getAtk(), expectedAtk);
    }

    @Test
    public void setDef() {
        int expectedDef = 30;
        Adventurer adventurer = new Adventurer(123, "abc");
        adventurer.setDef(expectedDef);
        assertEquals(adventurer.getDef(), expectedDef);
    }

    @Test
    public void getCe() {
        Adventurer adventurer = new Adventurer(123, "abc");
        assertEquals(adventurer.getCe(), 1);
    }

    @Test
    public void getItems() {
        Adventurer adventurer = new Adventurer(123, "abc");
        Item item = new Item(456, "bottle", "HpBottle");
        adventurer.getItems().put(456, item);
        assertEquals(adventurer.getItems().get(456).getItemId(), 456);
    }


    @Test
    public void getBottles() {
        Adventurer adventurer = new Adventurer(123, "abc");
        Bottle bottle = new Bottle(456, "efg", 5, "HpBottle", 0);
        adventurer.getBottles().add(bottle);
        assertEquals(adventurer.getBottles().get(0).getIdBol(), 456);
    }

    @Test
    public void getEquipments() {
        Adventurer adventurer = new Adventurer(123, "abc");
        Equipment equipment = new Equipment(456, "efg", 5, 40);
        adventurer.getEquipments().add(equipment);
        assertEquals(adventurer.getEquipments().get(0).getID(), 456);
    }

    @Test
    public void getItemPackage() {
        Adventurer adventurer = new Adventurer(123, "abc");
        Item item = new Item(456, "bottle", "HpBottle");
        adventurer.getItemPackage().put(456, item);
        assertEquals(adventurer.getItemPackage().get(456).getItemId(), 456);
    }

    @Test
    public void giveBottle() {
        Adventurer adventurer = new Adventurer(1, "advName");
        Item item = adventurer.giveBottle(111, "hpBol", 100, "HpBottle", 0);
        assertNotNull(item);
        assertEquals("HpBottle", item.getType());
        assertTrue(item.getHpBottleHashMap().containsKey(111));
        assertEquals("hpBol", item.getHpBottleHashMap().get(111).getName());
        assertEquals(100, item.getHpBottleHashMap().get(111).getCapacity());

        Item item1 = adventurer.giveBottle(222, "atkBol", 50, "AtkBottle", 5);
        assertNotNull(item1);
        assertEquals("AtkBottle", item1.getType());
        assertTrue(item1.getAtkBottleHashMap().containsKey(222));
        assertEquals("atkBol", item1.getAtkBottleHashMap().get(222).getName());
        assertEquals(50, item1.getAtkBottleHashMap().get(222).getCapacity());
        assertEquals(5, item1.getAtkBottleHashMap().get(222).getBolCe());

        Item item2 = adventurer.giveBottle(333, "defBol", 40, "DefBottle", 10);
        assertNotNull(item2);
        assertEquals("DefBottle", item2.getType());
        assertTrue(item2.getDefBottleHashMap().containsKey(333));
        assertEquals("defBol", item2.getDefBottleHashMap().get(333).getName());
        assertEquals(40, item2.getDefBottleHashMap().get(333).getCapacity());
        assertEquals(10, item2.getDefBottleHashMap().get(333).getBolCe());

        Item item3 = adventurer.giveBottle(444, "WRONGNAME", 0, "WRONGTYPE", 0);
        assertNotNull(item3);
        assertTrue(item3.getHpBottleHashMap().isEmpty());
        assertTrue(item3.getAtkBottleHashMap().isEmpty());
        assertTrue(item3.getDefBottleHashMap().isEmpty());
    }

    @Test
    public void giveEquipment() {
        Adventurer adventurer = new Adventurer(1, "advName");
        Item item = adventurer.giveEquipment(111, "equName", 100, 15);
        assertNotNull(item);
        assertEquals("Equipment", item.getType());
        assertTrue(item.getEquipmentHashMap().containsKey(111));
        assertEquals("equName", item.getEquipmentHashMap().get(111).getName());
        assertEquals(100, item.getEquipmentHashMap().get(111).getDurability());
        assertEquals(15, item.getEquipmentHashMap().get(111).getEquCe());

        Item item1 = adventurer.giveEquipment(333, "equName2", 150, 20);
        assertEquals(150, item1.getEquipmentHashMap().get(333).getDurability());
    }

    @Test
    public void increaseDurability() {
        Adventurer adventurer = new Adventurer(1, "advName");
        Equipment equipment = new Equipment(123, "equName", 30, 40);
        Item item = new Item(123, "equName", "Equipment");
        assertNotNull(item);
        adventurer.getItems().put(123, item);
        adventurer.getItems().get(123).getEquipmentHashMap().put(123, equipment);
        adventurer.increaseDurability(adventurer, 123);
        assertEquals(adventurer.getItems().get(123).getEquipmentHashMap().get(123).getDurability(), 31);
    }

    @Test
    public void deleteItem() {
        Adventurer adventurer = new Adventurer(123, "advName");
        Equipment equipment = new Equipment(111, "equName", 40, 30);
        Item equItem = new Item(111, "equName", "Equipment");
        equItem.getEquipmentHashMap().put(111, equipment);
        adventurer.getItems().put(111, equItem);

        HpBottle hpBottle = new HpBottle(222, "hpName", 40, "HpBottle", 0);
        Item hpItem = new Item(222, "hpName", "HpBottle");
        hpItem.getHpBottleHashMap().put(222, hpBottle);
        adventurer.getItems().put(222, hpItem);

        AtkBottle atkBottle = new AtkBottle(333, "atkName", 40, "AtkBottle", 30);
        Item atkItem = new Item(333, "atkName", "AtkBottle");
        atkItem.getAtkBottleHashMap().put(333, atkBottle);
        adventurer.getItems().put(333, atkItem);

        DefBottle defBottle = new DefBottle(444, "defName", 40, "DefBottle", 20);
        Item defItem = new Item(444, "defName", "DefBottle");
        defItem.getDefBottleHashMap().put(444, defBottle);
        adventurer.getItems().put(444, defItem);

        adventurer.deleteItem(adventurer, 111);
        assertNull(adventurer.getItems().get(111));

        adventurer.deleteItem(adventurer, 222);
        assertNull(adventurer.getItems().get(222));

        adventurer.deleteItem(adventurer, 333);
        assertNull(adventurer.getItems().get(333));

        adventurer.deleteItem(adventurer, 444);
        assertNull(adventurer.getItems().get(444));
    }

    @Test
    public void useBottle() {
        Adventurer adventurer = new Adventurer(123,"advName");
        HpBottle hpBottle = new HpBottle(111,"hpName",40,"HpBottle",0);
        Item hpItem = new Item(111,"hpName","HpBottle");
        hpItem.getHpBottleHashMap().put(111,hpBottle);
        adventurer.getItemPackage().put(111,hpItem);
        adventurer.getItems().put(111,hpItem);
        adventurer.useBottle(adventurer,111);
        assertEquals(540,adventurer.getHitPoint());
        assertFalse(hpItem.getHpBottleHashMap().get(111).getIsFull());

        AtkBottle atkBottle = new AtkBottle(222,"atkName",40,"AtkBottle",5);
        Item atkItem = new Item(222,"atkName","AtkBottle");
        atkItem.getAtkBottleHashMap().put(222,atkBottle);
        adventurer.getItemPackage().put(222,atkItem);
        adventurer.getItems().put(222,atkItem);
        adventurer.useBottle(adventurer,222);
        assertEquals(6,adventurer.getAtk());
        assertFalse(atkItem.getAtkBottleHashMap().get(222).getIsFull());

        DefBottle defBottle = new DefBottle(333,"defName",40,"DefBottle",5);
        Item defItem = new Item(333,"defName","DefBottle");
        defItem.getDefBottleHashMap().put(333,defBottle);
        adventurer.getItemPackage().put(333,defItem);
        adventurer.getItems().put(333,defItem);
        adventurer.useBottle(adventurer,333);
        assertEquals(5,adventurer.getDef());
        assertFalse(defItem.getDefBottleHashMap().get(333).getIsFull());

        Item nullItem = new Item(444,"nullName","WRONGTYPE");
        adventurer.getItems().put(444,nullItem);
        adventurer.useBottle(adventurer,444);
        assertEquals(540,adventurer.getHitPoint());
    }
}