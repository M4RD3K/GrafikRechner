package Grafikrechner;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.*;
import javax.swing.border.TitledBorder;


/**
 * Die Klasse AusgabeFeld gibt einem die Moeglichkeit das untere Panel der Gui einfach zu bearbeiten.
 */
public class AusgabeFeld extends JPanel {

	 //Jlabel
	JLabel jlZeigeNullstellen;
	JLabel jlAbleitung;
	JLabel jlZeigeAbleitung;
	JLabel jlNullstelle;
	JLabel jlAbleitungAnzeige;

	//Jbutton
	JButton jbZeichneFunktion;
	JButton jbAbleiten;
	JButton jbNullstellen;
	
	public AusgabeFeld() {
		
		
		//Jlabel objekte
		jlAbleitung = new JLabel("f'(x)");
		jlZeigeAbleitung = new JLabel("Ableitung");
		jlNullstelle = new JLabel("Nullstelle: ");
		jlZeigeNullstellen = new JLabel("P(X/Y)");
		jlAbleitungAnzeige = new JLabel("Ableitung:");
		
		//Jbutton objekte
		jbZeichneFunktion = new JButton("Zeichnen");
		jbAbleiten        = new JButton("Ableiten");
		jbNullstellen     = new JButton("Berechnen");
		
		//Einstellungen
		
		this.add(jlAbleitungAnzeige);
		this.add(jlAbleitung);
		this.add(jbAbleiten);
		
		this.add(jlNullstelle);
		this.add(jlZeigeNullstellen);
	    this.add(jbNullstellen);
	    
		this.setLayout(new GridLayout(2,3));
		this.setBorder(new TitledBorder("Aktionen"));
		this.setBackground(Color.white);
		
	}
	
}
