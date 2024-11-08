public class Num implements Factor {
    private final int value;

    public Num(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public void print() {
        System.out.println("Num " + this);
    }

    public int getValue() {
        return this.value;
    }
}
