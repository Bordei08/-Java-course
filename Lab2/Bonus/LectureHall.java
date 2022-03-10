package lab2.bonus;



public class LectureHall extends Room {
    private int capacity;
    private String roomName;
    private boolean videoProjector;

    public LectureHall(int cap, String name, boolean flag) {
        this.capacity = cap;
        this.roomName = name;
        this.videoProjector = flag;
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

    public boolean isVideoProjector() {
        return videoProjector;
    }

    public void setVideoProjector(boolean videoProjector) {
        this.videoProjector = videoProjector;
    }

    public boolean equals(Room lab) {
        return lab.getRoomName() == this.roomName;

    }

    public String toString() {
        return roomName + " . \n";
    }


}
