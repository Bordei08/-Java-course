package lab2.bonus;

public class ComputerLab extends Room {
    private int capacity;
    private String roomName;
    private String systemUsed;

    public ComputerLab(int cap, String name, String system) {
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

    public String getSystemUsed() {
        return this.systemUsed;

    }

    public void setSystemUsed(String system) {
        this.systemUsed = system;
    }

    public boolean equals(lab2.homework.Room lab) {
        return lab.getRoomName() == this.roomName;

    }

    public String toString() {
        return roomName + " . \n";
    }


}
