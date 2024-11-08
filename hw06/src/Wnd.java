public class Wnd implements Guard {
    @Override
    public boolean fight(Adventurer adv) {
        return adv.getComprehensiveCe(adv) > 4000;
    }

    @Override
    public String getType() {
        return "Wnd";
    }
}
