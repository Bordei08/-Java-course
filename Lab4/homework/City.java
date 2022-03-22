package homework;


import java.util.*;
import java.util.stream.IntStream;

public class City {
    private String nameCity;
    private List<Street> streets = new LinkedList<>();
    private Set<Intersection> intersections = new HashSet<>();


    City(String nameCity) {

        this.nameCity = nameCity;

        var intersections = IntStream.rangeClosed(0, 8)
                .mapToObj(i -> new Intersection("v" + i))
                .toArray(Intersection[]::new);

        streets.add(new Street(2, intersections[0], intersections[1]));
        streets.add(new Street(2, intersections[0], intersections[7]));
        streets.add(new Street(2, intersections[0], intersections[6]));
        streets.add(new Street(1, intersections[2], intersections[3]));
        streets.add(new Street(3, intersections[2], intersections[1]));
        streets.add(new Street(1, intersections[2], intersections[5]));
        streets.add(new Street(1, intersections[3], intersections[4]));
        streets.add(new Street(1, intersections[3], intersections[8]));
        streets.add(new Street(1, intersections[4], intersections[8]));
        streets.add(new Street(2, intersections[4], intersections[2]));
        streets.add(new Street(3, intersections[4], intersections[5]));
        streets.add(new Street(3, intersections[5], intersections[6]));
        streets.add(new Street(2, intersections[5], intersections[7]));
        streets.add(new Street(1, intersections[6], intersections[7]));
        streets.add(new Street(2, intersections[7], intersections[8]));
        streets.add(new Street(2, intersections[1], intersections[7]));

        streets.sort((Street s1, Street s2)->s1.getLengthStreet()-s2.getLengthStreet());


        this.intersections.addAll(Arrays.asList(intersections));

    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public List<Street> getStreets() {
        return streets;
    }

    public void setStreets(List<Street> streets) {
        this.streets = streets;
    }

    public Set<Intersection> getIntersections() {
        return intersections;
    }

    public void setIntersections(Set<Intersection> intersections) {
        this.intersections = intersections;
    }


    public void filterStreets(int number){
        streets.stream()
                .filter (e -> getNeighboringStreets(e) >= 3)
                .filter (e -> e.getLengthStreet() == number ).forEach(street -> System.out.println(street.toString()));


    }

    private int getNeighboringStreets(Street street){
        int neighbours = 0;
        for(Street idx : streets)
            if(!street.equals(idx) && street.getEndPoint1() == idx.getEndPoint1() || street.getEndPoint1() == idx.getEndPoint2() || street.getEndPoint2() == idx.getEndPoint1() || street.getEndPoint2() == idx.getEndPoint2()){
                neighbours ++;
            }
        return neighbours;
    }
}



