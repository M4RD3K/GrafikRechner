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
	JLabel jlExtrempunkte;
	JLabel jlZeigeExtrempunke;
	JLabel jlZeigeNullstellen;
	JLabel jlAbleitung;
	JLabel jlZeigeAbleitung;
	JLabel jlNullstelle;
	JLabel jlAbleitungAnzeige;

	//Jbutton
	JButton jbZeichneFunktion;
	JButton jbAbleiten;
	JButton jbExtrempunkte;
	JButton jbNullstellen;
	
	public AusgabeFeld() {
		
		
		//Jlabel objekte
		jlExtrempunkte = new JLabel("Extrempunkte:");
		jlZeigeExtrempunke = new JLabel("P(X/Y)");
		jlAbleitung = new JLabel("f'(x)");
		jlZeigeAbleitung = new JLabel("Ableitung");
		jlNullstelle = new JLabel("Nullstellen: ");
		jlZeigeNullstellen = new JLabel("P(X/Y)");
		jlAbleitungAnzeige = new JLabel("Ableitung:");
		
		//Jbutton objekte
		jbZeichneFunktion = new JButton("Zeichnen");
		jbAbleiten        = new JButton("Ableiten");
		jbExtrempunkte    = new JButton("Berechnen");
		jbNullstellen     = new JButton("Berechnen");
		
		//Einstellungen
		
		this.add(jlAbleitungAnzeige);
		this.add(jlAbleitung);
		this.add(jbAbleiten);
		
		this.add(jlExtrempunkte);
		this.add(jlZeigeExtrempunke);
		this.add(jbExtrempunkte);
		
		this.add(jlNullstelle);
		this.add(jlZeigeNullstellen);
	    this.add(jbNullstellen);
	    
		this.setLayout(new GridLayout(3,3));
		this.setBorder(new TitledBorder("Aktionen"));
		this.setBackground(Color.white);
		
	}
	
}
