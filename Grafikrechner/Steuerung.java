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
	Skalierung skalierung;
	public Steuerung() {
	
		dieGui = new Gui(this);
		dieGui.setVisible(true);
		dieDaten = new Daten();
		
		skalierung = new Skalierung();
		
		dieGui.unserMenu.jmiAnleitung.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dieAnleitung = new Anleitung();
			}
		});
		
		dieGui.funktionsMenuPanel.jbBerechne.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				zerlegeInProdukte();
				dieGui.funktionsMenuPanel.jlYwert1.setText("Y: "+berechneYWert(getEingegebenerXwert()));
				
				
			}
		});
		dieGui.dasAusgabefeld.jbZeichneFunktion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				zerlegeInProdukte();
				dieGui.repaint();
				
			}
		});
		
		dieGui.unserMenu.jmiSkalierungEinstellen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				skalierung.setVisible(true);
				
				
				if (skalierung != null) {
					
					skalierung.jButtonEinstellen.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
							dieGui.dasSchaubild.setxMin(Double.parseDouble(skalierung.jtXmin.getText()));
							dieGui.dasSchaubild.setxMax(Double.parseDouble(skalierung.jtXmax.getText()));
							dieGui.dasSchaubild.setyMin(Double.parseDouble(skalierung.jtYmin.getText()));
							dieGui.dasSchaubild.setyMax(Double.parseDouble(skalierung.jtYmax.getText()));
							
						}
					});
					
				}
				
				
			}
		});
	}
	
    public ArrayList<String> zerlegeFunktionsgleichungFuenf(String funktionsgleichung){
		
		int index = 0;
		ArrayList<String> liste = new ArrayList<String>();
		String s1 = funktionsgleichung;
		char[] tabelle = s1.toCharArray();
		
		for (int i = 1; i < tabelle.length; i++) {
			
			if ((tabelle[i] == '+') || (tabelle[i] == '-') ) {
	     		liste.add(s1.substring(0, i));
	     	break;	    		
			}	
		}
		
		index = liste.get(0).length();
		s1 = s1.substring(index);
		tabelle = s1.toCharArray();
				
		for (int j = 1; j < tabelle.length; j++) {

			if (tabelle[j] == '-' || (tabelle[j] == '+') ) {
				liste.add(s1.substring(0,j));			
				break;
			}		
		}
			
		index = liste.get(1).length();
		s1 = s1.substring(index);
		tabelle = s1.toCharArray();
		
		for (int j = 1; j < tabelle.length; j++) {
			if (tabelle[j] == '-' || (tabelle[j] == '+') ) {
				liste.add(s1.substring(0,j));			
				break;
			}		
		}
	
		index = liste.get(2).length();
		s1 = s1.substring(index);
		tabelle = s1.toCharArray();
		
		for (int j = 1; j < tabelle.length; j++) {
			if (tabelle[j] == '-' || (tabelle[j] == '+') ) {
				liste.add(s1.substring(0,j));			
				break;
			}		
		}
			
		index = liste.get(3).length();
		s1 = s1.substring(index);
		tabelle = s1.toCharArray();
		
		liste.add(s1);
		return liste;	
	}

	public ArrayList<String> zerlegeFunktionsgleichungVier(String funktionsgleichung){
		
		int index = 0;
		ArrayList<String> liste = new ArrayList<String>();
		String s1 = funktionsgleichung;
		char[] tabelle = s1.toCharArray();
		for (int i = 1; i < tabelle.length; i++) {	
			if ((tabelle[i] == '+') || (tabelle[i] == '-') ) {
	     		liste.add(s1.substring(0, i));
	     	break;	 		
			}	
		}
		
		index = liste.get(0).length();
		s1 = s1.substring(index);
		tabelle = s1.toCharArray();
				
		for (int j = 1; j < tabelle.length; j++) {
			if (tabelle[j] == '-' || (tabelle[j] == '+') ) {
				liste.add(s1.substring(0,j));		
				break;
			}	
		}
		
		index = liste.get(1).length();
		s1 = s1.substring(index);
		tabelle = s1.toCharArray();
		
		for (int j = 1; j < tabelle.length; j++) {
			if (tabelle[j] == '-' || (tabelle[j] == '+') ) {
				liste.add(s1.substring(0,j));		
				break;
			}		
		}	
		
		index = liste.get(2).length();
		s1 = s1.substring(index);
		tabelle = s1.toCharArray();
		liste.add(s1);
		
		return liste;	
	}
	
	public ArrayList<String> zerlegeFunktionsgleichungDrei(String funktionsgleichung){
		
		int index = 0;	
		ArrayList<String> liste = new ArrayList<String>();
		String s1 = funktionsgleichung;
		char[] tabelle = s1.toCharArray();
		
		for (int i = 1; i < tabelle.length; i++) {		
			if ((tabelle[i] == '+') || (tabelle[i] == '-') ) {
	     		liste.add(s1.substring(0, i));
	     	break;	   		
			}	
		}
		
		index = liste.get(0).length();
		s1 = s1.substring(index);
		tabelle = s1.toCharArray();
				
		for (int j = 1; j < tabelle.length; j++) {
			if (tabelle[j] == '-' || (tabelle[j] == '+') ) {
				liste.add(s1.substring(0,j));			
				break;
			}		
		}
			
		index = liste.get(1).length();
		s1 = s1.substring(index);
		tabelle = s1.toCharArray();		
		liste.add(s1);
		return liste;		
	}
	
	public ArrayList<String> zerlegeFunktionsgleichungZwei(String funktionsgleichung){
		
		int index = 0;	
		ArrayList<String> liste = new ArrayList<String>();
		String s1 = funktionsgleichung;
		char[] tabelle = s1.toCharArray();
		
		for (int i = 1; i < tabelle.length; i++) {
			
			if ((tabelle[i] == '+') || (tabelle[i] == '-') ) {
	     		liste.add(s1.substring(0, i));
	     	break;	     		
			}	
		}		
		index = liste.get(0).length();
		s1 = s1.substring(index);
		tabelle = s1.toCharArray();	
		liste.add(s1);
		return liste;		
	}
	
	public ArrayList<String> zerlegeFunktionsgleichungEins(String funktionsgleichung){
		
		ArrayList<String> liste = new ArrayList<String>();
		String s1 = funktionsgleichung;					
		liste.add(s1);
		return liste;	
		
	}
    
	public void zerlegeInProdukte() {
		
		String s1 = dieGui.funktionsMenuPanel.jtfFunktion1.getText().toString();
		char[] liste = s1.toCharArray();
		
		int zähler = 1;
		
		for (int i = 1; i < liste.length; i++) {
			if ((liste[i] == '+') || (liste[i] == '-') ) {
				zähler++;
			}
		}		
	
		if (zähler == 1) { 		
			dieDaten.speichereAkutelleProdukte(this.zerlegeFunktionsgleichungEins(getFunktionsgleichungAusGui()));	
		}	
		if (zähler == 2) {		 
			dieDaten.speichereAkutelleProdukte(this.zerlegeFunktionsgleichungZwei(getFunktionsgleichungAusGui()));
		}		
		if (zähler == 3) {		 
			dieDaten.speichereAkutelleProdukte(this.zerlegeFunktionsgleichungDrei(getFunktionsgleichungAusGui()));
		}	
		if (zähler == 4) {	 
			dieDaten.speichereAkutelleProdukte(this.zerlegeFunktionsgleichungVier(getFunktionsgleichungAusGui()));
		}
		if (zähler == 5) {			 
			dieDaten.speichereAkutelleProdukte(this.zerlegeFunktionsgleichungFuenf(getFunktionsgleichungAusGui()));	
		}
		
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

}