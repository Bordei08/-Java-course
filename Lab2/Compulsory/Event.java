package lab2.compulsory;


public class Event {
    private int startTime, endTime, size;
    private String nameEvent;

    public Event(){
    }

    public Event(String name, int start, int end, int sizeEvent) {
        this.nameEvent = name;
        this.startTime = start;
        this.endTime = end;
        this.size = sizeEvent;

    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (startTime != event.startTime) return false;
        if (endTime != event.endTime) return false;
        return size == event.size;
    }


}
