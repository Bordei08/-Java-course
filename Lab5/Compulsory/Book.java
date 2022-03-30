package compulsory;

public class Book extends Item implements java.io.Serializable {

    private String years;
    private String author;



    Book( String id, String title, String location, String years, String author) {
        setId(id);
        setTitle(title);
        setLocation(location);

        this.years= years;
        this.author = author;
    }

    Book(){

    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String toString() {
        return "name='" + getTitle() + '\'' +
                ", path='" + getLocation() + '\'' +
                ", author='" + author + '\'' +
                ", year=" + years +
                ", id=" + getId() ;

    }
}
