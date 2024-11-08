public class TreasureFactory {
    public static Treasure createTreasure(Guard guard) {
        switch (guard.getType()) {
            case "Shd":
                return new ShdTreasure();
            case "Flm":
                return new FlmTreasure();
            case "Stn":
                return new StnTreasure();
            case "Wnd":
                return new WndTreasure();
            case "Frz":
                return new FrzTreasure();
            default:
                throw new IllegalArgumentException("Unknown guard type");
        }
    }
}
