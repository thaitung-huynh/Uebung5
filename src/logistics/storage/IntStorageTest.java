package logistics.storage;

import logistics.material.Oil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntStorageTest {
    private static final int MAX = 3;

    private IntStorage intStorage;

    @Before
    public void setup() {
        intStorage = new IntStorage(0, Oil.INSTANCE, MAX);
    }

    @Test
    public void testEmptyStorage() {
        assertEquals(0, intStorage.getStored());
    }

    @Test
    public void testGetStorage() {
        intStorage.fill(1);
        assertEquals(1, intStorage.getStored());
    }

    @Test
    public void testGetMax() {
        assertEquals(MAX, intStorage.getMax());
    }

    @Test
    public void testFillUp() {
        intStorage.fillUp();
        assertEquals(MAX, intStorage.getStored());
    }

    @Test
    public void testUpperBound() {
        intStorage.fill(MAX + 1);
        assertEquals(MAX, intStorage.getStored());
    }

    @Test
    public void testConsume() {
        intStorage.fillUp();
        assertEquals(MAX, intStorage.getStored());
        assertEquals(MAX, intStorage.consume(MAX));
    }

    @Test
    public void testLowerBound() {
        intStorage.consume(1);
        assertEquals(0, intStorage.getStored());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalFill() {
        intStorage.fill(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalConsume() {
        intStorage.consume(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalLowerBoundConstructor() {
        new IntStorage(-1, Oil.INSTANCE, MAX);
    }

    @Test
    public void testUpperBoundConstructor() {
        final IntStorage storage = new IntStorage(MAX + 1, Oil.INSTANCE, MAX);
        assertEquals(MAX, storage.getStored());
    }
}
