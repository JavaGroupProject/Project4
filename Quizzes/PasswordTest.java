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
import javax.swing.JPasswordField;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class PasswordTest extends JPanel implements MyQuestion {

	// Applet object
	private OurController anApplet;
	
	// Image for background
	private Image backgroundImage;
	
	// Get image URLs
	URL submitURL = OurController.class.getResource("Submit Button.png");
	URL backgroundURL = OurController.class.getResource("PaswordQuiz-01.png");
	
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
	
	// Constructor
	public PasswordTest(OurController thisApplet, int aNumber){
		
		this.anApplet = thisApplet;
		
		number = aNumber;
		
		layout = new SpringLayout();
        setLayout(layout);
        
		// Set background
		try {
			backgroundImage = ImageIO.read(backgroundURL);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
        setQuestion();
        setAnswer();
	}
	
	class TextListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e){
	        
			// http://stackoverflow.com/questions/983964/why-does-jpasswordfield-getpassword-create-a-string-with-the-password-in-it
			password = new String(passwordField.getPassword());
			confirmedPassword = new String(confirmField.getPassword());
			
	        boolean isGoodPassword = isCorrect();
	        
	        if (isGoodPassword){
	        	
				anApplet.showNextTest(number);
	        }
		}
	}
	
	public void getAnswer(){
		// this is done by the ActionListener
	}
	
	
	public Boolean isCorrect(){
		// check if the passwords match
        if (password.equals(confirmedPassword)){
            
            // check if password is long enough
            if (password.length() >= 8){
                
                boolean includesSymbol = false;
                boolean includesNumber = false;
                boolean includesUpperCase = false;
                boolean includesLowerCase = false;
                
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
                
                return includesSymbol && includesNumber && includesUpperCase && includesLowerCase;
            }	   
        } 
        return false;
    }

	
	public void setAnswer(){
	        
        passwordField = new JPasswordField(20);
        confirmField = new JPasswordField(20);
        
        // change these to be in relation to each other
        
        // http://stackoverflow.com/questions/21622148/how-can-i-center-align-a-component-with-springlayout
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, passwordField,0,SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, passwordField,-25, SpringLayout.VERTICAL_CENTER, this);
        
        // http://stackoverflow.com/questions/21622148/how-can-i-center-align-a-component-with-springlayout
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, confirmField,0,SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, confirmField,25, SpringLayout.VERTICAL_CENTER, this);
        
        add(passwordField);
        add(confirmField);
          
	}
	
	public void setQuestion(){
		
		passwordLabel = new JLabel("Enter password: ");
		confirmLabel = new JLabel("Confirm password: ");
		submitButton = new JButton();
		submitButton.addActionListener(new TextListener());
		
		// Add icon to submit button
		submitButton.setOpaque(false);
		submitButton.setBorderPainted(false);
		submitButton.setContentAreaFilled(false);
        ImageIcon submit = new ImageIcon(submitURL);
        submitButton.setIcon((submit));
		
		// change these to be in relation to each other
		
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, confirmLabel,0,SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, confirmLabel,0, SpringLayout.VERTICAL_CENTER, this);
		
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, passwordLabel,0,SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, passwordLabel,-25-25, SpringLayout.VERTICAL_CENTER, this);
		
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, submitButton,0,SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, submitButton,30+25, SpringLayout.VERTICAL_CENTER, this);
        
		add(submitButton);
        add(passwordLabel);
        add(confirmLabel);
        
	}
	
	// Paint the background
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this);
    }
	
}