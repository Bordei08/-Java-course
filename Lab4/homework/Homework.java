package homework;





public class Homework {
    public static void main(String[] args) {

        City instance = new City("Oras1");

        instance.filterStreets(1);

        Graph graph = new Graph(instance);

        SolutionKruskal solution1 = new SolutionKruskal(graph);
        solution1.aplyKruska();
        System.out.println(solution1.toString());

        SolutionJGraphT solution2 = new SolutionJGraphT(instance);

        System.out.println(solution2.solvingJGraph());

    }

}
