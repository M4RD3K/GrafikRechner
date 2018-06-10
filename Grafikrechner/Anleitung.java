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
	
		jlAnleitung = new JLabel("Willkomme in der Anleitung"
				+ "Bisher unterstüzen wir in der Beta version "
				+ "nur Ganzrationale Funktionen bis zum 9. Grad"
				+ "es dürfen nur funktionsgleichungen ohne Brüche und klammern"
				+ "eingegeben werden. Für kommata bitte den punkt Operator verwenden");
	 	
		
	 //Objekte Bauen und einstellen
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
