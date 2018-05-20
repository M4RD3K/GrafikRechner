package Grafikrechner;

import java.awt.GridLayout;

import javax.swing.*;

public class Skalierung extends JFrame {

	JLabel jlXmin;
	JLabel jlXmax;
	JLabel jlYmin;
	JLabel jlYmax;
	
	JTextField jtXmin;
	JTextField jtXmax;
	JTextField jtYmin;
	JTextField jtYmax;
	
	JButton jButtonEinstellen;
	JButton jButtonStandart;
	
	JPanel dasPanelSkalierung;
	
	public Skalierung() {
		
		dasPanelSkalierung = new JPanel(new GridLayout(5,2));
		
		jlXmax = new JLabel("Maximaler X-Wert:");
		jlXmin = new JLabel("Minimaler X-Wert:");
		jlYmax = new JLabel("Maximaler Y-Wert:");
		jlYmin = new JLabel("Minimaler Y-Wert:");
		
	    jtXmin = new JTextField("-10");
	    jtXmax = new JTextField("10");
	    jtYmax = new JTextField("10");
	    jtYmin = new JTextField("-10");
	    
	    jButtonEinstellen = new JButton("Skalierung einstellen");
	    jButtonStandart   = new JButton("Standart Skalierung");
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
	    this.setContentPane(dasPanelSkalierung);
		this.setTitle("Skalierung");
		this.pack();
		
		
	}
	
}
