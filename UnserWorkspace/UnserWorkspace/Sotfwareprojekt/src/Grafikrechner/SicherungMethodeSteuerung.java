package Grafikrechner;

import java.util.ArrayList;

public class SicherungMethodeSteuerung {

	
	
public ArrayList<String> zerlegeFunktionsgleichung(String funktionsgleichung, int test){
		
		int index = 0;
		System.out.println(test);
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
			
			System.out.println(liste.get(index));
			
		}
		return liste;
		
		
		
	}
}
