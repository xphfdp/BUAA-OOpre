import java.util.ArrayList;
import java.util.HashMap;

public class Adventurer implements CombatEffectiveness {
    private final int idAdv;
    private final String name;
    private int hitPoint = 500;
    private int atk = 1;
    private int def = 0;
    //private final ArrayList<Item> items = new ArrayList<>();            //冒险者所拥有的所有物品
    private final HashMap<Integer, Item> items = new HashMap<>();
    private final ArrayList<Bottle> bottles = new ArrayList<>();
    private final ArrayList<Equipment> equipments = new ArrayList<>();
    private final HashMap<Integer, Item> itemPackage = new HashMap<>();  //冒险者所携带的物品

    public Adventurer(int idAdv, String name) {
        this.idAdv = idAdv;
        this.name = name;
    }

    public int getID() {
        return this.idAdv;
    }

    public String getName() {
        return this.name;
    }

    public int getHitPoint() {
        return this.hitPoint;
    }

    public int getAtk() {
        return this.atk;
    }

    public int getDef() {
        return this.def;
    }

    public int getAdvCe() {
        return this.atk + this.def;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public HashMap<Integer, Item> getItems() {
        return this.items;
    }

    public ArrayList<Bottle> getBottles() {
        return this.bottles;
    }

    public ArrayList<Equipment> getEquipments() {
        return this.equipments;
    }

    public HashMap<Integer, Item> getItemPackage() {
        return this.itemPackage;
    }

    @Override
    public int getCe() {
        return this.atk + this.def;
    }

    public Item giveBottle(int idBol, String nameBol, int capacity, String type, int bolCe) {
        Item item = new Item(idBol, nameBol, type);
        switch (type) {
            case "HpBottle":
                HpBottle hpBottle = new HpBottle(idBol, nameBol, capacity, type, 0);
                item.getHpBottleHashMap().put(idBol, hpBottle);
                break;
            case "AtkBottle":
                AtkBottle atkBottle = new AtkBottle(idBol, nameBol, capacity, type, bolCe);
                item.getAtkBottleHashMap().put(idBol, atkBottle);
                break;
            case "DefBottle":
                DefBottle defBottle = new DefBottle(idBol, nameBol, capacity, type, bolCe);
                item.getDefBottleHashMap().put(idBol, defBottle);
                break;
            default:
                System.out.println("WRONG BOTTLE TYPE");
        }
        return item;
    }

    public Item giveEquipment(int idEqu, String nameEqu, int durability, int equCe) {
        Item item = new Item(idEqu, nameEqu, "Equipment");
        Equipment equipment = new Equipment(idEqu, nameEqu, durability, equCe);
        item.getEquipmentHashMap().put(idEqu, equipment);
        return item;
    }

    public void increaseDurability(Adventurer adventurer, int idEqu) {
        Equipment equipment = adventurer.getItems().get(idEqu).getEquipmentHashMap().get(idEqu);
        equipment.durabilityIncrease();
        System.out.printf("%s %d\n", equipment.getName(), equipment.getDurability());
    }

    public void deleteItem(Adventurer adventurer,int idItem) {
        String className = "";
        String itemName = "";
        int specific = 0;
        Item item = adventurer.getItems().get(idItem);
        if (item.getEquipmentHashMap().containsKey(idItem)) {
            className = "Equipment";
            itemName = item.getEquipmentHashMap().get(idItem).getName();
            specific = item.getEquipmentHashMap().get(idItem).getDurability();
        } else if (item.getHpBottleHashMap().containsKey(idItem)) {
            className = "HpBottle";
            itemName = item.getHpBottleHashMap().get(idItem).getName();
            specific = item.getHpBottleHashMap().get(idItem).getCapacity();
        } else if (item.getAtkBottleHashMap().containsKey(idItem)) {
            className = "AtkBottle";
            itemName = item.getAtkBottleHashMap().get(idItem).getName();
            specific = item.getAtkBottleHashMap().get(idItem).getCapacity();
        } else if (item.getDefBottleHashMap().containsKey(idItem)) {
            className = "DefBottle";
            itemName = item.getDefBottleHashMap().get(idItem).getName();
            specific = item.getDefBottleHashMap().get(idItem).getCapacity();
        }
        adventurer.getItems().remove(idItem);
        System.out.printf("%s %s %d\n", className, itemName, specific);
    }

    public void useBottle(Adventurer adventurer,int idBol) {
        Item item = adventurer.getItemPackage().get(idBol);
        Item item1 = adventurer.getItems().get(idBol);
        String nameAdv = adventurer.getName();
        String nameBol = item1.getItemName();
        int hitPoint = adventurer.getHitPoint();
        int attack = adventurer.getAtk();
        int defense = adventurer.getDef();
        if (item != null) {
            String type = item.getType();
            if (type.equals("HpBottle") && item.getHpBottleHashMap().get(idBol).getIsFull()) {
                hitPoint += item.getHpBottleHashMap().get(idBol).getCapacity();
                item.getHpBottleHashMap().get(idBol).setIsFull(false);
                adventurer.setHitPoint(hitPoint);
            } else if (type.equals("AtkBottle") &&
                    item.getAtkBottleHashMap().get(idBol).getIsFull()) {
                attack += item.getAtkBottleHashMap().get(idBol).getCe();
                item.getAtkBottleHashMap().get(idBol).setIsFull(false);
                adventurer.setAtk(attack);
            } else if (type.equals("DefBottle") &&
                    item.getDefBottleHashMap().get(idBol).getIsFull()) {
                defense += item.getDefBottleHashMap().get(idBol).getCe();
                item.getDefBottleHashMap().get(idBol).setIsFull(false);
                adventurer.setDef(defense);
            } else {
                adventurer.getItemPackage().remove(idBol);
            }
            System.out.printf("%s %d %d %d\n", nameAdv, hitPoint, attack, defense);
        } else {
            System.out.printf("%s fail to use %s\n", nameAdv, nameBol);
        }
    }
}
