package Grafikrechner;

import java.awt.GridLayout;

import javax.swing.*;

public class Skalierung extends JFrame {

	//Jlabel
	JLabel jlXmin;
	JLabel jlXmax;
	JLabel jlYmin;
	JLabel jlYmax;
	
	//JtextField 
	JTextField jtXmin;
	JTextField jtXmax;
	JTextField jtYmin;
	JTextField jtYmax;
	
	//JButton
	JButton jButtonEinstellen;
	JButton jButtonStandart;
	
	//Jpanel
	JPanel dasPanelSkalierung;
	
    //Konstrucktor 
	public Skalierung() {
		
		dasPanelSkalierung = new JPanel(new GridLayout(5,2));
		
		//Label objekte bauen
		jlXmax = new JLabel("Maximaler X-Wert:");
		jlXmin = new JLabel("Minimaler X-Wert:");
		jlYmax = new JLabel("Maximaler Y-Wert:");
		jlYmin = new JLabel("Minimaler Y-Wert:");
		
		//TextField bauen mit Standart werten
	    jtXmin = new JTextField("-10");
	    jtXmax = new JTextField("10");
	    jtYmax = new JTextField("10");
	    jtYmin = new JTextField("-10");
	    
	    //JButton bauen
	    jButtonEinstellen = new JButton("Skalierung einstellen");
	    jButtonStandart   = new JButton("Standart Skalierung");
	    
	    //Die Objekte dem Panel adden
		dasPanelSkalierung.add(jlXmin);
		dasPanelSkalierung.add(jtXmin);
		dasPanelSkalierung.add(jlXmax);
		dasPanelSkalierung.add(jtXmax);
		dasPanelSkalierung.add(jlYmin);
		dasPanelSkalierung.add(jtYmin);
		dasPanelSkalierung.add(jlYmax);
		dasPanelSkalierung.add(jtYmax);
		dasPanelSkalierung.add(jButtonStandart);
		dasPanelSkalierung.add(jButtonEinstellen);
		
		//Fensteroptionen
	    this.setContentPane(dasPanelSkalierung);
		this.setTitle("Skalierung");
		this.pack();
		
		
	}
	
}
