import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class testGui extends JFrame{

	Steuerung s;

	JPanel     hauptcontainer;
	JTextField  xEingabe;
	JTextField hochzahl;
	JLabel ausgabe;
	JLabel zeigeAusgabe;
	JButton berechne;
	
    public testGui(Steuerung ps ) {
		
    	s = ps;
    	
    	hauptcontainer = new JPanel(new GridLayout(2, 3));
        xEingabe = new JTextField();
        hochzahl = new JTextField();
        ausgabe = new JLabel("");
        zeigeAusgabe = new JLabel("Y - Wert");
        berechne = new JButton("Berechne");
        
        hauptcontainer.add(hochzahl);
        hauptcontainer.add(xEingabe);
        hauptcontainer.add(berechne);
        hauptcontainer.add(zeigeAusgabe);
        hauptcontainer.add(ausgabe);
        
        this.setTitle("Grafikrechner");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);
        this.setContentPane(hauptcontainer);
 
        
        berechne.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
	
			double ywert = s.gebePrdouktwert(1, s.leseZahlX(), s.leseHochzah());
			ausgabe.setText(""+ywert);
		    
				
			}
		});
        
        
	}	
	
	
    
    
    
    
}
