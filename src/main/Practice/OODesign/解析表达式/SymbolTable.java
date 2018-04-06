package main.Practice.OODesign.解析表达式;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

    private Map<String, Integer> map; // id 与符号的key-value pair
    private int curId;

    public SymbolTable() {
        this.curId = 0;
        map = new HashMap<>();
    }

    public int add(String symbol) {
        return curId++;
    }

    public int find(String s) {
        return map.get(s);
    }

    public int getCurId() {
        return curId;
    }

    public void clear() {
        map.clear();
    }

    public String getSymbolByName(int id) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == id) {
                return entry.getKey();
            }
        }
        return null;
    }
}
