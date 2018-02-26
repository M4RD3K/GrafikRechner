package Grafikrechner;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gui extends JFrame {

	Steuerung dieSteuerung;
	
	
	//Panels
	
	JPanel jpContentpane;
	ZeichneFunktion zfZeichneFunktion;
	JPanel jpFunktionen;
	JPanel jpAbleitungen;
	JPanel jpWerte;
	JPanel jpAusgabe;
	
	//JLabel
	JLabel jlFunktion1;
	JLabel jlXwert1;
	JLabel jlYwert1;
	
	
	//TextFields
	JTextField jtfFunktion1;
	JTextField jtfXwert1;
	
	//JButton
	
	JButton jbBerechne;

	//JMenu
	
	JMenu jmskalierung;
	JMenu jmsueber;
	
	//JMenuBar
	JMenuBar jmbMeinMenu;
	
	//JMenuItem
	
	JMenuItem jmiHilfe;
	JMenuItem jmiSkalierungEinstellen;
	
	
	public Gui(Steuerung s) {
		
		dieSteuerung = s;
		
		
		//Panel Objekte
		
		jpContentpane     = new JPanel(new BorderLayout());
		zfZeichneFunktion = new ZeichneFunktion();
		jpFunktionen      = new JPanel(new GridLayout(1, 5));
		jpAbleitungen     = new JPanel(new GridLayout());
		jpWerte           = new JPanel(new GridLayout(1,1));
		jpAusgabe         = new JPanel(new GridLayout(2,1));
		
		//TextField Objekte
		jtfFunktion1 = new JTextField();
		jtfXwert1    = new JTextField();
		
				
		//Label Objekte
		jlFunktion1 = new JLabel("Funktion: ");
		jlXwert1    = new JLabel("X: ");
		jlYwert1    = new JLabel("Y:");
		
		//JMenu Objekte
	
		jmskalierung = new JMenu("Skalierung");
		jmsueber     = new JMenu("Über");
		
		
		//Menubar Objekt 
				
		jmbMeinMenu = new JMenuBar();
		
		//Menu Item Objekt
		
		jmiHilfe = new JMenuItem("Hilfe");
		jmiSkalierungEinstellen = new JMenuItem("Skalierung Einstellen");
		
		
		//JButton Objekt
		
		jbBerechne = new JButton("Berechne");
		
		
		//Add befehle ----------------------------------
		
		
	    //JMenu add
		
		jmskalierung.add(jmiSkalierungEinstellen);
		jmsueber.add(jmiHilfe);
		
		
		//JMenubar add
		
		jmbMeinMenu.add(jmsueber);
		jmbMeinMenu.add(jmskalierung);
		
		
	
		
		
		
		
		//Panel add
		jpFunktionen.add(jlFunktion1);
		jpFunktionen.add(jtfFunktion1);
		jpFunktionen.add(jlXwert1);
		jpFunktionen.add(jtfXwert1);
		jpFunktionen.add(jbBerechne);
		jpWerte.add(jlYwert1);
		jpAusgabe.add(jpWerte);
		jpAusgabe.add(jpAbleitungen);
		jpContentpane.add(jpFunktionen,BorderLayout.NORTH);
		jpContentpane.add(zfZeichneFunktion,BorderLayout.CENTER);
		jpContentpane.add(jpAusgabe,BorderLayout.SOUTH);
		
		
		//Action Listener
		jbBerechne.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				jlYwert1.setText("Y:"+jtfXwert1.getText());
			}
		});	
		
		//Fenster Optionen
		
		this.setJMenuBar(jmbMeinMenu);
		this.setContentPane(jpContentpane);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(200,200);
		
	}
	
	
	
	
}
