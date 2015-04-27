import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class Canvas extends JPanel {

	// Frame object
	private OurController anApplet;
	
	// Store the spring layout
	private SpringLayout springLayout;
	
	// Image for background
	private Image backgroundImage;
	
	// Pull image url from bin
	URL backgroundURL = OurController.class.getResource("Canvas.png");
	URL postURL = OurController.class.getResource("PostButton.png");
	URL submitURL = OurController.class.getResource("SubmitButton.png");
	URL resultsURL = OurController.class.getResource("ResultsButton.png");
	
	// Store all of the elements that will appear on the canvas
	private JTextArea status;
	private JButton statusButton;
	private JButton resultsButton;
	
	private JScrollPane newsfeedScrollPane;
	private JPanel privacyPanel;
	private JPanel infoPanel;
	private JPanel friendsPanel;
	private JPanel picturesPanel;
	
	private Newsfeed newsfeed;
	
	// Constructor
	public Canvas(OurController thisApplet){
		
		this.anApplet = thisApplet;
		
		anApplet.getUser().addPicture("image1.jpg");
		anApplet.getUser().addPicture("image2.jpg");
		anApplet.getUser().addPicture("image3.jpg");
		anApplet.getUser().addPicture("image4.jpg");
		
		initCanvas();		
	}
	
	public void initCanvas(){
		
		// move the initialization of each element to its own method
		
		// initialize the spring layout
		springLayout = new SpringLayout();
        setLayout(springLayout);
        
        // Set background
  		try {
  			backgroundImage = ImageIO.read(backgroundURL);
  		} catch (IOException e1) {
  			// TODO Auto-generated catch block
  			e1.printStackTrace();
  		}
		
        // create the text area for posting a status
        status = new JTextArea(4, 26);
        status.setEditable(true);
        status.setLineWrap(true);
        status.setWrapStyleWord(true);
        JScrollPane statusScrollPane = new JScrollPane(status);
        
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, statusScrollPane,0,SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.NORTH, statusScrollPane, 120, SpringLayout.NORTH, this);
                
        add(statusScrollPane);
        
        
        // create the button to add the post to the newsfeed
                
        statusButton = new JButton();
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, statusButton,0,SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.NORTH, statusButton, 5, SpringLayout.SOUTH, statusScrollPane);
        
        statusButton.addActionListener(new StatusListener());
        
        statusButton.setOpaque(false);
        statusButton.setBorderPainted(false);
        statusButton.setContentAreaFilled(false);
    	ImageIcon post = new ImageIcon(postURL);
    	statusButton.setIcon(post);
        add(statusButton);
        
        // create a newsfeed object
		newsfeed = new Newsfeed(this);
		
		// create a scroll pane for the newsfeed
		newsfeedScrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
											 ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		newsfeedScrollPane.setViewportView(newsfeed);
		newsfeedScrollPane.setPreferredSize(new Dimension(320,505));
		
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, newsfeedScrollPane,0,SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.NORTH, newsfeedScrollPane, 5, SpringLayout.SOUTH, statusButton);
		
		add(newsfeedScrollPane);
		
		// https://docs.oracle.com/javase/tutorial/uiswing/components/applet.html#images
		// https://docs.oracle.com/javase/tutorial/uiswing/components/icon.html
		// https://docs.oracle.com/javase/tutorial/uiswing/components/icon.html#applet
		// picture is in bin file for the project
		String imageName = anApplet.getUser().getProfilePicture();
		URL imageURL = OurController.class.getResource(imageName);
		ImageIcon profpic = new ImageIcon(imageURL);
		
		// create an image icon for the profile picture
		// will need to change this
        //ImageIcon profpic = new ImageIcon("/Users/Zoe/Desktop/picture.png", "profile picture");
        
        // http://www.coderanch.com/t/331731/GUI/java/Resize-ImageIcon
        Image img = profpic.getImage();
        Image newimg = img.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
        profpic = new ImageIcon(newimg);
        
        JLabel profpicLabel = new JLabel(profpic);
        profpicLabel.setSize(new Dimension(150, 150));
        
        springLayout.putConstraint(SpringLayout.EAST, profpicLabel, -95,SpringLayout.WEST, statusScrollPane);
        springLayout.putConstraint(SpringLayout.NORTH, profpicLabel, 120, SpringLayout.NORTH, this);
        
        add(profpicLabel);
        
        privacyPanel = new PrivacyPanel(anApplet);
		
		springLayout.putConstraint(SpringLayout.EAST, privacyPanel, -20, SpringLayout.WEST, statusScrollPane);
        springLayout.putConstraint(SpringLayout.NORTH, privacyPanel, 50, SpringLayout.SOUTH, profpicLabel);
		
        add(privacyPanel);
        
        infoPanel = new InfoPanel(anApplet);
		
		springLayout.putConstraint(SpringLayout.EAST, infoPanel, -20, SpringLayout.WEST, statusScrollPane);
        springLayout.putConstraint(SpringLayout.NORTH, infoPanel, 100, SpringLayout.SOUTH, privacyPanel);
		
        add(infoPanel);
        
        friendsPanel = new FriendPanel(anApplet);
		
		springLayout.putConstraint(SpringLayout.WEST, friendsPanel, 20, SpringLayout.EAST, statusScrollPane);
        springLayout.putConstraint(SpringLayout.NORTH, friendsPanel, 180, SpringLayout.NORTH, this);
		
        add(friendsPanel);
        
        picturesPanel = new PicturesPanel(anApplet, newsfeed);
		
		springLayout.putConstraint(SpringLayout.WEST, picturesPanel, 20, SpringLayout.EAST, statusScrollPane);
        springLayout.putConstraint(SpringLayout.NORTH, picturesPanel, 60, SpringLayout.SOUTH, friendsPanel);
		
        add(picturesPanel);       
	}
	
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
					
				//newsfeed.addPicturePost();
				
				//newsfeed.addPicture("Caption for the picture.", "picture.png");
				
				//newsfeed.addLink("Congrats, you just won a free car!\nCLICK HERE");
				
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
