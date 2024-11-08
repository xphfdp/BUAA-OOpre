public class StnTreasure implements Treasure {
    @Override
    public void showInfo() {
        System.out.println("Stoneheart Amulet");
    }

    @Override
    public void usedBy(Adventurer adventurer) {
        int defenseToPlus = 40;
        adventurer.setDef(adventurer.getDef() + defenseToPlus);
        if (!adventurer.getEmployees().isEmpty()) {
            for (Adventurer adventurer1 : adventurer.getEmployees()) {
                adventurer1.setDef(adventurer1.getDef() + defenseToPlus);
            }
        }
    }
}
