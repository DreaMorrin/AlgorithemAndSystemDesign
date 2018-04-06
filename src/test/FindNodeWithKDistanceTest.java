package test;

import main.Practice.Algorithm.亚麻20140723.FindNodeWithKDistance;
import main.Practice.Algorithm.亚麻20140723.GraphNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class FindNodeWithKDistanceTest {
    @Test
    public void testCase1() {
        FindNodeWithKDistance obj = new FindNodeWithKDistance();
        GraphNode A = new GraphNode(1);
        GraphNode B = new GraphNode(2);
        GraphNode C = new GraphNode(3);
        GraphNode D = new GraphNode(4);
        GraphNode E = new GraphNode(5);
        GraphNode F = new GraphNode(6);

        A.adjacentNodes.add(B);
        A.adjacentNodes.add(C);
        A.adjacentNodes.add(D);

        B.adjacentNodes.add(A);
        B.adjacentNodes.add(E);
        B.adjacentNodes.add(F);

        C.adjacentNodes.add(D);
        C.adjacentNodes.add(A);
        C.adjacentNodes.add(E);

        D.adjacentNodes.add(A);
        D.adjacentNodes.add(C);
        D.adjacentNodes.add(F);
        D.adjacentNodes.add(E);

        E.adjacentNodes.add(B);
        E.adjacentNodes.add(C);
        E.adjacentNodes.add(D);

        F.adjacentNodes.add(B);
        F.adjacentNodes.add(D);
        List<GraphNode> res = obj.findKDistanceNodes(A, 2);
        for (GraphNode n : res) {
            System.out.println(n);
        }

        assertEquals(res.size(), 2);
        res = obj.findKDistanceNodes(null, 2);
        assertEquals(res.size(), 0);

        res = obj.findKDistanceNodes(A, 5);
        assertEquals(res.size(), 0);

    }
}
