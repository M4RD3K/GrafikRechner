package Grafikrechner;

import java.util.ArrayList;

public class Daten {

	ArrayList<String> zerlegteProdukte; 
	 Double konstante = 0.0;
	 Double hochzahl  = 0.0;
	
	
   public Daten() {
	   
	   
	   zerlegteProdukte = new ArrayList<>();
	  

	   
   }	
	
   
   public void speichereAkutelleProdukte(ArrayList<String> dieListe) {
	   
	   zerlegteProdukte = dieListe;	   
	   
   }


public void setKonstante(Double konstante) {
	this.konstante = konstante;
}


public void setHochzahl(Double hochzahl) {
	this.hochzahl = hochzahl;
}
   
   
   
}
