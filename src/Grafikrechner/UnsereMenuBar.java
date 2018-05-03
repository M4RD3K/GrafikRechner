package Grafikrechner;

import javax.swing.*;

public class UnsereMenuBar extends JMenuBar {

	
	
	JMenu jmskalierung;
	JMenu jmHilfe;
	
	JMenuItem jmiAnleitung;
	JMenuItem jmiSkalierungEinstellen;
	
	
   public UnsereMenuBar() {
	
	   
	   //JMenu
	   jmskalierung = new JMenu("Skalierung");
	   jmHilfe     = new JMenu("Hilfe");
	   
	   //JMenuItem
	   jmiAnleitung = new JMenuItem("Anleitung");
	   jmiSkalierungEinstellen = new JMenuItem("Skalierung Einstellen");
	   
	   
	   //JMenu menuitems zuweisen 
	   jmskalierung.add(jmiSkalierungEinstellen);
	   jmHilfe.add(jmiAnleitung);
	   
	   //JMenu in die Menubar hinzufügen
	   this.add(jmskalierung);
	   this.add(jmHilfe);
	   
	   //Optionen
	   
	   this.setVisible(true);
	   
	   
  }
	
}
