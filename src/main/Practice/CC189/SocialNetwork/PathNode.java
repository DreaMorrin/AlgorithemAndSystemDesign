package main.Practice.CC189.SocialNetwork;

import java.util.LinkedList;

public class PathNode {

    private Person person = null;
    private PathNode previousNode = null;
    public PathNode(Person p, PathNode previous) {
        this.person = p;
        this.previousNode = previous;
    }

    public Person getPerson() {
        return person;
    }

    public LinkedList<Person> collapse(boolean startsWithRoot) {
        LinkedList<Person> path = new LinkedList<Person>();
        PathNode node = this;
        while (node != null) {
            if (startsWithRoot) {
                path.addLast(node.person);
            } else {
                path.addFirst(node.person);
            }
            node = node.previousNode;
        }
        return path;
    }
}
