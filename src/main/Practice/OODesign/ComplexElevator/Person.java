package main.Practice.OODesign.ComplexElevator;

public class Person {
    public static int AUTO_INCREMENT = 0;

    private String name;
    private int id;
    private int weight;

    public Person(String name, int weight) {
        this.name = name;
        this.weight = weight;
        this.id = AUTO_INCREMENT++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
