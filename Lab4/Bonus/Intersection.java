package bonus;

public class Intersection {
    private String nameintersection;


    public Intersection(String nameintersection) {

        this.nameintersection = nameintersection;
    }

    public String getNameintersection() {
        return nameintersection;
    }

    public void setNameintersection(String nameintersection) {
        this.nameintersection = nameintersection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Intersection)) return false;

        Intersection that = (Intersection) o;

        return getNameintersection() != null ? getNameintersection().equals(that.getNameintersection()) : that.getNameintersection() == null;
    }

    @Override
    public int hashCode() {
        return getNameintersection() != null ? getNameintersection().hashCode() : 0;
    }

    public String toString(){
        return nameintersection;
    }


}


