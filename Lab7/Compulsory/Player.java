import java.util.List;

public class Player implements Runnable{
    private String name;
    private Game game;
    private boolean running;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Game getGame() {
        return game;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public Player(String name){
        this.name = name;
    }

    private String getWord(List<Tile> extracted){
        String word = new String();
        for(Tile t : extracted){
            word += t;
        }
        return word;
    }

    private boolean submitWord() throws InterruptedException {
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()){
            return false;
        }
        String word = getWord(extracted);
        game.getBoard().addWord(this, word);
        Thread.sleep(40);
        return true;
    }

    public void setGame(Game game) {
        this.game = game;
    }
    @Override
    public void run(){
        try {
            while (submitWord()){

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
