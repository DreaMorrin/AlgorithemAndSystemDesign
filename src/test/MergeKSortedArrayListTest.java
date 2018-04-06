package test;

import main.Practice.Algorithm.亚麻20140723.MergeKSortedArrayList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedArrayListTest {
    @Test
    public void testCase1() {
        MergeKSortedArrayList obj = new MergeKSortedArrayList();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        list1.add(4);
        list1.add(13);
        list1.add(9);
        list1.add(1);
        list1.add(9);
        list1.add(19);
        list1.add(8);
        list1.add(2);
        list1.add(7);
        list1.add(15);
        list1.add(14);

        list2.add(12);
        list2.add(9);
        list2.add(1);
        list2.add(4);
        list2.add(10);
        list2.add(15);
        list2.add(16);
        list2.add(19);
        list2.add(18);
        list2.add(2);
        list2.add(3);

        list3.add(5);
        list3.add(14);
        list3.add(12);
        list3.add(11);
        list3.add(3);
        list3.add(14);
        list3.add(12);
        list3.add(2);
        list3.add(9);
        list3.add(0);
        list3.add(1);
        List<List<Integer>> source = new ArrayList<>();
        source.add(list1);
        source.add(list2);
        source.add(list3);
        for (int value : obj.mergeKSortedArrayList(source)) {
            System.out.println(value);
        }
    }
}
