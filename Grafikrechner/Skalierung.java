package Grafikrechner;

import java.awt.GridLayout;

import javax.swing.*;

public class Skalierung extends JFrame {

	JLabel jlXmin;
	JLabel jlXmax;
	JLabel jlYmin;
	JLabel jlYmax;
	JLabel jlLeer;
	
	JTextField jtXmin;
	JTextField jtXmax;
	JTextField jtYmin;
	JTextField jtYmax;
	
	JButton jButtonEinstellen;
	
	JPanel dasPanelSkalierung;
	
	public Skalierung() {
		
		dasPanelSkalierung = new JPanel(new GridLayout(2,5));
		
		jlLeer = new JLabel("");
		jlXmax = new JLabel("xMax:");
		jlXmin = new JLabel("xMin:");
		jlYmax = new JLabel("yMax:");
		jlYmin = new JLabel("yMin:");
		
	    jtXmin = new JTextField("-10");
	    jtXmax = new JTextField("10");
	    jtYmax = new JTextField("10");
	    jtYmin = new JTextField("-10");
	    
	    jButtonEinstellen = new JButton("Skalierung einstellen");
		dasPanelSkalierung.add(jlXmin);
		dasPanelSkalierung.add(jlXmax);
		dasPanelSkalierung.add(jlYmin);
		dasPanelSkalierung.add(jlYmax);
		dasPanelSkalierung.add(jlLeer);
		dasPanelSkalierung.add(jtXmin);
		dasPanelSkalierung.add(jtXmax);
		dasPanelSkalierung.add(jtYmin);
		dasPanelSkalierung.add(jtYmax);
		dasPanelSkalierung.add(jButtonEinstellen);
	    this.setContentPane(dasPanelSkalierung);
		
		this.pack();
		
		
	}
	
}
