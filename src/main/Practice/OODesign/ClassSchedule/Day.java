package main.Practice.OODesign.ClassSchedule;

import java.util.HashMap;
import java.util.Map;

public class Day {
    Map<Integer, Course> courses;

    public Day() {
        courses = new HashMap<>();
    }

    public boolean canAdd(Course course) {
        for (Map.Entry<Integer, Course> entry : courses.entrySet()) {
            if (isConflict(entry.getValue(), course)) {
                return false;
            }
        }
        return true;
    }

    public void addCourse(Course course) {
        courses.put(course.courseId, course);
    }

    private boolean isConflict(Course existing, Course toAdd) {
        if (existing.startTime < (toAdd.startTime + toAdd.duration) && existing.startTime > toAdd.startTime) {
            return true;
        } else if (existing.startTime + existing.duration < (toAdd.startTime + toAdd.duration) &&
                existing.startTime + existing.duration > toAdd.startTime) {
            return true;
        }
        return false;
    }
}
