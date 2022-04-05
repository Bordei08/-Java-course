import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");

    public ControlPanel(MainFrame frame){
        this.frame = frame;
        init();
    }
    private void init(){
        setLayout(new GridLayout(1, 3));

        add(exitBtn);
        add(loadBtn);
        add(saveBtn);

        exitBtn.addActionListener(this::exitGame);
    }

    private void exitGame(ActionEvent e){
        frame.dispose();
    }

}
