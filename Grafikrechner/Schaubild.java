package Grafikrechner;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

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
	@Override
	protected void paintComponent(Graphics arg0) {
		
		Graphics2D g = (Graphics2D) arg0;
		
		super.paintComponent(g);
		
		
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
			
				yPunkte[i]=(int)((this.getHeight()/2-(yWerte[i])/yAnteil));
			
		}
		
		
		
		
		g.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);
		g.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());
		g.setColor(new Color(176, 196, 222));
		for (int i = 0; i < xMax-xMin; i++) {
			
			g.drawLine((int)(i*xSkalierung),0, (int)(i*xSkalierung), this.getHeight());
			if(xMin<0 && xMax>0) {
				if(false) {
					
				}
				
			}
		}
		
		for (int i = 0; i < yMax-yMin; i++) {
			g.drawLine(0,(int)(i*ySkalierung), this.getWidth(), (int)(i*ySkalierung));
		}
		g.setColor(new Color(0, 0, 0));
		g.drawPolyline(xPunkte, yPunkte, xWerte.length);
	}

}
