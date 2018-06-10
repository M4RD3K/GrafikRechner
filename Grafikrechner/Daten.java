package Grafikrechner;

import java.util.ArrayList;

public class Daten {

   ArrayList<String> zerlegteProdukte; 

   public Daten() {
	   	   
	   zerlegteProdukte = new ArrayList<>();
	   
   }	
	
   public void speichereAkutelleProdukte(ArrayList<String> dieListe) {
	   
	   zerlegteProdukte = dieListe;	   
	   
   }
   
}
