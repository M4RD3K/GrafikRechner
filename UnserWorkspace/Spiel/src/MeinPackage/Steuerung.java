package MeinPackage;

public class Steuerung {
	

	Gui dieGui;
	
	Wuerfel  derWürfel[];
	Klappe  dieKlappe[];
	Spieler dieSpieler[];
	
	private int aAugensumme;
	private int aKlappenSumme;
	private int aldxAktiverSpieler;
	private int aMinuspunkte;
	

	
	

	public Steuerung(Gui gui, String pName1, String pName2) {
		
		dieGui = gui;
		
		aAugensumme = 0;
		aKlappenSumme = 0;
		aldxAktiverSpieler = 0;
		aMinuspunkte = 0;
		
		
		derWürfel    = new Wuerfel[2];
		derWürfel[0] = new Wuerfel();
		derWürfel[1] = new Wuerfel();
		
		dieSpieler = new Spieler[2];
		dieSpieler[0] = new Spieler(pName1);
		dieSpieler[1] = new Spieler(pName2);
		
		
		
	
		
		
	}


	public void wuerfeln() {
		
		int zahl1 = derWürfel[0].wuerfeln();
		int zahl2 = derWürfel[1].wuerfeln();
		
		dieGui.zeichneWuerfel(zahl1, zahl2);
		
	}



	public void klickKlappe(int wert) {
		// TODO Auto-generated method stub
		
	}


	public void wechsleSpieler() {
		// TODO Auto-generated method stub
		
	}

}
