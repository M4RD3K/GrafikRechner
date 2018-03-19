package Grafikrechner;

import javax.swing.*;

public class FrameAnleitung extends JFrame {
	
	
	public FrameAnleitung() {
		


		JPanel jpAnleitung;
		
		JLabel jlAnleitung;
		
		jpAnleitung = new JPanel();
		jlAnleitung = new JLabel("Willkommen in der Anleitung");
		
		jpAnleitung.add(jlAnleitung);
		
		this.setContentPane(jpAnleitung);
		this.setTitle("Text");
		this.setVisible(true);
		this.setSize(300, 300);
	}
	
	
}
