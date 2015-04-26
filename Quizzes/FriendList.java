import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class FriendList extends JPanel {
	
	// Applet object
	private OurController anApplet;
	
	// Image for background
	private Image backgroundImage;
	
	// Variable to hold screen number
	int number;
	
	//image button of each friend to add
	JButton friendButton1;
	JButton friendButton2;
	JButton friendButton3;
	JButton friendButton4;
	JButton friendButton5;
	JButton friendButton6; 
	
	//previous and next button on control panel
	JButton nextButton;
	JButton previousButton;
	
	private JLabel instruction;
	private JScrollPane top;
	
	public void FriendList(OurController thisApplet, int aNumber) {
		
		this.anApplet = thisApplet;
		
		number = aNumber;
		
		//add friend list panel and control panel
		JPanel friendListPanel = new JPanel();
		JPanel controlPanel = new JPanel(new BorderLayout());
		
		//add friend list images
		Image friendImage1;
		Image friendImage2;
		Image friendImage3;
		Image friendImage4;
		Image friendImage5;
		Image friendImage6;
    	
		//add icons for images
		Icon friendIcon1;
		Icon friendIcon2;
		Icon friendIcon3;
		Icon friendIcon4;
		Icon friendIcon5;
		Icon friendIcon6;
		
		//add the image buttons
		BufferedImage button;
		
	    try{
	    	
	    	// background image
	    	backgroundImage = ImageIO.read(new File("/Users/Olivia/Desktop/Project4 graphics/png/InfoQuiz-01.png"));
	    	
	    	//add image button #1
	    	button = ImageIO.read(new File("/Users/Olivia/Desktop/Project4 graphics/png/PaswordQuiz-01.png"));
	    	friendImage1 = button.getScaledInstance(300, 500, java.awt.Image.SCALE_SMOOTH);
	    	friendIcon1 = new ImageIcon(friendImage1);
	    	friendButton1 = new JButton(new ImageIcon(friendImage1));
	    	friendButton1.setBorder(BorderFactory.createEmptyBorder());
	    	friendButton1.setContentAreaFilled(false);
	    	friendButton1.setSize(100, 150);
	    	
	    	//add image button #2
	    	button = ImageIO.read(new File("/Users/Olivia/Desktop/Project4 graphics/png/PaswordQuiz-01.png"));
	    	friendImage2 = button.getScaledInstance(300, 500, java.awt.Image.SCALE_SMOOTH);
	    	friendIcon2 = new ImageIcon(friendImage2);
	    	friendButton2 = new JButton(new ImageIcon(friendImage2));
	    	friendButton2.setBorder(BorderFactory.createEmptyBorder());
	    	friendButton2.setContentAreaFilled(false);
	    	friendButton2.setSize(100, 150);
	    	
	    	//add image button #3
	    	button = ImageIO.read(new File("/Users/Olivia/Desktop/Project4 graphics/png/PaswordQuiz-01.png"));
	    	friendImage3 = button.getScaledInstance(300, 500, java.awt.Image.SCALE_SMOOTH);
	    	friendIcon3 = new ImageIcon(friendImage3);
	    	friendButton3 = new JButton(new ImageIcon(friendImage3));
	    	friendButton3.setBorder(BorderFactory.createEmptyBorder());
	    	friendButton3.setContentAreaFilled(false);
	    	friendButton3.setSize(100, 150);
	    	
	    	//add image button #4
	    	button = ImageIO.read(new File("/Users/Olivia/Desktop/Project4 graphics/png/PaswordQuiz-01.png"));
	    	friendImage4 = button.getScaledInstance(300, 500, java.awt.Image.SCALE_SMOOTH);
	    	friendIcon4 = new ImageIcon(friendImage4);
	    	friendButton4 = new JButton(new ImageIcon(friendImage4));
	    	friendButton4.setBorder(BorderFactory.createEmptyBorder());
	    	friendButton4.setContentAreaFilled(false);
	    	friendButton4.setSize(100, 150);
	    	
	    	//add image button #5
	    	button = ImageIO.read(new File("/Users/Olivia/Desktop/Project4 graphics/png/PaswordQuiz-01.png"));
	    	friendImage5 = button.getScaledInstance(300, 500, java.awt.Image.SCALE_SMOOTH);
	    	friendIcon5 = new ImageIcon(friendImage5);
	    	friendButton5 = new JButton(new ImageIcon(friendImage5));
	    	friendButton5.setBorder(BorderFactory.createEmptyBorder());
	    	friendButton5.setContentAreaFilled(false);
	    	friendButton5.setSize(100, 150);
	    	
	    	//add image button #6
	    	button = ImageIO.read(new File("/Users/Olivia/Desktop/Project4 graphics/png/PaswordQuiz-01.png"));
	    	friendImage6 = button.getScaledInstance(300, 500, java.awt.Image.SCALE_SMOOTH);
	    	friendIcon6 = new ImageIcon(friendImage6);
	    	friendButton6 = new JButton(new ImageIcon(friendImage6));
	    	friendButton6.setBorder(BorderFactory.createEmptyBorder());
	    	friendButton6.setContentAreaFilled(false);
	    	friendButton6.setSize(100, 150);
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	    
	    //set the size and layout of the panel
	    friendListPanel.setPreferredSize(new Dimension(500, 500));
	    friendListPanel.setLayout(new GridLayout(2, 3, 50, 50));
	    
	    //add the image buttons to the panel
	    friendListPanel.add(friendButton1);
	    friendListPanel.add(friendButton2);
	    friendListPanel.add(friendButton3);
	    friendListPanel.add(friendButton4);
	    friendListPanel.add(friendButton5);
	    friendListPanel.add(friendButton6);
	    
	    //add the panel to frame
	    add(friendListPanel, BorderLayout.CENTER);
	    
	    //add label at top of screen to give directions
	    instruction = new JLabel("Click on the profile picture(s) of people "
 				+ "you want to add as friend(s).", SwingConstants.CENTER);
		top = new JScrollPane(instruction);
 		add(top, BorderLayout.PAGE_START);
 		
 		//add control panel to frame
 		controlPanel.setBackground(Color.WHITE);
 		controlPanel.add(previousButton, BorderLayout.WEST);
 		controlPanel.add(nextButton, BorderLayout.EAST);
 		add(controlPanel, BorderLayout.PAGE_END);
	}
	
	// Paint the background
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this);
    }
}