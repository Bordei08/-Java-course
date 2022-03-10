package lab2.bonus;

import java.time.LocalTime;

public class Event {
    private LocalTime startTime;
    private LocalTime endTime;
    private String eventName;
    private int size;

    public Event(LocalTime start, LocalTime end, int cap, String name){
        this.startTime =  start;
        this.endTime = end;
        this.size = cap;
        this.eventName = name;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean  equals(Event event){
        return this.eventName == event.getEventName();
    }

    public String toString(){
        return this.eventName + " ["+ startTime.toString() + " || "+ endTime.toString() + "]  -> ";
    }
}
