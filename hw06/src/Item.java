import java.util.HashMap;
import java.util.Objects;

public class Item {
    private final int itemId;
    private final String itemName;
    private final String type;
    private final int ce;
    private HashMap<Integer, HpBottle> hpBottleHashMap = new HashMap<>();
    private HashMap<Integer, AtkBottle> atkBottleHashMap = new HashMap<>();
    private HashMap<Integer, DefBottle> defBottleHashMap = new HashMap<>();
    private HashMap<Integer, Equipment> equipmentHashMap = new HashMap<>();
    private HashMap<Integer, Bottle> bottleHashMap = new HashMap<>();

    public Item(int itemId, String itemName, String type,int ce) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.type = type;
        this.ce = ce;
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

    public String getMainType() {
        if (Objects.equals(this.type, "AtkBottle") ||
                Objects.equals(this.type, "HpBottle") ||
                Objects.equals(this.type, "DefBottle")) {
            return "Bottle";
        } else {
            return "Equipment";
        }
    }

    public int getCe() {
        return this.ce;
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

    public HashMap<Integer, Bottle> getBottleHashMap() {
        return this.bottleHashMap;
    }

    public void setBottleHashMap(HashMap<Integer, Bottle> bottleHashMap) {
        this.bottleHashMap = bottleHashMap;
    }

    public void setEquipmentHashMap(HashMap<Integer, Equipment> equipmentHashMap) {
        this.equipmentHashMap = equipmentHashMap;
    }

    public void setHpBottleHashMap(HashMap<Integer, HpBottle> hpBottleHashMap) {
        this.hpBottleHashMap = hpBottleHashMap;
    }
}
