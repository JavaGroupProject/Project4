import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SpringLayout;

public class PasswordTest extends JPanel implements InterfaceTest {

	private CardTest cardtest;
	private SpringLayout layout;
	private JButton submitButton;
	private JPasswordField passwordField;
	private JPasswordField confirmField;
	private JLabel passwordLabel;
	private JLabel confirmLabel;
	private String password;
	private String confirmedPassword;
	
	public PasswordTest(CardTest cardtest){
		
		this.cardtest = cardtest;
		
		layout = new SpringLayout();
        setLayout(layout);
		
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
	        	
				CardLayout cardLayout = cardtest.getCardLayout();
				cardLayout.show(cardtest.getCards(), "card1");
	        	
	        }
	        
	        // otherwise should send to error page
			
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
