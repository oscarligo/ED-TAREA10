import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class UnitTests {

    private Graph graph;
    private ShortestPath shortestPath;

    @Before 

    public void setUp() {
        graph = new Graph(5);
        graph.addEdge(0, 1, 3); 
        graph.addEdge(0, 3, 7); 
        graph.addEdge(1, 2, 1); 
        graph.addEdge(1, 4, 8); 
        graph.addEdge(2, 3, 2); 
        graph.addEdge(3, 4, 3); 
        graph.addEdge(4, 0, 4); 

        shortestPath = new ShortestPath(graph);

    }

    @Test

    public void shouldBeAbleToReturnSize() {
        assertEquals(5, graph.getSize());
    }

    @Test
    
    public void shouldbeAbleToAddEdge() {
        graph.addEdge(0, 2, 5);
        assertEquals(5, graph.getWeight(0, 2), 0.01);
    }

    @Test
    public void shouldBeAbleToFindShortestPath() {
        Graph shortestPaths = shortestPath.FloydWarshall();
        assertEquals(3, shortestPaths.getWeight(0, 1), 0.01);
    }

    @Test
    public void shouldBeAbleToFindGraphCenter() {
        int centerIndex = shortestPath.graphCenter();
        assertEquals(0, centerIndex);
    }

    @Test
    public void shouldBeAbleToFindCenterExcentricity() {
        shortestPath.graphCenter();
        double excentricity = shortestPath.getExcentricity();
        assertEquals(9, excentricity, 0.01);
    }

}