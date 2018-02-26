package MeinPackage;

import java.awt.Dimension;

import javax.swing.JButton;

public class MeinButton extends JButton {
	
	private static final int HEIGHT = 100;
	//private static final int WIDTH = 80;
	
	public MeinButton() {
		super();
	}
	
	
	public MeinButton(String text) {
		this();
		setText(text);
		setPreferredSize(new Dimension(text.length()*getFont().getSize(), HEIGHT));
		
		
	}

}
