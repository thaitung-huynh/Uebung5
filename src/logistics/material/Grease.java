package logistics.material;

import logistics.quantities.IntUnit;

public class Grease implements IntUnit {
    public static Grease INSTANCE = new Grease();

    private Grease() {}


    @Override
    public String toString() {
        return "units of grease";
    }
}
