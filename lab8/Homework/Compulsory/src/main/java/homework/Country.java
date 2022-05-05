package homework;

/**
 * This class defines a country object
 */

public class Country {

    int id, code;
    String name, continet;

    public Country(int id, int code, String name, String continet) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.continet = continet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinet() {
        return continet;
    }

    public void setContinet(String continet) {
        this.continet = continet;
    }
}
