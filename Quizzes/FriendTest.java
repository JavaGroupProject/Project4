import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class FriendTest extends JPanel implements MyQuestion {
	
	// Applet object
	private OurController aController;
	
	// Variable to hold screen number
	int number;
	
	// Image for background
	private Image backgroundImage;
	
	// Add friend list images
	Image friendImage1;
	Image friendImage2;
	Image friendImage3;
	Image friendImage4;
	Image friendImage5;
	Image friendImage6;

	// Get image URLs
	URL backgroundURL = OurController.class.getResource("InfoQuiz-01.png");
	URL friend1URL = OurController.class.getResource("Friend1-01.png");
	URL submitURL = OurController.class.getResource("Submit Button.png");

	// Create button of each friend to add
	JButton friendButton1;
	JButton friendButton2;
	JButton friendButton3;
	JButton friendButton4;
	JButton friendButton5;
	JButton friendButton6; 
	
	// Submit Button
	JButton submitButton;

	// Add icons for images
	Icon friendIcon1;
	Icon friendIcon2;
	Icon friendIcon3;
	Icon friendIcon4;
	Icon friendIcon5;
	Icon friendIcon6;
	
	public FriendTest(OurController thisController, int aNumber) {
		
		// Set the applet
		this.aController = thisController;
				
		// Set the screen number
		number = aNumber;
		
		// Set the layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
        // Create box for spacing
        add(Box.createRigidArea(new Dimension(10,115)));
        
        // Get images
	    try{
	    	//add background 
	    	backgroundImage = ImageIO.read(backgroundURL);
	    	
	    	//add image button #1
	    	friendImage1 = ImageIO.read(friend1URL);
	    	friendImage2 = ImageIO.read(friend1URL); 
	    	friendImage3 = ImageIO.read(friend1URL);
	    	friendImage4 = ImageIO.read(friend1URL);
	    	friendImage5 = ImageIO.read(friend1URL);
	    	friendImage6 = ImageIO.read(friend1URL);
	    	
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
        
  		// Set Questions
        setQuestion();
        setAnswer();        
	    		
		// Listener to take user to first screen of lesson
		submitButton.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	aController.showNextTest(number);
		    }
		});
	}

	@Override
	public void getAnswer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean isCorrect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAnswer() {
		
        // Add friend list panel
     	JPanel friendListPanel = new JPanel();	
	    
     	// Image button 1
    	friendButton1 = new JButton();
    	friendButton1.setOpaque(false);
    	friendButton1.setBorderPainted(false);
    	friendButton1.setContentAreaFilled(false);
        ImageIcon friend1 = new ImageIcon(friendImage1);
        friendButton1.setIcon(friend1);
    	
    	// Add image button 2
        friendButton2 = new JButton();
    	friendButton2.setOpaque(false);
    	friendButton2.setBorderPainted(false);
    	friendButton2.setContentAreaFilled(false);
        ImageIcon friend2 = new ImageIcon(friendImage1);
        friendButton2.setIcon(friend2);
    	
    	// Add image button #3
        friendButton3 = new JButton();
    	friendButton3.setOpaque(false);
    	friendButton3.setBorderPainted(false);
    	friendButton3.setContentAreaFilled(false);
        ImageIcon friend3 = new ImageIcon(friendImage1);
        friendButton3.setIcon(friend3);
    	
    	// Add image button #4  	
        friendButton4 = new JButton();
    	friendButton4.setOpaque(false);
    	friendButton4.setBorderPainted(false);
    	friendButton4.setContentAreaFilled(false);
        ImageIcon friend4 = new ImageIcon(friendImage1);
        friendButton4.setIcon(friend4);
    	
    	// Add image button #5    	
        friendButton5 = new JButton();
    	friendButton5.setOpaque(false);
    	friendButton5.setBorderPainted(false);
    	friendButton5.setContentAreaFilled(false);
        ImageIcon friend5 = new ImageIcon(friendImage1);
        friendButton5.setIcon(friend5);
    	
    	// Add image button #6 	
        friendButton6 = new JButton();
    	friendButton6.setOpaque(false);
    	friendButton6.setBorderPainted(false);
    	friendButton6.setContentAreaFilled(false);
        ImageIcon friend6 = new ImageIcon(friendImage1);
        friendButton6.setIcon(friend6);		
    	
	    //set the size and layout of the panel
	    friendListPanel.setPreferredSize(new Dimension(450, 400));
	    friendListPanel.setLayout(new GridLayout(2, 3));
	    friendListPanel.setAlignmentX(CENTER_ALIGNMENT);
	    friendListPanel.setOpaque(false);
	    
	    //add the image buttons to the panel
	    friendListPanel.add(friendButton1);
	    friendListPanel.add(friendButton2);
	    friendListPanel.add(friendButton3);
	    friendListPanel.add(friendButton4);
	    friendListPanel.add(friendButton5);
	    friendListPanel.add(friendButton6);
	    
	    //add the panel to frame
	    add(friendListPanel);
	    
	    
		// Create and set up button
		submitButton = new JButton();
		submitButton.setAlignmentX(CENTER_ALIGNMENT);
		
		// Add icon to submit button
		submitButton.setOpaque(false);
		submitButton.setBorderPainted(false);
		submitButton.setContentAreaFilled(false);
        ImageIcon submit = new ImageIcon(submitURL);
        submitButton.setIcon((submit));
        
        // Add button
        add(submitButton);
	}

	@Override
	public void setQuestion() {
		// TODO Auto-generated method stub
		
	}
	
	// Paint the background
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this);
    }
}