//Hi there!
//This is a test file

package cctuts;

import javax.swing.*;

public class testInterface extends JFrame{
	
	public testInterface(){
	   setSize(700,700);
	   JButton startButton = new JButton("Hi!");
	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	   setVisible(true);
	}
	
	public static void main(String[] args){ 
		new testInterface();
	}
}
