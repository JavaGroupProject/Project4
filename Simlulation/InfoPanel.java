import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InfoPanel extends JPanel {

	private OurController anApplet;
	
	private InfoPanel myPanel;
	

	private URL updateURL = OurController.class.getResource("UpdateButton.png");
	
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
		
	public InfoPanel(OurController thisApplet){
		
		this.anApplet = thisApplet;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(300, 200));
		setBackground(Color.WHITE);
		
		init();
		display();
		
		myPanel = this;
		
	}
	
	public void init(){
		
		name = new JLabel("Name: " + anApplet.getUser().getName());
		email = new JLabel("Email: " + anApplet.getUser().getEmail());
		addInfoButton = new JButton();
		addInfoButton.setOpaque(false);
		addInfoButton.setBorderPainted(false);
		addInfoButton.setContentAreaFilled(false);
    	ImageIcon post = new ImageIcon(updateURL);
    	addInfoButton.setIcon(post);
        add(addInfoButton);
		
		addInfoButton.addActionListener(new ButtonListener());
		name.setAlignmentX(LEFT_ALIGNMENT);
		email.setAlignmentX(LEFT_ALIGNMENT);
		addInfoButton.setAlignmentX(CENTER_ALIGNMENT);
		birthday.setAlignmentX(LEFT_ALIGNMENT);
		address.setAlignmentX(LEFT_ALIGNMENT);
		phone.setAlignmentX(LEFT_ALIGNMENT);
		ssn.setAlignmentX(LEFT_ALIGNMENT);
		gender.setAlignmentX(LEFT_ALIGNMENT);
		creditCard.setAlignmentX(LEFT_ALIGNMENT);
		school.setAlignmentX(LEFT_ALIGNMENT);
		gradYear.setAlignmentX(LEFT_ALIGNMENT);
		
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