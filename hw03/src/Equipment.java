public class Equipment {
    private final int idEqu;
    private final String name;
    private int durability;
    private final int equCe;

    public Equipment(int idEqu, String name, int durability, int equCe) {
        this.idEqu = idEqu;
        this.name = name;
        this.durability = durability;
        this.equCe = equCe;
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

    public int getEquCe() {
        return this.equCe;
    }
}
