package bonus;


import java.util.List;
import java.util.Objects;

public class SolutionTSP {

    private Integer roadCost;
    private List<Edge> minimalTree;
    private boolean[] visitedEdges;


    SolutionTSP(Graph graph) {
        SolutionKruskal solutionKruskal = new SolutionKruskal(graph);
        solutionKruskal.aplyKruska();
        this.roadCost = 0;

        this.minimalTree = solutionKruskal.getMnimumSpanningTree();
        this.visitedEdges = new boolean[minimalTree.size() + 1];

    }

    public void solving() {
        for (int i = 0; i < minimalTree.size(); i++)
            visitedEdges[i] = false;
        visitedEdges[0] = true;

        getRoadCostFor(minimalTree.get(0));

    }

    private void getRoadCostFor(Edge edge) {
        Integer idxEdge = 0;
        roadCost += edge.getCost();
        for (Edge idx : minimalTree) {
            if (areAdjacent(edge, idx) && !visitedEdges[idxEdge]) {
                visitedEdges[idxEdge] = true;
                getRoadCostFor(idx);

                if (!areVisitedEdges()) roadCost += edge.getCost();
            }
            idxEdge++;
        }


    }


    private boolean areVisitedEdges() {
        for (boolean visitedEdge : visitedEdges)
            if (!visitedEdge) return false;
        return true;
    }

    private boolean areAdjacent(Edge edge1, Edge edge2) {
        if (edge1 == edge2) return false;
        return Objects.equals(edge1.getNod1(), edge2.getNod1()) || Objects.equals(edge1.getNod1(), edge2.getNod2()) || Objects.equals(edge1.getNod2(), edge2.getNod2()) || Objects.equals(edge1.getNod2(), edge2.getNod1());
    }

    public String toString() {
        return "Costul este : " + Integer.toString(roadCost) ;

    }


}
