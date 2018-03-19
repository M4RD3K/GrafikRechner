
public class Steuerung {

	
	
	testGui dieGui;
	
	public Steuerung() {
	
		dieGui = new testGui(this);
		
	   }

		public double gebePrdouktwert(double a, double xwert,double hochzahl) {
			
			double ergebnis = Math.pow(xwert, hochzahl);
			ergebnis = ergebnis*a;	
			return ergebnis;
		}
		
	
		public double leseZahlX() {
			
		 String  xs = dieGui.xEingabe.getText();
		 double  x = Double.parseDouble(xs);	
		 
		 return x;
		 
		}
		
		
		public double leseHochzah() {
			
			 String  xs = dieGui.xEingabe.getText();
			 double  x = Double.parseDouble(xs);	
			 
			 return x;
			 
			}
}
