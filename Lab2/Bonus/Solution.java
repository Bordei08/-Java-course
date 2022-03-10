package lab2.bonus;

import java.util.ArrayList;
import java.util.List;


public class Solution {
    /**
     * Este un tablou bidimensional cu events.size() lini si rooms.size() coloane unde vom memora colorarea grafului
     * daca timeTable[i][j] = true atunci nodul i este colorat cu culoare j
     * Daca timeTable[i][j] = flase atunci nodul i nu este colorat cu culoare j
     */
    private boolean[][] timeTable;

    /**
     * Metoda solving este un fel de "functie main" a clasei solution deoarce aceasta returneaza solutia problemei prin diferite apeluri de metode.
     * Declaram un obiect de tip Graph si il initializam cu lista events
     * Declaram o Lista de camere colors care va reprezenta chiar lista rooms.
     * Apelam metoda DSatur pentru a colora graful graphEvents cu culorile colors
     */

    public String solving(List<Event> events, List<Room> rooms) {

        String result;
        Graph graphEvents = new Graph(events);
        timeTable = new boolean[events.size()][rooms.size()];
        List<Room> colors =  rooms;

        DSatur(graphEvents, colors);

        result = toStringResult(graphEvents, colors);
        return result;

    }

    /**\
     * In metoda DSatur sortam nodurile descrescator dupa gradul acestora si apoi incepem colorarea grafului.
     */

    private void DSatur(Graph graph, List<Room> colors) {
            graph.sort();
            colorNods(graph, colors);

    }

    /**
     *Aceasta functie are la baza metoda Greedy , pentru fiecare nod din nods (lista cu noduri sortate) se cauta o culoare care se potriveste din punctul de vedere al capacitati si daca este disponibila pentru nodul curent
     */

    private void colorNods(Graph graph, List<Room> colors) {

        List<Event> nods = graph.getNods();

        boolean[][] adjacentMatrix = graph.getAdjacentMatrix();

        for (int idxNod = 0; idxNod < nods.size(); idxNod++) {
            for (int idxColor = 0; idxColor < colors.size(); idxColor++) {
                if(colors.get(idxColor).getCapacity() == graph.getNods().get(idxNod).getSize()) {
                    timeTable[idxNod][idxColor] = match(idxColor, idxNod, adjacentMatrix, graph.countNods(), colors.size());

                }
            }
        }

    }

    /**
     *Metoda match verifica daca un nod se potriveste cu o culoare
     * Daca nodul nu are altaculoare alocata deja si daca nu exista un alt nod adiacent cu nodul curent care sa aiba atribuita culoarea testata atunci functia returneaza true, in caz contrar returneaza false.
     */

    private boolean match(int color, int nod, boolean[][] adjacentMatrix, int countNods, int countColors) {
        for (int i = 0; i < countNods; i++) {
            if (adjacentMatrix[i][nod] && timeTable[i][color] ) {
                return false;
            }
        }
        for(int i = 0; i < countColors ; i++)
            if(timeTable[nod][i])
                return false;
        return true;
    }

    

    private String toStringResult(Graph graph, List<Room> colors) {
        String result = "";
       List <Event> nods = graph.getNods();
        for (int idxNod = 0; idxNod < graph.countNods(); idxNod++)
            for (int idxColor = 0; idxColor < colors.size(); idxColor++)
                if (timeTable[idxNod][idxColor])
                    result += nods.get(idxNod).toString() + colors.get(idxColor).toString();

        return result;
    }

}
