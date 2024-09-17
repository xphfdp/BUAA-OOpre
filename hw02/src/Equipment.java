
public class Equipment {
    private final int idEqu;
    private final String name;
    private int durability;

    public Equipment(int idEqu, String name, int durability) {
        this.idEqu = idEqu;
        this.name = name;
        this.durability = durability;
    }

    public void durabilityIncrease() {
        this.durability++;
    }

    public int getID() {
        return this.idEqu;
    }

    public String getName() {
        return this.name;
    }

    public int getDurability() {
        return this.durability;
    }
}
