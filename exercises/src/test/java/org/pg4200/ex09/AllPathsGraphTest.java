package org.pg4200.ex09;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AllPathsGraphTest {

    private AllPathsGraph<String> createGraph() {

        AllPathsGraph<String> graph = new AllPathsGraph<>();

        graph.addEdge("0", "X");
        graph.addEdge("X", "1");
        graph.addEdge("X", "Y");
        graph.addEdge("1", "2");
        graph.addEdge("2", "Y");
        graph.addEdge("1", "3");
        graph.addEdge("3", "4");
        graph.addEdge("3", "5");
        graph.addEdge("4", "5");

        assertEquals(8, graph.getNumberOfVertices());
        assertEquals(9, graph.getNumberOfEdges());

        return graph;
    }

    @Test
    public void testFindSevenPaths() {
        AllPathsGraph<String> graph = createGraph();

        List<List<String>> paths = graph.findAllPaths("X", "5");

        assertNotNull(paths);
        assertEquals(4, paths.size());
        assertTrue(paths.stream().anyMatch(p -> p.size() == 4));
        assertTrue(paths.stream().anyMatch(p -> p.size() == 5));
        assertTrue(paths.stream().anyMatch(p -> p.size() == 6));
        assertTrue(paths.stream().anyMatch(p -> p.size() == 7));

    }

}
