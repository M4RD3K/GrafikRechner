package Grafikrechner;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
/**
 * Diese Klasse zeichnet das Koordinatensystem und die Funktion.
 */
public class Schaubild extends JPanel {

	private double xMin = -10;
	private double xMax = 10;
	private double yMin = -10;
	private double yMax = 10;
	private double xSkalierung;
	private double ySkalierung;
	private double xAnteil;
	private double yAnteil;
	private int breite;
	private int hoehe ;
	private int xPunkte[];
	private int yPunkte[];
	private double xWerte[];
	private double yWerte[];
	private String zahl;
	BufferedImage img = null;
	Gui dieGui;
	
	public double getxMin() {
		return xMin;
	}
	public void setxMin(double xMin) {
		this.xMin = xMin;
	}
	public double getxMax() {
		return xMax;
	}
	public void setxMax(double xMax) {
		this.xMax = xMax;
	}
	public double getyMin() {
		return yMin;
	}
	public void setyMin(double yMin) {
		this.yMin = yMin;
	}
	public double getyMax() {
		return yMax;
	}
	public void setyMax(double yMax) {
		this.yMax = yMax;
	}
	public Schaubild(Gui derGui) {
		  dieGui = derGui;
		  this.setBackground(Color.WHITE);
		  
		}
	/**
	 * Zeichnet Koordinatensystem und die Funktion
	 */
	@Override
	protected void paintComponent(Graphics arg0) {
		
		Graphics2D g = (Graphics2D) arg0;
		
		super.paintComponent(g);
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/GCN5ybe.jpg"));
		} catch (Exception e) {
			
		}
		
		xPunkte = new int[this.getWidth()];
		yPunkte = new int[xPunkte.length];
		xWerte = new double[xPunkte.length];
		yWerte = new double[xWerte.length];
		xSkalierung = this.getWidth()/(xMax-xMin);
		ySkalierung = this.getHeight()/(yMax-yMin);
		xAnteil = (xMax-xMin)/this.getWidth();
		yAnteil = (yMax-yMin)/this.getHeight();
		
		for (int i = 0; i < xPunkte.length; i++) {
			xPunkte[i]=i;
		}
		for (int i = 0; i < xWerte.length; i++) {
			xWerte[i]=xMin+i*xAnteil;
		}
		for (int i = 0; i < yWerte.length; i++) {
			yWerte[i]= dieGui.s.berechneYWert(xWerte[i]);
		}
		for (int i = 0; i < yPunkte.length; i++) {
			
				yPunkte[i]=(int)((this.getHeight()/((yMax-yMin)/yMax)-(yWerte[i])/yAnteil));
			
		}
		
		g.setColor(new Color(239, 238, 238));
		for (int i = 0; i < xMax-xMin; i++) {
			if(i+xMin==0) {
				g.setColor(new Color(0, 0, 0));				
				g.drawLine((int)(i*xSkalierung),0, (int)(i*xSkalierung), this.getHeight());
				g.setColor(new Color(239, 238, 238));
			}else {	g.drawLine((int)(i*xSkalierung),0, (int)(i*xSkalierung), this.getHeight());
			}			
		}
		
		for (int i = 0; i < yMax-yMin; i++) {
			if(i-yMax==0) {
				g.setColor(new Color(0, 0, 0));
				g.drawLine(0,(int)(i*ySkalierung), this.getWidth(), (int)(i*ySkalierung));
				g.setColor(new Color(239, 238, 238));
			}else {
			g.drawLine(0,(int)(i*ySkalierung), this.getWidth(), (int)(i*ySkalierung));
			}
		}
		for (int i = 0; i < yMax-yMin; i++) {
			
			g.setColor(new Color(0, 0, 0));
			g.drawLine((int)(-xMin*xSkalierung-10),(int)(i*ySkalierung), (int)(-xMin*xSkalierung), (int)(i*ySkalierung));
			if(yMax-i==0) {}else {
			g.drawString(""+(int)(yMax-i),(int)(-xMin*xSkalierung+5) ,(int)(i*ySkalierung+5) );
			}
			
		}
		for (int i = 0; i < xMax-xMin; i++) {
			
			g.setColor(new Color(0, 0, 0));
			g.drawLine((int)(i*xSkalierung),(int)(yMax*ySkalierung), (int)(i*xSkalierung),(int)(yMax*ySkalierung+10)) ;
			if(xMin+i==0) {}else {
				g.drawString(""+(int)(xMin+i),(int)(i*xSkalierung-3) , (int)(yMax*ySkalierung-5));
				}
		}
		g.setColor(new Color(65, 105, 225));
		if(dieGui.funktionsMenuPanel.jtfFunktion1.getText().equals("")) {
			g.setColor(new Color(0, 0, 0));
			
		}
		g.drawPolyline(xPunkte, yPunkte, xWerte.length);
		if(dieGui.funktionsMenuPanel.jtfFunktion1.getText().contains("a")||dieGui.funktionsMenuPanel.jtfFunktion1.getText().contains("z")||dieGui.funktionsMenuPanel.jtfFunktion1.getText().contains("z")||dieGui.funktionsMenuPanel.jtfFunktion1.getText().contains("q")||dieGui.funktionsMenuPanel.jtfFunktion1.getText().contains("w")||dieGui.funktionsMenuPanel.jtfFunktion1.getText().contains("r")||dieGui.funktionsMenuPanel.jtfFunktion1.getText().contains("t")||dieGui.funktionsMenuPanel.jtfFunktion1.getText().contains("u")||dieGui.funktionsMenuPanel.jtfFunktion1.getText().contains("p")||dieGui.funktionsMenuPanel.jtfFunktion1.getText().contains("�")||dieGui.funktionsMenuPanel.jtfFunktion1.getText().contains("�")||dieGui.funktionsMenuPanel.jtfFunktion1.getText().contains("�")) {
			g.setColor(new Color(0,0,0));
			g.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);
			//g.drawString("Fehler", 50, 50);
		}
		if(dieGui.funktionsMenuPanel.jtfFunktion1.getText().contains("eclipse")) {
			g.setColor(Color.RED);
			g.drawImage(img, 0,0,null);
		}
	}

}