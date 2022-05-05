package homework;

import static java.lang.Math.sqrt;

/**
 * This class will help us calculate the distance between 2 cities using the distanceBetween method (city1, city2)
 */

public class Compute {

    /**
     * This method uses the formula for the distance between two points to calculate the distance
     * @param city1
     * @param city2
     * @return
     */

    public String distanceBetween(City city1, City city2){
        String result = "The distance between cities "+ city1.getName() + " and " + city2.getName()+ " is ";
        double distance = 0;
        distance = sqrt((city2.getLatitude()-city1.getLatitude())*(city2.getLatitude()-city1.getLatitude()) + (city2.getLongitude() - city1.getLatitude())*(city2.getLongitude() - city1.getLatitude()));
        return result + distance * 10 + "km";
    }
}
