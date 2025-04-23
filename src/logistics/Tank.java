package logistics;

import logistics.material.BulletBelts;
import logistics.material.LiterDiesel;
import logistics.material.ShellBatches;
import logistics.quantities.NeedCollector;
import logistics.storage.FloatStorage;
import logistics.storage.IntStorage;

public class Tank extends Vehicle{
    private FloatStorage dieselStorage;
    private IntStorage bulletBeltsStorage;
    private IntStorage shellBatchesStorage;

    public Tank(String name) {
        super(name);
        dieselStorage = new FloatStorage(0, LiterDiesel.INSTANCE, 1200);
        bulletBeltsStorage = new IntStorage(0, BulletBelts.INSTANCE, 10);
        shellBatchesStorage = new IntStorage(0, ShellBatches.INSTANCE, 10);
    }

    @Override
    public void consumeAll(int intensityRate) {
        oilStorage.consume(1);
        greaseStorage.consume(1);
        dieselStorage.consume(intensityRate * 180);
        bulletBeltsStorage.consume(intensityRate * 2);
        shellBatchesStorage.consume(intensityRate * 2);
    }


    @Override
    public void reportNeeds(NeedCollector collector) {
        oilStorage.reportNeed(collector);
        greaseStorage.reportNeed(collector);
        dieselStorage.reportNeed(collector);
        bulletBeltsStorage.reportNeed(collector);
        shellBatchesStorage.reportNeed(collector);
    }


    @Override
    public void fillUpAll() {
        oilStorage.fillUp();
        greaseStorage.fillUp();
        dieselStorage.fillUp();
        bulletBeltsStorage.fillUp();
        shellBatchesStorage.fillUp();
    }
}
