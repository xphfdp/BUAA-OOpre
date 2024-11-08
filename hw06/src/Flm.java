public class Flm implements Guard {
    @Override
    public boolean fight(Adventurer adv) {
        return adv.getComprehensiveCe(adv) > 2000;
    }

    @Override
    public String getType() {
        return "Flm";
    }
}
