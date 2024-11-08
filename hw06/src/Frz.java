public class Frz implements Guard {
    @Override
    public boolean fight(Adventurer adv) {
        return adv.getComprehensiveCe(adv) > 5000;
    }

    @Override
    public String getType() {
        return "Frz";
    }
}
