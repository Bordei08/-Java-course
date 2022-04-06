package Panel;

import Main.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Clasa DrawingPanel va creea tabela cu jocul efectiv si totodata va implementa si logica jocului
 */

public class DrawingPanel extends JPanel {

    private final MainFrame frame;
    private int rows, cols;
    private int canvasWidth = 400, canvasHeight = 400;
    private int boardWidth, boardHeight;
    private int cellWidth, cellHeight;
    private int padX, padY;
    private int stoneSize = 20;
    private int stoneNumber = 0;
    private int[][] board;
    private int numberAvaStones = 0;
    private BufferedImage image;
    private Graphics2D offscreen;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
    }

    /**
     * Face printscreen-ul la tabela de joc
     */

    private void createOffscreenImage() {
        image = new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        offscreen = image.createGraphics();
        offscreen.setColor(Color.WHITE);  //fill the image with white
        offscreen.fillRect(0, 0, canvasWidth, canvasHeight);
    }

    /**
     * Salveaza printscreen-ul intr-un fisier png
     */

    public void saveImage() {
        try {
            if (ImageIO.write(image, "png", new File("./output_image.png"))) {
                System.out.println("-- saved");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializeaza datele tabelei, urmareste miscarile mouse 0ului si deseneaza tabela
     */

    public void init() {
        offscreen.setColor(Color.WHITE);  //fill the image with white
        offscreen.fillRect(0, 0, canvasWidth, canvasHeight);
        this.stoneNumber = 0;
        this.rows = frame.configPanel.getRows();
        this.cols = frame.configPanel.getCols();
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        this.board = new int[rows][cols];
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));

        this.addMouseListener(new MouseAdapter() {
                                  @Override
                                  public void mousePressed(MouseEvent e) {

                                        if (getStoneNumber() % 2 == 1)
                                            drawStone(e.getX(), e.getY());
                                        else
                                            computerMove();

                                        repaint();
                                    }

                              }
        );
        paintGrid();
        drawSticks();
        repaint();
    }

    /**
     * Verifica daca jocul s a terminat
     * Daca un player a pus o piesa care se intersecteaza cu o piesa a oponetului acesta a pierdut si functia va returna true
     * In caz contrat false
     *
     * @param x
     * @param y
     * @return
     */

    public boolean isGmameOver(int x, int y) {

        int turn = board[x][y];
        for (int i = 0; i < cols; i++)
            if (i != y && board[x][i] != board[x][y] && board[x][i] > 1)
                return true;

        for (int i = 0; i < rows; i++)
            if (i != x && board[i][y] != board[x][y] && board[i][y] > 1)
                return true;

        return false;
    }

    /**
     * Primeste coordonatele unui stick si are sanse 50% sa il coloreze sau nu
     * Noi vom  desena stick- uri spre parte dreapta sau in jos tinand cont de dimensiunile matricei (vezi functia drawingSticks)
     * Al treilea parametru este pentru directia stick ului
     *
     * @param row
     * @param col
     * @param dir
     */

    private void drawStick(int row, int col, int dir) {
        Random rand = new Random();
        int random = rand.nextInt(2);
        if (random == 0) return;


        int x1 = padX + col * cellWidth;
        int y1 = padY + row * cellHeight;
        this.board[row][col] = 1;
        if (dir == 1) {
            this.board[row][col + 1] = 1;
            offscreen.setColor(Color.BLACK);
            offscreen.fillRect(x1, y1 - 2, cellWidth, 4);
        }
        if (dir == 2) {
            this.board[row + 1][col] = 1;
            offscreen.setColor(Color.BLACK);
            offscreen.fillRect(x1 - 2, y1, 4, cellHeight);
        }
    }

    /**
     * Porneste din fiecare punct si formeaza stick-uri cu vecinul de jos si cel din dreapta, tinand cont de dimensiunile matricei
     * Pentru fiecare stick apeleaza functia drawingStick
     */

    private void drawSticks() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row != rows - 1 && col != cols - 1) {
                    drawStick(row, col, 1);
                    drawStick(row, col, 2);
                }
                if (row == rows - 1 && col != cols - 1) {
                    drawStick(row, col, 1);
                }
                if (col == cols - 1 && row != rows - 1) {
                    drawStick(row, col, 2);
                }
            }
        }
    }

    /**
     * Afiseaza in consola matrice ce reprezinta tabele de joc
     * 0 este pentru pozitie imposibila
     * 1 pozitie posibila de selectata
     * 2 pentru piesele rosi
     * 3 piesele albastre
     */

    private void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Deseneaza o piese la coordonatele date ca parametri
     * Verifica daca locatia dorita este disponibila, o deseneaza si verifica daca mutarea a fost decisiva sau nu
     *Daca numarul mutari este impar atunci este randul jucatorului, iar pentru cazul in care este par este randul Ai- ului
     * @param x
     * @param y
     */

    private void drawStone(int x, int y) {
        if (stoneNumber % 2 == 1) {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (x >= padX + col * cellWidth - stoneSize / 2 && x <= padX + col * cellWidth + stoneSize / 2) {
                        if (y >= padY + row * cellHeight - stoneSize / 2 && y <= padY + row * cellHeight + stoneSize / 2) {
                            if (board[row][col] == 0 || board[row][col] == 2 || board[row][col] == 3) return;

                            x = padX + col * cellWidth;
                            y = padY + row * cellHeight;
                            offscreen.setColor(this.stoneNumber % 2 == 1 ? Color.RED : Color.BLUE);
                            offscreen.fillOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
                            board[row][col] = this.stoneNumber % 2 == 1 ? 2 : 3;
                            // printBoard();
                            if (isGmameOver(row, col)) {
                                String winner = this.stoneNumber % 2 == 1 ? "Blue" : "Red";
                                System.out.println("Game over => Winner = " + winner);
                                //System.exit(0);
                            }
                            this.stoneNumber++;
                        }
                    }
                }
            }

        }
        else{

            int row, col;
            row = x ;
            col = y ;
            x = padX + col * cellWidth;
            y = padY + row * cellHeight;
            offscreen.setColor(this.stoneNumber % 2 == 1 ? Color.RED : Color.BLUE);
            offscreen.fillOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            board[row][col] = this.stoneNumber % 2 == 1 ? 2 : 3;
            if (isGmameOver(row, col)) {
                String winner = this.stoneNumber % 2 == 1 ? "Blue" : "Red";
                System.out.println("Game over => Winner = " + winner);
                //System.exit(0);
            }
            this.stoneNumber++;
        }
    }



    /**
     * Deseneaza linile verticale, orizontale si locurile unde pot fi adaugate piese
     */

    private void paintGrid() {
        offscreen.setColor(Color.DARK_GRAY);
        //horizontal lines
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            offscreen.drawLine(x1, y1, x2, y2);
        }

        for (int col = 0; col < cols; col++) {
            int x1 = padX + col * cellWidth;
            int y1 = padY;
            int x2 = x1;
            int y2 = y1 + boardHeight;
            offscreen.drawLine(x1, y1, x2, y2);
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                offscreen.setColor(Color.LIGHT_GRAY);
                offscreen.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }
    }

    /**
     * Deseneaza imaginea cu printscreen ul jocului
     *
     * @param graphics
     */

    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }

    public int getStoneNumber() {
        return this.stoneNumber;
    }

    /**
     * Aceasta metoda cauta  "cea mai buna mutare "
     */

    public void computerMove() {

        /**
         * Daca se indeplinesc urmatoarele propietati facem  miscarea
         * poztia se afla pe un stick
         *  blocheaza  o line libera(pe care nu se afla decat valori de 1 sau 0) care contine cel putin un capat al unui stick
         * o coloana care este libera si contine cel putin un capat al unui stick
         */

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                 if(board[i][j] == 1 && isGoodMoveForRows(i) && isGoodMoveForCols(j)){

                     drawStone(i,j);
                     return;
                 }
            }
        }

        /**
         * Facem miscare daca respecta urmatoarele propietati :
         * Daca se afla pe un stick
         * Daca nu se intersecteaza cu un oponent pe linie si coloana
         */

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 1 && isSaveMoveForRows(i) && isSaveMoveForCols(j)) {
                    drawStone(i, j);
                    return;
                }
            }
        }
        /**
         * Urmatoarele cazuri sunt cele de mai sus dar cu modificare ca cel putin una sa fie adevarata
         * In cele mai multe cazuri nu se ajunge pana aici
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(board[i][j] == 1 && (isSaveMoveForRows(i) || isSaveMoveForCols(j))){
                    drawStone(i,j);
                    return ;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(board[i][j] == 1 && (isGoodMoveForRows(i) || isGoodMoveForCols(j))){
                    drawStone(i,j);
                    return ;
                }
            }
        }


        System.out.println("error");
    }

    /**
     * Verfica daca lina x este libera si contine cel putin un capat al unui stick
     * @param x
     * @return
     */

    private boolean isGoodMoveForRows(int x){
        int sum = 0;
        for(int i = 0; i < cols; i ++){
            if(board[x][i] <= 1)
                sum ++;
            else
                return false;
        }
        return sum > 0;

    }

    /**
     * Verifica daca coloana x este libera si contine un capat al unui stick
     * @param x
     * @return
     */

    private boolean isGoodMoveForCols(int x){
        int sum = 0;
        for(int i = 0; i < rows; i ++){
            if(board[i][x] <= 1)
                sum ++;
            else
                return false;
        }
        return sum > 0;

    }

    /**
     * Verifica daca linia x este libera
     * @param x
     * @return
     */

    private boolean isSaveMoveForRows(int x){
        int sum = 0;
        for(int i = 0; i < cols; i ++){
            if(board[x][i] < 2 || board[x][i] == 3)
                sum ++;
            else
                return false;
        }
        return true;

    }

    /**
     * Verficia daca coloana x este libera
     * @param x
     * @return
     */

    private boolean isSaveMoveForCols(int x){
        int sum = 0;
        for(int i = 0; i < rows; i ++){
            if(board[i][x] <= 1 || board[i][x] == 3)
                sum ++;
            else
                return false;
        }
        return true;

    }

}
