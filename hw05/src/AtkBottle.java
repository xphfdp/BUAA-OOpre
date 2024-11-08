public class AtkBottle extends Bottle implements CombatEffectiveness {
    public AtkBottle(int idBol, String name, int capacity, String type, int bolCe) {
        super(idBol, name, capacity, type, bolCe);
    }

    @Override
    public int getCe() {
        return this.getBolCe() + (this.getCapacity() / 100);
    }
}