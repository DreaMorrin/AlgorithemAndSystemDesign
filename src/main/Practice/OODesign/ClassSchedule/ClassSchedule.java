package main.Practice.OODesign.ClassSchedule;

import java.util.ArrayList;
import java.util.List;

public class ClassSchedule {
    List<Day> days;

    public ClassSchedule() {
        this.days = new ArrayList<>();
    }

    public void addDays(int numOfDays) {
        for (int i = 0; i < numOfDays; i++) {
            days.add(new Day());
        }
    }

    public boolean addCourse(Course course) {
        for (int day : course.days) {
            Day courseDay = days.get(day);
            if (!courseDay.canAdd(course)) {
                return false;
            }
            courseDay.addCourse(course);
        }
        return true;
    }
}
