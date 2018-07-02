package Grafikrechner;

import java.util.ArrayList;

/**
 * Die Datenklasse wird dazu verwendet um Daten die fuer eine Berechnung anfallen, kurzzeitig zu speichern. 
 */
public class Daten {

   ArrayList<String> zerlegteProdukte; 
   ArrayList<String> zerlegteProdukteAbleitung;
   double x = 0; 
   public Daten() {
	   	   
	   zerlegteProdukte = new ArrayList<>();
	   zerlegteProdukteAbleitung = new ArrayList<>();
   }	
	
   public void speichereAkutelleProdukte(ArrayList<String> dieListe) {
	   
	   zerlegteProdukte = dieListe;	   
	   
   }
   
}
