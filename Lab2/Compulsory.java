package lab2.compulsory;

import java.util.List;

public class Compulsory {

    public static void main(String[] args) {

        Event c1 = new Event( "C1",8, 10, 100);
        Event c2 = new Event( "C2",10, 12, 100);
        Event l1 = new Event("L1",8,10,30);
        Event l2 = new Event( "L2",8, 10, 30);
        Event l3 = new Event();

        l3.setNameEvent("L3");
        l3.setStartTime(10);
        l3.setEndTime(12);
        l3.setSize(30);


        Room sala401 = new Room("401",30, Type.LAB);
        Room sala403 = new Room( "403",30, Type.LAB);
        Room sla405 = new Room( "405",30, Type.LAB);
        Room sala309 = new Room();

        sala309.setNameRoom("309");
        sala309.setCap(100);
        sala309.setRoomType(Type.LECTURE_HALL);

       printObj(c1,sala309);
       printObj(c2, sala309);
       printObj(l1, sala401);
       printObj(l2, sala403);
       printObj(l3, sala401);

    }

    private static void printObj(Event event, Room room ){
        System.out.println(event.getNameEvent() + " -> " + room.getNameRoom());
    }


}
