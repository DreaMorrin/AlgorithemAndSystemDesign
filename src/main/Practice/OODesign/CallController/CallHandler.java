package main.Practice.OODesign.CallController;

import java.util.ArrayList;
import java.util.List;

public class CallHandler {
    private static final int LEVELS = 3;

    private List<List<? extends Employee>> employeeLevels;
    private List<List<Call>> callQueue;

    public CallHandler(int numOfRespondant, int numOfManager, int numOfDirector) {

        List<Respondant> respondants = new ArrayList<>();
        for (int i = 0; i < numOfRespondant; i++) {
            respondants.add(new Respondant());
        }

        List<Manager> managers = new ArrayList<>();
        for (int i = 0; i < numOfManager; i++) {
            managers.add(new Manager());
        }

        List<Director> directors = new ArrayList<>();
        for (int i = 0; i < numOfDirector; i++) {
            directors.add(new Director());
        }
        employeeLevels.add(respondants);
        employeeLevels.add(managers);
        employeeLevels.add(directors);

        callQueue = new ArrayList<>();
    }

    public Employee getHandlerForCall(Call call) {
        return null;
    }

    public void dispatchCall(Call call, Employee employee) {

    }
}
