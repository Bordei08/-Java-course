import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner spinnerRow;
    JSpinner spinnerCol;
    JButton createBtn = new JButton("Create");

    public ConfigPanel(MainFrame frame){
        this.frame = frame;
        init();
    }

    private void init(){
        label = new JLabel("Grid size: ");
        spinnerRow = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        spinnerCol = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));

        add(label);
        add(spinnerRow);
        add(spinnerCol);
        add(createBtn);
    }
    public int getRows(){
        return  (Integer) spinnerRow.getValue();
    }
     public int getCols(){
        return (Integer) spinnerCol.getValue();
     }
}
