import java.util.ArrayList;

public class GRF_Zerlegung {

	public static void main(String[] args) {
	
		int index = 0;
		ArrayList<String> liste = new ArrayList<String>();
		String s1 = "-0,5x^2-22x-23x^3";
		System.out.println("Funktionsgleichung: "+s1);
		char[] tabelle = s1.toCharArray();
		
		for (int i = 1; i < tabelle.length; i++) {
			
			if ((tabelle[i] == '+') || (tabelle[i] == '-') ) {
	     		liste.add(s1.substring(0, i));
	     		break;
			}	
		}
		
		index = liste.get(0).length();
		s1 = s1.substring(index);
		tabelle = s1.toCharArray();
				
		for (int j = 1; j < tabelle.length; j++) {

			if (tabelle[j] == '-' || (tabelle[j] == '+') ) {
				liste.add(s1.substring(0,j));
			}
			
		}
		
		
		index = liste.get(1).length();
		s1 = s1.substring(index);
		tabelle = s1.toCharArray();
		
		liste.add(s1);
		
		System.out.println("Faktoren:");
		
		for (int i = 0; i < 3; i++) {
			System.out.println(liste.get(i));
		}

	}

}
