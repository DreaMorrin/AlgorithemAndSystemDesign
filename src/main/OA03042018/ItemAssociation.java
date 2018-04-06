package main.OA03042018;

import java.util.*;

public class ItemAssociation {

    public static void main(String[] args) {
        ItemAssociation ia = new ItemAssociation();
        String[][] items = {{"itemA", "itemB"}, {"itemC", "itemD"},
                {"itemA", "itemC"}, {"itemE", "itemF"}, {"itemG", "itemD"}};
        for (String str : ia.getLargest(items)) {
            System.out.println(str);
        }
    }

    public List<String> getLargest(String[][] items) {
        List<String> list = new ArrayList<>();
        if (items == null || items.length == 0 ||
                items[0] == null || items[0].length == 0) {
            return list;
        }
        Map<String, String> map = new HashMap<>();
        for (String[] item : items) {
            map.put(item[0], item[0]);
            map.put(item[1], item[1]);
        }

        for (String[] pair : items) {
            String k1 = map.get(pair[0]);
            String k2 = map.get(pair[1]);
            String val, unionKey;
            if (k1.compareTo(k2) > 0) {
                unionKey = k1;
                val = k2;
            } else {
                unionKey = k2;
                val = k1;
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getValue().equals(val)) {
                    map.put(entry.getKey(), unionKey);
                }
            }
        }
        Map<String, List<String>> coll = new HashMap<>();
        int size = Integer.MIN_VALUE;
        String maxKey = null;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (coll.containsKey(entry.getValue())) {
                List<String> ls = coll.get(entry.getValue());
                ls.add(entry.getKey());
                if (ls.size() > size) {
                    size = ls.size();
                    maxKey = entry.getValue();
                }
            } else {
                List<String> nList = new ArrayList<>();
                nList.add(entry.getKey());
                coll.put(entry.getValue(), nList);
            }
        }

        for (String str : coll.get(maxKey)) {
            list.add(str);
        }

        Collections.sort(list);
        return list;
    }
}
