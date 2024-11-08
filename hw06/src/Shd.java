public class Shd implements Guard {
    @Override
    public boolean fight(Adventurer adv) {
        return adv.getComprehensiveCe(adv) > 1000;
    }

    @Override
    public String getType() {
        return "Shd";
    }
}
