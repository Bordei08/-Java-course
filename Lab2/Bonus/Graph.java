package lab2.bonus;


import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

public class Graph {

    /**
     * tabloul bidimensional adjacentMatrix este o matrice patratica care retine daca doua noduri sunt adiacente
     * Lista nods va retine nodurile grafului , in cazul nostru evenimentele
     */
    private boolean[][] adjacentMatrix;
    private List<Event> nods;

    public Graph(List<Event> events) {
        this.adjacentMatrix = new boolean[events.size()][events.size()];
        this.nods = events;

    }

    /**
     * Metoda adjacentMatrixInitialization formeaza matricea de adiacenta pentru graful cu nodurile nods
     * Acesta parcurge doar jumatate de matice pentru ca este o matrice patratica simetrica
     */
    private void adjacentMatrixInitialization() {
        for (int idxNodI = 1; idxNodI < nods.size(); idxNodI++) {
            for (int idxNodJ = 0; idxNodJ < idxNodI; idxNodJ++) {
                if (areAdjacent(nods.get(idxNodI), nods.get(idxNodJ))) {
                    adjacentMatrix[idxNodI][idxNodJ] = adjacentMatrix[idxNodJ][idxNodI] = true;

                }
            }
        }
    }

    /**
     * Avand in vedere ca nodurile noastre sunt evenimente aceasta functie defineste o adiacenta intre doua evenimente
     *  Daca evenimentul i se suprapune cu evenimentul j (din punctul de vedere al orei de desfasurare) atunci sunt adiacente
     *  Daca evenimentele nu au aceasi capacitate nu sunt adiacente chiar daca se suprapun deoarece  nu se pot organiza in aceasi camera
     */
    private boolean areAdjacent(Event event1, Event event2) {
        LocalTime startEvent1 = event1.getStartTime();
        LocalTime endEvent1 = event1.getEndTime();
        LocalTime startEvent2 = event2.getStartTime();
        LocalTime endEvent2 = event2.getEndTime();

        if(event1.getSize() != event2.getSize())
            return false;

        if(endEvent1.compareTo(startEvent2) <= 0)
            return false;

        if(startEvent1.compareTo(endEvent2) >= 0)
             return false;

        return true;

    }



    public boolean[][] getAdjacentMatrix() {
        adjacentMatrixInitialization();
        return this.adjacentMatrix;
    }


    /**
     * Metoda sort sorteaza lista cu nods dupa gradele nodurilor, nodurile vor fi sortate in ordine descrescatoare.
     */
    public void sort() {

        for (int idxNodI = 0; idxNodI < nods.size(); idxNodI++)
            for (int idxNodJ = 0; idxNodJ < nods.size(); idxNodJ++)
                if (degree(idxNodI) > degree(idxNodJ)) {
                    Collections.swap(nods, idxNodI, idxNodJ);

                }


    }

    /**
     Returneaza gradul unui  nod
     */
    private int degree(int nod){
        int result = 0;
        for(int i = 0; i < nods.size(); i++)
            if(areAdjacent(nods.get(i), nods.get(nod)) && nod != i)
                result ++;

        return result;
    }

    public List<Event> getNods(){
        return this.nods;
    }

    public int countNods(){
        return nods.size();
    }


}
