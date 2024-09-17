
//import java.lang.reflect.Array;

import java.util.ArrayList;

public class Adventurer {
    private final int idAdv;
    private final String name;
    private final ArrayList<Bottle> bottles = new ArrayList<>();
    private final ArrayList<Equipment> equipments = new ArrayList<>();

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

    public ArrayList<Bottle> getBottles() {
        return this.bottles;
    }

    public ArrayList<Equipment> getEquipments() {
        return this.equipments;
    }
}
