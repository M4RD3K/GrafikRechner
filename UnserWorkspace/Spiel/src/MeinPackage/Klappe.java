package MeinPackage;

public class Klappe {
	
	private int aWert;
	private int aZustand;
	
	public static final int GESETZT = 1;
	
	public Klappe(int wert) {
		aZustand = 0;
		aWert = wert;
	}
	
	
	public int gibZustand() {
		return aZustand;
	}


	public void setzeZustand(int zustand) {
		aZustand = zustand;
		
	}


	public int gibWert() {
		// TODO Auto-generated method stub
		return aWert;
	}

}
