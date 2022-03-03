package lab2.compulsory;


public class Room {
    private  int cap;
    private  Type roomType ;
    private String nameRoom;


    public Room(){

    }


    public Room(String name ,int capRoom, Type sala) {
        this.nameRoom = name;
       this.cap = capRoom;
        this.roomType = sala;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public Type getRoomType() {
        return roomType;
    }

    public void setRoomType(Type roomType) {
        this.roomType = roomType;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (cap != room.cap) return false;
        return roomType == room.roomType;
    }


}
