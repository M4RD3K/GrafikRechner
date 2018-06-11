package Grafikrechner;

import java.text.DecimalFormat;

import javax.swing.SwingUtilities;;
public class Startklasse {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				Steuerung s = new Steuerung();
				
			}
		});
		
				
	}
	
	
}
