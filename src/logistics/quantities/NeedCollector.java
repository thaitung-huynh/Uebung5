package logistics.quantities;

import java.util.HashMap;
import java.util.Map;

public class NeedCollector {
    private Map<IntUnit, Integer> intNeeded = new HashMap<>();
    private Map<FloatUnit, Float> floatNeeded = new HashMap<>();

    public NeedCollector() {
        intNeeded = new HashMap<>();
        floatNeeded = new HashMap<>();
    }

    public void add(int amount, IntUnit unit) {
        if (intNeeded.containsKey(unit)) {
            intNeeded.put(unit, intNeeded.get(unit) + amount);
        }
        else
            intNeeded.put(unit, amount);
    }

    public void add(float amount, FloatUnit unit) {
        if (floatNeeded.containsKey(unit))
            floatNeeded.put(unit, floatNeeded.get(unit) + amount);
        else
            floatNeeded.put(unit, amount);
    }

    public int getNeed(IntUnit unit) {
        return intNeeded.get(unit);
    }

    public float getNeed(FloatUnit unit) {
        return floatNeeded.get(unit);
    }

    public void show() {
        System.out.println(intNeeded);
        System.out.println(floatNeeded);
    }
}
