package lab2.homework;


/**
 * Clasa event defineste un obiect de tip event cu toate  specificatile acestuia .
 */

public class Event {
    private int startTime, endTime, size;
    private String eventName;


    Event(int start, int end, int cap, String name){
        this.startTime = start;
        this.endTime = end;
        this.size = cap;
        this.eventName = name;
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

    public String getEventName() {
        return this.eventName;
    }

    public void setEventName(String nameEvent) {
        this.eventName = nameEvent;
    }

    public boolean equals(Event event){
       return this == event;
    }

    public String toString(){
        return eventName + " -> ";
    }
}
