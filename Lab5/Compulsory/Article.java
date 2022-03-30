package compulsory;

public class Article extends  Item implements java.io.Serializable{

    private String years;
    private String author;

    Article(String id, String title, String location, String years, String author){
        setId(id);
        setTitle(title);
        setLocation(location);
        this.years = years;
        this.author = author;
    }

    Article(){

    }

    public String toString() {
        return "name='" + getTitle() + '\'' +
                ", path='" + getLocation() + '\'' +
                ", author='" + author + '\'' +
                ", year=" + years +
                ", id=" + getId() ;

    }
}
