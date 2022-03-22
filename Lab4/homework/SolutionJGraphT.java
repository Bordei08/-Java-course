package homework;

import org.jgrapht.Graph;
import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

public class SolutionJGraphT {

    private City city;


    SolutionJGraphT(City city) {
        this.city = city;
    }

    public String solvingJGraph() {
        Graph<Intersection, DefaultWeightedEdge> graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        for (Intersection idx : city.getIntersections())
            graph.addVertex(idx);

        for (Street idx : city.getStreets()) {
            graph.addEdge(idx.getEndPoint1(), idx.getEndPoint2());
            graph.setEdgeWeight(idx.getEndPoint1(), idx.getEndPoint2(), idx.getLengthStreet());
        }

        KruskalMinimumSpanningTree alg = new KruskalMinimumSpanningTree<>(graph);
        var result = alg.getSpanningTree();
        return result.toString();
    }


}
