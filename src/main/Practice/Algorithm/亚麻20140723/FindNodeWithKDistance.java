package main.Practice.Algorithm.亚麻20140723;

import java.util.*;

public class FindNodeWithKDistance {
    public List<GraphNode> findKDistanceNodes(GraphNode node, int k) {
        List<GraphNode> nodes = new ArrayList<>();
        if (node == null) {
            return nodes;
        }

        Queue<GraphNode> queue = new LinkedList<>();
        Set<GraphNode> visited = new HashSet<>();
        queue.offer(node);
        visited.add(node);
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                GraphNode n = queue.poll();
                for (GraphNode innerNode : n.adjacentNodes) {
                    if (visited.contains(innerNode)) {
                        continue;
                    }
                    if (steps == k) {
                        nodes.add(innerNode);
                    }
                    queue.offer(innerNode);
                    visited.add(innerNode);
                }
            }
        }
        return nodes;
    }
}
