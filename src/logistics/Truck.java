package logistics;

import logistics.material.BulletBelts;
import logistics.material.LiterDiesel;
import logistics.quantities.NeedCollector;
import logistics.storage.FloatStorage;
import logistics.storage.IntStorage;

public class Truck extends Vehicle {
    private FloatStorage dieselStorage;
    private IntStorage bulletBeltsStorage;

    public Truck(String name) {
        super(name);
        dieselStorage = new FloatStorage(0, LiterDiesel.INSTANCE, 180);
        bulletBeltsStorage = new IntStorage(0, BulletBelts.INSTANCE, 3);
    }

    @Override
    public void consumeAll(int intensityRate) {
        oilStorage.consume(1);
        greaseStorage.consume(1);
        dieselStorage.consume(intensityRate * 25);
        bulletBeltsStorage.consume(intensityRate * 2);
    }


    @Override
    public void reportNeeds(NeedCollector collector) {
        oilStorage.reportNeed(collector);
        greaseStorage.reportNeed(collector);
        dieselStorage.reportNeed(collector);
        bulletBeltsStorage.reportNeed(collector);
    }


    @Override
    public void fillUpAll() {
        oilStorage.fillUp();
        greaseStorage.fillUp();
        dieselStorage.fillUp();
        bulletBeltsStorage.fillUp();
    }

}
