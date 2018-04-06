package main.Practice.Algorithm.亚麻20140723;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    public int val;
    public List<GraphNode> adjacentNodes;
    public GraphNode(int val) {
        this.val = val;
        this.adjacentNodes = new ArrayList<>();
    }

    @Override
    public String toString() {
        String base =  "Val: " + this.val + ", ";
        for (GraphNode n : this.adjacentNodes) {
            base = base + n.val + " ";
        }
        return base;
    }

}
