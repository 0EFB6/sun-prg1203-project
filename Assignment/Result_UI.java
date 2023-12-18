package Assignment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Result_UI extends JFrame implements ActionListener{
    private JLabel resultLabel;

    public Result_UI(String result) {
        setTitle("Result");
        resultLabel = new JLabel(result);
        add(resultLabel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
    	
    }
}
