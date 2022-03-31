package homework.catalog;



import java.util.ArrayList;
import java.util.List;

public class Catalog implements java.io.Serializable {
    private String name;
    private List<Item> items = new ArrayList<>();

    private String path;
   public Catalog(String name, String path){
        this.name = name;
        this.path = path;

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public  Catalog(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void add(Item item) {
        items.add(item);
    }

    public Item findById(String id) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }
    public String toString(){
        String result = "";
        for(Item idx : items)
            result += idx.toString() + "\n";

        return result;
    }

}