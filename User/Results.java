import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Results extends JPanel{
	private boolean nameCheck;	
	private boolean birthdayCheck;
	private boolean emailCheck;
	private boolean addressCheck;
	private boolean phoneCheck;
	private boolean ssnCheck;
	private boolean profPicCheck;
	
	
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
	
	public Results() {		
	
		if(nameCheck) {
			JTextArea textArea = new JTextArea(name1);
	        textArea.setEditable(false);
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        JScrollPane areaScrollPane = new JScrollPane(textArea);
	        areaScrollPane.setPreferredSize(new Dimension(300, 200));
		}
	
		if(birthdayCheck) {
			JTextArea textArea = new JTextArea(bd1);
	        textArea.setEditable(false);
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        JScrollPane areaScrollPane = new JScrollPane(textArea);
	        areaScrollPane.setPreferredSize(new Dimension(300, 200));
		}
		
		if(emailCheck) {
			JTextArea textArea = new JTextArea(email1);
	        textArea.setEditable(false);
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        JScrollPane areaScrollPane = new JScrollPane(textArea);
	        areaScrollPane.setPreferredSize(new Dimension(300, 200));
		}
		
		if(addressCheck) {
			JTextArea textArea = new JTextArea(address1);
	        textArea.setEditable(false);
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        JScrollPane areaScrollPane = new JScrollPane(textArea);
	        areaScrollPane.setPreferredSize(new Dimension(300, 200));
		}
		
		if(phoneCheck) {
			JTextArea textArea = new JTextArea(phone1);
	        textArea.setEditable(false);
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        JScrollPane areaScrollPane = new JScrollPane(textArea);
	        areaScrollPane.setPreferredSize(new Dimension(300, 200));
		}
		
		if(ssnCheck) {
			JTextArea textArea = new JTextArea(ssn1);
	        textArea.setEditable(false);
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        JScrollPane areaScrollPane = new JScrollPane(textArea);
	        areaScrollPane.setPreferredSize(new Dimension(300, 200));
		}
		
		if(profPicCheck) {
			JTextArea textArea = new JTextArea(pp1);
	        textArea.setEditable(false);
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        JScrollPane areaScrollPane = new JScrollPane(textArea);
	        areaScrollPane.setPreferredSize(new Dimension(300, 200));
		}
	}
}
