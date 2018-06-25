package Grafikrechner;

import java.util.ArrayList;

public class Daten {

   ArrayList<String> zerlegteProdukte;
   ArrayList<String> zerlegteProdukteAbleitung;

   public Daten() {
	   	   
	   zerlegteProdukte = new ArrayList<>();
	   zerlegteProdukteAbleitung = new ArrayList<>();
	   
   }	
	
   public void speichereAkutelleProdukte(ArrayList<String> dieListe) {
	   
	   zerlegteProdukte = dieListe;	   
	   
   }
   
}
