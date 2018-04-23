package Grafikrechner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Steuerung {

	Gui dieGui;
	Daten dieDaten;
	Berechne berechne;

	public Steuerung() {

		dieGui = new Gui(this);
		dieGui.setVisible(true);
		dieDaten = new Daten();
        berechne = new Berechne();
        
		
		dieGui.funktionsMenuPanel.jbBerechne.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				zerlegeInProdukte();
				berechne.zerlegeInFaktoren(dieDaten.zerlegteProdukte);
			}
		});

	}

	public ArrayList<String> zerlegeFunktionsgleichungFuenf(String funktionsgleichung) {

		int index = 0;
		ArrayList<String> liste = new ArrayList<String>();
		String s1 = funktionsgleichung;
		char[] tabelle = s1.toCharArray();

		for (int i = 1; i < tabelle.length; i++) {

			if ((tabelle[i] == '+') || (tabelle[i] == '-')) {
				liste.add(s1.substring(0, i));
				break;
			}
		}

		index = liste.get(0).length();
		s1 = s1.substring(index);
		tabelle = s1.toCharArray();

		for (int j = 1; j < tabelle.length; j++) {

			if (tabelle[j] == '-' || (tabelle[j] == '+')) {
				liste.add(s1.substring(0, j));
				break;
			}
		}

		index = liste.get(1).length();
		s1 = s1.substring(index);
		tabelle = s1.toCharArray();

		for (int j = 1; j < tabelle.length; j++) {
			if (tabelle[j] == '-' || (tabelle[j] == '+')) {
				liste.add(s1.substring(0, j));
				break;
			}
		}

		index = liste.get(2).length();
		s1 = s1.substring(index);
		tabelle = s1.toCharArray();

		for (int j = 1; j < tabelle.length; j++) {
			if (tabelle[j] == '-' || (tabelle[j] == '+')) {
				liste.add(s1.substring(0, j));
				break;
			}
		}

		index = liste.get(3).length();
		s1 = s1.substring(index);
		tabelle = s1.toCharArray();

		liste.add(s1);
		return liste;
	}

	public ArrayList<String> zerlegeFunktionsgleichungVier(String funktionsgleichung) {

		int index = 0;
		ArrayList<String> liste = new ArrayList<String>();
		String s1 = funktionsgleichung;
		char[] tabelle = s1.toCharArray();
		for (int i = 1; i < tabelle.length; i++) {
			if ((tabelle[i] == '+') || (tabelle[i] == '-')) {
				liste.add(s1.substring(0, i));
				break;
			}
		}

		index = liste.get(0).length();
		s1 = s1.substring(index);
		tabelle = s1.toCharArray();

		for (int j = 1; j < tabelle.length; j++) {
			if (tabelle[j] == '-' || (tabelle[j] == '+')) {
				liste.add(s1.substring(0, j));
				break;
			}
		}

		index = liste.get(1).length();
		s1 = s1.substring(index);
		tabelle = s1.toCharArray();

		for (int j = 1; j < tabelle.length; j++) {
			if (tabelle[j] == '-' || (tabelle[j] == '+')) {
				liste.add(s1.substring(0, j));
				break;
			}
		}

		index = liste.get(2).length();
		s1 = s1.substring(index);
		tabelle = s1.toCharArray();
		liste.add(s1);

		return liste;
	}

	public ArrayList<String> zerlegeFunktionsgleichungDrei(String funktionsgleichung) {

		int index = 0;
		ArrayList<String> liste = new ArrayList<String>();
		String s1 = funktionsgleichung;
		char[] tabelle = s1.toCharArray();

		for (int i = 1; i < tabelle.length; i++) {
			if ((tabelle[i] == '+') || (tabelle[i] == '-')) {
				liste.add(s1.substring(0, i));
				break;
			}
		}

		index = liste.get(0).length();
		s1 = s1.substring(index);
		tabelle = s1.toCharArray();

		for (int j = 1; j < tabelle.length; j++) {
			if (tabelle[j] == '-' || (tabelle[j] == '+')) {
				liste.add(s1.substring(0, j));
				break;
			}
		}

		index = liste.get(1).length();
		s1 = s1.substring(index);
		tabelle = s1.toCharArray();
		liste.add(s1);
		return liste;
	}

	public ArrayList<String> zerlegeFunktionsgleichungZwei(String funktionsgleichung) {

		int index = 0;
		ArrayList<String> liste = new ArrayList<String>();
		String s1 = funktionsgleichung;
		char[] tabelle = s1.toCharArray();

		for (int i = 1; i < tabelle.length; i++) {

			if ((tabelle[i] == '+') || (tabelle[i] == '-')) {
				liste.add(s1.substring(0, i));
				break;
			}
		}
		index = liste.get(0).length();
		s1 = s1.substring(index);
		tabelle = s1.toCharArray();

		liste.add(s1);
		return liste;
	}

	public ArrayList<String> zerlegeFunktionsgleichungEins(String funktionsgleichung) {

		int index = 0;
		ArrayList<String> liste = new ArrayList<String>();
		String s1 = funktionsgleichung;
		char[] tabelle = s1.toCharArray();

		liste.add(s1);
		return liste;
	}

	public boolean ueberpruefeFunktion(String Funktionsgleichung) {

		return true;
	}

	public void zerlegeInProdukte() {

		String s1 = dieGui.funktionsMenuPanel.jtfFunktion1.getText().toString();
		char[] liste = s1.toCharArray();

		int zähler = 1;

		for (int i = 1; i < liste.length; i++) {
			if ((liste[i] == '+') || (liste[i] == '-')) {
				zähler++;
			}
		}

		if (zähler == 1) {
			dieDaten.speichereAkutelleProdukte(this.zerlegeFunktionsgleichungEins(getFunktionsgleichung()));
		}
		if (zähler == 2) {
			dieDaten.speichereAkutelleProdukte(this.zerlegeFunktionsgleichungZwei(getFunktionsgleichung()));
		}
		if (zähler == 3) {
			dieDaten.speichereAkutelleProdukte(this.zerlegeFunktionsgleichungDrei(getFunktionsgleichung()));
		}
		if (zähler == 4) {
			dieDaten.speichereAkutelleProdukte(this.zerlegeFunktionsgleichungVier(getFunktionsgleichung()));
		}
		if (zähler == 5) {
			dieDaten.speichereAkutelleProdukte(this.zerlegeFunktionsgleichungFuenf(getFunktionsgleichung()));
		}

	}

	public String getFunktionsgleichung() {

		String s = dieGui.funktionsMenuPanel.jtfFunktion1.getText();

		return s;

	}

	public void zerlegeInFaktoren(ArrayList<String> arrayList) {

		ArrayList<String[]> dieListe;

		dieListe = new ArrayList<String[]>();
		String[] dasArray = new String[2];

		for (int i = 0; i < arrayList.size(); i++) {

			String s1, s2;
			String produkt = arrayList.get(i);
			char[] charList = produkt.toCharArray();

			for (int j = 0; j < charList.length; j++) {

				if (charList[j] == 'x') {

					s1 = produkt.substring(0, j);
					s2 = produkt.substring(j, produkt.length());
					dasArray[0] = s1;
					dasArray[1] = s2;
					System.out.println(s1);
					System.out.println(s2);
					dieListe.add(dasArray);
				}

			}
		}
		dieDaten.zerlegteFaktoren = dieListe;

		System.out.println("------");

		for (int i = 0; i < dieDaten.zerlegteFaktoren.size(); i++) {

			String s1[] = dieDaten.zerlegteFaktoren.get(i);

			for (int j = 0; j < s1.length; j++) {

				System.out.println(s1[i]);

			}

		}

	}

}
