package main.Practice.OODesign.AirportDesign;

public class Airport {
    private static Airport instance = null;
    private Airport () {}

    public static Airport getInstance() {
        if (instance == null) {
            synchronized (Airport.class) {
                if (instance == null) {
                    instance = new Airport();
                }
            }
        }
        return instance;
    }
}
