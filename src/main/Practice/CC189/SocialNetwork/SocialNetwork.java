package main.Practice.CC189.SocialNetwork;

import java.util.LinkedList;
import java.util.Map;

/**
 * 1. If we are handling facebook or linkedin at this case, how would you improve you design
 * We should divide it into several servers to process this, so each key will have to hash to a machine ID
 * equation: " hash(personId) % #ofMachines "
 * 2. What if your request need to jump machines back and forth
 * We should allocate personIds to those machines regionally. Meanning people from same region should be aggregated into one machine.
 * This can reduce the possibility of jumping between machines
 * 3. Your approach requires a visited map. How you are going to implement that feature in this case
 *
 */

public class SocialNetwork {
    public LinkedList<Person> findPathBiBFS(Map<Integer, Person> people, int source, int destination) {

        BFSData sourceData = new BFSData(people.get(source));
        BFSData destData = new BFSData(people.get(destination));

        while (!sourceData.isFinished() && !destData.isFinished()) {
            Person collision = searchLevel(people, sourceData, destData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision.getPersonId());
            }

            collision = searchLevel(people, sourceData, destData);
            if (collision != null) {
                return mergePaths(destData, sourceData, collision.getPersonId());
            }
        }

        return null;
    }

    public Person searchLevel(Map<Integer, Person> people, BFSData primary, BFSData secondary) {
        int count = primary.toVisit.size();
        for (int i = 0; i < count; i++) {
            PathNode pathNode = primary.toVisit.poll();
            int personId = pathNode.getPerson().getPersonId();

            if (secondary.visited.containsKey(personId)) {
                return pathNode.getPerson();
            }

            Person person = pathNode.getPerson();
            for (int friendId : person.getFriends()) {
                if (!primary.visited.containsKey(friendId)) {
                    Person friend = people.get(friendId);
                    PathNode next = new PathNode(friend, pathNode);
                    primary.visited.put(friendId, next);
                    primary.toVisit.offer(next);
                }
            }
        }
        return null;
    }

    public LinkedList<Person> mergePaths(BFSData bfs1, BFSData bfs2, int connection) {
        PathNode end1 = bfs1.visited.get(connection);
        PathNode end2 = bfs2.visited.get(connection);
        LinkedList<Person> pathOne = end1.collapse(false);
        LinkedList<Person> pathTwo = end2.collapse(true);
        pathTwo.removeFirst();
        pathOne.addAll(pathTwo);
        return pathOne;
    }
}
