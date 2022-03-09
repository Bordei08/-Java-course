package lab2.homework;


/**
 * computerLab este o clasa extinsa a clasei abstracte room si defineste un obiect de tip laborator
 */

public class computerLab extends Room{
    private int capacity;
    private String  roomName;
    private String systemUsed;

    computerLab(int cap, String name, String system){
        this.capacity = cap;
        this.roomName = name;
        this.systemUsed = system;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String getRoomName() {
        return roomName;
    }

    @Override
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getSystemUsed(){
        return this.systemUsed;

    }

    public void setSystemUsed(String system){
        this.systemUsed = system;
    }

    public boolean equals( Room lab){
        return lab.getRoomName() == this.roomName;

    }

    public String toString(){
        return roomName + " . \n";
    }


}
