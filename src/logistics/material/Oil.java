package logistics.material;

import logistics.quantities.IntUnit;

public class Oil implements IntUnit {
    public static Oil INSTANCE = new Oil();

    private Oil() {}

    @Override
    public String toString() {
        return "units of oil";
    }
}
