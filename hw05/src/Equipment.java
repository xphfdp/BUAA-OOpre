public class Equipment {
    private final int idEqu;
    private final String name;
    private int durability;
    private final String type;
    private final int equCe;

    public Equipment(int idEqu, String name, int durability, String type, int equCe) {
        this.idEqu = idEqu;
        this.name = name;
        this.durability = durability;
        this.type = type;
        this.equCe = equCe;
    }

    public void durabilityIncrease() {
        this.durability++;
    }

    public void durabilityDecrease() {
        this.durability--;
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

    public int getEquCe() {
        return this.equCe;
    }

    public String getType() {
        return this.type;
    }
}
