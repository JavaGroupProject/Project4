import java.awt.Color;
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

public class InfoPanel extends JPanel {

	private MyApplet anApplet;
	
	private InfoPanel myPanel;
	
	private JLabel title = new JLabel("PERSONAL INFO");
	private JLabel name;
	private JLabel email;
	private JLabel birthday = new JLabel("Birthday: ");
	private JLabel address = new JLabel("Address: ");
	private JLabel phone = new JLabel("Phone number: ");
	private JLabel ssn = new JLabel("Social security number: ");
	private JLabel gender = new JLabel("Gender: ");
	private JLabel creditCard = new JLabel("Credit card: ");
	private JLabel school = new JLabel("School: ");
	private JLabel gradYear = new JLabel("Graduation year: ");
	
	private JButton addInfoButton;
		
	public InfoPanel(MyApplet thisApplet){
		
		this.anApplet = thisApplet;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(300, 360));
		setBackground(Color.WHITE);
		
		init();
		display();
		
		myPanel = this;
		
	}
	
	public void init(){
		
		name = new JLabel("Name: " + anApplet.getUser().getName());
		email = new JLabel("Email: " + anApplet.getUser().getEmail());
		addInfoButton = new JButton("Add Info");
		addInfoButton.addActionListener(new ButtonListener());
		title.setAlignmentX(CENTER_ALIGNMENT);
		name.setAlignmentX(CENTER_ALIGNMENT);
		email.setAlignmentX(CENTER_ALIGNMENT);
		addInfoButton.setAlignmentX(CENTER_ALIGNMENT);
		birthday.setAlignmentX(CENTER_ALIGNMENT);
		address.setAlignmentX(CENTER_ALIGNMENT);
		phone.setAlignmentX(CENTER_ALIGNMENT);
		ssn.setAlignmentX(CENTER_ALIGNMENT);
		gender.setAlignmentX(CENTER_ALIGNMENT);
		creditCard.setAlignmentX(CENTER_ALIGNMENT);
		school.setAlignmentX(CENTER_ALIGNMENT);
		gradYear.setAlignmentX(CENTER_ALIGNMENT);
		add(Box.createRigidArea(new Dimension(10,80)));
		
	}
	
	public void display(){
		
		UserInfo user = anApplet.getUser();
		
    	if (!(user.getBirthday()).equals("")){
    		birthday.setText("Birthday: " + user.getBirthday());
    	}
    	
    	if (!user.getAddress().equals("")){
    		address.setText("Address: " + user.getAddress());
    	}
    	
    	if (!user.getPhone().equals("")){
    		phone.setText("Phone number: " + user.getPhone());

    	}
    	
    	if (!user.getSsn().equals("")){
    		ssn.setText("Social security number: " + user.getSsn());

    	}
    	
    	if (!user.getGender().equals("")){
    		gender.setText("Gender: " + user.getGender());

    	}
    	
    	if (!user.getCreditCard().equals("")){
    		creditCard.setText("Credit card number: " + user.getCreditCard());

    	}
    	
    	if (!user.getSchool().equals("")){
    		school.setText("School: " + user.getSchool());

    	}
    	
    	if (!user.getGradYear().equals("")){
    		gradYear.setText("Graduation year: " + user.getGradYear());

    	}
    	
		add(title);
		add(name);
		add(email);
		add(birthday);
		add(address);
		add(phone);
		add(ssn);
		add(gender);
		add(creditCard);
		add(school);
		add(gradYear);
		add(addInfoButton);
		
	}
		
	class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e){
			
			UserInfo user = anApplet.getUser();

	    	// http://stackoverflow.com/questions/6555040/multiple-input-in-joptionpane-showinputdialog
        	// https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
        	JPanel optionPanel = new JPanel();
        	optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.Y_AXIS));
        	
        	optionPanel.add(new JLabel("Birthday:"));
        	JTextField birthdayField = new JTextField(20);
        	optionPanel.add(birthdayField);
        	optionPanel.add(new JLabel("Address:"));
        	JTextField addressField = new JTextField(20);
        	optionPanel.add(addressField);
        	optionPanel.add(new JLabel("Phone number:"));
        	JTextField phoneField = new JTextField(20);
        	optionPanel.add(phoneField);
        	optionPanel.add(new JLabel("Social security number:"));
        	JTextField ssnField = new JTextField(20);
        	optionPanel.add(ssnField);
        	optionPanel.add(new JLabel("Gender:"));
        	JTextField genderField = new JTextField(20);
        	optionPanel.add(genderField);
        	optionPanel.add(new JLabel("Credit card number:"));
        	JTextField creditCardField = new JTextField(20);
        	optionPanel.add(creditCardField);
        	optionPanel.add(new JLabel("School:"));
        	JTextField schoolField = new JTextField(20);
        	optionPanel.add(schoolField);
        	optionPanel.add(new JLabel("Graduation year:"));
        	JTextField gradYearField = new JTextField(20);
        	optionPanel.add(gradYearField);

        	
        	int result = JOptionPane.showConfirmDialog(anApplet, optionPanel, "Enter your information", 
        											   JOptionPane.OK_CANCEL_OPTION);
        	
            if (result == JOptionPane.OK_OPTION) {
            	// TODO need to figure out what to do with this information/what to do if it is empty
            	// set results boolean to true if all 3 of these fields aren't blank
            	String birthday = birthdayField.getText();
            	String address = addressField.getText();
            	String phone = phoneField.getText();
            	String ssn = ssnField.getText();
            	String gender = genderField.getText();
            	String creditCard = creditCardField.getText();
            	String school = schoolField.getText();
            	String gradYear = gradYearField.getText();
            	
            	if (birthday != null){
            		user.setBirthday(birthday);
            	}
            	
            	if (address != null){
            		user.setAddress(address);
            	}
            	
            	if (phone != null){
            		user.setPhone(phone);
            	}
            	
            	if (ssn != null){
            		user.setSsn(ssn);
            	}
            	
            	if (gender != null){
            		user.setGender(gender);
            	}
            	
            	if (creditCard != null){
            		user.setCreditCard(creditCard);
            	}
            	
            	if (school != null){
            		user.setSchool(school);
            	}
            	
            	if (gradYear != null){
            		user.setGradYear(gradYear);
            	}
            	
            	myPanel.display();
            	myPanel.revalidate();
            	myPanel.repaint();
            	
             }
			
		}
		
	}
	
}