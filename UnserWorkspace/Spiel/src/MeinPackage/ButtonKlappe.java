package MeinPackage;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonKlappe extends JButton implements ActionListener {
	
	public int wert;
	public static final String GESCHLOSSEN = "X";
	public static final int HEIGHT = 200;
	public static final int WIDTH = 48;
	Gui parent;
	
	public ButtonKlappe(int wert, Gui gui) {
		parent = gui;
		this.wert = wert;
		this.setPreferredSize(new Dimension( WIDTH,HEIGHT));
		this.setText(""+wert);
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		parent.klickKlappe(wert);
		
	}

}
