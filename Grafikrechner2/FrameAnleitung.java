package Grafikrechner;

import javax.swing.*;

public class FrameAnleitung extends JFrame {


public FrameAnleitung() {
		
	    //JPanel 
		JPanel jpAnleitung;
		
		//JLabel
		JLabel jlAnleitung;
		
		//Objekte Bauen
		jpAnleitung = new JPanel();
		jlAnleitung = new JLabel("Willkommen in der Anleitung");
		
		//Objekte dem Frame hinzufügen
		jpAnleitung.add(jlAnleitung);
		
		//Fensteroptionen
		this.setContentPane(jpAnleitung);
		this.setTitle("Text");
		this.setVisible(true);
		this.setSize(300, 300);
		this.setTitle("Anleitung");
	}
	
	
}
