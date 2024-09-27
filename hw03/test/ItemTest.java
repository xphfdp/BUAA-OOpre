import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void getItemId() {
        int itemId = 123;
        Item item = new Item(itemId,"bottle","HpBottle");
        assertEquals(item.getItemId(),itemId);
    }

    @Test
    public void getItemName() {
        String itemName = "bottle";
        Item item = new Item(123,itemName,"HpBottle");
        assertEquals(item.getItemName(),itemName);
    }

    @Test
    public void getType() {
        String itemType = "HpBottle";
        Item item = new Item(123,"bottle",itemType);
        assertEquals(item.getType(),itemType);
    }


    @Test
    public void getHpBottleHashMap() {
        Item item = new Item(123,"bottle","HpBottle");
        HashMap<Integer,HpBottle> hpBottleHashMap = item.getHpBottleHashMap();
        HpBottle hpBottle = new HpBottle(456,"hpBottle",50,"HpBottle",0);
        hpBottleHashMap.put(456,hpBottle);
        assertEquals(1,hpBottleHashMap.size());
        assertEquals(hpBottle,hpBottleHashMap.get(456));
    }

    @Test
    public void getAtkBottleHashMap() {
        Item item = new Item(123,"bottle","AtkBottle");
        HashMap<Integer,AtkBottle> atkBottleHashMap = item.getAtkBottleHashMap();
        AtkBottle atkBottle = new AtkBottle(456,"atkBottle",50,"AtkBottle",30);
        atkBottleHashMap.put(456,atkBottle);
        assertEquals(1,atkBottleHashMap.size());
        assertEquals(atkBottle,atkBottleHashMap.get(456));
    }

    @Test
    public void getDefBottleHashMap() {
        Item item = new Item(123,"bottle","DefBottle");
        HashMap<Integer,DefBottle> defBottleHashMap = item.getDefBottleHashMap();
        DefBottle defBottle = new DefBottle(456,"defBottle",50,"DefBottle",20);
        defBottleHashMap.put(456,defBottle);
        assertEquals(1,defBottleHashMap.size());
        assertEquals(defBottle,defBottleHashMap.get(456));
    }

    @Test
    public void getEquipmentHashMap() {
        Item item = new Item(123,"equip","Equipment");
        HashMap<Integer,Equipment> equipmentHashMap =item.getEquipmentHashMap();
        Equipment equipment = new Equipment(456,"equip2",25,30);
        equipmentHashMap.put(456,equipment);
        assertEquals(1,equipmentHashMap.size());
        assertEquals(equipment,equipmentHashMap.get(456));
    }
}