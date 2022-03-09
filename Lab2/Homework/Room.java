package lab2.homework;

/**
 * Room  este o calsa abstracta care memoreaza propietatile unei camere
 */

public abstract class Room {
    private int capacity;
    private String roomName;

    abstract public int getCapacity();

    abstract public void setCapacity(int cap);

    abstract public String getRoomName();

    abstract public void setRoomName(String name);

}
