import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
	
	// constants to store the information about the possible friends
	private final String FRIEND1_NAME = "Herbert Gruber";
	private final String FRIEND2_NAME = "Charlie Scott";
	private final String FRIEND3_NAME = "Bernie McDool";
	private final String FRIEND4_NAME = "Amy Parker";
	private final String FRIEND5_NAME = "Ben Connolly";
	private final String FRIEND6_NAME = "Lisa Williams";
	
	private final String FRIEND_QUIZ_IMAGE = "FriendQuiz-01.png";
	private final String SUBMIT_BUTTON_IMAGE = "Submit Button.png";
	
	private final String FRIEND1_LABEL = "Friend1-01.png";
	private final String FRIEND2_LABEL = "Friend2-01.png";
	private final String FRIEND3_LABEL = "Friend3-01.png";
	private final String FRIEND4_LABEL = "Friend4-01.png";
	private final String FRIEND5_LABEL = "Friend5-01.png";
	private final String FRIEND6_LABEL = "Friend6-01.png";
	
	private final String FRIEND1_IMAGE = "friendicon1-01.png";
	private final String FRIEND2_IMAGE = "friendicon2-01.png";
	private final String FRIEND3_IMAGE = "friendicon3-01.png";
	private final String FRIEND4_IMAGE = "friendicon4-01.png";
	private final String FRIEND5_IMAGE = "friendicon5-01.png";
	private final String FRIEND6_IMAGE = "friendicon6-01.png";
	
	private String selectedName = "";
	
	// Add friend list images
	Image friendImage1;
	Image friendImage2;
	Image friendImage3;
	Image friendImage4;
	Image friendImage5;
	Image friendImage6;

	// Get image URLs
	URL backgroundURL = OurController.class.getResource(FRIEND_QUIZ_IMAGE);
	URL friend1URL = OurController.class.getResource(FRIEND1_LABEL);
	URL friend2URL = OurController.class.getResource(FRIEND2_LABEL);
	URL friend3URL = OurController.class.getResource(FRIEND3_LABEL);
	URL friend4URL = OurController.class.getResource(FRIEND4_LABEL);
	URL friend5URL = OurController.class.getResource(FRIEND5_LABEL);
	URL friend6URL = OurController.class.getResource(FRIEND6_LABEL);
	URL submitURL = OurController.class.getResource(SUBMIT_BUTTON_IMAGE);

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
	
	//Array of Friend Objects
	ArrayList<Friend> friendList;
	
	public FriendTest(OurController thisController, int aNumber) {
		
		// Set the applet
		this.aController = thisController;
		
		// set the friend list to the one in the controller class
		friendList = aController.getFriends();
		
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
	    	friendImage2 = ImageIO.read(friend2URL); 
	    	friendImage3 = ImageIO.read(friend3URL);
	    	friendImage4 = ImageIO.read(friend4URL);
	    	friendImage5 = ImageIO.read(friend5URL);
	    	friendImage6 = ImageIO.read(friend6URL);
	    	
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
        
  		// Set Questions and Answers
        setQuestion();
        setAnswer();        
	    		
		// Listener to take user to first screen of lesson
		submitButton.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	aController.showCanvas();
		    }
		});
		
	}

	@Override
	public Boolean isCorrect() {
		
		// boolean to store whether the friend can be added
		boolean canAddFriend = true;
		
		// loop through the list of friends to determine if this friend is already in the list
		for (int i = 0; i < friendList.size(); i++){
			if (selectedName.equals(friendList.get(i).getName())){
				canAddFriend = false;
			}
		}
		
		return canAddFriend;
		
	}

	@Override
	public void setQuestion() {
		
        // Add friend list panel
     	JPanel friendListPanel = new JPanel();	
	    
     	// Image button 1
    	friendButton1 = new JButton();
    	friendButton1.addActionListener(new FriendListener());
    	friendButton1.setName(FRIEND1_NAME);
    	friendButton1.setOpaque(false);
    	friendButton1.setBorderPainted(false);
    	friendButton1.setContentAreaFilled(false);
        ImageIcon friend1 = new ImageIcon(friendImage1);
        friendButton1.setIcon(friend1);
    	
    	// Add image button 2
        friendButton2 = new JButton();
        friendButton2.addActionListener(new FriendListener());
        friendButton2.setName(FRIEND2_NAME);
    	friendButton2.setOpaque(false);
    	friendButton2.setBorderPainted(false);
    	friendButton2.setContentAreaFilled(false);
        ImageIcon friend2 = new ImageIcon(friendImage2);
        friendButton2.setIcon(friend2);
    	
    	// Add image button #3
        friendButton3 = new JButton();
        friendButton3.addActionListener(new FriendListener());
        friendButton3.setName(FRIEND3_NAME);
    	friendButton3.setOpaque(false);
    	friendButton3.setBorderPainted(false);
    	friendButton3.setContentAreaFilled(false);
        ImageIcon friend3 = new ImageIcon(friendImage3);
        friendButton3.setIcon(friend3);
    	
    	// Add image button #4  	
        friendButton4 = new JButton();
        friendButton4.addActionListener(new FriendListener());
        friendButton4.setName(FRIEND4_NAME);
    	friendButton4.setOpaque(false);
    	friendButton4.setBorderPainted(false);
    	friendButton4.setContentAreaFilled(false);
        ImageIcon friend4 = new ImageIcon(friendImage4);
        friendButton4.setIcon(friend4);
    	
    	// Add image button #5    	
        friendButton5 = new JButton();
        friendButton5.addActionListener(new FriendListener());
        friendButton5.setName(FRIEND5_NAME);
    	friendButton5.setOpaque(false);
    	friendButton5.setBorderPainted(false);
    	friendButton5.setContentAreaFilled(false);
        ImageIcon friend5 = new ImageIcon(friendImage5);
        friendButton5.setIcon(friend5);
    	
    	// Add image button #6 	
        friendButton6 = new JButton();
        friendButton6.addActionListener(new FriendListener());
        friendButton6.setName(FRIEND6_NAME);
    	friendButton6.setOpaque(false);
    	friendButton6.setBorderPainted(false);
    	friendButton6.setContentAreaFilled(false);
        ImageIcon friend6 = new ImageIcon(friendImage6);
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
	    
	}

	@Override
	public void setAnswer() {

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
	
	// Paint the background
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this);
    }
	
	// listener for each of the buttons to choose a friend
	class FriendListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e){
			
			// get the name of the button
			// Citation: http://stackoverflow.com/questions/7867834/get-button-name-from-actionlistener
			JButton selectedImage = (JButton) e.getSource();
			selectedName = selectedImage.getName();
			
			// check if the friend is not already in the list and can be added
			boolean canAdd = isCorrect();
			
			if (canAdd){
				
				// add the correct friend based on the button that was pressed
				if (selectedName.equals(FRIEND1_NAME)){
			     	friendList.add(new Friend(FRIEND1_NAME, FRIEND1_IMAGE, 0, "Jersey City NJ", 24));
				}
				else if (selectedName.equals(FRIEND2_NAME)){
			     	friendList.add(new Friend(FRIEND2_NAME, FRIEND2_IMAGE, 0, "Naples FA", 34));
				}
				else if (selectedName.equals(FRIEND3_NAME)){
			     	friendList.add(new Friend(FRIEND3_NAME, FRIEND3_IMAGE, 0, "Sand Diego CA", 42));
				}
				else if (selectedName.equals(FRIEND4_NAME)){
			     	friendList.add(new Friend(FRIEND4_NAME, FRIEND4_IMAGE, 45, "Derby CT", 35));
				}
				else if (selectedName.equals(FRIEND5_NAME)){
			     	friendList.add(new Friend(FRIEND5_NAME, FRIEND5_IMAGE, 63, "Louisville KY", 37));
				}
				else if (selectedName.equals(FRIEND6_NAME)){
			     	friendList.add(new Friend(FRIEND6_NAME, FRIEND6_IMAGE, 12, "Phoenix AZ", 74));
				}
				else {
					// TODO should throw an exception
				}
				
			}
			
		}
		
	}
	
}