package Grafikrechner;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Schaubild extends JPanel {

	private double xMin;
	private double xMax;
	private double yMin;
	private double yMax;
	private double xSkalierung;
	private double ySkalierung;
	private int breite;
	private int hoehe ;
	private int xPunkte[];
	private int yPunkte[];
	private int xWerte[];
	private int yWerte[];
	Gui dieGui;
	
	public Schaubild(Gui derGui) {
		  dieGui = derGui;
	      this.setBorder(BorderFactory.createTitledBorder("Schaubild"));
		  this.setBackground(Color.WHITE);
		  
		}
	@Override
	protected void paintComponent(Graphics arg0) {
		
		Graphics2D g = (Graphics2D) arg0;
		
		super.paintComponent(g);
		
		xPunkte = new int[this.getWidth()];
		yPunkte = new int[this.getHeight()];
		xWerte = new int[xPunkte.length];
		yWerte = new int[xWerte.length];
		xMin = -10;
		xMax = 10;
		yMin = -10;
		yMax = 10;
		xSkalierung = this.getWidth()/(xMax-xMin);
		ySkalierung = this.getHeight()/(yMax-yMin);
		
		for (int i = 0; i < xPunkte.length; i++) {
			xPunkte[i]=i;
		}
		for (int i = 0; i < xWerte.length; i++) {
			xWerte[i]=i;
		}
		for (int i = 0; i < yWerte.length; i++) {
			yWerte[i]= (int)(dieGui.s.berechneYWert(i));
		}
		
		g.drawPolyline(xWerte, yWerte, xWerte.length);
		
		g.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);
		g.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());
		for (int i = 0; i < xMax-xMin; i++) {
			g.drawLine((int)(i*xSkalierung), this.getHeight()/2, (int)(i*xSkalierung), this.getHeight()/2+10);
		}
		for (int i = 0; i < yMax-yMin; i++) {
			g.drawLine(this.getWidth()/2,(int)(i*ySkalierung), this.getWidth()/2-10, (int)(i*ySkalierung));
		}	
	}

}
