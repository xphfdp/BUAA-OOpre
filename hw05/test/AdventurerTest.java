import org.junit.Test;
import java.util.ArrayList;
import java.util.TreeMap;

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
    public void getMaxBottles() {
        int expectedMaxBottles = 21;
        Adventurer adventurer = new Adventurer(123, "abc");
        adventurer.setAtk(100);
        assertEquals(expectedMaxBottles, adventurer.getMaxBottles());
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
    public void getItemPackage() {
        Adventurer adventurer = new Adventurer(123, "abc");
        Item item = new Item(456, "bottle", "HpBottle");
        adventurer.getItemPackage().put(456, item);
        assertEquals(adventurer.getItemPackage().get(456).getItemId(), 456);
    }

    @Test
    public void getFragments() {
        Adventurer adventurer = new Adventurer(123, "abc");
        Fragment fragment = new Fragment(234, "fragment");
        adventurer.getFragments().add(fragment);
        assertEquals(adventurer.getFragments().get(0).getIdFrag(), 234);
    }

    @Test
    public void getTakenEquipment() {
        Adventurer adventurer = new Adventurer(123, "abc");
        Equipment equipment = new Equipment(234, "equName", 30, "Axe", 100);
        adventurer.getTakenEquipment().put("equName", equipment);
        assertEquals(234, adventurer.getTakenEquipment().get("equName").getID());
    }

    @Test
    public void getTakenBottles() {
        Adventurer adventurer = new Adventurer(123, "abc");
        Bottle bottle = new Bottle(234, "bolName", 30, "AtkBottle", 30);
        TreeMap<Integer, Bottle> bottleTreeMap = new TreeMap<>();
        bottleTreeMap.put(234, bottle);
        adventurer.getTakenBottles().put("bolName", bottleTreeMap);
        assertEquals(234, adventurer.getTakenBottles().get("bolName").get(234).getIdBol());
    }

    @Test
    public void takeItems() {
        Adventurer adventurer = new Adventurer(123, "advName");
        Equipment equipment = new Equipment(1, "equName", 50, "Sword", 10);
        HpBottle hpBottle = new HpBottle(2, "hpName", 50, "HpBottle", 0);
        Item equItem = new Item(1, "equName", "Equipment");
        equItem.getEquipmentHashMap().put(1, equipment);
        Item bolItem = new Item(2, "hpName", "HpBottle");
        bolItem.getBottleHashMap().put(2, hpBottle);
        adventurer.getItems().put(1, equItem);
        adventurer.getItems().put(2, bolItem);

        adventurer.takeItem(adventurer, 1);
        assertTrue(adventurer.getItemPackage().containsKey(1));
        assertTrue(adventurer.getTakenEquipment().containsKey("equName"));
        assertEquals(equipment, adventurer.getTakenEquipment().get("equName"));

        TreeMap<Integer, Bottle> bottleTreeMap = new TreeMap<>();
        bottleTreeMap.put(3, new Bottle(3, "bolName", 30, "AtkBottle", 40));
        adventurer.getTakenBottles().put("bolName", bottleTreeMap);
        adventurer.takeItem(adventurer, 2);
        assertTrue(adventurer.getItemPackage().containsKey(2));
        assertEquals(1, adventurer.getTakenBottles().get("bolName").size());
        //assertEquals(hpBottle,adventurer.getTakenBottles().get("bolName").get(3));

        TreeMap<Integer, Bottle> bottleTreeMap1 = new TreeMap<>();
        bottleTreeMap1.put(4, new Bottle(4, "bolName", 30, "HpBottle", 0));
        bottleTreeMap1.put(5, new Bottle(5, "bolName", 30, "HpBottle", 0));
        bottleTreeMap1.put(6, new Bottle(6, "bolName", 30, "HpBottle", 0));
        adventurer.getTakenBottles().put("bolName", bottleTreeMap1);
        adventurer.takeItem(adventurer, 2);
        assertEquals(3, adventurer.getTakenBottles().get("bolName").size());
        assertFalse(adventurer.getTakenBottles().get("bolName").containsKey(2));
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
        Item item = adventurer.giveEquipment(111, "equName", 100, "Axe", 15);
        assertNotNull(item);
        assertEquals("Equipment", item.getType());
        assertTrue(item.getEquipmentHashMap().containsKey(111));
        assertEquals("equName", item.getEquipmentHashMap().get(111).getName());
        assertEquals(100, item.getEquipmentHashMap().get(111).getDurability());
        assertEquals(15, item.getEquipmentHashMap().get(111).getEquCe());

        Item item1 = adventurer.giveEquipment(333, "equName2", 150, "Axe", 20);
        assertEquals(150, item1.getEquipmentHashMap().get(333).getDurability());
    }

    @Test
    public void increaseDurability() {
        Adventurer adventurer = new Adventurer(1, "advName");
        Equipment equipment = new Equipment(123, "equName", 30, "Axe", 40);
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
        Equipment equipment = new Equipment(111, "equName", 40, "Axe", 30);
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
        Bottle hpBottle = new Bottle(201,"hpBottle",50,"HpBottle",0);
        Item hpItem = new Item(201,"hpBottle","HpBottle");
        hpItem.getBottleHashMap().put(201,hpBottle);
        Bottle atkBottle = new Bottle(202,"atkBottle",20,"AtkBottle",30);
        Item atkItem = new Item(202,"atkBottle","AtkBottle");
        atkItem.getBottleHashMap().put(202,atkBottle);
        Bottle defBottle = new Bottle(203,"defBottle",30,"DefBottle",30);
        Item defItem = new Item(203,"defBottle","DefBottle");
        defItem.getBottleHashMap().put(203,defBottle);
        adventurer.getItems().put(201, hpItem);
        adventurer.getItems().put(202, atkItem);
        adventurer.getItems().put(203, defItem);
        TreeMap<Integer, Bottle> hpMap = new TreeMap<>();
        hpMap.put(201,hpBottle);
        adventurer.getTakenBottles().put("hpBottle",hpMap);
        TreeMap<Integer, Bottle> atkMap = new TreeMap<>();
        atkMap.put(202,atkBottle);
        adventurer.getTakenBottles().put("atkBottle",atkMap);
        TreeMap<Integer, Bottle> defMap = new TreeMap<>();
        defMap.put(203,defBottle);
        adventurer.getTakenBottles().put("defBottle",defMap);
        adventurer.useBottle(adventurer,201);
        assertEquals(550,adventurer.getHitPoint());
        adventurer.useBottle(adventurer,202);
        assertEquals(31,adventurer.getAtk());
        adventurer.useBottle(adventurer,203);
        assertEquals(30,adventurer.getDef());
    }

    @Test
    public void exchangeWelfare() {
        Adventurer adventurer = new Adventurer(123, "advName");
        adventurer.getFragments().add(new Fragment(1, "fragment"));
        adventurer.getFragments().add(new Fragment(2, "fragment"));
        adventurer.getFragments().add(new Fragment(3, "fragment"));
        adventurer.getFragments().add(new Fragment(4, "fragment"));
        adventurer.getFragments().add(new Fragment(5, "fragment"));

        HpBottle bottle = new HpBottle(11, "hpBottle", 100, "HpBottle", 0);
        Item item = new Item(11, "hpBottle", "Bottle");
        item.getBottleHashMap().put(11, bottle);
        adventurer.getItems().put(11, item);
        adventurer.exchangeWelfare(adventurer, "fragment", 11);
        assertTrue(adventurer.getItems().get(11).getBottleHashMap().get(11).getIsFull());

        adventurer.getFragments().add(new Fragment(6, "fragment"));
        adventurer.getFragments().add(new Fragment(7, "fragment"));
        adventurer.getFragments().add(new Fragment(8, "fragment"));
        adventurer.getFragments().add(new Fragment(9, "fragment"));
        adventurer.getFragments().add(new Fragment(10, "fragment"));
        adventurer.exchangeWelfare(adventurer, "fragment", 22);
        assertTrue(adventurer.getItems().containsKey(22));
        assertEquals("HpBottle", adventurer.getItems().get(22).getType());

        adventurer.getFragments().clear();
        adventurer.getFragments().add(new Fragment(11, "fragment"));
        adventurer.getFragments().add(new Fragment(12, "fragment"));
        adventurer.exchangeWelfare(adventurer, "fragment", 33);
        assertFalse(adventurer.getItems().containsKey(33));
    }

    @Test
    public void battle() {
        Adventurer adventurer0 = new Adventurer(123,"advName");
        adventurer0.setAtk(10);
        Item axe = adventurer0.giveEquipment(11,"axeName",10,"Axe",5);
        adventurer0.getTakenEquipment().put("axeName",axe.getEquipmentHashMap().get(11));

        ArrayList<Adventurer> adventurers = new ArrayList<>();
        Adventurer enemy1 = new Adventurer(1,"enemy1");
        enemy1.setDef(10);
        enemy1.setHitPoint(100);
        adventurers.add(enemy1);
        Adventurer enemy2 = new Adventurer(2, "enemy2");
        enemy2.setDef(8);
        enemy2.setHitPoint(80);
        adventurers.add(enemy2);

        adventurer0.battle(adventurer0,"axeName",adventurers);
        assertEquals(10,enemy1.getHitPoint());
        assertEquals(8,enemy2.getHitPoint());
        assertEquals(9,adventurer0.getTakenEquipment().get("axeName").getDurability());

        adventurer0.setAtk(1);
        adventurer0.battle(adventurer0,"axeName",adventurers);
        assertEquals(10,enemy1.getHitPoint());
        assertEquals(8,enemy2.getHitPoint());
    }
}