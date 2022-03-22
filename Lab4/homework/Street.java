package homework;

import com.github.javafaker.Faker;

public class Street {

    private String nameStreet;
    private Integer lengthStreet;
    private Intersection endPoint1, endPoint2;


    public Street(Integer lengthStreet, Intersection endPoint1, Intersection endPoint2) {
        Faker faker = new Faker();
        this.nameStreet = faker.address().streetName();
        this.lengthStreet = lengthStreet;
        this.endPoint1 = endPoint1;
        this.endPoint2 = endPoint2;

    }

    public String getNameStreet() {

        return nameStreet;
    }

    public void setNameStreet(String nameStreet) {
        this.nameStreet = nameStreet;
    }

    public Integer getLengthStreet() {
        return lengthStreet;
    }

    public void setLengthStreet(Integer lengthStreet) {
        this.lengthStreet = lengthStreet;
    }

    public Intersection getEndPoint1() {
        return endPoint1;
    }

    public void setEndPoint1(Intersection endPoint1) {
        this.endPoint1 = endPoint1;
    }

    public Intersection getEndPoint2() {
        return endPoint2;
    }

    public void setEndPoint2(Intersection endPoint2) {
        this.endPoint2 = endPoint2;
    }

    public String toString() {
        return "Numele strazii este  " + nameStreet + " cu lungimea " + lengthStreet + " cu capetele " + endPoint1 + " si " + endPoint2 + "\n";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Street)) return false;

        Street street = (Street) o;

        if (getNameStreet() != null ? !getNameStreet().equals(street.getNameStreet()) : street.getNameStreet() != null)
            return false;
        if (getLengthStreet() != null ? !getLengthStreet().equals(street.getLengthStreet()) : street.getLengthStreet() != null)
            return false;
        if (getEndPoint1() != null ? !getEndPoint1().equals(street.getEndPoint1()) : street.getEndPoint1() != null)
            return false;
        return getEndPoint2() != null ? getEndPoint2().equals(street.getEndPoint2()) : street.getEndPoint2() == null;
    }


}
