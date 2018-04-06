package main.Practice.OODesign.ClassSchedule;

import java.util.List;

public class Course {
    int courseId;
    int startTime;
    int duration;
    List<Integer> days;
    public Course(int courseId, int startTime, int duration, List<Integer> days) {
        this.courseId = courseId;
        this.startTime = startTime;
        this.duration = duration;
        this.days = days;
    }
}
