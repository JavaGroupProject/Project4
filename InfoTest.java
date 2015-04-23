import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

// https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/BoxLayoutDemoProject/src/layout/BoxLayoutDemo.java

@SuppressWarnings("serial")
public class InfoTest extends JPanel implements MyQuestion {

	// Applet object
	private MyApplet anApplet;
	
	// Variable to hold screen number
	int number;
	
	// Button to submit
	private JButton submitButton;
	
	// Labels for user info
	private JLabel nameLabel;
	private JLabel birthdayLabel;
	private JLabel emailLabel;
	private JLabel addressLabel;
	private JLabel phoneLabel;
	private JLabel ssnLabel;
	private JLabel required;
	
	// Fields for user info
	private JTextField nameField;
	private JTextField birthdayField;
	private JTextField emailField;
	private JTextField addressField;
	private JTextField phoneField;
	private JTextField ssnField;
	
	// Constructor
	public InfoTest(MyApplet thisApplet, int aNumber){

		// Set the applet
		this.anApplet = thisApplet;
		
		// Set the screen number
		number = aNumber;
        
		// Set the layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        setQuestion();
        setAnswer();
        
		submitButton = new JButton("SUBMIT");
		submitButton.addActionListener(new TextListener());
		submitButton.setAlignmentX(CENTER_ALIGNMENT);
		
		add(Box.createRigidArea(new Dimension(10,500/6)));
        add(nameLabel);
        add(nameField);
        add(birthdayLabel);
        add(birthdayField);
        add(emailLabel);
        add(emailField);
        add(addressLabel);
        add(addressField);
        add(phoneLabel);
        add(phoneField);
        add(ssnLabel);
        add(ssnField);
        add(submitButton);
        add(required);
		
	}
	
	public void getAnswer(){
		// this is done by the action listener
	}
	
	public Boolean isCorrect(){
		
        String name = nameField.getText();
//        String birthday = birthdayField.getText();
        String email = emailField.getText();
//        String address = addressField.getText();
//        String phone = phoneField.getText();
//        String ssn = ssnField.getText();
        
        if(!name.equals("") && !email.equals("")){
        	
        	return true;
        	
        }else{
        	// https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
        	JOptionPane.showMessageDialog(anApplet,
        		    "Please provide some information before proceeding.",
        		    "Error",
        		    JOptionPane.ERROR_MESSAGE);
        }
		
		return false;
	}
	
	public void setAnswer(){
		
		nameField = new JTextField(20);
		birthdayField = new JTextField(20);
		emailField = new JTextField(20);
		addressField = new JTextField(20);
		phoneField = new JTextField(20);
		ssnField = new JTextField(20);
		
		nameField.setMaximumSize(new Dimension(300,30));
		birthdayField.setMaximumSize(new Dimension(300,30));
		emailField.setMaximumSize(new Dimension(300,30));
		addressField.setMaximumSize(new Dimension(300,30));
		phoneField.setMaximumSize(new Dimension(300,30));
		ssnField.setMaximumSize(new Dimension(300,30));
		
	}
	
	public void setQuestion(){
		
        nameLabel = new JLabel("*Name: ");
		birthdayLabel = new JLabel("Birthday:");
		emailLabel = new JLabel("*Email: ");
		addressLabel = new JLabel("Address: ");
		phoneLabel = new JLabel("Phone number: ");
		ssnLabel = new JLabel("Social security number: ");
		
		required = new JLabel("* Required information");
		
		nameLabel.setAlignmentX(CENTER_ALIGNMENT);
		birthdayLabel.setAlignmentX(CENTER_ALIGNMENT);
		emailLabel.setAlignmentX(CENTER_ALIGNMENT);
		addressLabel.setAlignmentX(CENTER_ALIGNMENT);
		phoneLabel.setAlignmentX(CENTER_ALIGNMENT);
		ssnLabel.setAlignmentX(CENTER_ALIGNMENT);
		required.setAlignmentX(CENTER_ALIGNMENT);
		
	}
	
	class TextListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e){

			boolean isInfoCorrect = isCorrect();
			
			if (isInfoCorrect){
								
				anApplet.showNextTest(number);				
			}
		}		
	}	
}
