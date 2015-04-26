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

	private Canvas canvas;
	
	// variables to help generate posts on the newsfeed
	private int newsfeedIndex = 0;
	private final int NEWSFEED_OPTIONS = 4;
	
	// array list to store the friends that the user has chosen
	// information should be generated from the friends quiz
	private ArrayList<Friend> friends = new ArrayList<Friend>();
	
	// array list to store the text for all of the bad links
	private ArrayList<String> badLinks = new ArrayList<String>();
	
	public Newsfeed(Canvas canvas){
		
		// TODO this is just to test that the friends class works
		//Friend f = new Friend("Name", "profpic", 2, "location", 4);
		friends.add(new Friend("Name", "picture.png", 1, "location1", 100));
		friends.add(new Friend("Another Name", "image4.jpg", 2, "location2", 20));
		
		// adds a new picture post every 10 seconds
		Timer timer = new Timer(10000, new timerListener());
	    timer.start();
		
		// not sure if this is necessary
		this.canvas = canvas;
		
		initNewsfeed();
		
		try {
			readBadLinks();
			//loadMessagesURL();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void initNewsfeed(){
		
		// set the layout as a box layout
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// set the background color to white
		setBackground(Color.WHITE);
		
	}
	
	public void readBadLinks() throws FileNotFoundException, IOException {
		
		// http://www.tutorialspoint.com/javaexamples/applet_readfile.htm
		// this version of the method reads from a file placed in bin
		String line = null;
		URL url = Canvas.class.getResource("badLinks.txt");
	         
	    InputStream in = url.openStream();
	    BufferedReader bf = new BufferedReader(new InputStreamReader(in));
	    while((line = bf.readLine()) != null){
	    	
	    	// add text that says click here to the bad link
	    	String newLink = line + "\nCLICK HERE";
	    	
	    	// add the complete text string to the bad links array
	    	badLinks.add(newLink);
	    }
		
	}
	
	public void addPost(String text){
		
		//add(new JLabel("    "), 0);
		
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
		
		//scroll.setBorder(null);
		
		// add the scroll pane to the top of the newsfeed
		add(scroll, 0);
		
		// revalidate and repaint so that the new post appears on the screen
		revalidate();
		repaint();
		
	}
	
	public void addPicture(String caption, String picture){
		
		add(new JLabel("    "), 0);
		
		// also works to use MyApplet.class
		URL imageURL = Canvas.class.getResource(picture);
		ImageIcon image = new ImageIcon(imageURL);
		
		// need to figure out a better way to access the pictures
        //ImageIcon image = new ImageIcon("/Users/Zoe/Desktop/picture.png", "picture");
        
        // http://www.coderanch.com/t/331731/GUI/java/Resize-ImageIcon
        Image img = image.getImage();
        Image newimg = img.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
        image = new ImageIcon(newimg);
        
        JLabel imageLabel = new JLabel(image);
        imageLabel.setSize(new Dimension(150,150));
        
        imageLabel.setAlignmentX(CENTER_ALIGNMENT);
        
        add(imageLabel, 0);
        
		if (!caption.equals("")){
			addPost(caption);
		}
		else {
			// revalidate and repaint so that the new post appears on the screen
			revalidate();
			repaint();
		}
		
	}
		
	public void addLink(String linkText){
		
		// create a new text area
		JTextArea linkPost = new JTextArea();
		
		// set the text to the string passed as an argument
		linkPost.setText(linkText);
		
		// format the text area
		linkPost.setEditable(false);
		linkPost.setLineWrap(true);
		linkPost.setWrapStyleWord(true);
		
		// http://stackoverflow.com/questions/10133366/how-to-clear-jtextfield-when-mouse-clicks-the-jtextfield
		linkPost.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	
            	// TODO
            	// might need to have different looking panels depending on the post
            	// will also need to process the information differently (in the ok option if statement)
            	
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
            	
            	int result = JOptionPane.showConfirmDialog(canvas, optionPanel, "Enter your information", 
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
		
		//scroll.setBorder(null);

		// add the scroll pane to the top of the newsfeed
		add(scroll, 0);
		
		// revalidate and repaint so that the new post appears on the screen
		revalidate();
		repaint();
		
	}
	
	// http://www.java2s.com/Tutorial/Java/0240__Swing/SwingTimers.htm
	class timerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
  			
			// Create a random number generator
  			// Citation: http://www.javapractices.com/topic/TopicAction.do?Id=62
  			Random numberGenerator = new Random();
  			// need to alternate between posts from friends and bad links
  			// both can be with or without pictures
  			switch(newsfeedIndex){
  				case 0: // text and picture
  					System.out.println("text and picture");
  					
			  		// generate a random number from 0 to the size of the friends list - 1 
  					// (a valid index into the ArrayList)
			  		int randomIndex = numberGenerator.nextInt(friends.size());
			  			
			  		String caption = friends.get(randomIndex).getName() + " posted a photo: ";
			  		addPicture(caption, friends.get(randomIndex).getRandomPicture());
			  		break;
			  	case 1: // bad link
			  		System.out.println("add bad link");
			  		
			  		// generate a random number from 0 to the size of the bad links list - 1 
  					// (a valid index into the ArrayList)
			  		int randomLink = numberGenerator.nextInt(badLinks.size());
			  		
			  		addLink(badLinks.get(randomLink));
					break;
		  		case 2: // text
			  		System.out.println("add text");
			  		
			  		// generate a random number from 0 to the size of the friends list - 1 
  					// (a valid index into the ArrayList)
			  		int randomFriend = numberGenerator.nextInt(friends.size());
			  		
			  		String postText = friends.get(randomFriend).getName() + ": " 
			  						  + friends.get(randomFriend).getRandomMessage();
			  		addPost(postText);
			  		break;
			  	case 3: // ad?
			  		System.out.println("add something here");
			  		break;
			  	default: // error, should throw an exception
			  		break;
  			}
  			
  			// TODO cycle or generate a random number???
  			newsfeedIndex = (newsfeedIndex+1) % NEWSFEED_OPTIONS;

		}
	}
	
}