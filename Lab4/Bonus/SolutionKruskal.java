package bonus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class SolutionKruskal {

    private List<Edge> mnimumSpanningTree = new ArrayList<>();
    private List<List<Integer>> nodes = new ArrayList();
    private List<Edge> edges = new ArrayList<>();
    private Integer countNodes ;
    private Integer minimCost ;


    SolutionKruskal(Graph graph) {

        for (int i = 0; i < graph.getCountNodes(); i++) {
            nodes.add(new ArrayList());
            nodes.get(i).add(i);
        }

        edges = graph.getEdges();
        countNodes = graph.getCountNodes();
    }


    public void aplyKruska() {

        minimCost = 0;
       /* for (Edge idx : edges)
            System.out.println(idx.toString());

        */

        while (nodes.size() > 1) {
            Edge edge = edges.get(0);
            int x, y;
            x = find(edge.getNod1());
            y = find(edge.getNod2());

            if (x != y) {
                union(x, y);
                minimCost += edge.getCost();
                mnimumSpanningTree.add(edge);
            }
            edges.remove(0);

        }

    }

    private Integer find(Integer nod) {
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = 0; j < nodes.get(i).size(); j++) {
                if (Objects.equals(nodes.get(i).get(j), nod))
                    return i;
            }
        }
        return 0;
    }

    private void union(Integer poz1, Integer poz2) {

        for (int i = 0; i < nodes.get(poz2).size(); i++) {
            nodes.get(poz1).add(nodes.get(poz2).get(i));
        }

        nodes.remove(nodes.get(poz2));

    }

    public List<Edge> getMnimumSpanningTree() {
        return mnimumSpanningTree;
    }

    public String toString(){

        String result = "";

        for(Edge idx : mnimumSpanningTree)
            result += idx.toString() + "\n";

        result += "Costul este  " + Integer.toString(minimCost);
        return result;
    }

}
