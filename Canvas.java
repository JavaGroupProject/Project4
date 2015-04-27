import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.BoxLayout;
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

	// Frame object
	private MyApplet anApplet;
	
	// Store the spring layout
	private SpringLayout springLayout;
	
	// Store all of the elements that will appear on the canvas
	private JTextArea status;
	private JButton statusButton;
	private JScrollPane newsfeedScrollPane;
	private JPanel privacyPanel;
	private JPanel infoPanel;
	private JPanel friendsPanel;
	private JPanel picturesPanel;
	
	private Newsfeed newsfeed;
	
	// Constructor
	public Canvas(MyApplet thisApplet){
				
		this.anApplet = thisApplet;
		
		// TODO
		anApplet.getUser().setProfilePicture("image1.jpg");
		anApplet.getUser().setName("User Name");
		anApplet.getUser().setEmail("user@email.com");
		anApplet.getUser().addPicture("picture.png");
		anApplet.getUser().addPicture("image1.jpg");
		anApplet.getUser().addPicture("image2.jpg");
		anApplet.getUser().addPicture("image3.jpg");
		
		initCanvas();
		
	}
	
	public void initCanvas(){
				
		// move the initialization of each element to its own method
		
		// initialize the spring layout
		springLayout = new SpringLayout();
        setLayout(springLayout);
		
        // create the text area for posting a status
        status = new JTextArea(4, 26);
        //status.setSize(new Dimension(320, 100));
        status.setEditable(true);
        status.setLineWrap(true);
        status.setWrapStyleWord(true);
        JScrollPane statusScrollPane = new JScrollPane(status);
        
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, statusScrollPane,0,SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.NORTH, statusScrollPane, 120, SpringLayout.NORTH, this);
                
        add(statusScrollPane);
        
        
        // create the button to add the post to the newsfeed
                
        statusButton = new JButton("POST");
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, statusButton,0,SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.NORTH, statusButton, 5, SpringLayout.SOUTH, statusScrollPane);
        
        statusButton.addActionListener(new StatusListener());
        
        add(statusButton);
        
        // create a newsfeed object
		newsfeed = new Newsfeed(this);
		
		// create a scroll pane for the newsfeed
		newsfeedScrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
											 ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		newsfeedScrollPane.setViewportView(newsfeed);
		newsfeedScrollPane.setPreferredSize(new Dimension(320, 505));
		
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, newsfeedScrollPane,0,SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.NORTH, newsfeedScrollPane, 5, SpringLayout.SOUTH, statusButton);
		
		add(newsfeedScrollPane);
		
		// https://docs.oracle.com/javase/tutorial/uiswing/components/applet.html#images
		// https://docs.oracle.com/javase/tutorial/uiswing/components/icon.html
		// https://docs.oracle.com/javase/tutorial/uiswing/components/icon.html#applet
		// picture is in bin file for the project
		
		String imageName = anApplet.getUser().getProfilePicture();
		URL imageURL = MyApplet.class.getResource(imageName);
		ImageIcon profpic = new ImageIcon(imageURL);
		
		// create an image icon for the profile picture
		// will need to change this
        //ImageIcon profpic = new ImageIcon("/Users/Zoe/Desktop/picture.png", "profile picture");
        
        // http://www.coderanch.com/t/331731/GUI/java/Resize-ImageIcon
        Image img = profpic.getImage();
        Image newimg = img.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
        profpic = new ImageIcon(newimg);
        
        JLabel profpicLabel = new JLabel(profpic);
        profpicLabel.setSize(new Dimension(150,150));
        
        springLayout.putConstraint(SpringLayout.EAST, profpicLabel, -95,SpringLayout.WEST, statusScrollPane);
        springLayout.putConstraint(SpringLayout.NORTH, profpicLabel, 120, SpringLayout.NORTH, this);
        
        add(profpicLabel);
        
		privacyPanel = new PrivacyPanel(anApplet);
		/*privacyPanel.setPreferredSize(new Dimension(300, 210));
		privacyPanel.setBackground(Color.WHITE);
		
		privacyPanel.add(new JLabel("PRIVACY"), BorderLayout.CENTER);*/
		
		springLayout.putConstraint(SpringLayout.EAST, privacyPanel, -20, SpringLayout.WEST, statusScrollPane);
        springLayout.putConstraint(SpringLayout.NORTH, privacyPanel, 40, SpringLayout.SOUTH, profpicLabel);
		
        add(privacyPanel);
        
        infoPanel = new InfoPanel(anApplet);
		
		springLayout.putConstraint(SpringLayout.EAST, infoPanel, -20, SpringLayout.WEST, statusScrollPane);
        springLayout.putConstraint(SpringLayout.NORTH, infoPanel, 40, SpringLayout.SOUTH, privacyPanel);
		
        add(infoPanel);
        
        friendsPanel = new FriendPanel(anApplet);
        
		/*friendsPanel = new JPanel();
		friendsPanel.setPreferredSize(new Dimension(300, 295));
		friendsPanel.setBackground(Color.WHITE);
		
		friendsPanel.add(new JLabel("Friends"), BorderLayout.CENTER);*/
		
		springLayout.putConstraint(SpringLayout.WEST, friendsPanel, 20, SpringLayout.EAST, statusScrollPane);
        springLayout.putConstraint(SpringLayout.NORTH, friendsPanel, 120, SpringLayout.NORTH, this);
		
        add(friendsPanel);
        
        picturesPanel = new PicturesPanel(anApplet, newsfeed);
		/*picturesPanel = new JPanel();
		picturesPanel.setPreferredSize(new Dimension(300, 295));
		picturesPanel.setBackground(Color.WHITE);
		
		picturesPanel.add(new JLabel("Pictures"), BorderLayout.CENTER);*/
		
		springLayout.putConstraint(SpringLayout.WEST, picturesPanel, 20, SpringLayout.EAST, statusScrollPane);
        springLayout.putConstraint(SpringLayout.NORTH, picturesPanel, 20, SpringLayout.SOUTH, friendsPanel);
		
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
	
}
