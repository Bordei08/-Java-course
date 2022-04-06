package Panel;

import Main.MainFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Clasa ControlPanel ne va ajuta sa implementam butoanele din josul aplicatiei Exit, Save si Load
 */

public class ControlPanel extends JPanel {

    private final MainFrame frame;
    private JButton exitBtn = new JButton("Exit");
    private JButton loadBtn = new JButton("Load");
    private JButton saveBtn = new JButton("Save");

    public ControlPanel(MainFrame frame){
        this.frame = frame;
        init();
    }

    /**
     * Functionalitatea  butoanelor
     */

    private void init(){
        setLayout(new GridLayout(1, 3));

        add(exitBtn);
        add(loadBtn);
        add(saveBtn);

        exitBtn.addActionListener(this::exitGame);
        saveBtn.addActionListener(this::saveImage);
    }

    /**
     * Salveaza imaginea cu tabla de joc
     * @param e
     */

    private void saveImage(ActionEvent e){
        frame.saveImage();
    }

    /**
     * Inchide aplicatia
     * @param e
     */

    private void exitGame(ActionEvent e){
        frame.dispose();
    }

}
