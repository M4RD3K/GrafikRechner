package Grafikrechner;

import java.util.ArrayList;

public class Daten {

	ArrayList<String> zerlegteProdukte;
	ArrayList<String[]> zerlegteFaktoren;
	 
	
   public Daten() {
	    
	   zerlegteProdukte = new ArrayList<>();
	   zerlegteFaktoren = new ArrayList<String[]>();
	   
   }	
	
   
   public void speichereAkutelleProdukte(ArrayList<String> dieListe) {
	   
	   zerlegteProdukte = dieListe;	   
	   
   }
	
   public void speichereAktuelleFaktoren(ArrayList<String[]> dieListe) {
	   
	   zerlegteFaktoren = dieListe;
	   
   }
}
