package Grafikrechner;

import java.awt.Color;

import javax.swing.*;


/**
 *In der Klasse UnsereMenubar kann die Menuebar unseres Projektes genauer konfiguriert werden. 
 */
public class UnsereMenuBar extends JMenuBar {

	
	
	JMenu jmskalierung;
	JMenu jmHilfe;
	
	JMenuItem jmiAnleitung;
	JMenuItem jmiSkalierungEinstellen;
	JMenuItem jmiUeber;
	
	
   public UnsereMenuBar() {
	
	   
	   //JMenu
	   jmskalierung = new JMenu("Skalierung");
	   jmHilfe     = new JMenu("Hilfe");
	   
	   //JMenuItem
	   jmiAnleitung = new JMenuItem("Anleitung");
	   jmiSkalierungEinstellen = new JMenuItem("Skalierung einstellen");
	   
	   
	   //JMenu menuitems zuweisen 
	   jmskalierung.add(jmiSkalierungEinstellen);
	   jmHilfe.add(jmiAnleitung);
	   
	   //JMenu in die Menubar hinzufügen
	   this.add(jmskalierung);
	   this.add(jmHilfe);
	   this.setBorderPainted(false);
	   
  }
	
}
