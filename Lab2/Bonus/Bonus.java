package lab2.bonus;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bonus {

    private static int countEvents = 10, countRooms = 4, eventDuration = 120;

    /**
     * Metoda main este metoda principala unde vom apela anumite metode pentru a obtine rezultatul dorit.
     */

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        List<Event> events = new ArrayList<Event>();
        List<Room> rooms = new ArrayList<Room>();
        Solution problem = new Solution();

        creatEvents(events);
        creatRooms(rooms);



        System.out.println(problem.solving(events, rooms));
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;

        System.out.println("Timp de rulare : "  + timeElapsed) ;


    }

    /**
     * Metoda creatEvents genereaza evenimente random
     *
     */
    private static void creatEvents(List<Event> events) {
        LocalTime startTime, endTime;
        int capacity;
        String name;
        for (int i = 0; i < countEvents; i++) {
            startTime = creatStartTime();
            endTime = creatEndTime(startTime);
            capacity = creatCapacity();
            name = creatEventName(capacity);
            events.add(new Event(startTime, endTime, capacity, name));
        }
    }

    /**
     * Metoda creatStartTime genereaza un timp de start random, intervalul orar este de 24 de ore deci 1440 minute
     */
    private static LocalTime creatStartTime() {
        int minutes, hours;
        Random rand = new Random();
        LocalTime result;

        minutes = rand.nextInt(1440 - eventDuration);

        hours = minutes / 60;
        minutes = minutes % 60;

        result = LocalTime.of(hours, minutes);

        return result;
    }


    /**
     *Creaza endTime-ul un eveniment deja cu un startTime generat
     */
    private static LocalTime creatEndTime(LocalTime start) {
        LocalTime result;
        int minutes = start.getHour() * 60 + start.getMinute() + eventDuration;
        int hours = minutes / 60;
        minutes = minutes % 60;

        result = LocalTime.of(hours, minutes);

        return result;
    }

    /**
     *Genereaza doua numere 100 sau 30 reprezentand capacitatea unui eveniment sau capacitatea unei camere
     */

    private static int creatCapacity() {
        Random rand = new Random();

        if (rand.nextInt(100) < 50)
            return 30;
        return 100;
    }

    /**
     * returneaza un nume pentru fiecare event daca eventul este de capacitate mai mica ca 100 va fi lab in caz contrat va fi curs
     */
    private static String creatEventName(int cap) {
        String result = "";
        if (cap < 100)
            result = "Lab";
        else
            result = "Curs";

        return result;
    }

    /**
     * Genereaza  camere random si le memoreaza in lista rooms
     */
    private static void creatRooms(List<Room> rooms) {
        int capacity;
        String name;
        for (int i = 0; i < countRooms; i++) {
            capacity = creatCapacity();
            name = creatRoomName(rooms);
            if(capacity < 100)
                rooms.add(new ComputerLab(capacity,name,"Linux"));
            else
                rooms.add(new LectureHall(capacity,name,true));

        }

    }

    /**
     * Returneaza un nume random distinct pentru fiecare camera creata
     */
    private static String creatRoomName(List<Room> rooms) {
        String result = "C";
        Random rand = new Random();
        int numberRoom;

       boolean correctName = false;
        while (!correctName ){
            numberRoom = rand.nextInt(100, 999);
            result = "C" + String.valueOf(numberRoom);
             correctName = isUnic(rooms, result);
        }
        return result;
    }


    /**
     * Verifica daca un nume nu este deja folosit pentru o camera
     */
    private static boolean isUnic(List<Room> rooms, String name) {
        if (rooms.size() == 0)
            return true;

        for (int i = 0; i < rooms.size(); i++)
            if (name == rooms.get(i).getRoomName())
                return false;

        return true;


    }


}
