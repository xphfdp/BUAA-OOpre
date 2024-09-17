
public class Bottle {
    private final int idBol;
    private final String name;
    private final int capacity;

    public Bottle(int idBol, String name, int capacity) {
        this.idBol = idBol;
        this.name = name;
        this.capacity = capacity;
    }

    public int getIdBol() {
        return this.idBol;
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
