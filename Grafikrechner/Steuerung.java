package Grafikrechner;

import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.security.auth.DestroyFailedException;
import javax.security.auth.kerberos.KerberosKey;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.plaf.synth.SynthSpinnerUI;

public class Steuerung {

	//Assosationen deklarieren
	Gui dieGui;
	Daten dieDaten;
	Anleitung dieAnleitung;
	Skalierung dieSkalierung;
	DecimalFormat format;
	
	//Konstruktor 
	public Steuerung() {
	
		dieSkalierung = new Skalierung();
		dieGui = new Gui(this);
		dieGui.setVisible(true);
		dieDaten = new Daten();
		
		
		//Objekt um das Format der Double Werte anzupassen
		format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
	
		//Actionlistner der Buttons 
		dieGui.dasAusgabefeld.jbAbleiten.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				bestimeAbleitung();
			}
		});
		
		dieGui.unserMenu.jmiAnleitung.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dieAnleitung = new Anleitung();
			}
		});
		
		
		dieGui.funktionsMenuPanel.jtfXwert1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				funktionsgleichungZerlegen(getFunktionsgleichungAusGui());
				ausgabeXYwert();
				
			}
		});
		
		dieGui.funktionsMenuPanel.jtfFunktion1.addActionListener(new ActionListener() {
			
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
			
				gebeTextSkalierung();
				
			}
		});
		
		dieSkalierung.jButtonStandart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				setzeStandartSkalierung();
							
			}
		});		
	}
	

	
	
	public void funktionsgleichungZerlegen(String gleichung) {
		
		int anzahlProdukte = 0;

		ArrayList<Integer> indexe;
		ArrayList<String>  zerlegeStrings;
		
		zerlegeStrings = new ArrayList<>();
		indexe         = new ArrayList<>();
		
		char dieZeichen[] = gleichung.toCharArray();
		
		for (int i = 0; i < dieZeichen.length; i++) {
			if (dieZeichen[i] == '+' || dieZeichen[i] == '-' ) {
				
				anzahlProdukte++;
				indexe.add(i);
			}
		}
		
		int alterindex = 0;
			
		for (int i = 0; i < anzahlProdukte; i++) {
		
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
		
		ArrayList<String> dieProdukte = new ArrayList<>();
		dieProdukte = dieDaten.zerlegteProdukte;
		double ywert = 0.0;
		
		for (int i = 0; i < dieProdukte.size(); i++) {
				
			try {
				
				double konstante = bestimmeKonstanteDesProdukts(dieDaten.zerlegteProdukte.get(i));
				ywert = ywert+konstante;
				
			} catch (Exception e) {
				
			double exponent;
			double konstante;
			String skonstante;
			String shochzahl;
			String produkt   = dieProdukte.get(i);
			char[] charList  =  produkt.toCharArray();
					
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

		
		
		int index =1;
		double dkonstante = 0.0;
		double nenner;
		double zähler;
		
		if(skonstante.contains("/")) {
			
			char[] list = skonstante.toCharArray();
			
			for (int i = 0; i < list.length; i++) {
				
				if (list[i] == '/') {
					
					index = i;
					
				}
			}
			
			nenner = Double.parseDouble(skonstante.substring(0,index));
			zähler = Double.parseDouble(skonstante.substring(index+1,skonstante.length()));
			
			dkonstante = zähler/nenner;
			return dkonstante;
			
		}
		
		if (skonstante.equals("")) {
			return 1;
		} else if (skonstante.equals("-")) {
			return -1;
		} else if (skonstante.equals("+")) {
			return 1;
		}
		else  {
			if (Double.parseDouble(skonstante) == 0) {
				return 0;
			} else {
				dkonstante = Double.parseDouble(skonstante);	
			}
		}
		System.out.println(dkonstante);
		
		return dkonstante;
		
	} 
	
	public double berechneProduktZahlenWert(double x,double hochzahl,double konstante) {
	
	double ywert;
    if (konstante == 0.0) {
    	
     ywert = 0;
     
	} else {

	    ywert = konstante*Math.pow(x, hochzahl);
	    
	}   return ywert; 
     
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
	
	public void bestimeAbleitung() {
	    
		funktionsgleichungZerlegen(getFunktionsgleichungAusGui());
		
		ArrayList<String> abgeleitereProdukte = new ArrayList<>();
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList = dieDaten.zerlegteProdukte;
		
		for (int i = 0; i < arrayList.size(); i++) {
			
			
			try {
				
				double konstante = bestimmeKonstanteDesProdukts(dieDaten.zerlegteProdukte.get(i));
				
			} catch (Exception e) {
			
			double exponent,konstante;
			double neuExponent,neuKonstante;
			String skonstante,shochzahl,ableitung;
			String produkt = arrayList.get(i);
			char[] charList =  produkt.toCharArray();
					
			for (int j = 0; j < charList.length; j++) {
			
				 if (charList[j] =='x') {
					 String ableitungProdukt = "";
					 skonstante = produkt.substring(0, j);
					 shochzahl = produkt.substring(j,produkt.length());	 
					 konstante = bestimmeKonstanteDesProdukts(skonstante);
	                 exponent = bestimmeExponent(shochzahl);
	                 
	                 neuKonstante = konstante*exponent;
	                 neuExponent = exponent-1;       
	     	        
	                 ableitungProdukt = format.format(neuKonstante)+"x^"+format.format(neuExponent);
	                 
	                 if (neuKonstante == 1 ) {
	                	 
	                	 ableitungProdukt = "x^"+format.format(neuExponent);
	 	        
					}if (neuExponent == 1) {
						
					ableitungProdukt = format.format(neuKonstante)+"x";
						
					} if (neuExponent == 1 && neuKonstante == 1) {
				    
					 ableitungProdukt ="+x"; }
					
					 if (neuExponent == 0 && neuKonstante == 1) {
						    
					 ableitungProdukt ="1"; }
					 if(neuExponent == 0 && neuKonstante>=0) {
						 
						 ableitungProdukt = "+"+format.format(neuKonstante);
						 
					 }	 if(neuExponent == 0 && neuKonstante<0) {
						 
						 ableitungProdukt = format.format(neuKonstante);
						 
					 }				
					 abgeleitereProdukte.add(ableitungProdukt);
					
				      
				    } 

				}	
			
			}
			
		}
		
	    String ableitung = String.join("", abgeleitereProdukte);
	    
	    if (ableitung.startsWith("+")) {
			ableitung = ableitung.substring(1,ableitung.length());
		}
	    
		dieGui.dasAusgabefeld.jlAbleitung.setText("f'(x) = "+ableitung);
	}
	
	public void gebeTextSkalierung() {
		
		dieGui.dasSchaubild.setxMin(Double.parseDouble(dieSkalierung.jtXmin.getText()));
		dieGui.dasSchaubild.setxMax(Double.parseDouble(dieSkalierung.jtXmax.getText()));
		dieGui.dasSchaubild.setyMin(Double.parseDouble(dieSkalierung.jtYmin.getText()));
		dieGui.dasSchaubild.setyMax(Double.parseDouble(dieSkalierung.jtYmax.getText()));
		dieGui.repaint();
			
	}
	
	public void setzeStandartSkalierung() {
		
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
	
	
	
	
}