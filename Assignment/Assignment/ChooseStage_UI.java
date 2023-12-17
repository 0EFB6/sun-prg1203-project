package Assignment;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ChooseStage_UI extends JFrame implements ActionListener{
	
	private JRadioButton rb1;
    private JRadioButton rb2;
    private JRadioButton rb3;
    private JRadioButton rb4;
    private JRadioButton rb5;
    private JRadioButton rb6;
    JButton stageSubmit = null;
    JPanel stagePanel = null;
	
	 public ChooseStage_UI(){	
		 this.setTitle("Choose stage");
		 
		 ButtonGroup bg = new ButtonGroup();
		    // Add the radio buttons to the button group
		    rb1 = new JRadioButton("Alola", true);
		    rb2 = new JRadioButton("Hoenn", false);
		    rb3 = new JRadioButton("Johto", true);
		    rb4 = new JRadioButton("Kalos", false);
		    rb5 = new JRadioButton("Sinnoh", true);
		    rb6 = new JRadioButton("Unova", false);
		    bg.add(rb1);
		    bg.add(rb2);
		    bg.add(rb3);
		    bg.add(rb4);
		    bg.add(rb5);
		    bg.add(rb6);

		    // Add "SUBMIT" button
		    stageSubmit = new JButton("SUBMIT");
		
		    // Add to the panel and frame
		    stagePanel = new JPanel(new GridLayout(4, 1));
		    stagePanel.add(rb1);
		    stagePanel.add(rb2);
		    stagePanel.add(rb3);
		    stagePanel.add(rb4);
		    stagePanel.add(rb5);
		    stagePanel.add(rb6);
		    stagePanel.add(stageSubmit);		
		    add(stagePanel);
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    // Set the size and visibility\
		    stageSubmit.addActionListener(this); 
		    setSize(400, 200);
		    setLocationRelativeTo(null); // set location to middle
		    setVisible(true);
			
	 }
	 
	 public void actionPerformed(ActionEvent ae) {
		 this.dispose();
		 Battle_UI battle = new Battle_UI();
	 }
}
