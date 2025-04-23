package logistics.storage;

import logistics.quantities.FloatUnit;
import logistics.quantities.NeedCollector;

public class FloatStorage {

    private float stored;
    private FloatUnit unit;
    private final float max;

    public FloatStorage(float stored, FloatUnit unit, float max) {
        if (stored < 0 || max < 0)
            throw new IllegalArgumentException("negative");
        this.stored = stored;
        this.unit = unit;
        this.max = max;
    }


    public float consume(float amount) {
        float preStored = stored;
        stored -= amount;
        if (stored < 0) stored = 0;
        return (stored == 0 ? preStored : amount);
    }

    public void fill(float amount) {
        stored = Math.min(stored + amount, max);
    }

    public void fillUp() {
        stored = max;
    }

    public void reportNeed(NeedCollector collector) {
        collector.add(max - stored, unit);
    }


    public float getStored() {
        return stored;
    }

    public FloatUnit getUnit() {
        return unit;
    }

    public float getMax() {
        return max;
    }

    @Override
    public String toString() {
        return "storage with " + stored + " of " + max + " " + unit.toString();
    }

}
