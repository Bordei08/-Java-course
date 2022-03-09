package lab2.homework;


/**
 * Clasa  solution defineste un  obiect care prin accesare metodelor propii va rezolva problema suprapunerii orelor
 */


import java.util.List;

public class solution {
    /**
     * timeTabel va retine evenimentelor care se pot organiza in anumite camere, lucru verificat prin capacitatea camerei si numarul de participanti al evenimentului
     */
    private boolean[][] timeTable;

    /**
     * Metoda solving este metoda principala a clasei  solution care va returna  un string acesta reprezentand "orarul" evenimentelor
     * @param events
     * @param rooms
     * @return
     */

    public String solving(List<Event> events, List<Room> rooms) {

        String result;
        timeTable = new boolean[events.size()][rooms.size()];

        timeTabelInitialization(events, rooms);

        result = solvingTimeTable(events, rooms);

        return result;

    }


    /**
     * metoda timeTabelInitialization  initializeaza matricea timeTable
     * @param events
     * @param rooms
     */
    private void timeTabelInitialization(List<Event> events, List<Room> rooms) {
        for (int idxEvent = 0; idxEvent < events.size(); idxEvent++) {
            for (int idxRoom = 0; idxRoom < rooms.size(); idxRoom++) {
                if (rooms.get(idxRoom).getCapacity() == events.get(idxEvent).getSize())
                    timeTable[idxEvent][idxRoom] = true;
            }
        }
    }

    /**
     *solvingTimeTable ia cate un eveniment din lista events si ii aloca o camera apoi elimnia din timeTable toate adia adiacentele dintre camera ocupta si alte evenimente care se petrec la acceasi ora.
     *      * @param events
     * @param events
     * @param rooms
     * @return
     */
    private String solvingTimeTable(List<Event> events, List<Room> rooms) {
        String resultTimeTable = "";
        for (int idxEvent = 0; idxEvent < events.size(); idxEvent++)
            for (int idxRoom = 0; idxRoom < rooms.size(); idxRoom++) {
                if (timeTable[idxEvent][idxRoom]) {
                    resultTimeTable += events.get(idxEvent).toString() + rooms.get(idxRoom).toString();
                    occupiedRoom(idxEvent,idxRoom,events,rooms);
                    break;
                }
            }
        return resultTimeTable;
    }

    /**
     * Elimina suprapunerea a doua evenimente pe aceasi camera la aceasi ora.
     * @param idxEvent
     * @param idxRoom
     * @param events
     * @param rooms
     */
    private void occupiedRoom(int idxEvent, int idxRoom,  List<Event> events, List<Room> rooms){
        for(int i = 0; i < events.size(); i ++){
            if(events.get(i).getStartTime() == events.get(idxEvent).getStartTime())
                timeTable[i][idxRoom] = false;
        }

    }
}
