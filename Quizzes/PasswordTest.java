import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class PasswordTest extends JPanel implements MyQuestion {

	// Applet object
	private OurController anApplet;
	
	// Layout
	private SpringLayout layout;
	
	// Variable to hold screen number
	int number;
	
	// Button
	private JButton submitButton;
	private JButton returnButton = new JButton("BACK");
	
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
        
    	// Add button
		JPanel buttonsPanel = new JPanel(new BorderLayout());
		buttonsPanel.setBackground(Color.WHITE);
		buttonsPanel.add(returnButton, BorderLayout.WEST);
		add(buttonsPanel);
		
		// Adjust constraints for the panel
	    layout.putConstraint(SpringLayout.WEST, buttonsPanel, 3, SpringLayout.WEST, this);
	    layout.putConstraint(SpringLayout.NORTH, buttonsPanel, 700, SpringLayout.NORTH, this);
		
		// listener to take the user to the previous screen
		returnButton.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	anApplet.showNextLesson(4);
		    }
		});
		
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
	
	// need to add more testing here
	public Boolean isCorrect(){
		if (password.equals(confirmedPassword)){
			
			if (password.length() >= 8){
				return true;
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
		submitButton = new JButton("SUBMIT");
		submitButton.addActionListener(new TextListener());
		
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
	
}
