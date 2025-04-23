package logistics;

import logistics.material.BulletBelts;
import logistics.material.MetGallonsKerosene;
import logistics.material.RocketPods;
import logistics.quantities.NeedCollector;
import logistics.storage.FloatStorage;
import logistics.storage.IntStorage;

public class Helicopter extends Vehicle {
    private FloatStorage keroseneStorage;
    private IntStorage rocketPodsStorage;
    private IntStorage bulletBeltsStorage;

    public Helicopter(String name) {
        super(name);
        keroseneStorage = new FloatStorage(0, MetGallonsKerosene.INSTANCE, 500);
        rocketPodsStorage = new IntStorage(0, RocketPods.INSTANCE, 2);
        bulletBeltsStorage = new IntStorage(0, BulletBelts.INSTANCE, 2);
    }

    @Override
    public void consumeAll(int intensityRate) {
        oilStorage.consume(1);
        greaseStorage.consume(1);
        keroseneStorage.consume(intensityRate * 50);
        rocketPodsStorage.consume(intensityRate);
        bulletBeltsStorage.consume(intensityRate);
    }


    @Override
    public void reportNeeds(NeedCollector collector) {
        oilStorage.reportNeed(collector);
        greaseStorage.reportNeed(collector);
        keroseneStorage.reportNeed(collector);
        rocketPodsStorage.reportNeed(collector);
        bulletBeltsStorage.reportNeed(collector);
    }


    @Override
    public void fillUpAll() {
        oilStorage.fillUp();
        greaseStorage.fillUp();
        keroseneStorage.fillUp();
        rocketPodsStorage.fillUp();
        bulletBeltsStorage.fillUp();
    }
}
