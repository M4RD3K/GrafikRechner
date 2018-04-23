package Grafikrechner;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gui extends JFrame {

	  //Assosation mit Steuerungsklasse
	  Steuerung s;
	  
	  //Hautpanel des Frames
	  JPanel jpHautpanel;
	  
	  //Panel für Eingabefunktionen
	  FunktionsMenuPanel funktionsMenuPanel;
	  
	  //Die Menübar
	  UnsereMenuBar unserMenu;
	  
	  //Constuctor 
      public Gui(Steuerung dieSteuerung) {
	
    	  //Assisation mit Steuerungsklasse herstellen
    	  s = dieSteuerung;
    	  
    	  //Objekte für das Frame bauen. 
    	  jpHautpanel        = new JPanel(new BorderLayout());
    	  funktionsMenuPanel = new FunktionsMenuPanel();  	  
    	  unserMenu          = new UnsereMenuBar();
    	  
    	  //Fensteroptionen	  
    	  this.setContentPane(jpHautpanel);
    	  this.add(funktionsMenuPanel, BorderLayout.NORTH);
    	  this.setJMenuBar(unserMenu);
    	  this.pack();
    	  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	   
	}
	
	
}
