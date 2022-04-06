package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import Panel.ConfigPanel;
import Panel.ControlPanel;
import Panel.DrawingPanel;
import static java.awt.FlowLayout.CENTER;

/**
 * Aceasta clasa este "clasa parinte" pentru ControlPanel, ConfigPanel si DrawnPanel
 * Aceasta ne va ajuta sa realizam o legatura copil -> Parinte  -> Copil
 */

public class MainFrame extends JFrame {

    public ConfigPanel configPanel;
    private ControlPanel controlPanel = new ControlPanel(this);
    private DrawingPanel canvas;

    /**
     * Setam numele  si  dimensiunea ferestrei
     * si o initializam cu metoda init
     */

    public MainFrame(){
        super("My app");
        super.setSize(400, 500);
        init();
    }

    /**
     * Setam  butonul de inchidere X
     *folosim un obiect ConfiPanel pentru a configura tabela dupa bunul plac si il plasam in "nordul" aplicatiei
     * folosim un obiect ControlPanel pentru a implementa butoanele EXIT , Save, Load si le plasam in "sud"
     * folosim un obiect DrawPanel pentru a desena tabela jocului
     */

    private void init(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        configPanel = new ConfigPanel(this);
        canvas = new DrawingPanel(this);
        controlPanel = new ControlPanel(this);
       add(configPanel, BorderLayout.NORTH);
       add(controlPanel, BorderLayout.SOUTH);
       add(canvas, CENTER);

    }

    /**
     * Deseneaza tabla de joc
     * @param actionEvent
     */

    public void initDrawingPanel(ActionEvent actionEvent) {
        canvas.init();
    }

    /**
     * Salveaza imaginea
     */

    public void saveImage() {
        canvas.saveImage();
    }
}
