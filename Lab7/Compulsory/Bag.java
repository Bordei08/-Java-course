import java.util.*;

public class Bag {
    private final List<Tile> letters;
    Random random = new Random();

    public Bag(){
        List<Tile> temp = new ArrayList<>();
        for(char c = 'a'; c <= 'z'; c++){
            temp.add(new Tile(c, random.nextInt(10)+1));
        }
        letters = temp;
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) {
                break;
            }
            extracted.add(getOneTile());
        }
        return extracted;
    }

    private Tile getOneTile() {
        Tile t;
        synchronized (this) {
            int index = random.nextInt(letters.size());
            t = letters.get(index);
            letters.remove(index);
        }
        return t;
    }


}
