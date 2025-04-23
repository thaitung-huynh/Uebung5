package logistics.material;

import logistics.quantities.FloatUnit;

public class LiterDiesel implements FloatUnit {
    public static LiterDiesel INSTANCE = new LiterDiesel();

    private LiterDiesel() {}

    @Override
    public String toString() {
        return "liters of diesel";
    }
}
