package MeinPackage;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;

import javax.swing.JButton;
import javax.swing.border.Border;

public class MeinButtonWuerfel extends JButton {

	private int wert;
	private int width, height;
	private int mitteX, mitteY, spalteLinks, spalteRechts,reihe1, reihe2, reihe3, gap;
	private static final int HEIGHT = 100;
	private static final int WIDTH = 100;
	public static final int RADIUS_CIRCLE = 15;

	public MeinButtonWuerfel(int wert) {
		super();
		this.wert = wert;
			
		//this.setBorderPainted(false);
		this.setOpaque(true);
		//this.setContentAreaFilled(false);
		this.setBorder(new RoundedBorder(10)); //10 is the radius
		this.setForeground(Color.white);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		revalidate();
	}

	
	
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		
		g2.setRenderingHint(
                 RenderingHints.KEY_ANTIALIASING, 
                 RenderingHints.VALUE_ANTIALIAS_ON);
		
		
				
		g2.setColor(Color.BLACK);
		
		
		width = getSize().width;
		height = getSize().height;
		
		
		
		mitteX = width/2 - RADIUS_CIRCLE/2;
		mitteY = height/2 - RADIUS_CIRCLE/2;
		spalteLinks = width/4 - RADIUS_CIRCLE/2;
		spalteRechts = width - spalteLinks- RADIUS_CIRCLE;
		
		gap=(height-(3*RADIUS_CIRCLE))/4;
				
		reihe2 = height - (height/2)  -RADIUS_CIRCLE/2;
		reihe1 = reihe2-gap-RADIUS_CIRCLE;
		reihe3 = reihe2+gap+RADIUS_CIRCLE;

		switch (wert) {
		case 1:
			zeichneEins(g2);
			break;
		case 2:
			zeichneZwei(g2);
			break;
		case 3:
			zeichneDrei(g2);
			break;
		case 4:
			zeichneVier(g2);
			break;
		case 5:
			zeichneFuenf(g2);
			break;
		case 6:
			zeichneSechs(g2);
			break;

		}

	}

	private void zeichneSechs(Graphics2D g) {
		g.fillOval(spalteLinks, reihe1, RADIUS_CIRCLE, RADIUS_CIRCLE);
		g.fillOval(spalteLinks, reihe2, RADIUS_CIRCLE, RADIUS_CIRCLE);
		g.fillOval(spalteLinks, reihe3, RADIUS_CIRCLE, RADIUS_CIRCLE);
		g.fillOval(spalteRechts, reihe1, RADIUS_CIRCLE, RADIUS_CIRCLE);
		g.fillOval(spalteRechts, reihe2, RADIUS_CIRCLE, RADIUS_CIRCLE);
		g.fillOval(spalteRechts, reihe3, RADIUS_CIRCLE, RADIUS_CIRCLE);

	}

	private void zeichneFuenf(Graphics2D g) {
		g.fillOval(spalteLinks, reihe1, RADIUS_CIRCLE, RADIUS_CIRCLE);
		g.fillOval(spalteLinks, reihe3, RADIUS_CIRCLE, RADIUS_CIRCLE);
		g.fillOval(spalteRechts, reihe1, RADIUS_CIRCLE, RADIUS_CIRCLE);
		g.fillOval(mitteX, mitteY, RADIUS_CIRCLE, RADIUS_CIRCLE);
		g.fillOval(spalteRechts, reihe3, RADIUS_CIRCLE, RADIUS_CIRCLE);

	}

	private void zeichneVier(Graphics2D g) {
		g.fillOval(spalteLinks, reihe1, RADIUS_CIRCLE, RADIUS_CIRCLE);
		g.fillOval(spalteLinks, reihe3, RADIUS_CIRCLE, RADIUS_CIRCLE);
		g.fillOval(spalteRechts, reihe1, RADIUS_CIRCLE, RADIUS_CIRCLE);
		g.fillOval(spalteRechts, reihe3, RADIUS_CIRCLE, RADIUS_CIRCLE);

	}

	private void zeichneDrei(Graphics2D g) {
		g.fillOval(spalteLinks, reihe1, RADIUS_CIRCLE, RADIUS_CIRCLE);
		g.fillOval(mitteX, mitteY, RADIUS_CIRCLE, RADIUS_CIRCLE);
		g.fillOval(spalteRechts, reihe3, RADIUS_CIRCLE, RADIUS_CIRCLE);
	}

	private void zeichneZwei(Graphics2D g) {
		g.fillOval(spalteLinks, reihe1, RADIUS_CIRCLE, RADIUS_CIRCLE);
		g.fillOval(spalteRechts, reihe3, RADIUS_CIRCLE, RADIUS_CIRCLE);

	}

	private void zeichneEins(Graphics2D g) {
		g.fillOval(mitteX, mitteY, RADIUS_CIRCLE, RADIUS_CIRCLE);

	}

	public int getWert() {
		return wert;
	}

	public void setWert(int wert) {
		this.wert = wert;
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
