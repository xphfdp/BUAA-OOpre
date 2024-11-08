public class WndTreasure implements Treasure {
    @Override
    public void showInfo() {
        System.out.println("Windrunner Boots");
    }

    @Override
    public void usedBy(Adventurer adventurer) {
        int defenseToPlus = 30;
        adventurer.setDef(adventurer.getDef() + defenseToPlus);
        if (!adventurer.getEmployees().isEmpty()) {
            for (Adventurer adventurer1 : adventurer.getEmployees()) {
                adventurer1.setDef(adventurer1.getDef() + defenseToPlus);
            }
        }
    }
}
