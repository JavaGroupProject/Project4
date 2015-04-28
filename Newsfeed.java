import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Newsfeed extends JPanel {
	
	private OurController aController;
	
	// variables to help generate posts on the newsfeed
	private int newsfeedIndex = 0;
	private final int NEWSFEED_OPTIONS = 4;
	
	// array list to store the friends that the user has chosen
	private ArrayList<Friend> friends;
	
	// array list to store the text for all of the bad links
	private ArrayList<String> badLinks = new ArrayList<String>();
	
	// timer for generating posts
	private Timer timer;
	
	private final String BAD_LINKS_FILE = "badLinks.txt";
	private final String CLICK_HERE = "\nCLICK HERE";
	
	public Newsfeed(OurController controller){
		
		this.aController = controller;
		
		// get the user's friends
		friends = aController.getFriends();
		
		// adds a new picture post every 10 seconds
		timer = new Timer(10000, new timerListener());
	    timer.start();
		
	    // initialize the newsfeed
		initNewsfeed();
		
		// get the text for the bad links
		try {
			readBadLinks();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// initialize the newsfeed
	public void initNewsfeed(){
		
		// set the layout as a box layout
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// set the background color to white
		setBackground(Color.WHITE);
		
	}
	
	// stops the timer so posts aren't generated anymore
	public void stopTimer(){
		
		timer.stop();
		
	}
	
	// read the bad links text from the file in bin
	// Citation: http://www.tutorialspoint.com/javaexamples/applet_readfile.htm
	public void readBadLinks() throws FileNotFoundException, IOException {
		
		String line = null;
		
		// get the correct file
		URL url = Canvas.class.getResource(BAD_LINKS_FILE);
	    
		// read all of the lines from the file
	    InputStream in = url.openStream();
	    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	    while((line = reader.readLine()) != null){
	    	
	    	// add text that says click here to the bad link
	    	String newLink = line + CLICK_HERE;
	    	
	    	// add the complete text string to the bad links array
	    	badLinks.add(newLink);
	    }
		
	}
	
	// add a post to the newsfeed
	public void addPost(String text){
		
		// create a new text area
		JTextArea post = new JTextArea();
		
		// set the text to the string passed as an argument
		post.setText(text);
		
		// format the text area
		post.setEditable(false);
		post.setLineWrap(true);
		post.setWrapStyleWord(true);
		
		// create a scroll pane for the text area 
		JScrollPane scroll = new JScrollPane(post);
		
		// set the dimensions of the scroll pane
		scroll.setMaximumSize(new Dimension(300, 50));
		scroll.setMinimumSize(new Dimension(300, 50));
		scroll.setPreferredSize(new Dimension(300, 50));
		
		// add the scroll pane to the top of the newsfeed
		add(scroll, 0);
		
		// revalidate and repaint so that the new post appears on the screen
		revalidate();
		repaint();
		
	}
	
	// add a picture and caption to the newsfeed
	public void addPicture(String caption, String picture){
		
		// add a blank label to fix the spacing
		add(new JLabel("    "), 0);
		
		// TODO might be able to cut down on this code
		URL imageURL = Canvas.class.getResource(picture);
		ImageIcon image = new ImageIcon(imageURL);
        // http://www.coderanch.com/t/331731/GUI/java/Resize-ImageIcon
        Image img = image.getImage();
        Image newimg = img.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
        image = new ImageIcon(newimg);
        
        // create a jlabel with the image
        JLabel imageLabel = new JLabel(image);
        imageLabel.setSize(new Dimension(150,150));
        imageLabel.setAlignmentX(CENTER_ALIGNMENT);
        add(imageLabel, 0);
        
        // add a caption if one is provided
		if (!caption.equals("")){
			addPost(caption);
		}
		else {
			// revalidate and repaint so that the new post appears on the screen
			revalidate();
			repaint();
		}
		
	}
	
	// adds a bad link to the newsfeed
	public void addLink(String linkText){
		
		// create a new text area
		JTextArea linkPost = new JTextArea();
		
		// set the text to the string passed as an argument
		linkPost.setText(linkText);
		
		// format the text area
		linkPost.setEditable(false);
		linkPost.setLineWrap(true);
		linkPost.setWrapStyleWord(true);
		
		// add a mouse listener so that you can tell if the user has clicked on the bad link
		// http://stackoverflow.com/questions/10133366/how-to-clear-jtextfield-when-mouse-clicks-the-jtextfield
		linkPost.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	
            	// http://stackoverflow.com/questions/6555040/multiple-input-in-joptionpane-showinputdialog
            	// https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
            	JPanel optionPanel = new JPanel();
            	optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.Y_AXIS));
            	optionPanel.add(new JLabel("Name:"));
            	JTextField nameField = new JTextField(20);
            	optionPanel.add(nameField);
            	optionPanel.add(new JLabel("Email:"));
            	JTextField emailField = new JTextField(20);
            	optionPanel.add(emailField);
            	optionPanel.add(new JLabel("Address:"));
            	JTextField addressField = new JTextField(20);
            	optionPanel.add(addressField);
            	
            	int result = JOptionPane.showConfirmDialog(aController, optionPanel, "Enter your information", 
            											   JOptionPane.OK_CANCEL_OPTION);
            	
                if (result == JOptionPane.OK_OPTION) {
                	// TODO need to figure out what to do with this information/what to do if it is empty
                	String name = nameField.getText();
                	String email = emailField.getText();
                	String address = addressField.getText();
                    //System.out.println("name: " + nameField.getText());
                    //System.out.println("email: " + emailField.getText());
                    //System.out.println("address: " + addressField.getText());
                 }
            	
            }
        });
		
		// create a scroll pane for the text area 
		JScrollPane scroll = new JScrollPane(linkPost);
		
		// set the dimensions of the scroll pane
		scroll.setMaximumSize(new Dimension(300, 50));
		scroll.setMinimumSize(new Dimension(300, 50));
		scroll.setPreferredSize(new Dimension(300, 50));

		// add the scroll pane to the top of the newsfeed
		add(scroll, 0);
		
		// revalidate and repaint so that the new post appears on the screen
		revalidate();
		repaint();
		
	}
	
	// create a listener for the timer so that items are placed on the newsfeed
	// http://www.java2s.com/Tutorial/Java/0240__Swing/SwingTimers.htm
	class timerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
  			
			// Create a random number generator
  			// Citation: http://www.javapractices.com/topic/TopicAction.do?Id=62
  			Random numberGenerator = new Random();
  			switch(newsfeedIndex){
  				case 0: // text and picture
			  		// generate a random number from 0 to the size of the friends list - 1 
  					// (a valid index into the ArrayList)
			  		int randomIndex = numberGenerator.nextInt(friends.size());
			  			
			  		String caption = friends.get(randomIndex).getName() + " posted a photo: ";
			  		addPicture(caption, friends.get(randomIndex).getRandomPicture());
			  		break;
			  	case 1: // bad link			  		
			  		// generate a random number from 0 to the size of the bad links list - 1 
  					// (a valid index into the ArrayList)
			  		int randomLink = numberGenerator.nextInt(badLinks.size());
			  		
			  		addLink(badLinks.get(randomLink));
					break;
		  		case 2: // text			  		
			  		// generate a random number from 0 to the size of the friends list - 1 
  					// (a valid index into the ArrayList)
			  		int randomFriend = numberGenerator.nextInt(friends.size());
			  		
			  		String postText = friends.get(randomFriend).getName() + ": " 
			  						  + friends.get(randomFriend).getRandomMessage();
			  		addPost(postText);
			  		break;
			  	case 3:
			  		// does nothing, adds extra time before the next picture is displayed
			  		break;
			  	default:
			  		break;
  			}
  			
  			newsfeedIndex = (newsfeedIndex+1) % NEWSFEED_OPTIONS;

		}
	}
	
}