package logistics.material;

import logistics.quantities.IntUnit;

public class RocketPods implements IntUnit {
    public static RocketPods INSTANCE = new RocketPods();

    private RocketPods() {}

    @Override
    public String toString() {
        return "pods of 70mm rockets";
    }
}
