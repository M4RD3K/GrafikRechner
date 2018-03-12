package Grafikrechner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Steuerung {

	Gui dieGui;
	
	
	
	public Steuerung() {
		
		dieGui = new Gui(this);
		dieGui.setVisible(true);
	
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
		
		System.out.println("Faktoren:");
		
		for (int i = 0; i < 4; i++) {
			
			System.out.println(liste.get(i));
			
		}
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
		
		System.out.println("Faktoren:");
		
		for (int i = 0; i < 4; i++) {
			
			System.out.println(liste.get(i));
			
		}
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
		
		System.out.println("Faktoren:");
		
		for (int i = 0; i < 3; i++) {
			
			System.out.println(liste.get(i));
			
		}
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
		
		System.out.println("Faktoren:");
		
		for (int i = 0; i < 2; i++) {
			
			System.out.println(liste.get(i));
			
		}
		return liste;
		
		
		
	}
	public ArrayList<String> zerlegeFunktionsgleichungEins(String funktionsgleichung){
		
		int index = 0;
		
		ArrayList<String> liste = new ArrayList<String>();
		String s1 = funktionsgleichung;
		char[] tabelle = s1.toCharArray();						
		
		liste.add(s1);
		
		System.out.println("Faktoren:");
		
		for (int i = 0; i < 1; i++) {
			
			System.out.println(liste.get(i));
			
		}
		return liste;
		
		
		
	}

	public boolean ueberpruefeFunktion(String Funktionsgleichung) {
		
		return true;
	}
	
	public List<String> zFG(String funktionsgleichung){
		
		List<String> liste = new ArrayList<String>();
		String s1 = funktionsgleichung;
		char[] tabelle = s1.toCharArray();
		int anzahlElemente = 1;
		
		String[] liste2 = s1.split( Pattern.quote( "+" ) );
			
			
		liste = (List<String>) Arrays.asList(liste2);
		
		
		
		
		return liste;
	}
}
