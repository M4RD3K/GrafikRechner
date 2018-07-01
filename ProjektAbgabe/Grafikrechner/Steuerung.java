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

/**
 * Dies ist die wichtigste Klasse des Programms. 
 * Sie kuemmert sich um die Berechnungen und Zerlegung der Funktionen.
 * Gleichzeitig stellt sie auch die Verbindung mit der Gui her damit diese die Funktion zeichnen kann.  
 *
 * */
public class Steuerung {

	Gui dieGui;
	Daten dieDaten;
	Anleitung dieAnleitung;
	Skalierung dieSkalierung;
	DecimalFormat format;
	
	/**
	 * Im Konstruktur werden die Listener der Buttons gesetzt, welche die jeweilig gewollte Funktion des Buttons ausfuehren.
	 */
	public Steuerung() {
	
		dieSkalierung = new Skalierung();
		dieGui = new Gui(this);
		dieGui.setVisible(true);
		dieDaten = new Daten();
		
		format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
	
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
        dieGui.dasAusgabefeld.jbNullstellen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
		dieDaten.x=Double.parseDouble(dieGui.funktionsMenuPanel.jtfXwert1.getText());
				findeNullstelle(dieDaten.x);
				
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
	
    /**
     *In der Methode funktionsgleichungZerlegen wird die eingegebene Funktion nach den Rechenzeichen 
     *der Addition und Subtraktion zerlegt. Beispielsweise 2x^2-3x wird zerlegt in 2x^2 und -3x.
     *Diese zerlegten Strings werden dann in eine ArrayList gespreichert, die in der Datenklasse uebergeben wird.
     *@param gleichung Dies ist die eingegebene Funktionsgleichung aus der Gui
     */
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
	/**
	 * Macht das gleiche wie funktionsgleichungZerlegen nur das sie die Ableitung verwendet.
	 * @param gleichung Dies ist die Ableitung der eingebenen Funktionsgleichung.
	 */
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
/**
 * Die Methode getFunktionsgeichungAusGui liefert die eingebene Funktionsgleichung.
 * @return Dies ist die eingebene Funktionsgleichung.
 */
	public String getFunktionsgleichungAusGui() {

		String s = dieGui.funktionsMenuPanel.jtfFunktion1.getText();
		
		if (s.contains(",")) {
			setzeFehler();
			return "";	
		}
		
		return s;
			
	}
	
	/**
	 *In der berechneYWert Methode wird der Y-Wert fuer einen bestimmten Zahlenwert berechnet. Dabei ruft die Methode die Daten
	 *der zerlegten Funktionsgleichung ab und berechnet fuer jede Funktion einen Y-Wert. Dieser Y-Wert wird dann mit dem des vorherigen
	 *addidert. Die Methode ist dann komplett durchgelafen sobald der Y-Wert fuer alle Funktionen berechnet wurde. 
	 *@param x Dies ist die Zahl die in die Funktion eingesetzt wird. 
	 *@return Hier wird dann der Y-Wert in Form einer Kommazahl zurueck gegeben. 
	 */
	public double berechneYWert(double x) {
		
		ArrayList<String> dieProdukte = new ArrayList<>();
		dieProdukte = dieDaten.zerlegteProdukte;
		double ywert = 0.0;
		
		for (int i = 0; i < dieProdukte.size(); i++) {
		
				try {

					double konstante = Double.parseDouble(dieProdukte.get(i));
					ywert = ywert+konstante;

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
	
	
   /**
    * In der Methode bestimmeExponent wird bestimmt welcher Funktionsgrad vorliegt. Dabei wird die jeweilige Funktion, nach einem Hochzeichen (^)
    * untersucht und danach anhand der gefundenen Stelle, die Hochzahl bestimmt und als Kommazahl umformatiert.
    * @param exponent Dies enthaelt den String von dem der Exponent bestimmt werden soll. 
    * @return Dies ist der Gefundene Exponent. 
    */
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
	/**
	 * Die Methode findeNullstelle berechnet durch das Newton-Verfahren die Nullstelle und gibt sie auf der Oberflaeche aus.
	 * @param x Ist der Starwert indem die Nullstelle gefunden werden soll.
	 */
	 public void findeNullstelle(double x) {
		  int iterationen= 100000;		  
		  double xalt= x;
		  for(int i=0;i<=iterationen;i++) {
			  xalt = xalt-(berechneYWert(xalt)/berechneYWertAbleitung(xalt));
			  
		  }
		  dieGui.dasAusgabefeld.jlZeigeNullstellen.setText("N("+xalt+"/"+0+")");
	  }
	  
	  /**
	   * Diese Methode berechnet den y-Wert der Ableiteung fuer einen spezifischen X-Wert.
	   * @param x Ist der eingebene x-Wert
	   * @return ywert Dies ist der berechnete y-Wert
	   */
	  public double berechneYWertAbleitung(double x) {
			
			ArrayList<String> dieProdukte = new ArrayList<>();
			dieProdukte = dieDaten.zerlegteProdukteAbleitung;
			double ywert = 0.0;
			
			for (int i = 0; i < dieProdukte.size(); i++) {
			
					try {

						double konstante = bestimmeKonstanteDesProdukts(dieDaten.zerlegteProdukteAbleitung.get(i));
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
	/**
	 * Die Methode bestimmeKonstanteDesProduktes bestimmt die jeweilige Konstante eines einzelnen Produktes. 
	 * Beispielsweise bei 3x^2 ist die Konstante 3. 
	 * @param skonstante Ist der String der die jeweilige Konstante enthaelt. 
	 * @return Hier wird die Konstante zurueck gegeben. 
	 */  
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
	
	/**
	 * Die Methode berechnePrdouktZahlenWert berechnet den jeweiligen Zahlenwert der sich aus einer Funktion ergibt,
	 * wenn man in diese ein bestimmtes X einsetzt. Dabei wird die bestimmte Konstante mit dem jeweiligen X-Wert und seiner Hochzahl multipliziert.
	 * @param x Ist die Zahl die in die Funktion eingesetzt wird 
	 * @param hochzahl Dies ist die vorher bestimmte Hochzahl aus der Methode bestimmeExponetDesProdukes.
	 * @param konstante Dies ist die vorher bestimme Konstante aus der Methode bestimmeKonstanteDesProduktes.
	 * @return Hier wird der berechnete Zahlenwert zurück gegeben. 
	 */
	public double berechneProduktZahlenWert(double x,double hochzahl,double konstante) {
	
	double ywert;
    if (konstante == 0.0) {
    	
     ywert = 0;
     
	} else {

	    ywert = konstante*Math.pow(x, hochzahl);
	    
	}   return ywert; 
     
    }
	
	/**
	 * Die Methode getEingebenerXwert holt aus der Gui den eingebenenen x-Wert.
	 * @return Dies ist der eingebene x-Wert.
	 */
	public double getEingegebenerXwert() {
		
		try {
		String svariable = dieGui.funktionsMenuPanel.jtfXwert1.getText().toString();
		double variable = Double.parseDouble(svariable);
		return variable;
			
		} catch (Exception e) {
		  
			return 0;
		}
		
	}
	/**
	 * Diese Metode setzt das Label dass fuer die Ausgabe des y-Wertes zustaendig ist. 
	 */
	public void ausgabeXYwert() {
		
		dieGui.funktionsMenuPanel.jlYwert1.setText("y-Wert: "+berechneYWert(getEingegebenerXwert()));
	}
	
	/**
	 * Die Methode bestimmeAbleitung ermoeglicht es Funktionen abzuleiten. 
	 * Hierbei wird die zerlegte Funktion aus der Datenklasse verwendet.
	 * Von der zerlegten Funktion werden jeweils die Konstante und der Exponent berechnet und je nach Funktionstyp abgleitet.
	 * Bisher werden nur GRF und Trigromtrische Funktionen in der Normalform unterstuetzt. (ohne ausmultiplzieren etc.)
	 */
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
	
	
	/**
	 * Die Methode gebeTextSkalierung holt den text aus dem Fenster in dem man die Skalierung einstellen kann.
	 */
	public void gebeTextSkalierung() {
		
		dieGui.dasSchaubild.setxMin(Double.parseDouble(dieSkalierung.jtXmin.getText()));
		dieGui.dasSchaubild.setxMax(Double.parseDouble(dieSkalierung.jtXmax.getText()));
		dieGui.dasSchaubild.setyMin(Double.parseDouble(dieSkalierung.jtYmin.getText()));
		dieGui.dasSchaubild.setyMax(Double.parseDouble(dieSkalierung.jtYmax.getText()));
		dieGui.repaint();
			
	}
	/**Die Methode setzeStandartSkalierung setzt den Text in dem Fenster in dem die Skalierung eingesellt wird auf 
	 * den Standart Wert zuruek. 
	 * 
	 */
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
	/**
	 * Die Methode ueberpuefeFunktion ueberprueft die Funktionsgleichung auf Fehler wie beispielsweise ein Komma statt Punkt
	 * oder das verwendet einer falschen Variable. Sie ist zureit jedoch nicht aktiv da sie Probleme bei sin(x) und cos(x) 
	 * verursacht. 
	 * @param funktion Dies ist die Funktionsgleichung.
	 * @return Die Methode gibt true zurueck wenn die Funktion korrekt ist.
	 */
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
    /**
     * Diese Methode setzt im Fehlelerfall den Text "Fehler" in das Feld im dem die Funktion seht.
     */
    public void setzeFehler() {
	  
	  dieGui.funktionsMenuPanel.jtfFunktion1.setText("Fehler");
	  
  }
	
}