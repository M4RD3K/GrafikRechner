package Grafikrechner;

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
	
	public AusgabeFeld() {
		
		
		//Jlabel objekte
		jlAbleitung = new JLabel("Ableitung:");
		jlZeigeAbleitung = new JLabel("F(x)");
		
		//Jbutton objekte
		jbZeichneFunktion = new JButton("Zeichnen");
		
	    this.add(jlAbleitung);
	    this.add(jlZeigeAbleitung);
	    this.add(jbZeichneFunktion);
		
	    
		this.setLayout(new GridLayout(0,3));
		this.setBorder(new TitledBorder("Ausgabe"));
		
		
	}
	
}
