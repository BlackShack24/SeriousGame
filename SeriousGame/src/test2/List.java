package test2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class List implements ActionListener {
	    private int counter = 0;
	    private JLabel text;
	    
	    public List(JLabel text) {
	    	this.text = text;
	    }
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        text.setText(""+counter++);
	    }
	}
