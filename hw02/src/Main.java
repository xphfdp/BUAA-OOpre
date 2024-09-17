import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Adventurer> adventurers = new ArrayList<>();

    public static void addAdventurer() {
        int idAdv = scanner.nextInt();
        String nameAdv = scanner.next();
        Adventurer adventurer = new Adventurer(idAdv, nameAdv);
        adventurers.add(adventurer);
    }

    public static void giveBottle() {
        int idAdv = scanner.nextInt();
        int idBol = scanner.nextInt();
        String nameBol = scanner.next();
        int capacityBol = scanner.nextInt();
        Bottle bottle = new Bottle(idBol, nameBol, capacityBol);
        for (Adventurer adventurer : adventurers) {
            if (idAdv == adventurer.getID()) {
                adventurer.getBottles().add(bottle);
                break;
            }
        }
    }

    public static void giveEquipment() {
        int idAdv = scanner.nextInt();
        int idEqu = scanner.nextInt();
        String nameEqu = scanner.next();
        int durabilityEqu = scanner.nextInt();
        Equipment equipment = new Equipment(idEqu, nameEqu, durabilityEqu);
        for (Adventurer adventurer : adventurers) {
            if (idAdv == adventurer.getID()) {
                adventurer.getEquipments().add(equipment);
                break;
            }
        }
    }

    public static void increaseDurability() {
        int idAdv = scanner.nextInt();
        int idEqu = scanner.nextInt();
        for (Adventurer adventurer : adventurers) {
            if (idAdv == adventurer.getID()) {
                for (int j = 0; j < adventurer.getEquipments().size(); j++) {
                    if (idEqu == adventurer.getEquipments().get(j).getID()) {
                        adventurer.getEquipments().get(j).durabilityIncrease();
                        System.out.printf("%s %d\n",
                                adventurer.getEquipments().get(j).getName(),
                                adventurer.getEquipments().get(j).getDurability());
                        break;
                    }
                }
                break;
            }
        }
    }

    public static void deleteBottle() {
        int idAdv = scanner.nextInt();
        int idBol = scanner.nextInt();
        int bottleNumber;
        String delNameBol;
        int delCapacityBol;
        for (Adventurer adventurer : adventurers) {
            if (idAdv == adventurer.getID()) {
                for (int j = 0; j < adventurer.getBottles().size(); j++) {
                    if (idBol == adventurer.getBottles().get(j).getIdBol()) {
                        bottleNumber = adventurer.getBottles().size() - 1;
                        delNameBol = adventurer.getBottles().get(j).getName();
                        delCapacityBol = adventurer.getBottles().get(j).getCapacity();
                        adventurer.getBottles().remove(j);
                        System.out.printf("%d %s %d\n",
                                bottleNumber, delNameBol, delCapacityBol);
                        break;
                    }
                }
                break;
            }
        }
    }

    public static void deleteEquipment() {
        int idAdv = scanner.nextInt();
        int idEqu = scanner.nextInt();
        int equipmentNumber;
        String delNameEqu;
        int delDurabilityEqu;
        for (Adventurer adventurer : adventurers) {
            if (idAdv == adventurer.getID()) {
                for (int j = 0; j < adventurer.getEquipments().size(); j++) {
                    if (idEqu == adventurer.getEquipments().get(j).getID()) {
                        equipmentNumber = adventurer.getEquipments().size() - 1;
                        delNameEqu = adventurer.getEquipments().get(j).getName();
                        delDurabilityEqu =
                                adventurer.getEquipments().get(j).getDurability();
                        adventurer.getEquipments().remove(j);
                        System.out.printf("%d %s %d\n",
                                equipmentNumber, delNameEqu, delDurabilityEqu);
                        break;
                    }
                }
                break;
            }
        }
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        while (n > 0) {
            int op = scanner.nextInt();
            if (op == 1) {
                //执行操作1（加入一个有ID和name的冒险者）
                addAdventurer();
            } else if (op == 2) {
                //执行操作2（给ID冒险者有ID、name、capacity的药水瓶）
                giveBottle();
            } else if (op == 3) {
                //执行操作3（给冒险者有ID、name、durability的装备）
                giveEquipment();
            } else if (op == 4) {
                //执行操作4（给ID冒险者的ID装备增加一点耐久）
                increaseDurability();
            } else if (op == 5) {
                //执行操作5（将ID冒险者ID药水瓶删除）
                deleteBottle();
            } else {
                //执行操作6（将ID冒险者ID装备删除）
                deleteEquipment();
            }
            n--;
        }
    }
}