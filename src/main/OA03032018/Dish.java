package main.OA03032018;

import java.util.*;

/**
 * 大概意思是给人推荐菜谱，input是两个二维String 数组，第一个用来存菜名和对应的菜系，第二个用来存人名和这个人喜欢的菜系，
 * 要去返回一个二维String数组，存的值是人名对应可能喜欢的菜名(如果人名后面对应的是“*”，那么就表示所有菜系都要)。
 * input: String[][] menu, String[][] personPreferences.
 * output: String[][] recommendation
 * example 1:
 * input:
 * {{"Pizza", "Italian"}, {"Pasta", "Italian"}, {"Burger", "American"}},
 * {{"Peter", "Italian"}, {"Adam", "American"}}
 * Expected output:
 * {{"Peter", "Pizza"}, {"Peter", "Pasta"}, {"Adam", "Burger"}}
 *
 * example 2:
 * input:
 * {{"Pizza", "Italian"}, {"Pasta", "Italian"}, {"Burger", "American"}},
 * {{"Peter", "*"}}.
 * Expected output:
 * {{"Peter", "Pizza"}, {"Peter", "Pasta"}, {"Peter", "Burger"}}
 * 解题思路参考：
 * 几乎没坑，就是考察基本数据结构HashMap。把菜谱存入HashMap后，对person进行循环匹配，注意*号的处理。
 */

public class Dish {
    public static void main(String[] args) {
        Dish d = new Dish();
        String[][] dishes = {{"Pizza", "Italian"}, {"Pasta", "Italian"}, {"Burger", "American"}};
        String[][] persons = {{"Peter", "Italian"}, {"Adam", "American"}};
        for (String[] item : d.getRecommendation(dishes, persons)) {
            System.out.println(Arrays.toString(item));
        }
    }

    public String[][] getRecommendation(String[][] dishes, String[][] person) {
        if (dishes == null || dishes.length == 0) {
            return null;
        }

        if (person == null || person.length == 0) {
            return null;
        }
        Map<String, List<String>> dishMap = new HashMap<>();
        for (int i = 0; i < dishes.length; i++) {
            if (dishMap.containsKey(dishes[i][1])) {
                dishMap.get(dishes[i][1]).add(dishes[i][0]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(dishes[i][0]);
                dishMap.put(dishes[i][1], list);
            }
        }

        List<String> allDishes = new ArrayList<>();
        for (List<String> ls : dishMap.values()) {
            allDishes.addAll(ls);
        }

        Map<String, List<String>> personMap = new HashMap<>();
        int size = 0;
        for (int i = 0; i < person.length; i++) {
            if (person[i][0].equals("*")) {
                personMap.put(person[i][0], allDishes);
                size += allDishes.size();
            } else {
                personMap.put(person[i][0], dishMap.get(person[i][1]));
                size += dishMap.get(person[i][1]).size();
            }
        }
        String[][] results = new String[size][2];
        int start = 0;
        for (Map.Entry<String, List<String>> entry : personMap.entrySet()) {
            for (String s : entry.getValue()) {
                results[start][0] = entry.getKey();
                results[start][1] = s;
                start++;
            }
        }
        return results;
    }
}
