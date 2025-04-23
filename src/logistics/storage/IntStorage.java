package logistics.storage;

import logistics.quantities.IntUnit;
import logistics.quantities.NeedCollector;

public class IntStorage {
    private int stored;
    private IntUnit unit;
    private final int max;

    public IntStorage(int stored, IntUnit unit, int max) {
        if (stored < 0 || max < 0)
            throw new IllegalArgumentException("negative");
        this.stored = Math.min(stored, max);
        this.unit = unit;
        this.max = max;
    }


    public int consume(int amount) {
        if (amount < 0)
            throw new IllegalArgumentException("negative");
        int preStored = stored;
        stored -= amount;
        if (stored < 0) stored = 0;
        return (stored == 0 ? preStored : amount);
    }

    public void fill(int amount) {
        if (amount < 0) throw new IllegalArgumentException("negative");
        stored = Math.min(stored + amount, max);
    }

    public void fillUp() {
        stored = max;
    }

    public void reportNeed(NeedCollector collector) {

        collector.add(max - stored, unit);
    }


    public int getStored() {
        return stored;
    }

    public IntUnit getUnit() {
        return unit;
    }

    public int getMax() {
        return max;
    }

    @Override
    public String toString() {
        return "storage with " + stored + " of " + max + " " + unit.toString();
    }

}
