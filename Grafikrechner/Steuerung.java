package Grafikrechner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.security.auth.DestroyFailedException;
import javax.swing.plaf.synth.SynthSpinnerUI;

public class Steuerung {

	Gui dieGui;
	Daten dieDaten;
	Anleitung dieAnleitung;
	Skalierung dieSkalierung;
	public Steuerung() {
	
		dieSkalierung = new Skalierung();
		dieGui = new Gui(this);
		dieGui.setVisible(true);
		dieDaten = new Daten();
		
		dieGui.unserMenu.jmiAnleitung.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dieAnleitung = new Anleitung();
			}
		});
		
		dieGui.funktionsMenuPanel.jbBerechne.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				funktionsgleichungZerlegen(getFunktionsgleichungAusGui());
				ausgabeXYwert();
				
			}
		});
		dieGui.dasAusgabefeld.jbZeichneFunktion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				funktionsgleichungZerlegen(getFunktionsgleichungAusGui());
				dieGui.repaint();
				
			}
		});
		
		dieGui.unserMenu.jmiSkalierungEinstellen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dieSkalierung.setVisible(true);
					
			}
			
			
	
			
		});
		
		dieSkalierung.jButtonEinstellen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				dieGui.dasSchaubild.setxMin(Double.parseDouble(dieSkalierung.jtXmin.getText()));
				dieGui.dasSchaubild.setxMax(Double.parseDouble(dieSkalierung.jtXmax.getText()));
				dieGui.dasSchaubild.setyMin(Double.parseDouble(dieSkalierung.jtYmin.getText()));
				dieGui.dasSchaubild.setyMax(Double.parseDouble(dieSkalierung.jtYmax.getText()));
				dieGui.repaint();
				
			}
		});
		
		dieSkalierung.jButtonStandart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dieGui.dasSchaubild.setxMin(-10);
				dieGui.dasSchaubild.setxMax(10);
				dieGui.dasSchaubild.setyMin(-10);
				dieGui.dasSchaubild.setyMax(10);
				dieGui.repaint();
				
				dieSkalierung.jtXmin.setText("-10");
				dieSkalierung.jtXmax.setText("10");
				dieSkalierung.jtYmin.setText("-10");
				dieSkalierung.jtYmax.setText("10");
				
				
			}
		});		
	}
	

	
	
	public void funktionsgleichungZerlegen(String gleichung) {
		
		int anzahlRechenzeichen = 0;
		
		ArrayList<Integer> indexe;
		ArrayList<String> zerlegeStrings;
		zerlegeStrings = new ArrayList<>();
		indexe = new ArrayList<>();
		
		char dieZiffern[] = gleichung.toCharArray();
		
		for (int i = 0; i < dieZiffern.length; i++) {
			if (dieZiffern[i] == '+' || dieZiffern[i] == '-' ) {
				anzahlRechenzeichen++;
				indexe.add(i);
			}
		}
		
		int alterindex = 0;
			
		for (int i = 0; i < anzahlRechenzeichen; i++) {
		
			String produkt = gleichung.substring(alterindex,indexe.get(i));
			alterindex = indexe.get(i);
			zerlegeStrings.add(produkt);
			
		}
		
		String letztesProdukt = gleichung.substring(alterindex);
		zerlegeStrings.add(letztesProdukt);
		
		dieDaten.zerlegteProdukte = zerlegeStrings;
		
	}
	
	
	public String getFunktionsgleichungAusGui() {
		
		String s = dieGui.funktionsMenuPanel.jtfFunktion1.getText();
		return s;
		
	}
	
	public double berechneYWert(double x) {
		
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList = dieDaten.zerlegteProdukte;
		double ywert = 0.0;
		
		for (int i = 0; i < arrayList.size(); i++) {
			
			
			try {
				
				double konstante = bestimmeKonstanteDesProdukts(dieDaten.zerlegteProdukte.get(i));
				ywert = ywert+konstante;
				
			} catch (Exception e) {
				
			double exponent,konstante;
			String skonstante,shochzahl;
			String produkt = arrayList.get(i);
			char[] charList =  produkt.toCharArray();
					
			for (int j = 0; j < charList.length; j++) {
			
				 if (charList[j] =='x') {
					
					 skonstante = produkt.substring(0, j);
					 shochzahl = produkt.substring(j,produkt.length());	 
					 konstante = bestimmeKonstanteDesProdukts(skonstante);
	                 exponent = bestimmeExponent(shochzahl);
					 ywert = ywert + (berechneProduktZahlenWert(x,exponent, konstante));		  
				} 		 			 
				}	
			}
			}
		return ywert;
		}

	  public double bestimmeExponent(String exponent) {
		  
		  double dExponent;
		  
		  if (exponent.contains("^")){
			
		  char arrey[] = exponent.toCharArray();
          char hochzahl = arrey[arrey.length-1];
		  String sExponent = Character.toString(hochzahl) ;	
		  dExponent = Double.parseDouble(sExponent);
		  return dExponent;
		  
		} 
		 
		 dExponent = 1.0;
		 return dExponent;	  
	  }
	  
	public double bestimmeKonstanteDesProdukts(String skonstante) {
		
		double dkonstante = 0.0;
		if (skonstante.equals("")) {
		} else if (skonstante.equals("-")) {
			return -1;
		} else if (skonstante.equals("+")) {
			return 1;
		}
		else  {
			dkonstante = Double.parseDouble(skonstante);
		}
		return dkonstante;
		
	} 
	
	public double berechneProduktZahlenWert(double x,double hochzahl,double konstante) {
	
	double ywert; 	
    if (konstante == 0.0) {
     ywert = Math.pow(x, hochzahl);
	} else {
	ywert = konstante*Math.pow(x, hochzahl);
	}	
    return ywert; 
    }
	
	public double getEingegebenerXwert() {
		
		try {
		String svariable = dieGui.funktionsMenuPanel.jtfXwert1.getText().toString();
		double variable = Double.parseDouble(svariable);
		return variable;
			
		} catch (Exception e) {
		  return 0;
		}
		
	}
	
	public void ausgabeXYwert() {
		
		dieGui.funktionsMenuPanel.jlYwert1.setText("Y-Wert: "+berechneYWert(getEingegebenerXwert()));
	}

}