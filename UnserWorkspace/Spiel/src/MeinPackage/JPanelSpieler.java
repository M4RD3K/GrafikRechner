package MeinPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class JPanelSpieler extends JPanel {
	
	JLabel lbTitel;
	JLabel lbName;
	JLabel lbPunkte;
	JPanel jpTitel;
	JPanel jpDaten;
	JTextField tfName;
	JTextField tfPunkte;
	
	JSeparator separator ;
	
	int sNr;
	
	public JPanelSpieler(int spielerNr) {
		sNr = spielerNr;
		lbTitel = new JLabel("Spieler " + sNr);
		lbName = new JLabel("Name:");
		lbPunkte = new JLabel("Punkte:");
		tfName = new JTextField(10);
		tfPunkte = new JTextField(5);
		jpDaten = new JPanel();
		jpTitel = new JPanel();
		
		this.setBorder(new RoundedBorder(10)); //10 is the radius
		this.setLayout(new BorderLayout());
		
		jpTitel.add(lbTitel);
		jpTitel.setBackground(Color.GRAY);
		jpTitel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		GridLayout gridLayout = new GridLayout(2, 2,10,10);
		gridLayout.setHgap(10);
		gridLayout.setVgap(10);
		jpDaten.setLayout(gridLayout);
		jpDaten.add(lbName);
		jpDaten.add(tfName);
		jpDaten.add(lbPunkte);
		jpDaten.add(tfPunkte);
		
		this.add(jpTitel,BorderLayout.NORTH);
		
		
		separator = new JSeparator(JSeparator.HORIZONTAL);
		separator.setPreferredSize(new Dimension(getWidth(),10));
				
		this.add(separator,BorderLayout.CENTER);
		this.add(jpDaten,BorderLayout.SOUTH);
		
		
	}

	private static class RoundedBorder implements Border {

	    private int radius;


	    RoundedBorder(int radius) {
	        this.radius = radius;
	    }


	    public Insets getBorderInsets(Component c) {
	        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
	    }


	    public boolean isBorderOpaque() {
	        return true;
	    }


	    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
	        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
	    }
	}

}

	

