package main.OA03042018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonManager {

    public static void main(String[] args) {
        Employee samir = new Employee("samir");
        Employee dom = new Employee("dom");
        Employee michael = new Employee("michael");

        Employee peter = new Employee("peter");
        Employee porter = new Employee("porter");
        Employee bob = new Employee("bob");

        dom.subordinates = Arrays.asList(bob, peter, porter);

        Employee milton = new Employee("milton");
        Employee nina = new Employee("nina");

        peter.subordinates = Arrays.asList(milton, nina);

        Employee bill = new Employee("bill");
        bill.subordinates = Arrays.asList(dom, samir, michael);

        Employee xiaopan = new Employee("xiaopan");

        CommonManager cm = new CommonManager();
        System.out.println(cm.getLowestCommonManager(bill, nina, peter));
    }

    public ResultType getLowestCommonManager(Employee reporter, Employee e1, Employee e2) {
        if (reporter == null) {
            return new ResultType(false, false, reporter);
        }
        boolean a_exist = false, b_exist = false;
        if (reporter.subordinates == null || reporter.subordinates.size() == 0) {
            if (reporter == e1) {
                a_exist = true;
            }
            if (reporter == e2) {
                b_exist = true;
            }
            return new ResultType(a_exist, b_exist, (a_exist || b_exist) ? reporter : null);
        }
        int count = 0;
        Employee lca = null;
        for (Employee subordinate : reporter.subordinates) {
            ResultType sub = getLowestCommonManager(subordinate, e1, e2);
            if (sub.a_exist || reporter == e1) {
                a_exist = true;
            }
            if (sub.b_exist || reporter == e2) {
                b_exist = true;
            }
            if (sub.node != null) {
                lca = sub.node;
                count++;
            }
        }

        if (reporter == e1 || reporter == e2) {
            return new ResultType(a_exist, b_exist, reporter);
        }

        if (count == 2) {
            return new ResultType(a_exist, b_exist, reporter);
        }

        if (lca != null) {
            return new ResultType(a_exist, b_exist, lca);
        }

        return new ResultType(a_exist, b_exist, null);

    }
}

class ResultType {
    boolean a_exist;
    boolean b_exist;
    Employee node;
    public ResultType(boolean a, boolean b, Employee node) {
        this.a_exist = a;
        this.b_exist = b;
        this.node = node;
    }
    
    @Override
    public String toString() {
        return this.a_exist + " " + this.b_exist + " " + this.node.name;
    }
    
}

class Employee {
    String name;
    List<Employee> subordinates;
    public Employee(String name) {
        this.name = name;
        this.subordinates = new ArrayList<>();
    }
}