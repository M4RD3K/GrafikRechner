package Grafikrechner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Anleitung extends JFrame {

	JLabel jlAnleitung;
	JPanel jPAnleitung;
	
	public Anleitung() {
	
		
	 jPAnleitung = new JPanel();	
	 jlAnleitung = new JLabel("Hier steht die Anleitung");
	
	 this.setContentPane(jPAnleitung);
	 this.setSize(400, 400);
	 jPAnleitung.add(jlAnleitung);
	 
	 this.setVisible(true);
	 
	}
	
}
