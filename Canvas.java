import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class Canvas extends JPanel {

	// OurController object
	private OurController aController;
	
	// Store the spring layout
	private SpringLayout springLayout;
	
	// Image for background
	private Image backgroundImage;
	
	// constants to store the images
	private final String CANVAS_BACKGROUND = "Canvas.png";
	private final String POST_BUTTON_IMAGE = "PostButton.png";
	private final String SUBMIT_BUTTON_IMAGE = "SubmitButton.png";
	private final String RESULTS_BUTTON_IMAGE = "ResultsButton.png";
	
	// Pull image url from bin
	URL backgroundURL = OurController.class.getResource(CANVAS_BACKGROUND);
	URL postURL = OurController.class.getResource(POST_BUTTON_IMAGE);
	URL submitURL = OurController.class.getResource(SUBMIT_BUTTON_IMAGE);
	URL resultsURL = OurController.class.getResource(RESULTS_BUTTON_IMAGE);
	
	// Store all of the elements that will appear on the canvas
	private JTextArea status;
	private JButton statusButton;
	private JButton resultsButton;
	private JScrollPane newsfeedScrollPane;
	private JScrollPane statusScrollPane;
	private JPanel privacyPanel;
	private JPanel infoPanel;
	private JPanel friendsPanel;
	private JPanel picturesPanel;
	private JLabel profpicLabel;
	
	// store the newsfeed object
	private Newsfeed newsfeed;
	
	// Constructor
	public Canvas(OurController thisController){
		
		this.aController = thisController;
		
		// initialize the users pictures and the canvas
		initUserPictures();
		initCanvas();	
	
	}
	
	public void initUserPictures(){
		
		// TODO add correct pictures
		aController.getUser().addPicture("image1.jpg");
		aController.getUser().addPicture("image2.jpg");
		aController.getUser().addPicture("image3.jpg");
		aController.getUser().addPicture("image4.jpg");
		
	}
	
	public void initCanvas(){
		
		// initialize the spring layout
		springLayout = new SpringLayout();
        setLayout(springLayout);
        
        // Set background
  		try {
  			backgroundImage = ImageIO.read(backgroundURL);
  		} catch (IOException e1) {
  			e1.printStackTrace();
  		}
		
        // create the text area for posting a status
        status = new JTextArea(4, 26);
        status.setEditable(true);
        status.setLineWrap(true);
        status.setWrapStyleWord(true);
        statusScrollPane = new JScrollPane(status);        
        
        // create the button to add the post to the newsfeed      
        statusButton = new JButton();
        statusButton.addActionListener(new StatusListener());
        statusButton.setOpaque(false);
        statusButton.setBorderPainted(false);
        statusButton.setContentAreaFilled(false);
    	ImageIcon post = new ImageIcon(postURL);
    	statusButton.setIcon(post);
        
        // create a newsfeed object and create a scroll pane for it
		newsfeed = new Newsfeed(aController);
		newsfeedScrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
											 ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		newsfeedScrollPane.setViewportView(newsfeed);
		newsfeedScrollPane.setPreferredSize(new Dimension(320,505));
		
		// References for dealing with image icons
		// https://docs.oracle.com/javase/tutorial/uiswing/components/applet.html#images
		// https://docs.oracle.com/javase/tutorial/uiswing/components/icon.html
		// https://docs.oracle.com/javase/tutorial/uiswing/components/icon.html#applet
		// http://www.coderanch.com/t/331731/GUI/java/Resize-ImageIcon
		
		// add the user's profile picture
		String imageName = aController.getUser().getProfilePicture();
		URL imageURL = OurController.class.getResource(imageName);
		ImageIcon profpic = new ImageIcon(imageURL);        
        profpicLabel = new JLabel(profpic);
        profpicLabel.setSize(new Dimension(150, 150));         
        
        // create the privacy panel
        privacyPanel = new PrivacyPanel(aController);
               
        // create the info panel
        infoPanel = new InfoPanel(aController);
        
        // create the friends panel
        friendsPanel = new FriendPanel(aController);
        
        // create the pictures panel
        picturesPanel = new PicturesPanel(aController, newsfeed);    
        
        // create the results button
        resultsButton = new JButton("RESULTS");
        resultsButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		// stop the timer so content is no longer generated on the newsfeed
        		newsfeed.stopTimer();
        		aController.showResults();
        	}
        });
        
        // set the constraints
        setAllSpringConstraints();
        
        // add everything to the canvas
        addToCanvas();
        
	}
	
	// sets the constraints for all of the elements that need to be added to the jpanel
	public void setAllSpringConstraints(){
		
		// status
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, statusScrollPane,0,SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.NORTH, statusScrollPane, 120, SpringLayout.NORTH, this);
        
        // status post button
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, statusButton,0,SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.NORTH, statusButton, 5, SpringLayout.SOUTH, statusScrollPane);
        
        // newsfeed
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, newsfeedScrollPane,0,SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.NORTH, newsfeedScrollPane, 5, SpringLayout.SOUTH, statusButton);
        
        // profile picture
        springLayout.putConstraint(SpringLayout.EAST, profpicLabel, -95,SpringLayout.WEST, statusScrollPane);
        springLayout.putConstraint(SpringLayout.NORTH, profpicLabel, 120, SpringLayout.NORTH, this);
        
        // privacy panel
		springLayout.putConstraint(SpringLayout.EAST, privacyPanel, -20, SpringLayout.WEST, statusScrollPane);
        springLayout.putConstraint(SpringLayout.NORTH, privacyPanel, 50, SpringLayout.SOUTH, profpicLabel);
        
        // info panel
		springLayout.putConstraint(SpringLayout.EAST, infoPanel, -20, SpringLayout.WEST, statusScrollPane);
        springLayout.putConstraint(SpringLayout.NORTH, infoPanel, 100, SpringLayout.SOUTH, privacyPanel);
        
        // friends panel
		springLayout.putConstraint(SpringLayout.WEST, friendsPanel, 20, SpringLayout.EAST, statusScrollPane);
        springLayout.putConstraint(SpringLayout.NORTH, friendsPanel, 180, SpringLayout.NORTH, this);
        
        // pictures panel
		springLayout.putConstraint(SpringLayout.WEST, picturesPanel, 20, SpringLayout.EAST, statusScrollPane);
        springLayout.putConstraint(SpringLayout.NORTH, picturesPanel, 60, SpringLayout.SOUTH, friendsPanel);
        
        // results button
        springLayout.putConstraint(SpringLayout.WEST, resultsButton, 900, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.NORTH, resultsButton, 0, SpringLayout.NORTH, this);
        
	}
	
	// adds all of the elements to the jpanel
	public void addToCanvas(){
		
		add(statusScrollPane);
        add(statusButton);
        add(newsfeedScrollPane);
        add(profpicLabel);
        add(privacyPanel);
        add(infoPanel);
        add(friendsPanel);
        add(picturesPanel); 
        add(resultsButton);
		
	}
	
	// method to display updated elements on the screen
	public void display(){
		
		// reset the user's profile picture in case it was changed
		String imageName = aController.getUser().getProfilePicture();
		URL imageURL = OurController.class.getResource(imageName);
		ImageIcon profpic = new ImageIcon(imageURL);
        profpicLabel.setIcon(profpic);
		
        // redisplay the info, friends, and pictures panel in case they have been updated
        infoPanel.revalidate();
        infoPanel.repaint();
        
        friendsPanel.revalidate();
        friendsPanel.repaint();
        
        picturesPanel.revalidate();
        picturesPanel.repaint();
        
	}
	
	// listener to help post a status
	class StatusListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e){
			
			// string to store the text to post on the newsfeed
			String postText = status.getText();
			
			// only post if there is actually text in the post
			if (!postText.equals("")){
				
				// add to the postText so the user can tell that they posted the message
				postText = "You: " + postText;
				
				// call the addPost method from the Newsfeed class
				newsfeed.addPost(postText);
				
				// clear the post text area
				// http://stackoverflow.com/questions/15798532/how-to-clear-jtextarea
				status.setText(null);
				status.revalidate();
				status.repaint();
				
			}
		}		
	}
	
	// Paint the background
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this);
    }
	
}
