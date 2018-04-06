package main.Practice.CC189.SocialNetwork;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private List<Integer> friends = new ArrayList<>();
    private int personId;
    private String info;

    public Person(int id) {
        this.personId = id;
    }

    public List<Integer> getFriends() {
        return friends;
    }

    public void setFriends(List<Integer> friends) {
        this.friends = friends;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
