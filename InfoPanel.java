import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InfoPanel extends JPanel {

	private OurController aController;
	
	// store an object of itself so it can be revalidated in the action listener
	private InfoPanel myPanel;
	
	// constant to store the button image
	private final String UPDATE_BUTTON_IMAGE = "UpdateButton.png";
	
	// url for the button image
	private URL updateURL = OurController.class.getResource(UPDATE_BUTTON_IMAGE);
	
	// jlabels that will appear on the screen
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
	
	// text fields for the option pane
	private JTextField birthdayField;
	private JTextField addressField;
	private JTextField phoneField;
	private JTextField ssnField;
	private JTextField genderField;
	private JTextField creditCardField;
	private JTextField schoolField;
	private JTextField gradYearField;
	
	// button for adding more information
	private JButton addInfoButton;
		
	public InfoPanel(OurController thisController){
		
		this.aController = thisController;
		
		myPanel = this;
		
		// set the layout, size, and background
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(300, 200));
		setBackground(Color.WHITE);
		
		init();
		display();	
		
	}
	
	public void init(){
		
		// place the user's name and email on jlabels
		name = new JLabel("Name: " + aController.getUser().getName());
		email = new JLabel("Email: " + aController.getUser().getEmail());
		
		// set up the add info button
		addInfoButton = new JButton();
		addInfoButton.setOpaque(false);
		addInfoButton.setBorderPainted(false);
		addInfoButton.setContentAreaFilled(false);
    	ImageIcon post = new ImageIcon(updateURL);
    	addInfoButton.setIcon(post);
        add(addInfoButton);
		addInfoButton.addActionListener(new ButtonListener());
		
		// set the alignment of all the buttons on the screen
		setAlignment();
		
	}
	
	// set the alignment of all the elements that appear on the panel
	public void setAlignment(){
		
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
		
		// get the user object
		UserInfo user = aController.getUser();
		
		// add the user's info to jlabels only if the information is not empty
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
    	
    	// add all of the jlabels to the jpanel
		addLabels();
		
	}
	
	// add all of the labels to the panel
	public void addLabels(){
		
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
	
	public JPanel createOptionPanel(){
		
		// create a panel to be displayed on the option pane
    	// http://stackoverflow.com/questions/6555040/multiple-input-in-joptionpane-showinputdialog
    	// https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
    	JPanel optionPanel = new JPanel();
    	optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.Y_AXIS));
    	
    	// add a label and text field for each of the info elements
    	
    	// birthday
    	optionPanel.add(new JLabel("Birthday:"));
    	birthdayField = new JTextField(20);
    	optionPanel.add(birthdayField);
    	
    	// address
    	optionPanel.add(new JLabel("Address:"));
    	addressField = new JTextField(20);
    	optionPanel.add(addressField);
    	
    	// phone number
    	optionPanel.add(new JLabel("Phone number:"));
    	phoneField = new JTextField(20);
    	optionPanel.add(phoneField);
    	
    	// social security number
    	optionPanel.add(new JLabel("Social security number:"));
    	ssnField = new JTextField(20);
    	optionPanel.add(ssnField);
    	
    	// gender
    	optionPanel.add(new JLabel("Gender:"));
    	genderField = new JTextField(20);
    	optionPanel.add(genderField);
    	
    	// credit card number
    	optionPanel.add(new JLabel("Credit card number:"));
    	creditCardField = new JTextField(20);
    	optionPanel.add(creditCardField);
    	
    	// school
    	optionPanel.add(new JLabel("School:"));
    	schoolField = new JTextField(20);
    	optionPanel.add(schoolField);
    	
    	// graduation year
    	optionPanel.add(new JLabel("Graduation year:"));
    	gradYearField = new JTextField(20);
    	optionPanel.add(gradYearField);
		
    	return optionPanel;
    	
	}
	
	// listener for the add info button
	class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e){
			
			// get the user from the controller
			UserInfo user = aController.getUser();

			JPanel optionPanel = createOptionPanel();

        	// create the option pane and store the result
        	int result = JOptionPane.showConfirmDialog(aController, optionPanel, "Enter your information", 
        											   JOptionPane.OK_CANCEL_OPTION);
        	
        	// if the user pressed the "ok" option
            if (result == JOptionPane.OK_OPTION) {
            	// TODO need to update the results page
            	
            	// get the text from the textfields
            	String birthday = birthdayField.getText();
            	String address = addressField.getText();
            	String phone = phoneField.getText();
            	String ssn = ssnField.getText();
            	String gender = genderField.getText();
            	String creditCard = creditCardField.getText();
            	String school = schoolField.getText();
            	String gradYear = gradYearField.getText();
            	
            	// if the text fields aren't empty, then update the user's information
            	if (!birthday.equals("")){
            		user.setBirthday(birthday);
            	}
            	
            	if (!address.equals("")){
            		user.setAddress(address);
            	}
            	
            	if (!phone.equals("")){
            		user.setPhone(phone);
            	}
            	
            	if (!ssn.equals("")){
            		user.setSsn(ssn);
            	}
            	
            	if (!gender.equals("")){
            		user.setGender(gender);
            	}
            	
            	if (!creditCard.equals("")){
            		user.setCreditCard(creditCard);
            	}
            	
            	if (!school.equals("")){
            		user.setSchool(school);
            	}
            	
            	if (!gradYear.equals("")){
            		user.setGradYear(gradYear);
            	}
            	
            	// call the display method and then revalidate and repaint so that the new
            	// information shows up
            	myPanel.display();
            	myPanel.revalidate();
            	myPanel.repaint();
            	
             }
			
		}
		
	}
	
}