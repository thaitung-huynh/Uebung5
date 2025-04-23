package logistics.material;

import logistics.quantities.FloatUnit;

public class MetGallonsKerosene implements FloatUnit {
    public static MetGallonsKerosene INSTANCE = new MetGallonsKerosene();

    private MetGallonsKerosene() {}

    @Override
    public String toString() {
        return "met gallons of kerosene";
    }
}
