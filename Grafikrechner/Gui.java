package Grafikrechner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/**
 * In der Gui Klasse wird die Gui unseres Programmes aus den einzelnen Paneln zu einem kompletten Frame zusammengesetzt. 
 */
public class Gui extends JFrame {
	
	  //Ausgabefeld

	  AusgabeFeld dasAusgabefeld;
	
	  //Schaubild
	  Schaubild dasSchaubild;
	
	  //Assosation mit Steuerungsklasse
	  Steuerung s;
	  
	  //Hautpanel des Frames
	  JPanel jpHautpanel;
	  
	  //Panel für Eingabefunktionen
	  FunktionsMenuPanel funktionsMenuPanel;
	  
	  //Die Menübar
	  UnsereMenuBar unserMenu;
	  
	  //Konstuctor 
      public Gui(Steuerung dieSteuerung) {
	
    	  //Assisation mit Steuerungsklasse herstellen
    	  s = dieSteuerung;
    	  
    	  //Objekte für das Frame bauen. 
    	  dasSchaubild       = new Schaubild(this);
    	  jpHautpanel        = new JPanel(new BorderLayout());
    	  funktionsMenuPanel = new FunktionsMenuPanel();  	  
    	  unserMenu          = new UnsereMenuBar();
    	  dasAusgabefeld     = new AusgabeFeld();
    	  
    	  //Fensteroptionen	  
    	  this.setContentPane(jpHautpanel);
    	  this.add(funktionsMenuPanel, BorderLayout.NORTH);
    	  this.add(dasSchaubild,BorderLayout.CENTER);
    	  this.setJMenuBar(unserMenu);
    	  this.add(dasAusgabefeld,BorderLayout.SOUTH);
    	  this.setSize(600,600);;
    	  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	  this.setTitle("Grafikrechner");
    	
    	  
	}
	
	
}
