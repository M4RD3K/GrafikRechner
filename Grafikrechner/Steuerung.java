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
		dieGui.dasAusgabefeld.jbNullstellen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				findeNullstelle(0);
				
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
		
		dieGui.funktionsMenuPanel.jbZeichne.addActionListener(new ActionListener() {
			
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
	

	
public void funktionsgleichungAbleitungZerlegen(String gleichung) {
		
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
		
		dieDaten.zerlegteProdukteAbleitung = zerlegeStrings;
		
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
					System.out.println(konstante);
					if (konstante == 1) {
						
						ywert = ywert+0;
						
					} else {
						
						ywert = ywert + konstante;
					}
				

				} catch (Exception e) {

					double trigomemetrie = 0;
					double exponent;
					double konstante;
					String skonstante;
					String shochzahl;
					String produkt = dieProdukte.get(i);
					char[] charList = produkt.toCharArray();
					
					
                   if (produkt.contains("sin(x)")) {
						
						for (int j = 0; j < charList.length; j++) {
							
							if (charList[j] == 's') {
								
								skonstante = produkt.substring(0,j);
								konstante = bestimmeKonstanteDesProdukts(skonstante);
								trigomemetrie = konstante*Math.sin(x);
								ywert =  ywert + trigomemetrie;
							} 									
						}
						
					} else if (produkt.contains("cos(x)")) {
						
                         for (int j = 0; j < charList.length; j++) {
							
							if (charList[j] == 'c') {
								
								skonstante = produkt.substring(0,j);
								konstante = bestimmeKonstanteDesProdukts(skonstante);
								trigomemetrie = konstante*Math.cos(x);
								ywert = ywert +trigomemetrie;
							} 	

                         }		
							
					} else if (produkt.contains("x")) {

						for (int j = 0; j < charList.length; j++) {

							if (charList[j] == 'x') {

								skonstante = produkt.substring(0, j);
								shochzahl = produkt.substring(j, produkt.length());
								konstante = bestimmeKonstanteDesProdukts(skonstante);
								exponent = bestimmeExponent(shochzahl);
								ywert = ywert + (berechneProduktZahlenWert(x, exponent, konstante));

							} 
						}

					} else if (produkt.contains("^")) {

						for (int k = 0; k < charList.length; k++) {

							if (charList[k] == '^') {

								skonstante = produkt.substring(0, k);
								konstante = bestimmeKonstanteDesProdukts(skonstante);
								exponent = bestimmeExponent(produkt);
								ywert = ywert + Math.pow(konstante, exponent);

							}
						}

					} 
				} 
  }
		
	   return ywert;
		
    }

	  public double bestimmeExponent(String exponent) {
		  
		  double dExponent;
		  
		  
		  if (exponent.contains("^")){
			
		    char[] liste = exponent.toCharArray();
		    
		    int index = 0;
		    
		    for (int i = 0; i < liste.length; i++) {
				
		    	   if (liste[i] == '^') {
					
		    		   index = i;
		    		   
				}
		    	   
			}
			
		    exponent = exponent.substring(index+1,exponent.length());
		    dExponent = Double.parseDouble(exponent);
		    return dExponent;
		} 
		 
		 dExponent = 1.0;
		 return dExponent;	  
	  }
	  
	  public void findeNullstelle(double x) {
		  int iterationen= 1000000;
		  double xneu=0;
		  double xalt= x;
		  for(int i=0;i<=iterationen;i++) {
			  xneu = xalt-(berechneYWert(xalt/berechneYWertAbleitung(xalt)));
			  xalt = xneu;
		  }
		  dieGui.dasAusgabefeld.jlNullstelle.setText("Nullstelle: ("+xneu+"/"+berechneYWert(xneu)+")");
	  }
	  
	  
	  
	  public double berechneYWertAbleitung(double x) {
			
			ArrayList<String> dieProdukte = new ArrayList<>();
			dieProdukte = dieDaten.zerlegteProdukteAbleitung;
			double ywert = 0.0;
			
			for (int i = 0; i < dieProdukte.size(); i++) {
			
					try {

						double konstante = bestimmeKonstanteDesProdukts(dieDaten.zerlegteProdukteAbleitung.get(i));
						System.out.println(konstante);
						if (konstante == 1) {
							
							ywert = ywert+0;
							
						} else {
							
							ywert = ywert + konstante;
						}
					

					} catch (Exception e) {

						double trigomemetrie = 0;
						double exponent;
						double konstante;
						String skonstante;
						String shochzahl;
						String produkt = dieProdukte.get(i);
						char[] charList = produkt.toCharArray();
						
						
	                   if (produkt.contains("sin(x)")) {
							
							for (int j = 0; j < charList.length; j++) {
								
								if (charList[j] == 's') {
									
									skonstante = produkt.substring(0,j);
									konstante = bestimmeKonstanteDesProdukts(skonstante);
									trigomemetrie = konstante*Math.sin(x);
									ywert =  ywert + trigomemetrie;
								} 									
							}
							
						} else if (produkt.contains("cos(x)")) {
							
	                         for (int j = 0; j < charList.length; j++) {
								
								if (charList[j] == 'c') {
									
									skonstante = produkt.substring(0,j);
									konstante = bestimmeKonstanteDesProdukts(skonstante);
									trigomemetrie = konstante*Math.cos(x);
									ywert = ywert +trigomemetrie;
								} 	

	                         }		
								
						} else if (produkt.contains("x")) {

							for (int j = 0; j < charList.length; j++) {

								if (charList[j] == 'x') {

									skonstante = produkt.substring(0, j);
									shochzahl = produkt.substring(j, produkt.length());
									konstante = bestimmeKonstanteDesProdukts(skonstante);
									exponent = bestimmeExponent(shochzahl);
									ywert = ywert + (berechneProduktZahlenWert(x, exponent, konstante));

								} 
							}

						} else if (produkt.contains("^")) {

							for (int k = 0; k < charList.length; k++) {

								if (charList[k] == '^') {

									skonstante = produkt.substring(0, k);
									konstante = bestimmeKonstanteDesProdukts(skonstante);
									exponent = bestimmeExponent(produkt);
									ywert = ywert + Math.pow(konstante, exponent);

								}
							}

						} 
					} 
	  }
			
		   return ywert;
			
	    }

	  
	public double bestimmeKonstanteDesProdukts(String skonstante) {
		int index =1;
		double dkonstante = 0.0;
		double nenner;
		double zaeler;

		
		if(skonstante.contains("/")) {
			
			char[] list = skonstante.toCharArray();
			
			for (int i = 0; i < list.length; i++) {
				
				if (list[i] == '/') {
					
					index = i;
					
				}
			}
			
			nenner = Double.parseDouble(skonstante.substring(0,index));
			zaeler = Double.parseDouble(skonstante.substring(index+1,skonstante.length()));
			
			dkonstante = nenner/zaeler;
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
			
			String abgeleiteteTrigometire = "";
			double exponent,konstante;
			double neuExponent,neuKonstante;
			String skonstante,shochzahl,ableitung;
			String produkt = arrayList.get(i);
			char[] charList =  produkt.toCharArray();
					
			for (int j = 0; j < charList.length; j++) {
				
			
				 if (produkt.contains("sin(x)")) {
					 
				     if (charList[j] == 's') {
						
				    	 skonstante = produkt.substring(0,j);
				    	 konstante = bestimmeKonstanteDesProdukts(skonstante);
				    	 
				    	 abgeleiteteTrigometire = format.format(konstante)+"cos(x)";
				    	 
				    	 if (konstante > 1 || konstante > 0 && konstante< 1) {
								abgeleiteteTrigometire = "+"+format.format(konstante)+"cos(x)";
							}
				    	 
				    	 if (konstante == 1) {
				    		 
							abgeleiteteTrigometire = "+cos(x)";
						} 
				    	 if (konstante == -1) {
				    		 
								abgeleiteteTrigometire = "-cos(x)";
							} 
				    	 
				          abgeleitereProdukte.add(abgeleiteteTrigometire);
				      }
				    	 
					} else if (produkt.contains("cos(x)")) {
						 
					     if (charList[j] == 'c') {
							
					    	 skonstante = produkt.substring(0,j);
					    	 konstante = bestimmeKonstanteDesProdukts(skonstante);
					    	 konstante = konstante*-1;
					    	 
					    	 abgeleiteteTrigometire = format.format(konstante)+"sin(x)";
					    	 
					    	 if (konstante > 1 || konstante > 0 && konstante< 1) {
									abgeleiteteTrigometire = "+"+format.format(konstante)+"sin(x)";
								}
					    	 
					    	 if (konstante == 1) {
								abgeleiteteTrigometire = "+sin(x)";
								
							}
					    	 
					    	 if (konstante == -1) {
									abgeleiteteTrigometire = "-cos(x)";
									
								}				    
					    	   abgeleitereProdukte.add(abgeleiteteTrigometire); 
						 } 
						
				     		
				} else if (charList[j] =='x') {
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
	    funktionsgleichungAbleitungZerlegen(ableitung);
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
	
  public boolean ueberpruefeFunktion(String funktion){
	  
	  if (funktion.contains(",")) {
		  setzeFehler();
		  return false;	  
	  } 
	  if (funktion == "") {
		  setzeFehler();
		  return false;
	  }
	  if (funktion.contains("^x")) {
		  setzeFehler();
		  return false;
	  }
	   if (funktion.endsWith("-")) {
		  setzeFehler();
		  return false;
	}  if (funktion.contains("x") == false) {
		  setzeFehler();
	      return false;
	}  if (funktion.startsWith("-")) {
		return true;
	}
	 return true; 
  }	
	
  
  public void setzeFehler() {
	  
	  dieGui.funktionsMenuPanel.jtfFunktion1.setText("Fehler");
	  
	  
	  
  }
	
}