import java.util.HashMap;

public class Item {
    private final int itemId;
    private final String itemName;
    private final String type;
    private HashMap<Integer, HpBottle> hpBottleHashMap = new HashMap<>();
    private HashMap<Integer, AtkBottle> atkBottleHashMap = new HashMap<>();
    private HashMap<Integer, DefBottle> defBottleHashMap = new HashMap<>();
    private HashMap<Integer, Equipment> equipmentHashMap = new HashMap<>();

    public Item(int itemId, String itemName, String type) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.type = type;
    }

    public int getItemId() {
        return this.itemId;
    }

    public String getItemName() {
        return this.itemName;
    }

    public String getType() {
        return this.type;
    }

    public HashMap<Integer, HpBottle> getHpBottleHashMap() {
        return this.hpBottleHashMap;
    }

    public HashMap<Integer, AtkBottle> getAtkBottleHashMap() {
        return this.atkBottleHashMap;
    }

    public HashMap<Integer, DefBottle> getDefBottleHashMap() {
        return this.defBottleHashMap;
    }

    public HashMap<Integer, Equipment> getEquipmentHashMap() {
        return this.equipmentHashMap;
    }
}
