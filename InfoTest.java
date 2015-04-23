import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/BoxLayoutDemoProject/src/layout/BoxLayoutDemo.java

public class InfoTest extends JPanel implements InterfaceTest {

	private CardTest cardtest;
	private JButton submitButton;
	
	private JLabel nameLabel;
	private JLabel birthdayLabel;
	private JLabel emailLabel;
	private JLabel addressLabel;
	private JLabel phoneLabel;
	private JLabel ssnLabel;
	
	private JTextField nameField;
	private JTextField birthdayField;
	private JTextField emailField;
	private JTextField addressField;
	private JTextField phoneField;
	private JTextField ssnField;
	
	public InfoTest(CardTest cardtest){
		
		this.cardtest = cardtest;
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        /*nameLabel = new JLabel("Full name: ");
		birthdayLabel = new JLabel("Birthday:");
		emailLabel = new JLabel("Email: ");
		addressLabel = new JLabel("Address: ");
		phoneLabel = new JLabel("Phone number: ");
		ssnLabel = new JLabel("Social security number: ");
		
		nameField = new JTextField(20);
		birthdayField = new JTextField(20);
		emailField = new JTextField(20);
		addressField = new JTextField(20);
		phoneField = new JTextField(20);
		ssnField = new JTextField(20);
				
		nameLabel.setAlignmentX(CENTER_ALIGNMENT);
		birthdayLabel.setAlignmentX(CENTER_ALIGNMENT);
		emailLabel.setAlignmentX(CENTER_ALIGNMENT);
		addressLabel.setAlignmentX(CENTER_ALIGNMENT);
		phoneLabel.setAlignmentX(CENTER_ALIGNMENT);
		ssnLabel.setAlignmentX(CENTER_ALIGNMENT);
		
		nameField.setMaximumSize(new Dimension(300,30));
		birthdayField.setMaximumSize(new Dimension(300,30));
		emailField.setMaximumSize(new Dimension(300,30));
		addressField.setMaximumSize(new Dimension(300,30));
		phoneField.setMaximumSize(new Dimension(300,30));
		ssnField.setMaximumSize(new Dimension(300,30));*/
		
        System.out.println(cardtest.getHeight());
        
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
		
	}
	
	public void getAnswer(){
		// this is done by the action listener
	}
	
	public Boolean isCorrect(){
		
        String name = nameField.getText();
        String birthday = birthdayField.getText();
        String email = emailField.getText();
        String address = addressField.getText();
        String phone = phoneField.getText();
        String ssn = ssnField.getText();
        
        if(!name.equals("") && birthday.equals("") && !email.equals("") && address.equals("") &&
           phone.equals("") && ssn.equals("")){
        	
        	return true;
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
		
        nameLabel = new JLabel("Full name: ");
		birthdayLabel = new JLabel("Birthday:");
		emailLabel = new JLabel("Email: ");
		addressLabel = new JLabel("Address: ");
		phoneLabel = new JLabel("Phone number: ");
		ssnLabel = new JLabel("Social security number: ");
		
		nameLabel.setAlignmentX(CENTER_ALIGNMENT);
		birthdayLabel.setAlignmentX(CENTER_ALIGNMENT);
		emailLabel.setAlignmentX(CENTER_ALIGNMENT);
		addressLabel.setAlignmentX(CENTER_ALIGNMENT);
		phoneLabel.setAlignmentX(CENTER_ALIGNMENT);
		ssnLabel.setAlignmentX(CENTER_ALIGNMENT);
		
	}
	
	class TextListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e){

			boolean isInfoCorrect = isCorrect();
			
			if (isInfoCorrect){
								
				CardLayout cardLayout = cardtest.getCardLayout();
				cardLayout.show(cardtest.getCards(), "card6");
				
			}
			
			// otherwise go to error page
			
		}
		
	}
	
}
