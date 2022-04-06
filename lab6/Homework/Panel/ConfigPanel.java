package Panel;

import Main.MainFrame;
import javax.swing.*;

/**
 * Clasa ConfigPanel ne ajuta sa realizam configurarile tablei de joc, dimensiunea
 */

public class ConfigPanel extends JPanel {
    private final MainFrame frame;
    private JLabel label;
    private JSpinner spinnerRow;
    private JSpinner spinnerCol;
    private JButton createBtn = new JButton("Create");

    public ConfigPanel(MainFrame frame){
        this.frame = frame;
        init();
    }

    /**
     *  Cream interfata pentru a putea seta dimensiunea tablei, initializat initial cu  dimensiunea 3 pe 5
     *  Totodata vom creea si butonul Creat
     */

    private void init(){
        label = new JLabel("Grid size: ");
        spinnerRow = new JSpinner(new SpinnerNumberModel(5, 2, 100, 1));
        spinnerCol = new JSpinner(new SpinnerNumberModel(3, 2, 100, 1));

        add(label);
        add(spinnerRow);
        add(spinnerCol);
        add(createBtn);
        createBtn.addActionListener(frame::initDrawingPanel);
    }

    /**
     * Returneaza numarul de lini ale tabelei
     * @return
     */

     public int getRows(){
        return  (Integer) spinnerRow.getValue();
    }

    /**
     * returneaza numarul de coloane ale tabelei
     * @return
     */

     public int getCols(){
        return (Integer) spinnerCol.getValue();
     }
}
