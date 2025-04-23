package logistics;

import logistics.material.Grease;
import logistics.material.Oil;
import logistics.quantities.NeedCollector;
import logistics.storage.IntStorage;

public abstract class Vehicle {
    private String name;
    protected IntStorage oilStorage;
    protected IntStorage greaseStorage;

    public Vehicle(String name) {
        this.name = name;
        this.oilStorage = new IntStorage(0, Oil.INSTANCE, 3);
        this.greaseStorage = new IntStorage(0, Grease.INSTANCE, 3);
    }

    public abstract void reportNeeds(NeedCollector collector);

    public abstract void fillUpAll();

    public abstract void consumeAll(int intensityRate);


}
