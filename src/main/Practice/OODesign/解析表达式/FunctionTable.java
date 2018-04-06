package main.Practice.OODesign.解析表达式;

import java.util.HashMap;
import java.util.Map;

public class FunctionTable {
    private Map<Integer, Function> map;

    public FunctionTable() {
        this.map = new HashMap<>();
    }

    public Function getFunction(int id) {
        return map.getOrDefault(id, null);
    }

    public int getSize() {
        return map.size();
    }
}
