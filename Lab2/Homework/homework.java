package lab2.homework;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Bordei Mihai-Gabi
 *
 * Programul este structura in 6 clase:
 * * <ul>
 * * <li>homework, clasa principala ce contine metoda main.
 * * <li>room, o clasa abstracta ce contine propietatile unei camere.
 * * <li>event, aceasta clasa defineste propietatile unui eveniment, in cazul nostru un laborator sau un curs.
 * * <li>computerLab, o clasa extinsa pe baza calsei room ce contine propietatile unei camere unde se poate realiza un laborator.
 * * <il>lectureHall, o clasa extinsa pe baza clasei room ce contine propietatile unei camere unde se poate realiza un curs.
 * *  </ul>
 */




public class homework {

    /**
     * In metoda main initializam doua liste una cu obiecte de tip event si una cu obiecte de tip room
     * Tot in functia main vom declara si un obiect de tipul solution .
     */
    public static void main(String[] args) {
        List<Event> events = new ArrayList<Event>();
        List<Room> rooms = new ArrayList<Room>();
        solution problem = new solution();

        creatEventsAndRooms(events, rooms);

        System.out.println(problem.solving(events, rooms));


    }

    /**
     * Adaugam in listele events si rooms cate 5 obiecte de fiecare si dupa verifica daca aceste obiecte sunt distincte
     * @param events
     * @param rooms
     */
    private static void creatEventsAndRooms(List<Event> events, List<Room> rooms) {
        Event event1 = new Event(8, 10, 30, "Lab1");
        Event event2 = new Event(10, 12, 30, "Lab2");
        Event event3 = new Event(8, 10, 100, "Curs1");
        Event event4 = new Event(8, 10, 100, "Curs2");
        Event event5 = new Event(8, 10, 30, "Lab3");

        events.add(event1);
        events.add(event2);
        events.add(event3);
        events.add(event4);
        events.add(event5);

        if (!checkEvents(events)) {
            System.out.println("Evenimente invalide !");
            System.exit(0);
        }

        Room room1 = new computerLab(30, "C403", "Linux");
        Room room2 = new computerLab(30, "C405", "Linux");
        Room room3 = new lectureHall(100, "c309", true);
        Room room4 = new lectureHall(100, "c112", false);
        Room room5 = new computerLab(30, "C407", "Windows");

        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        rooms.add(room5);

        if (!checkRooms(rooms)) {
            System.out.println("Camera invalida !!");
            System.exit(0);
        }
    }

    /**
     * Verificam elementele din events
     * @param events
     * @return
     */
    private static boolean checkEvents(List<Event> events) {
        for (int i = 1; i < events.size(); i++)
            for (int j = 0; j < events.size(); j++)
                if (events.get(i).equals(events.get(j)) && i != j)
                    return false;
        return true;
    }

    /**
     * Verificam elemnetele din rooms
     * @param rooms
     * @return
     */

    private static boolean checkRooms(List<Room> rooms) {
        for (int i = 0; i < rooms.size(); i++)
            for (int j = 0; j < rooms.size(); j++)
                if (rooms.get(i).equals(rooms.get(j)) && i != j)
                    return false;
        return true;
    }
}
