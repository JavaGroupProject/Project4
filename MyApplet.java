import java.awt.CardLayout;

import javax.swing.JApplet;


public class myApplet extends JApplet{
	
	// Create card layout
	final public CardLayout cardlayout = new CardLayout();
	
	// Initialize constants
	private final int WIDTH = 500;
	private final int HEIGHT = 500;
	
	// Initialize  Panels
	Welcome myWelcome = new Welcome(this);
	
	// Set Strings for Panels
	final static String WELCOME = "Welcome";
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
