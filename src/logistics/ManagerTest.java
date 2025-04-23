package logistics;

import logistics.material.BulletBelts;
import logistics.material.Grease;
import logistics.material.LiterDiesel;
import logistics.material.MetGallonsKerosene;
import logistics.material.Oil;
import logistics.material.RocketPods;
import logistics.material.ShellBatches;
import logistics.quantities.NeedCollector;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ManagerTest {
    private static final float EPS = 1e-5f;
    private Manager manager;

    @Before
    public void setup() {
        manager = new Manager();
        manager.addVehicle(new Tank("Leo1"));
        manager.addVehicle(new Tank("Leo2"));
        manager.addVehicle(new Helicopter("Tiger1"));
        manager.addVehicle(new Helicopter("Tiger2"));
    }

    @Test
    public void testInitialNeed() {
        final NeedCollector collector = manager.collectNeeds();
        assertEquals(4, collector.getNeed(RocketPods.INSTANCE));
        assertEquals(12, collector.getNeed(Oil.INSTANCE));
        assertEquals(24, collector.getNeed(BulletBelts.INSTANCE));
        assertEquals(20, collector.getNeed(ShellBatches.INSTANCE));
        assertEquals(12, collector.getNeed(Grease.INSTANCE));
        assertEquals(1000f, collector.getNeed(MetGallonsKerosene.INSTANCE), EPS);
        assertEquals(2400f, collector.getNeed(LiterDiesel.INSTANCE), EPS);
    }

    @Test
    public void testNeedAfterFillUp() {
        manager.fillUpVehicles();
        final NeedCollector collector = manager.collectNeeds();
        assertEquals(0, collector.getNeed(RocketPods.INSTANCE));
        assertEquals(0, collector.getNeed(Oil.INSTANCE));
        assertEquals(0, collector.getNeed(BulletBelts.INSTANCE));
        assertEquals(0, collector.getNeed(ShellBatches.INSTANCE));
        assertEquals(0, collector.getNeed(Grease.INSTANCE));
        assertEquals(0f, collector.getNeed(MetGallonsKerosene.INSTANCE), EPS);
        assertEquals(0f, collector.getNeed(LiterDiesel.INSTANCE), EPS);
    }

    @Test
    public void testNeedAfterLogTick() {
        manager.fillUpVehicles();
        manager.logTick(1);
        final NeedCollector collector = manager.collectNeeds();
        assertEquals(2, collector.getNeed(RocketPods.INSTANCE));
        assertEquals(4, collector.getNeed(Oil.INSTANCE));
        assertEquals(6, collector.getNeed(BulletBelts.INSTANCE));
        assertEquals(4, collector.getNeed(ShellBatches.INSTANCE));
        assertEquals(4, collector.getNeed(Grease.INSTANCE));
        assertEquals(360f, collector.getNeed(LiterDiesel.INSTANCE), EPS);
        assertEquals(100f, collector.getNeed(MetGallonsKerosene.INSTANCE), EPS);
    }
}
