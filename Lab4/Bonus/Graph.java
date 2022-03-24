package bonus;




import java.util.ArrayList;
import java.util.List;



public class Graph {
   // private boolean[][] adjacentMatrix;
    private int countNodes;
    private List<Edge> edges = new  ArrayList<Edge>();



   public  Graph(City city) {
       this.countNodes = city.getIntersections().size();
       createEdges(city.getStreets());
    }

   /* private void createAdjacentMatrix(List<Street> edges){
       Integer idxNod1, idxNod2;
       for(int idx =0; idx < edges.size(); idx ++){
           idxNod1 = getIndexNod(edges.get(idx).getEndPoint1().getNameintersection());
           idxNod2 = getIndexNod(edges.get(idx).getEndPoint2().getNameintersection());
           adjacentMatrix[idxNod1][idxNod2] =   adjacentMatrix[idxNod2][idxNod1] = true;
       }
    }
*/
    private Integer getIndexNod(String nod){
       String number = nod.substring(1);
       return Integer.parseInt(number);

    }

    private void createEdges(List<Street> streets){

       for(int idx = 0; idx < streets.size(); idx ++){
          this.edges.add(new Edge(getIndexNod(streets.get(idx).getEndPoint1().getNameintersection()), getIndexNod(streets.get(idx).getEndPoint2().getNameintersection()), streets.get(idx).getLengthStreet()));
       }

    }

    public int getCountNodes() {
        return countNodes;
    }

    public void setCountNodes(int countNodes) {
        this.countNodes = countNodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }


}
