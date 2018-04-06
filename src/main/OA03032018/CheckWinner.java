package main.OA03032018;

import java.util.ArrayList;
import java.util.List;

/**
 * 说的是小明要帮公司买水果，给了一个codeList， 里面装的是他买的水果，给了一个shoppingCart里面装的是target水果，
 * 目标是检查codelist里的水果顺序是否和shoppingCart里的顺序匹配。
 *注意的是只有codelist中的所有链表的item之后加起来小于等于shoppingcart里item之和才可能返回1。
 *另外在codelist中有可能出现item时 "anything"， 它可以和任意的水果匹配。
 *Ex1:
*
 *codelist:
 *[apple, apple],
 *[orange, banana, orange]
 *shoppingCart: [orange, apple, apple, orange, banana, orange].
 *return 1, 因为codelist里的顺序和shoppingcart里除了第一个orange之后的水果顺序匹配.
 *
 *Ex2:
 *codelist:
 *[orange, banana, orange]，
 *[apple, apple]
 *shoppingCart: [orange, apple, apple, orange, banana, orange]
 *return 0, 因为codeList里的顺序和shoppingcart没法匹配。
 *
 *Ex3:
 *codelist:
 *[apple, apple],
 *[orange, banana, orange],
 *[pear, orange, grape]
 *shoppingCart: [orange, apple, apple, orange, banana, orange, pear, grape]
 *return 0, 因为codelist里最后一个[pear, orange, grape]中的orange没法和shoppingcart里的水果匹配。
 *
 *Ex4:
 *codeList:
 *[apple, apple],
 *[orange, anything, orange].
 *shoppingCart:
 *[orange, apple, apple, orange, mango, orange]
 *return 1。
 *第一题直接用two pointer扫描就行了，因为是顺序匹配的，codeList里面匹配上的就不再管了，没有匹配到的就从这一行的起点重新开始。
 *shoppingCart那边先记录初始位置，然后和另一边同步移动，匹配不到的时候就从初始位置的后面一位重新开始，
 *能匹配codeList的完整一行就更新起始位置。
 *解题思路参考：
 *题目好长，具体细节可能不一样。通常用two pointers可以解决，配合滑动窗口可以O(n)时间复杂度。
 *坑：可能抽到的题目会有附加一个条件就是两个codelist集合直接可以任意匹配shoppingcart里面的东西，那么就需要另一个pointer。
 *参考答案没有考虑这个附加条件。
 */

public class CheckWinner {
    public static void main(String[] args) {
        CheckWinner cw = new CheckWinner();
        List<List<String>> codeList = new ArrayList<List<String>>();
        List<String> code = new ArrayList<String>();
        code.add("apple");
        code.add("apple");
        codeList.add(code);
        code = new ArrayList<String>();
        code.add("anything");
        code.add("banana");
        code.add("orange");
        codeList.add(code);

        List<String> shoppingCart = new ArrayList<String>();
        shoppingCart.add("orange");
        shoppingCart.add("apple");
        shoppingCart.add("apple");
        shoppingCart.add("orange");
        shoppingCart.add("banana");
        shoppingCart.add("orange");

        System.out.println(cw.checkWinner(codeList, shoppingCart));

    }

    public int checkWinner(List<List<String>> codeList, List<String> shoppingCart) {
        if (shoppingCart == null || shoppingCart.size() == 0) {
            return 0;
        }
        List<String> nList = new ArrayList<>();
        for (List<String> subList : codeList) {
            for (String item: subList) {
                nList.add(item);
            }
        }

        if (nList.size() > shoppingCart.size()) {
            return 0;
        }
        int right = 0;
        for (int i = 0; i <= shoppingCart.size() - nList.size(); i++) {
            while (right < nList.size() && (nList.get(right).equals(shoppingCart.get(i + right)) || nList.get(right).equals("anything"))) {
                right++;
            }
            if (right == nList.size()) {
                return 1;
            }
            right = 0;
        }
        return -1;
    }
}
