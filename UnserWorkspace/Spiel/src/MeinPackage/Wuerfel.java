package MeinPackage;

public class Wuerfel {
	
	private int aLetzterWurf;
	private int neuerWurf;
	
	public int getNeuerWurf() {
		return neuerWurf;
	}

	public int wuerfeln() {
		aLetzterWurf = neuerWurf;
		neuerWurf = (int)(Math.random()*6+1);
		return neuerWurf;
	}
	
	public int gibLetzterWurf() {
		return aLetzterWurf;
	}

}
