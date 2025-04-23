package logistics;

import logistics.quantities.FloatUnit;
import logistics.quantities.IntUnit;
import logistics.quantities.NeedCollector;

import java.util.ArrayList;
import java.util.List;

public class Manager {

    private List<Vehicle> vehicles = new ArrayList<Vehicle>();


    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void fillUpVehicles() {
        for (Vehicle vehicle : vehicles) {
            vehicle.fillUpAll();
        }
    }

    public void logTick(int intensityRate) {
        for (Vehicle vehicle : vehicles) {
            vehicle.consumeAll(intensityRate);
        }
    }

    public NeedCollector collectNeeds() {
        NeedCollector collector = new NeedCollector();
        for (Vehicle vehicle : vehicles) {
            vehicle.reportNeeds(collector);
        }
        return collector;
    }

    public void showOverallNeed() {
        collectNeeds().show();
    }

    public void showNeed(IntUnit unit) {
        NeedCollector collector = collectNeeds();
        System.out.println(collector.getNeed(unit));
    }

    public void showNeed(FloatUnit unit) {
        NeedCollector collector = collectNeeds();
        System.out.println(collector.getNeed(unit));
    }


}
