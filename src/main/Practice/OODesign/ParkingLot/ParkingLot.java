package main.Practice.OODesign.ParkingLot;

import main.Practice.OODesign.ParkingLot.models.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ParkingLot {
    int zipCode;
    Stack<Spot> smallSpot;
    Stack<Spot> mediumSpot;
    Stack<Spot> largeSpot;
    Stack<Spot> extraLargeSpot;
    Map<String, Spot> parkedSpots;
    long spotId = 0l;

    public ParkingLot (int small, int medium, int large, int extraLarge, int zipCode) {

        this.zipCode = zipCode;
        //initiate small spots
        this.smallSpot = new Stack<>();
        for (int i = 0; i < small; i++) {
            smallSpot.push(new Spot(spotId++, Size.S));
        }
        //initiate medium spots
        this.mediumSpot = new Stack<>();
        for (int i = 0; i < medium; i++) {
            mediumSpot.push(new Spot(spotId++, Size.M));
        }
        //initiate large spots
        this.largeSpot = new Stack<>();
        for (int i = 0; i < large; i++) {
            largeSpot.push(new Spot(spotId++, Size.L));
        }
        //initiate extra large spots
        this.extraLargeSpot = new Stack<>();
        for (int i = 0; i < extraLarge; i++) {
            extraLargeSpot.push(new Spot(spotId++, Size.XL));
        }

        //initiate parked spots
        this.parkedSpots = new HashMap<>(small + medium + large + extraLarge, 1L);
    }

    public Spot placeCar(Car car) {
        if (!mediumSpot.empty()) {
            Spot spot = mediumSpot.pop();
            spot.setVehicle(car);
            parkedSpots.put(car.getLicense(), spot);
            return spot;
        } else if (!largeSpot.empty()) {
            Spot spot = largeSpot.pop();
            spot.setVehicle(car);
            parkedSpots.put(car.getLicense(), spot);
            return spot;
        } else if (!extraLargeSpot.empty()) {
            Spot spot = extraLargeSpot.pop();
            spot.setVehicle(car);
            parkedSpots.put(car.getLicense(), spot);
            return spot;
        }
        return null;
    }

    public Spot placeMotorcycle(MotorCycle motorCycle) {
        if (!smallSpot.empty()) {
            Spot spot = smallSpot.pop();
            spot.setVehicle(motorCycle);
            parkedSpots.put(motorCycle.getLicense(), spot);
            return spot;
        } else if (!mediumSpot.empty()) {
            Spot spot = mediumSpot.pop();
            spot.setVehicle(motorCycle);
            parkedSpots.put(motorCycle.getLicense(), spot);
            return spot;
        } else if (!largeSpot.empty()) {
            Spot spot = largeSpot.pop();
            spot.setVehicle(motorCycle);
            parkedSpots.put(motorCycle.getLicense(), spot);
            return spot;
        } else if (!extraLargeSpot.empty()) {
            Spot spot = extraLargeSpot.pop();
            spot.setVehicle(motorCycle);
            parkedSpots.put(motorCycle.getLicense(), spot);
            return spot;
        }
        return null;
    }

    public Spot placeTruck(Truck truck) {
        if (!largeSpot.empty()) {
            Spot spot = largeSpot.pop();
            spot.setVehicle(truck);
            parkedSpots.put(truck.getLicense(), spot);
            return spot;
        } else if (!extraLargeSpot.empty()) {
            Spot spot = extraLargeSpot.pop();
            spot.setVehicle(truck);
            parkedSpots.put(truck.getLicense(), spot);
            return spot;
        }
        return null;
    }

    public Spot placeBus(Bus bus) {
        if (!extraLargeSpot.empty()) {
            Spot spot = extraLargeSpot.pop();
            spot.setVehicle(bus);
            parkedSpots.put(bus.getLicense(), spot);
            return spot;
        }
        return null;
    }

    public Spot retrieveVehicleByVehicleId(String license) {
        if (license == null || license.length() == 0) {
            return null;
        }
        Spot spot = parkedSpots.getOrDefault(license, null);
        if (spot == null) {
            freeUpTheSpot(spot);
        }
        return spot;
    }

    private void freeUpTheSpot(Spot spot) {
        spot.setVehicle(null);
        switch (spot.getSize()) {
            case S: smallSpot.push(spot); break;
            case M: mediumSpot.push(spot); break;
            case L: largeSpot.push(spot); break;
            case XL: extraLargeSpot.push(spot); break;
            default: break;
        }
    }
}
