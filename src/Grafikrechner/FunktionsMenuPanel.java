package Grafikrechner;

import java.awt.GridLayout;

import javax.swing.*;

public class FunktionsMenuPanel extends JPanel {

	
	
	//JLabel
	JLabel jltest;
	JLabel jlFunktion1;
	JLabel jlXwert1;
	JLabel jlYwert1;
	
	//JTextfield
	JTextField jtfFunktion1;
	JTextField jtfXwert1;
	
	//JButton
	JButton jbBerechne;
	
	public FunktionsMenuPanel() {
	
		//Layout einstellen
		this.setLayout(new GridLayout(1,5));
		
		//JTextfield Objekte
		jtfFunktion1 = new JTextField();
		jtfXwert1    = new JTextField();		
		
		//JLabel Objekte
		jltest      = new JLabel("test");
		jlFunktion1 = new JLabel("Funktion: ");
		jlXwert1    = new JLabel("X: ");
		jlYwert1    = new JLabel("Y:");
		
		//JButton Objekte
		jbBerechne = new JButton("Berechne");
		
		//Objekte dem Panel zurodnen
		
		this.add(jlFunktion1);
		this.add(jtfFunktion1);
		this.add(jlXwert1);
		this.add(jtfXwert1);
		this.add(jbBerechne);
		
		
	}
	
}
