import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static final HashMap<Integer, Adventurer> adventurers = new HashMap<>();

    public static void addAdventurer() {
        int idAdv = scanner.nextInt();
        String nameAdv = scanner.next();
        Adventurer adventurer = new Adventurer(idAdv, nameAdv);
        adventurers.put(idAdv, adventurer);
    }

    public static void takeItem() {
        int idAdv = scanner.nextInt();
        int idItem = scanner.nextInt();
        Adventurer adventurer = adventurers.get(idAdv);
        Item item = adventurer.getItems().get(idItem);
        adventurer.getItemPackage().put(idItem, item);
    }

    public static void giveBottle() {
        int idAdv = scanner.nextInt();
        int idBol = scanner.nextInt();
        String nameBol = scanner.next();
        int capacity = scanner.nextInt();
        String type = scanner.next();
        int bolCe = scanner.nextInt();
        Item item = adventurers.get(idAdv).giveBottle(idBol, nameBol, capacity, type, bolCe);
        adventurers.get(idAdv).getItems().put(idBol, item);
    }

    public static void giveEquipment() {
        int idAdv = scanner.nextInt();
        int idEqu = scanner.nextInt();
        String nameEqu = scanner.next();
        int durability = scanner.nextInt();
        int equCe = scanner.nextInt();
        Item item = adventurers.get(idAdv).giveEquipment(idEqu, nameEqu, durability, equCe);
        adventurers.get(idAdv).getItems().put(idEqu, item);
    }

    public static void increaseDurability() {
        int idAdv = scanner.nextInt();
        int idEqu = scanner.nextInt();
        Adventurer adventurer = adventurers.get(idAdv);
        adventurer.increaseDurability(adventurer, idEqu);
    }

    public static void deleteItem() {
        int idAdv = scanner.nextInt();
        int idItem = scanner.nextInt();
        Adventurer adventurer = adventurers.get(idAdv);
        adventurer.deleteItem(adventurer, idItem);
    }

    public static void useBottle() {
        int idAdv = scanner.nextInt();
        int idBol = scanner.nextInt();
        Adventurer adventurer = adventurers.get(idAdv);
        adventurer.useBottle(adventurer, idBol);
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        while (n > 0) {
            int op = scanner.nextInt();
            if (op == 1) {                      //执行操作1（加入一个有ID和name的冒险者）
                addAdventurer();
            } else if (op == 2) {               //执行操作2（给ID冒险者有ID、name、capacity、type、CE的药水瓶）
                giveBottle();
            } else if (op == 3) {               //执行操作3（给ID冒险者有ID、name、durability、CE的装备）
                giveEquipment();
            } else if (op == 4) {               //执行操作4（给ID冒险者的ID装备增加一点耐久）
                increaseDurability();
            } else if (op == 5) {               //执行操作5（将ID冒险者ID物品删除）
                deleteItem();
            } else if (op == 6) {               //执行操作6（ID冒险者携带ID物品）
                takeItem();
            } else {                            //执行操作7（ID冒险者使用ID药水）
                useBottle();
            }
            n--;
        }
    }
}