import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Results extends JPanel{
	
	private OurController aController;
	
	// TODO change back to private
	public boolean nameCheck = true;	
	public boolean birthdayCheck = false;
	public boolean emailCheck = true;
	public boolean addressCheck = false;
	public boolean phoneCheck = false;
	public boolean ssnCheck = false;
	public boolean profPicCheck = true;
	
	
	private static String name1 = "You have made your name public to other viewers";
	private static String bd1 = "You have made your birthday public to other viewers";
	private static String email1 = "You have made your email public to other viewers";
	private static String address1 = "You have made your address public to other viewers";
	private static String phone1 = "You have made your phone number public"
			+ " to other viewers.";
	private static String ssn1 = "You have made your social security numbers public"
			+ " to other viewers";
	private static String pp1 = "You have made your profile picture public to"
			+ " other viewers";
	
	public Results(OurController aController) {		
	
		this.aController = aController;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(Box.createRigidArea(new Dimension(10,100)));
		
		display();
	}
	
	public void display(){
		
		if(nameCheck) {
			JTextArea textArea = new JTextArea(name1);
	        textArea.setEditable(false);
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        JScrollPane areaScrollPane = new JScrollPane(textArea);
	        areaScrollPane.setMaximumSize(new Dimension(300, 50));
	        areaScrollPane.setAlignmentX(CENTER_ALIGNMENT);
	        add(areaScrollPane);
		}
	
		if(birthdayCheck) {
			JTextArea textArea = new JTextArea(bd1);
	        textArea.setEditable(false);
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        JScrollPane areaScrollPane = new JScrollPane(textArea);
	        areaScrollPane.setMaximumSize(new Dimension(300, 50));
	        areaScrollPane.setAlignmentX(CENTER_ALIGNMENT);
	        add(areaScrollPane);
		}
		
		if(emailCheck) {
			JTextArea textArea = new JTextArea(email1);
	        textArea.setEditable(false);
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        JScrollPane areaScrollPane = new JScrollPane(textArea);
	        areaScrollPane.setMaximumSize(new Dimension(300, 50));
	        areaScrollPane.setAlignmentX(CENTER_ALIGNMENT);
	        add(areaScrollPane);
		}
		
		if(addressCheck) {
			JTextArea textArea = new JTextArea(address1);
	        textArea.setEditable(false);
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        JScrollPane areaScrollPane = new JScrollPane(textArea);
	        areaScrollPane.setMaximumSize(new Dimension(300, 50));
	        areaScrollPane.setAlignmentX(CENTER_ALIGNMENT);
	        add(areaScrollPane);
		}
		
		if(phoneCheck) {
			JTextArea textArea = new JTextArea(phone1);
	        textArea.setEditable(false);
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        JScrollPane areaScrollPane = new JScrollPane(textArea);
	        areaScrollPane.setMaximumSize(new Dimension(300, 50));
	        areaScrollPane.setAlignmentX(CENTER_ALIGNMENT);
	        add(areaScrollPane);
		}
		
		if(ssnCheck) {
			JTextArea textArea = new JTextArea(ssn1);
	        textArea.setEditable(false);
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        JScrollPane areaScrollPane = new JScrollPane(textArea);
	        areaScrollPane.setMaximumSize(new Dimension(300, 50));
	        areaScrollPane.setAlignmentX(CENTER_ALIGNMENT);
	        add(areaScrollPane);
		}
		
		if(profPicCheck) {
			JTextArea textArea = new JTextArea(pp1);
	        textArea.setEditable(false);
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        JScrollPane areaScrollPane = new JScrollPane(textArea);
	        areaScrollPane.setMaximumSize(new Dimension(300, 50));
	        areaScrollPane.setAlignmentX(CENTER_ALIGNMENT);
	        add(areaScrollPane);
		}
		
	}
	
}
