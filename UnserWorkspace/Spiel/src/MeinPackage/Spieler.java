package MeinPackage;

public class Spieler {
	
	private String aName;
	private int aMinusPunkte;
	
	public Spieler(String pName) {
		aName = pName;
		
	}
	
	public String gibName() {
		return aName;
	}
	
	public int gibMinusPunkte() {
		return aMinusPunkte;
	}
	
	public void setzeMinusPunkte(int pMinusPunkte) {
		aMinusPunkte = pMinusPunkte;
	}

	
}
