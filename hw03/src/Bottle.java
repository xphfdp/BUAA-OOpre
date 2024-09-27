public class Bottle {
    private final int idBol;
    private final String name;
    private int capacity;
    private final String type;
    private final int bolCe;
    private boolean isFull = true;

    public Bottle(int idBol, String name, int capacity,String type,int bolCe) {
        this.idBol = idBol;
        this.name = name;
        this.capacity = capacity;
        this.type = type;
        this.bolCe = bolCe;
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

    public int getBolCe() {
        return this.bolCe;
    }

    public boolean getIsFull() {
        return this.isFull;
    }

    public void setIsFull(boolean isFull)
    {
        this.isFull = isFull;
    }
}
