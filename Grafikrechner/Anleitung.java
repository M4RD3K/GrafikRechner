package Grafikrechner;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * In deser Klasse wird das Frame konfiguriert das die Anleitung beinhaltet.
 */
public class Anleitung extends JFrame {

	//AnleitungsPanel
	JPanel jPAnleitung;
	
	//JLabel
	
	JLabel jlAnleitung0;
	JLabel jlAnleitung1;
	JLabel jlAnleitung2;
	JLabel jlAnleitung3;
	JLabel jlAnleitung4;
	JLabel jlAnleitung5;
	JLabel jlAnleitung6;
	JLabel jlAnleitung7;
	JLabel jlAnleitung8;
	JLabel jlAnleitung9;
	JLabel jlAnleitung10;
	JLabel jlAnleitung11;
	JLabel jlAnleitung12;
	public Anleitung() {
		
	 //JLabel Objekte bauen.
     jlAnleitung0  = new JLabel("Geben Sie ihre Funktionsgleichung im Eingabefeld neben 'Funktion:' ein.");
     jlAnleitung1  = new JLabel("Um die Funktionsgleichung zu zeichnen muss der Button zeichen gedrückt werden.");
     jlAnleitung2  = new JLabel("Wenn sie einen Bestimmten Y-Wert zu einem X-haben wollen müsseb sie in das");
     jlAnleitung3  = new JLabel("Eingabefeld neben 'x-Wert' den gewünschten X-Wert eingeben und enter drücken.");
     jlAnleitung4  = new JLabel("Möchten Sie ihre Funktion ableiten so müssen sie diese Ebfalls eingeben und den Button 'Ableiten' drücken");
     jlAnleitung5  = new JLabel("Untersützte Funktionstypen und Zeichen:");
     jlAnleitung6  = new JLabel("Das Programm akzeptiert Funktionen der Schreibweise a*x^n sowie a*sin(x) und a*(cos(x).");
     jlAnleitung7  = new JLabel("Es Können brüche in der Form a/b eingegeben werden ein X im Bruch wird nicht Untersützt.");
     jlAnleitung8  = new JLabel("Bitte geben sie keine Klammern oder Malzeichen ein" );
     jlAnleitung9  = new JLabel("Als Variable nur X-Verweden");
     jlAnleitung11 = new JLabel("Einen Puntk als Komma verwenden.");
     jlAnleitung10 = new JLabel("Solange sie sich an die Obigen vorschriften Halten sollte es zu keinen Problemem mit dem Programm kommen.");
     jlAnleitung12 = new JLabel("Zum berechnen der nullstelle erst Zeichnen, dann Ableiten und beim x-Wert den startwert deklarieren worum die nullstelle gefunden werden soll");
    		 
     //JPanel Objekt bauen.
	 jPAnleitung = new JPanel(new GridLayout(13,0));
	 
	 //Panel Obtionen
	 
	 jPAnleitung.setBorder(new TitledBorder("Anleitung:"));
	 
	 jPAnleitung.add(jlAnleitung0);
	 jPAnleitung.add(jlAnleitung1);
	 jPAnleitung.add(jlAnleitung2);
	 jPAnleitung.add(jlAnleitung3);
	 jPAnleitung.add(jlAnleitung4);
	 jPAnleitung.add(jlAnleitung5);
	 jPAnleitung.add(jlAnleitung6);
	 jPAnleitung.add(jlAnleitung7);
	 jPAnleitung.add(jlAnleitung8);
	 jPAnleitung.add(jlAnleitung9);
	 jPAnleitung.add(jlAnleitung11);
	 jPAnleitung.add(jlAnleitung12);
	 jPAnleitung.add(jlAnleitung10);
	 
	 jPAnleitung.setBackground(Color.WHITE);
	 
	 //Anleitunspanel einstellem
	 
	 this.setContentPane(jPAnleitung);
	 this.setSize(730,400);
	 this.setVisible(true);
	 
	 
	}
	
}
