
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.TreeMap;

public class Adventurer implements CombatEffectiveness {
    private final int idAdv;
    private final String name;
    private int hitPoint = 500;
    private int atk = 1;
    private int def = 0;
    private final HashMap<Integer, Item> items = new HashMap<>();
    private final HashMap<Integer, Item> itemPackage = new HashMap<>();  //冒险者所携带的物品
    private final ArrayList<Fragment> fragments = new ArrayList<>();
    private final HashMap<String, Equipment> takenEquipment = new HashMap<>();
    private final HashMap<String, TreeMap<Integer, Bottle>> takenBottles = new HashMap<>();

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

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getMaxBottles() {
        return this.getCe() / 5 + 1;
    }

    public HashMap<Integer, Item> getItems() {
        return this.items;
    }

    public HashMap<Integer, Item> getItemPackage() {
        return this.itemPackage;
    }

    public ArrayList<Fragment> getFragments() {
        return this.fragments;
    }

    public HashMap<String, Equipment> getTakenEquipment() {
        return this.takenEquipment;
    }

    public HashMap<String, TreeMap<Integer, Bottle>> getTakenBottles() {
        return this.takenBottles;
    }

    @Override
    public int getCe() {
        return this.atk + this.def;
    }

    public void takeItem(Adventurer adventurer, int idItem) {
        Item item = adventurer.getItems().get(idItem);
        if (item != null) {
            adventurer.getItemPackage().put(idItem, item);
            String name = item.getItemName();
            if (Objects.equals(item.getType(), "Equipment")) {
                adventurer.getTakenEquipment().put(name, item.getEquipmentHashMap().get(idItem));
            } else {
                Bottle bottle = item.getBottleHashMap().get(idItem);
                if (adventurer.getTakenBottles().containsKey(name)) {
                    if (adventurer.getTakenBottles().get(name).size() <
                            adventurer.getMaxBottles()) {
                        adventurer.getTakenBottles().get(name).put(idItem, bottle);
                    }
                } else {
                    TreeMap<Integer, Bottle> bottleTreeMap = new TreeMap<>();
                    bottleTreeMap.put(idItem, bottle);
                    adventurer.getTakenBottles().put(name, bottleTreeMap);
                }
            }
        }
    }

