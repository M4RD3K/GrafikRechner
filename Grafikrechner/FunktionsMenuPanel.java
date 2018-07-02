package Grafikrechner;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * Die Klasse FunktionsMenuPanel ist die Klasse, die das Panel, mit dem in der Gui die Funktionsgleichung
 * eingegeben werden kann, erstellt. Dies beinhaltet auch ein Eingabefeld zur Berechung eines bestimmten X/Y-Wertes und den Button um
 * das Schaubild der Funktion zu zeichnen.
 */
public class FunktionsMenuPanel extends JPanel {

	// JLabel
	JLabel jlFunktion1;
	JLabel jlXwert1;
	JLabel jlYwert1;
	JFormattedTextField s1;

	// JTextfield
	JTextField jtfFunktion1;
	JTextField jtfXwert1;

	// JButton
	JButton jbZeichne;

	public FunktionsMenuPanel() {

		// Layout einstellen
		this.setLayout(new GridLayout(1, 6));

		// JTextfield Objekte
		jtfFunktion1 = new JTextField();
		jtfXwert1 = new JTextField();

		// JLabel Objekte
		jlFunktion1 = new JLabel("  Funktion: ");
		jlXwert1 = new JLabel("X-Wert: ");
		jlYwert1 = new JLabel("Y-Wert:");
		s1 = new JFormattedTextField();

		// JButton Objekte
		jbZeichne = new JButton("Zeichne");

		// Objekte dem Panel zurodnen

		
		this.add(jlFunktion1);
		this.add(jtfFunktion1);
		this.add(jlXwert1);
		this.add(jtfXwert1);
		this.add(jlYwert1);
		this.add(jbZeichne);
		this.setBackground(Color.white);
		this.setBorder(new LineBorder(Color.BLACK));

	}
}
