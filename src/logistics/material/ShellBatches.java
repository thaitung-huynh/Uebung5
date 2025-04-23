package logistics.material;

import logistics.quantities.IntUnit;

public class ShellBatches implements IntUnit {
    public static ShellBatches INSTANCE = new ShellBatches();

    private ShellBatches() {}

    @Override
    public String toString() {
        return "batches of 120mm shells";
    }
}
