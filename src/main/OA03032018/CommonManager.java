package main.OA03032018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 寻找公司员工的最低共同上司
 * 变化1:不是bineary tree
 * 变化2:ceo不是manager 如果共同上司是ceo return null
 * 变化3:员工可能不在这个公司 return null
 * 解题思路参考：
 * 题目描述不太清楚，坑：注意这个是个多叉数不是二叉。
 * Reporter 是下属
 */

public class CommonManager {
    public static void main(String[] args) {
        Employee samir = new Employee("samir");
        Employee dom = new Employee("dom");
        Employee michael = new Employee("michael");

        Employee peter = new Employee("peter");
        Employee porter = new Employee("porter");
        Employee bob = new Employee("bob");

        dom.reporters = Arrays.asList(bob, peter, porter);

        Employee milton = new Employee("milton");
        Employee nina = new Employee("nina");

        peter.reporters = Arrays.asList(milton, nina);

        Employee bill = new Employee("bill");
        bill.reporters = Arrays.asList(dom, samir, michael);

        Employee xiaopan = new Employee("xiaopan");

        CommonManager cm = new CommonManager();
        System.out.println(cm.getLowestCommonManager(bill, dom, samir).a_exist);
    }

    public ResultType getLowestCommonManager(Employee root, Employee e1, Employee e2) {
        if (root == null) {
            return new ResultType(false, false, root);
        }
        boolean a_exist = false, b_exist = false;
        if (root.reporters == null && root.reporters.size() == 0) {
            if (root == e1) {
                a_exist = true;
            }
            if (root == e2) {
                b_exist = true;
            }
            return new ResultType(a_exist, b_exist, (a_exist || b_exist) ? root : null);
        }
        int count = 0;
        Employee lca = null;
        for (Employee reporter : root.reporters) {
            ResultType sub = getLowestCommonManager(reporter, e1, e2);

            if (sub.a_exist || root == e1) {
                a_exist = true;
            }
            if (sub.b_exist || root == e2) {
                b_exist = true;
            }

            if (sub.node != null) {
                lca = sub.node;
                count++;
            }
        }

        if (root == e1 || root == e2) {
            return new ResultType(a_exist, b_exist, root);
        }
        if (count == 2) {
            return new ResultType(a_exist, b_exist, root);
        }

        if (lca != null) {
            return new ResultType(a_exist, b_exist, lca);
        }

        return new ResultType(a_exist, b_exist, null);
    }
}

class Employee {
    String name;
    List<Employee> reporters;
    public Employee (String name) {
        this.name = name;
        this.reporters = new ArrayList<>();
    }
}

class ResultType {
    boolean a_exist, b_exist;
    Employee node;
    public ResultType (boolean a, boolean b, Employee node) {
        this.a_exist = a;
        this.b_exist = b;
        this.node = node;
    }
}
