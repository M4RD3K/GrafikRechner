package Grafikrechner;

import java.util.ArrayList;

public class Berechne {

	public void zerlegeInFaktoren(ArrayList<String> arrayList) {

		ArrayList<String[]> dieListe;

		dieListe = new ArrayList<String[]>();
		String[] dasArray = new String[2];

		for (int i = 0; i < arrayList.size(); i++) {

			String konArray, powString;
			String produkt = arrayList.get(i);
			char[] charList = produkt.toCharArray();

			for (int j = 0; j < charList.length; j++) {

				if (charList[j] == 'x') {

					konArray = produkt.substring(0, j);
					powString = produkt.substring(j, produkt.length());
					double y = calculateY(konArray,powString);
					System.out.println(y);		
				}
			}
		}
		
	}
	public double calculateY (String s1, String s2) {
		int x = 1;
		double ergebnis = -1;
		
		
		if (s2.contains("^")) {
			int power;
			String test = s2.substring(s2.length());
			double as = Double.parseDouble(test);
			power = (int) as;
			char[] kon = s1.toCharArray();
			int a = kon[1];
			System.out.println(a);
			System.out.println(power);
			
			ergebnis = a* (Math.pow(2,3));
			System.out.println(ergebnis);
			
		
		
		}
		return ergebnis;
	}
	
}
