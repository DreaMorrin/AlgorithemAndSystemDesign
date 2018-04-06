package main.Practice.OODesign.解析表达式;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<Integer, Double> map;

    public Storage() {
        this.map = new HashMap<>();
    }

    public void clear() {
        map.clear();
    }

    public double getValue(int id) {
        return map.getOrDefault(id, 0.0);
    }

    public void setValue(int id, double value) {
        map.put(id, value);
    }

    public void addValue(int id, double value) {
        map.put(id, value);

    }
}
