package Grafikrechner;

import java.util.ArrayList;

/**
 * Die Datenlasse wird dazu verwendet um Daten die anfallen fuer eine Berechnung kurzzeitig zu speichern. 
 */

public class Daten {

   ArrayList<String> zerlegteProdukte; 

   public Daten() {
	   	   
	   zerlegteProdukte = new ArrayList<>();
	   
   }	
	
   public void speichereAkutelleProdukte(ArrayList<String> dieListe) {
	   
	   zerlegteProdukte = dieListe;	   
	   
   }
   
}
