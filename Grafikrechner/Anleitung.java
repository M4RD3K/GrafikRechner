package Grafikrechner;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Anleitung extends JFrame {

	//AnleitungsPanel
	JPanel jPAnleitung;
	
	//JLabel
	
	JLabel jlAnleitung;
	
	public Anleitung() {
		
	 //Objekte Bauen und einstellen
     jlAnleitung = new JLabel("Anleitung");
	 jPAnleitung = new JPanel(new BorderLayout());	
	 jPAnleitung.setBorder(new TitledBorder("Anleitung:"));
	 jPAnleitung.setBackground(Color.WHITE);
	 jPAnleitung.add(jlAnleitung);
	
	 //Anleitunspanel einstellem
	 this.setContentPane(jPAnleitung);
	 this.setSize(400, 400);
	 this.setVisible(true);
	 
	 
	}
	
}
