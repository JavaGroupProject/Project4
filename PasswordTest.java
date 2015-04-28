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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class PasswordTest extends JPanel implements MyQuestion {

	// Applet object
	private OurController aController;
	
	// Image for background
	private Image backgroundImage;
	
	// constants to store the images
	private final String SUBMIT_BUTTON_IMAGE = "Submit Button.png";
	private final String PASSWORD_QUIZ_IMAGE = "PaswordQuiz-01.png";
	
	// constants for the spring layout spacing
	private final int NO_SPACE = 0;
	private final int SPACING = 25;
	private final int PASSWORD_SPACING = -50;
	private final int SUBMIT_SPACING = 55;
	private final int FIELD_LENGTH = 20;
	
	// Get image URLs
	URL submitURL = OurController.class.getResource(SUBMIT_BUTTON_IMAGE);
	URL backgroundURL = OurController.class.getResource(PASSWORD_QUIZ_IMAGE);
	
	// Layout
	private SpringLayout layout;
	
	// Variable to hold screen number
	int number;
	
	// Button
	private JButton submitButton;
	
	// Fields
	private JPasswordField passwordField;
	private JPasswordField confirmField;
	
	// Labels
	private JLabel passwordLabel;
	private JLabel confirmLabel;
	
	// Strings
	private String password;
	private String confirmedPassword;
	private boolean matching = false;
	private boolean length = false;
	private boolean includesSymbol = false;
	private boolean includesNumber = false;
	private boolean includesUpperCase = false;
	private boolean includesLowerCase = false;
	
	// Constructor
	public PasswordTest(OurController thisApplet, int aNumber){
		
		this.aController = thisApplet;
		
		number = aNumber;
		
		// Set the layout
		layout = new SpringLayout();
        setLayout(layout);
        
		// Set background
		try {
			backgroundImage = ImageIO.read(backgroundURL);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// set the questions and answers
        setQuestion();
        setAnswer();
	}
	
	// Listener for the password text fields
	class TextListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e){
	        
			// get the text from each of the password fields
			// http://stackoverflow.com/questions/983964/why-does-jpasswordfield-getpassword-create-a-string-with-the-password-in-it
			password = new String(passwordField.getPassword());
			confirmedPassword = new String(confirmField.getPassword());
			
			// check if the password is correct
	        boolean isGoodPassword = isCorrect();
	        
	        // if the required info is entered
	        if(isGoodPassword){
	        	
	        	aController.showNextTest(number);
	        	
	        }
	        else{
	        	isCorrect();
        	
	        	// use an option pane to show the user what they did wrong
	        	// https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
	        	JOptionPane.showMessageDialog(aController, getErrorMessage(), "Error", 
	        								  JOptionPane.ERROR_MESSAGE);
	        }
	        
		}
	}
	
	@Override
	public Boolean isCorrect(){
		// check if the passwords match
        if (password.equals(confirmedPassword)){
        	matching = true;
        }
            
        // check if password is long enough
        if (password.length() >= 8){
        	length = true;
        }
                
        // check if password contains a symbol, number, upper case letter, and lower case letter
        for (int i = 0; i < password.length(); i++){
            
            char thisChar = password.charAt(i);
            
            // symbols
            if ((thisChar >= 32 && thisChar <= 47) || (thisChar >= 58 && thisChar <= 64) ||
                (thisChar >= 91 && thisChar <= 96) || (thisChar >= 123 && thisChar <= 126)){
                includesSymbol = true;
            }
            // numbers
            else if (thisChar >= 48 && thisChar <= 57){
                includesNumber = true;
            }
            // upper case letters
            else if (thisChar >= 65 && thisChar <= 90){
                includesUpperCase = true;
            }
            // lower case letters
            else {
                includesLowerCase = true;
            }   
        }
                
       return matching && length && includesSymbol && includesNumber && includesUpperCase && includesLowerCase;
    }

	@Override
	public void setAnswer(){
	    
		// create two password fields
        passwordField = new JPasswordField(FIELD_LENGTH);
        confirmField = new JPasswordField(FIELD_LENGTH);
        
        // place the two password fields on the screen
        // http://stackoverflow.com/questions/21622148/how-can-i-center-align-a-component-with-springlayout
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, passwordField, NO_SPACE,SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, passwordField,-SPACING, SpringLayout.VERTICAL_CENTER, this);
        
        // http://stackoverflow.com/questions/21622148/how-can-i-center-align-a-component-with-springlayout
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, confirmField, NO_SPACE,SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, confirmField,SPACING, SpringLayout.VERTICAL_CENTER, this);
        
        // add the password fields to the screen
        add(passwordField);
        add(confirmField);
          
	}
	
	@Override
	public void setQuestion(){
		
		// create labels for the passwords
		passwordLabel = new JLabel("Enter password: ");
		confirmLabel = new JLabel("Confirm password: ");
		
		// create a submit button
		submitButton = new JButton();
		submitButton.addActionListener(new TextListener());
		
		// Add icon to submit button
		submitButton.setOpaque(false);
		submitButton.setBorderPainted(false);
		submitButton.setContentAreaFilled(false);
        ImageIcon submit = new ImageIcon(submitURL);
        submitButton.setIcon((submit));
		
        // place the labels and the submit button
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, confirmLabel,NO_SPACE,SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, confirmLabel,NO_SPACE, SpringLayout.VERTICAL_CENTER, this);
		
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, passwordLabel,NO_SPACE,SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, passwordLabel,PASSWORD_SPACING, SpringLayout.VERTICAL_CENTER, this);
		
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, submitButton,NO_SPACE,SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, submitButton,SUBMIT_SPACING, SpringLayout.VERTICAL_CENTER, this);
        
        // add the labels and the submit button to the screen
		add(submitButton);
        add(passwordLabel);
        add(confirmLabel);
        
	}
	
	// get the error message to be displayed for the user
	private String getErrorMessage(){
		
		String error = "";
		
		// add the correct text based on the errors that the users have
		if(!matching){
			error += ("Passwords do not match.\n");
		}
		if(!length){
			error += ("Password is not long enough.\n");
		}
		if(!includesSymbol){
			error += ("Password must inlcude a special character.\n");
		}
		if(!includesNumber){
			error += ("Password must include a number.\n");
		}
		if(!includesUpperCase || !includesLowerCase){
			error += ("Password must include both upper and lower case characters.\n");
		}
		
		return error;
	}
	
	// Paint the background
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, NO_SPACE, NO_SPACE, this);
    }
	
}
