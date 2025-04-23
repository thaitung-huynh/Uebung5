package logistics.material;

import logistics.quantities.IntUnit;

public class BulletBelts implements IntUnit {

    public static BulletBelts INSTANCE = new BulletBelts();

    private BulletBelts() {}

    @Override
    public String toString() {
        return "belts of 7.62 bullets";
    }

}
