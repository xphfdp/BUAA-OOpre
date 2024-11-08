public class FrzTreasure implements Treasure {
    @Override
    public void showInfo() {
        System.out.println("Frostbite Staff");
    }

    @Override
    public void usedBy(Adventurer adventurer) {
        int attackToPlus = 50;
        adventurer.setAtk(adventurer.getAtk() + attackToPlus);
        if (!adventurer.getEmployees().isEmpty()) {
            for (Adventurer adventurer1 : adventurer.getEmployees()) {
                adventurer1.setAtk(adventurer1.getAtk() + attackToPlus);
            }
        }
    }
}
