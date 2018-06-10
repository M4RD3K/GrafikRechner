package Grafikrechner;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class AusgabeFeld extends JPanel {

	 //Jlabel
	
	JLabel jlAbleitung;
	JLabel jlZeigeAbleitung;
	JLabel jlNullstelle1;

	//Jbutton
	JButton jbZeichneFunktion;
	JButton jbAbleiten;
	
	public AusgabeFeld() {
		
		
		//Jlabel objekte
		jlAbleitung = new JLabel("f'(x)");
		jlZeigeAbleitung = new JLabel("Ableitung");
		
		//Jbutton objekte
		jbZeichneFunktion = new JButton("Zeichnen");
		jbAbleiten        = new JButton("Ableiten");
		
		//Einstellungen
	    this.add(jbAbleiten);
	    this.add(jlAbleitung);
	    this.add(jbZeichneFunktion);
		this.setLayout(new GridLayout(0,3));
		this.setBorder(new TitledBorder("Aktionen"));
		this.setBackground(Color.white);
		
	}
	
}
