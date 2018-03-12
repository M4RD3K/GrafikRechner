package Grafikrechner;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class Gui<E> extends JFrame {

	Steuerung dieSteuerung;
	
	//--------------------------------------------------------------------------------------------------------FrameAnleitung
	FrameAnleitung fAnleitung;
	//--------------------------------------------------------------------------------------------------------JDropdown
	JComboBox<String> jcbfuktionstypWählen;
	//--------------------------------------------------------------------------------------------------------Panels
	JPanel jpContentpane;
	ZeichneFunktion zfZeichneFunktion;
	JPanel jpFunktionen;
	JPanel jpAbleitungen;
	JPanel jpWerte;
	JPanel jpAusgabe;
	//--------------------------------------------------------------------------------------------------------JLabel
	JLabel jltest;
	JLabel jlFunktion1;
	JLabel jlXwert1;
	JLabel jlYwert1;
	//--------------------------------------------------------------------------------------------------------TextFields
	JTextField jtfFunktion1;
	JTextField jtfXwert1;
	//--------------------------------------------------------------------------------------------------------JButton
	JButton jbBerechne;
	//--------------------------------------------------------------------------------------------------------JMenu	
	JMenu jmskalierung;
	JMenu jmHilfe;
	//--------------------------------------------------------------------------------------------------------JMenuBar
	JMenuBar jmbMeinMenu;
	//--------------------------------------------------------------------------------------------------------JMenuItem
	JMenuItem jmiAnleitung;
	JMenuItem jmiSkalierungEinstellen;
	
	
	public Gui(Steuerung s) {
		
     //-------------------------------------------------------------------------------------------------------JCombobox
	    jcbfuktionstypWählen = new JComboBox<>();
     //-------------------------------------------------------------------------------------------------------Steuerung		
		dieSteuerung = s;
	 //-------------------------------------------------------------------------------------------------------JPanel Objekte	
		jpContentpane     = new JPanel(new BorderLayout());
		zfZeichneFunktion = new ZeichneFunktion();
		jpFunktionen      = new JPanel(new GridLayout(1, 6));
		jpAbleitungen     = new JPanel(new GridLayout());
		jpWerte           = new JPanel(new GridLayout(1,1));
		jpAusgabe         = new JPanel(new GridLayout(2,1));	
	 //-------------------------------------------------------------------------------------------------------JTextField Objekte
		jtfFunktion1 = new JTextField();
		jtfXwert1    = new JTextField();		
	 //-------------------------------------------------------------------------------------------------------JLabel Objekte
		jltest = new JLabel("test");
		jlFunktion1 = new JLabel("Funktion: ");
		jlXwert1    = new JLabel("X: ");
		jlYwert1    = new JLabel("Y:");
	 //-------------------------------------------------------------------------------------------------------JMenu Objekte
		jmskalierung = new JMenu("Skalierung");
		jmHilfe     = new JMenu("Hilfe");	
	 //-------------------------------------------------------------------------------------------------------JMenuBar Objekte				
		jmbMeinMenu = new JMenuBar();
	 //-------------------------------------------------------------------------------------------------------JMenuItem Objekte
		jmiAnleitung = new JMenuItem("Anleitung");
		jmiSkalierungEinstellen = new JMenuItem("Skalierung Einstellen");
	 //-------------------------------------------------------------------------------------------------------JButton Objekte
		jbBerechne = new JButton("Berechne");
	 //-------------------------------------------------------------------------------------------------------Add Befehle
		
	 //-------------------------------------------------------------------------------------------------------JMenu add		
		jmskalierung.add(jmiSkalierungEinstellen);
		jmHilfe.add(jmiAnleitung);
	 //-------------------------------------------------------------------------------------------------------JMenubar add
		jmbMeinMenu.add(jmskalierung);
		jmbMeinMenu.add(jmHilfe);
	 //-------------------------------------------------------------------------------------------------------Panel add
		jcbfuktionstypWählen.addItem("Anzahl Faktoren");
		jcbfuktionstypWählen.addItem("1");
		jcbfuktionstypWählen.addItem("2");
		jcbfuktionstypWählen.addItem("3");
		jcbfuktionstypWählen.addItem("4");
		jcbfuktionstypWählen.addItem("5");
		jpFunktionen.add(jlFunktion1);
		jpFunktionen.add(jtfFunktion1);
		jpFunktionen.add(jcbfuktionstypWählen);
		jpFunktionen.add(jlXwert1);
		jpFunktionen.add(jtfXwert1);
		jpFunktionen.add(jbBerechne);
		jpWerte.add(jlYwert1);
		jpAusgabe.add(jpWerte);
		jpAusgabe.add(jpAbleitungen);
		jpContentpane.add(jpFunktionen,BorderLayout.NORTH);
		jpContentpane.add(zfZeichneFunktion,BorderLayout.CENTER);
		jpContentpane.add(jpAusgabe,BorderLayout.SOUTH);
	  //-------------------------------------------------------------------------------------------------------Action Listener
		jbBerechne.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				jlYwert1.setText("Y:"+jtfXwert1.getText());
				
				if(s.ueberpruefeFunktion(jtfFunktion1.getText().toString())) {
					
			switch (jcbfuktionstypWählen.getSelectedIndex()) {
			
			case 1:
				s.zerlegeFunktionsgleichungEins(jtfFunktion1.getText().toString());
				break;
			case 2:
				s.zerlegeFunktionsgleichungZwei(jtfFunktion1.getText().toString());
				break;
			case 3:
				s.zerlegeFunktionsgleichungDrei(jtfFunktion1.getText().toString());
				break;
			case 4:
				s.zerlegeFunktionsgleichungVier(jtfFunktion1.getText().toString());
				break;
			case 5:
				s.zerlegeFunktionsgleichungFuenf(jtfFunktion1.getText().toString());
				break;
			default:
				jtfFunktion1.setText("wähl was aus du idiot");
				break;
			}
				}
				
				
				
				
			}
		});	
		
		
		
		jmiAnleitung.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hi");
			
				fAnleitung = new FrameAnleitung();
				
			}
		});
		
	 //---------------------------------------------------------------------------------------------------------Fenster Optionen
		
		this.setJMenuBar(jmbMeinMenu);
		this.setContentPane(jpContentpane);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.pack();
		
	}
	
	
	
	
}
