package bonus;


public class Bonus {
    public static void main(String[] args) {

        City instance = new City("Gabi");
        Graph graph = new Graph(instance);
        SolutionTSP solution3 = new SolutionTSP(graph);
        solution3.solving();
        System.out.println(solution3.toString());

    }

}
