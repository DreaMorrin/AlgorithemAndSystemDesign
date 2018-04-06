package main.Practice.OODesign.CallController;

public class CallCenter {
    private static CallCenter instance = null;
    private CallCenter () {}
    public static CallCenter getInstance() {
        if (instance == null) {
            synchronized (CallCenter.class) {
                if (instance == null) {
                    instance = new CallCenter();
                }
            }
        }
        return instance;
    }
}
