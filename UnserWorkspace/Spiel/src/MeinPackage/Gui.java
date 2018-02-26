package MeinPackage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Gui extends JFrame {
	
	Steuerung dieSteuerung;
	
	JPanel jpLinks;
	JPanel jpRechts;
	JPanelSpieler jpSpieler1;
	JPanelSpieler jpSpieler2;
	JPanel jpWuerfel;
	JPanel jpUnten;
	JPanel jpKlappen;
	JPanel jpButtons;
	JPanel contentPane;
	
	JTextField tfPunkte1;
	JTextField tfPunkte2;
	JButton btWuerfeln;
	JButton btSpielerWechsel;
	
	ButtonKlappe klappeButtons[]; 
	
	MeinButtonWuerfel w1,w2;
	
	
	public static final String TITEL = "Shut the Box";
	private static final String WUERFELN = "würfeln";
	private static final String SPIELER_WECHSELN = "Spielerwechsel";
	
	public Gui(String pName1, String pName2) {
		dieSteuerung = new Steuerung(this,pName1,pName2);
		
		
		
		setTitle(TITEL);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		contentPane = new JPanel();
		jpLinks = new JPanel();
		jpRechts = new JPanel();
		jpSpieler1 = new JPanelSpieler(1);
		jpSpieler2 = new JPanelSpieler(2);
		jpWuerfel  = new JPanel();
		jpUnten = new JPanel();
		jpButtons = new JPanel();
		jpKlappen = new JPanel();
		
				
		
		
		btWuerfeln = new MeinButton(WUERFELN);
		btWuerfeln.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				klickWuerfeln();
				
			}
		});
		
		
		btSpielerWechsel= new MeinButton(SPIELER_WECHSELN);
		
		klappeButtons = new ButtonKlappe[9];
		
		for (int i = 0; i < klappeButtons.length; i++) {
			klappeButtons[i]= new ButtonKlappe(i+1, this);
			jpKlappen.add(klappeButtons[i]);
		}
		
		
		
		w1 = new MeinButtonWuerfel(6);
		w2 = new MeinButtonWuerfel(5);
		
		
		contentPane.setLayout(new BorderLayout(10,10));
		contentPane.add(jpLinks,BorderLayout.WEST);
		contentPane.add(jpRechts,BorderLayout.CENTER);
		
		
		jpRechts.setLayout(new BorderLayout(10,10));
		jpRechts.add(jpKlappen,BorderLayout.CENTER);
		jpRechts.add(jpUnten,BorderLayout.SOUTH);
		
		jpUnten.setLayout(new FlowLayout(FlowLayout.LEFT,0,10));
		jpButtons.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		
		jpButtons.add(btWuerfeln);
		jpButtons.add(btSpielerWechsel);
		
		
		jpWuerfel.setLayout(new FlowLayout(FlowLayout.RIGHT,10,10));
		jpWuerfel.add(w1);
		jpWuerfel.add(w2);

		jpUnten.add(jpButtons);
		jpUnten.add(jpWuerfel);
		
		
		jpKlappen.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		
		
		
		
				
		
		GridLayout gridLayoutLinks = new GridLayout(4, 1,20,10);
		jpLinks.setLayout(gridLayoutLinks);
		gridLayoutLinks.setVgap(20);
		gridLayoutLinks.setHgap(50);
		
		
		jpLinks.add(jpSpieler1);
		jpLinks.add(jpSpieler2);
		
		
		
		setContentPane(contentPane);
		pack();
		
		btWuerfeln.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				klickWuerfeln();
				
			}
		});
		
		btSpielerWechsel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				klickWechsleSpieler();
				
			}
		});
		
	}
	
	

	public void zeigePunkte(int pIdxSpieler, int pMinusPunkte) {
		
	}
	
	public void oeffneAlleKlappen() {
		
		//alle Klappen öffnen
		
	}
	
	public void schliesseKlappe(int pWert) {
				klappeButtons[pWert-1].setText("X");
				
	}
	
	public void aktiviereWuerfelTaste(boolean b) {
		btWuerfeln.setEnabled(b);
	}
	
	public void aktiviereWechselTaste(boolean b) {
		
	}

	public void klickWechsleSpieler() {
		dieSteuerung.wechsleSpieler();
		
	}
	
	public void klickWuerfeln() {
		System.out.println("Wuerfeln geklickt");
		dieSteuerung.wuerfeln();
		
	}

	public void zeichneWuerfel(int wert1, int wert2) {
		w1.setWert(wert1);
		w2.setWert(wert2);
		
		w1.revalidate();
		w2.revalidate();
		w1.repaint();
		w2.repaint();
		
	}
	
	public void klickKlappe(int wert) {
		System.out.println("Klappe"+wert+"  geklickt");
		dieSteuerung.klickKlappe(wert);
	}
	
	public int gibAugensumme() {
		return w1.getWert()+w2.getWert();
	}
}