    public Item giveBottle(int idBol, String nameBol, int capacity, String type, int bolCe) {
        Item item = new Item(idBol, nameBol, type);
        Bottle bottle = new Bottle(idBol, nameBol, capacity, type, bolCe);
        item.getBottleHashMap().put(idBol, bottle);
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

    public Item giveEquipment(int idEqu, String nameEqu, int durability, String type, int equCe) {
        Item item = new Item(idEqu, nameEqu, "Equipment");
        Equipment equipment = new Equipment(idEqu, nameEqu, durability, type, equCe);
        item.getEquipmentHashMap().put(idEqu, equipment);
        return item;
    }

    public void increaseDurability(Adventurer adventurer, int idEqu) {
        if (adventurer.getItems().get(idEqu) != null &&
                adventurer.getItems().get(idEqu).getEquipmentHashMap().get(idEqu) != null) {
            Equipment equipment = adventurer.getItems().get(idEqu).getEquipmentHashMap().get(idEqu);
            equipment.durabilityIncrease();
            System.out.printf("%s %d\n", equipment.getName(), equipment.getDurability());
        }
    }

    public void deleteItem(Adventurer adventurer, int itemId) {
        int specific = 0;
        String className = "";
        Item item = adventurer.getItems().get(itemId);
        if (item != null) {
            String itemName = item.getItemName();
            if (item.getEquipmentHashMap().containsKey(itemId)) {
                Equipment equipment = item.getEquipmentHashMap().get(itemId);
                className = equipment.getType();
                specific = equipment.getDurability();
                HashMap<String, Equipment> hashMap = adventurer.getTakenEquipment();
                if (hashMap.containsKey(itemName) && (hashMap.get(itemName).getID() == itemId)) {
                    adventurer.getTakenEquipment().remove(itemName);
                }
            } else if (item.getBottleHashMap().containsKey(itemId)) {
                Bottle bottle = item.getBottleHashMap().get(itemId);
                className = bottle.getType();
                specific = bottle.getCapacity();
                if (adventurer.getTakenBottles().get(itemName) != null) {
                    adventurer.getTakenBottles().get(itemName).remove(itemId);
                }
            }
            adventurer.getItems().remove(itemId);
            adventurer.getItemPackage().remove(itemId);
            System.out.printf("%s %s %d\n", className, itemName, specific);
        }
    }

    public void useBottle(Adventurer adventurer, int idBol) {
        String advName = adventurer.getName();
        String bolName = adventurer.getItems().get(idBol).getItemName();
        int hitPoint = adventurer.getHitPoint();
        int attack = adventurer.getAtk();
        int defense = adventurer.getDef();
        if (adventurer.getTakenBottles().containsKey(bolName) &&
                adventurer.getTakenBottles().get(bolName) != null &&
                adventurer.getTakenBottles().get(bolName).containsKey(idBol) &&
                adventurer.getTakenBottles().get(bolName).get(idBol) != null) {
            String type = adventurer.getTakenBottles().get(bolName).get(idBol).getType();
            Bottle bottle = adventurer.getTakenBottles().get(bolName).get(idBol);
            if (bottle.getIsFull()) {
                if (Objects.equals(type, "HpBottle")) {
                    hitPoint += bottle.getCapacity();
                    bottle.setIsFull(false);
                    adventurer.setHitPoint(hitPoint);
                } else if (Objects.equals(type, "AtkBottle")) {
                    attack += bottle.getBolCe() + (bottle.getCapacity() / 100);
                    bottle.setIsFull(false);
                    adventurer.setAtk(attack);
                } else if (Objects.equals(type, "DefBottle")) {
                    defense += bottle.getBolCe() + (bottle.getCapacity() / 100);
                    bottle.setIsFull(false);
                    adventurer.setDef(defense);
                }
            } else {
                adventurer.getItems().remove(idBol);
                adventurer.getTakenBottles().get(bolName).remove(idBol);
                adventurer.getItemPackage().remove(idBol);
            }
            System.out.printf("%s %d %d %d\n", advName, hitPoint, attack, defense);
        } else {
            System.out.printf("%s fail to use %s\n", advName, bolName);
        }
    }

    public void exchangeWelfare(Adventurer adventure, String nameFrag, int idWelfare) {
        long fragCount = adventure.getFragments().stream()
                .filter(fragment -> Objects.equals(fragment.getNameFrag(), nameFrag))
                .count();
        if (fragCount < 5) {
            System.out.printf("%d: Not enough fragments collected yet\n", fragCount);
            return;
        }
        Item item = adventure.getItems().get(idWelfare);
        if (item != null) {
            if ("Bottle".equals(item.getMainType())) {
                if (item.getBottleHashMap() == null) {
                    item.setBottleHashMap(new HashMap<>());
                }
                Bottle bottle = item.getBottleHashMap().get(idWelfare);
                if (bottle != null && !bottle.getIsFull()) {
                    bottle.setIsFull(true);
                }
                if (bottle != null) {
                    System.out.printf("%s %d\n", item.getItemName(), bottle.getCapacity());
                }
            } else if ("Equipment".equals(item.getMainType())) {
                if (item.getEquipmentHashMap() == null) {
                    item.setEquipmentHashMap(new HashMap<>());
                }
                Equipment equipment = item.getEquipmentHashMap().get(idWelfare);
                if (equipment != null) {
                    equipment.durabilityIncrease();
                    System.out.printf("%s %d\n", item.getItemName(), equipment.getDurability());
                }
            }
        } else {
            HpBottle hpBottle = new HpBottle(idWelfare, nameFrag, 100, "HpBottle", 0);
            item = new Item(idWelfare, nameFrag, "HpBottle");
            if (item.getHpBottleHashMap() == null) {
                item.setHpBottleHashMap(new HashMap<>());
            }
            item.getHpBottleHashMap().put(idWelfare, hpBottle);
            item.getBottleHashMap().put(idWelfare,hpBottle);
            adventure.getItems().put(idWelfare, item);
            System.out.printf("Congratulations! HpBottle %s acquired\n", nameFrag);
        }
        int removeCount = 0;
        Iterator<Fragment> iterator = adventure.getFragments().iterator();
        while (iterator.hasNext() && removeCount < 5) {
            Fragment fragment = iterator.next();
            if (Objects.equals(fragment.getNameFrag(), nameFrag)) {
                iterator.remove();
                removeCount++;
            }
        }
    }

    public void battle(Adventurer adventurer0, String equName, ArrayList<Adventurer> list) {
        int maxDef = -1;
        for (Adventurer adventurer : list) {
            if (maxDef < adventurer.getDef()) {
                maxDef = adventurer.getDef();
            }
        }
        Equipment equipment = adventurer0.getTakenEquipment().get(equName);
        if (equipment == null) {
            System.out.printf("Adventurer %d defeated\n", adventurer0.getID());
        } else {
            int advAtk = adventurer0.getAtk();
            int equCe = equipment.getEquCe();
            if (advAtk + equCe > maxDef) {
                for (Adventurer adventurer : list) {
                    int hitPoint = adventurer.getHitPoint();
                    if (Objects.equals(equipment.getType(), "Axe")) {
                        adventurer.setHitPoint(hitPoint / 10);
                    } else if (Objects.equals(equipment.getType(), "Sword")) {
                        adventurer.setHitPoint(hitPoint - advAtk - equCe + adventurer.getDef());
                    } else {
                        adventurer.setHitPoint(hitPoint - advAtk - equCe);
                    }
                    System.out.printf("%s %d\n", adventurer.getName(), adventurer.getHitPoint());

                }
                int idEqu = equipment.getID();
                adventurer0.getTakenEquipment().get(equName).durabilityDecrease();
                if (adventurer0.getTakenEquipment().get(equName).getDurability() <= 0) {
                    adventurer0.getTakenEquipment().remove(equName);
                    adventurer0.getItems().remove(idEqu);
                    adventurer0.getItemPackage().remove(idEqu);
                }
            } else {
                System.out.printf("Adventurer %d defeated\n", adventurer0.getID());
            }
        }
    }
}
