package bonus;


import java.util.*;
import java.util.stream.IntStream;

public class City {
    private String nameCity;
    private List<Street> streets = new LinkedList<>();
    private Set<Intersection> intersections = new HashSet<>();
    private boolean[] vistedIntersections;


    City(String nameCity) {

        this.nameCity = nameCity;

        var intersections = IntStream.rangeClosed(0, 8).mapToObj(i -> new Intersection("v" + i)).toArray(Intersection[]::new);

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

        streets.sort((Street s1, Street s2) -> s1.getLengthStreet() - s2.getLengthStreet());


        this.intersections.addAll(Arrays.asList(intersections));

    }


    City(Integer countIntersections, Integer countStreets) {
        var intersections = IntStream.rangeClosed(0, countIntersections - 1).mapToObj(i -> new Intersection("v" + i)).toArray(Intersection[]::new);

        vistedIntersections = new boolean[intersections.length];
        createStreets(intersections, countStreets);

        streets.sort((Street s1, Street s2) -> s1.getLengthStreet() - s2.getLengthStreet());


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


    public void filterStreets(int number) {
        streets.stream().filter(e -> getNeighboringStreets(e) >= 3).filter(e -> e.getLengthStreet() == number).forEach(street -> System.out.println(street.toString()));


    }

    private int getNeighboringStreets(Street street) {
        int neighbours = 0;
        for (Street idx : streets)
            if (!street.equals(idx) && street.getEndPoint1() == idx.getEndPoint1() || street.getEndPoint1() == idx.getEndPoint2() || street.getEndPoint2() == idx.getEndPoint1() || street.getEndPoint2() == idx.getEndPoint2()) {
                neighbours++;
            }
        return neighbours;
    }

    private void createStreets(Intersection[] intersections, Integer countStreets) {
        Random random = new Random();
        Integer idxIntersection1, idxIntersection2;
        boolean[][] cityStreets = new boolean[intersections.length][intersections.length];

        for (int i = 0; i < intersections.length - 1; i++)
            this.streets.add(new Street(0, intersections[i], intersections[i + 1]));

        countStreets -= intersections.length + 1;

        for (int i = 0; i < countStreets; i++) {
            idxIntersection1 = random.nextInt(intersections.length);
            idxIntersection2 = random.nextInt(intersections.length);
            while (!isStreet(idxIntersection1, idxIntersection2, cityStreets)) {
                idxIntersection1 = random.nextInt(intersections.length);
                idxIntersection2 = random.nextInt(intersections.length);
            }
            cityStreets[idxIntersection1][idxIntersection2] = cityStreets[idxIntersection2][idxIntersection1] = true;
            this.streets.add(new Street(0, intersections[idxIntersection1], intersections[idxIntersection2]));
        }

        createStreetsLength(cityStreets);

    }

    private boolean isStreet(Integer nod1, Integer nod2, boolean[][] cityStreets) {
        if (Objects.equals(nod1, nod2)) return false;
        return !cityStreets[nod1][nod2];
    }

    private void createStreetsLength(boolean[][] cityStreets) {
        setStreetsLengthForTriangle(cityStreets);
        setStreetsLengthforRestore();
    }

    private void setStreetsLengthForTriangle(boolean[][] cityStreets) {
        Integer idxIntersection1, idxIntersection2;
        Integer cost1, cost2, cost3;
        Integer idxStreet1, idxStreet2;
        Random rand = new Random();
        for (Street idx : this.streets) {
            idxIntersection1 = getIndexIntersection(idx.getEndPoint1().getNameintersection());
            idxIntersection2 = getIndexIntersection(idx.getEndPoint2().getNameintersection());
            for (int i = 0; i < cityStreets.length; i++)
                if (cityStreets[idxIntersection1][i] && cityStreets[idxIntersection2][i]) {

                    idxStreet1 = getIdxStreetWith(i, idxIntersection1);
                    idxStreet2 = getIdxStreetWith(i, idxIntersection2);

                    if (idx.getLengthStreet() < 1) cost1 = rand.nextInt(100) + 1;
                    else cost1 = idx.getLengthStreet();

                    if (this.streets.get(idxStreet1).getLengthStreet() < 1) cost2 = rand.nextInt(100) + 1;
                    else cost2 = this.streets.get(idxStreet1).getLengthStreet();

                    if (this.streets.get(idxStreet2).getLengthStreet() < 1) cost3 = rand.nextInt(100) + 1;
                    else cost3 = this.streets.get(idxStreet2).getLengthStreet();

                    while (!isTriangle(cost1, cost2, cost3)) {
                        if (idx.getLengthStreet() < 1) cost1 = rand.nextInt(100) + 1;
                        else cost1 = idx.getLengthStreet();

                        if (this.streets.get(idxStreet1).getLengthStreet() < 1) cost2 = rand.nextInt(100) + 1;
                        else cost2 = this.streets.get(idxStreet1).getLengthStreet();

                        if (this.streets.get(idxStreet2).getLengthStreet() < 1) cost3 = rand.nextInt(100) + 1;
                        else cost3 = this.streets.get(idxStreet2).getLengthStreet();
                    }

                    idx.setLengthStreet(cost1);
                    this.streets.get(idxStreet1).setLengthStreet(cost2);
                    this.streets.get(idxStreet2).setLengthStreet(cost3);


                }

        }

    }

    private Integer getIndexIntersection(String nod) {
        String number = nod.substring(1);
        return Integer.parseInt(number);

    }


    private boolean isTriangle(Integer a, Integer b, Integer c) {
        return a < b + c && b < a + c && c < a + b;
    }


    private Integer getIdxStreetWith(Integer intersection1, Integer intersection2) {
        Integer idxStreet = 0;
        for (Street idx : this.streets) {
            if (getIndexIntersection(idx.getEndPoint1().getNameintersection()).equals(intersection1) && getIndexIntersection(idx.getEndPoint2().getNameintersection()).equals(intersection2) || getIndexIntersection(idx.getEndPoint1().getNameintersection()).equals(intersection2) && getIndexIntersection(idx.getEndPoint2().getNameintersection()).equals(intersection1)) {
                return idxStreet;
            }
            idxStreet++;
        }
        return -1;
    }

    private void setStreetsLengthforRestore() {
        Random rand = new Random();
        for (Street idx : this.streets) {
            if (idx.getLengthStreet() < 1)
                idx.setLengthStreet(rand.nextInt(100) + 1);
        }
    }


}



