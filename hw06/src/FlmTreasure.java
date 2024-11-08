public class FlmTreasure implements Treasure {
    @Override
    public void showInfo() {
        System.out.println("Flamebrand Sword");
    }

    @Override
    public void usedBy(Adventurer adventurer) {
        int attackToPlus = 40;
        adventurer.setAtk(adventurer.getAtk() + attackToPlus);
        if (!adventurer.getEmployees().isEmpty()) {
            for (Adventurer adventurer1 : adventurer.getEmployees()) {
                adventurer1.setAtk(adventurer1.getAtk() + attackToPlus);
            }
        }
    }
}
