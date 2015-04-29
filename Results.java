import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.text.DecimalFormat;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Results extends JPanel {
	
	// booleans to store what information was stored	
	public boolean birthdayCheck = false;
	public boolean addressCheck = false;
	public boolean phoneCheck = false;
	public boolean ssnCheck = false;
	public boolean genderCheck = false;
	public boolean creditCardCheck = false;
	public boolean schoolCheck = false;
	public boolean gradYearCheck = false;
	public boolean isProfilePublic = false;
	
	// strings to store the error messages
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
	private static String g1 = "You have made your gender public to other viewers";
	private static String cc1 = "You have made your credit card information public to other viewers";
	private static String s1 = "You have made your school public to other viewers";
	private static String grad1 = "You have made your graduation year public to other viewers";
	
	// integers to store the original height and width of the health bar
	private int healthBarWidth = 998;
	private int healthBarHeight = 29;
	
	private final int POINTS_PER_CHECK = 100;

	
	public Results() {	
		
		// set the layout
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// create a drawing object
        StatusBar statusBar = new StatusBar();
        
        // add extra space at the top of the file
        add(Box.createRigidArea(new Dimension(10,100)));
        
        // label for the health bar
        JLabel healthLabel = new JLabel("Profile Security Strength");
        healthLabel.setAlignmentX(CENTER_ALIGNMENT);
        add(healthLabel);
        
        // add the status bar
        add(statusBar);
		
        // add labels to tell the user what information they shared
        
        // name is always shared
	    JLabel nameMessage = new JLabel(name1);
	    nameMessage.setAlignmentX(CENTER_ALIGNMENT);
	    add(nameMessage);
	    add(new JLabel(" "));

	    // email is always shared
		JLabel emailMessage = new JLabel(email1);
		emailMessage.setAlignmentX(CENTER_ALIGNMENT);
	    add(emailMessage);
	    add(new JLabel(" "));
	    
	    // profile picture is always shared
	    JLabel profPicMessage = new JLabel(pp1);
	    profPicMessage.setAlignmentX(CENTER_ALIGNMENT);
	    add(profPicMessage);
	    add(new JLabel(" "));
	    
	    // check if birthday is shared publicly
		if(birthdayCheck && isProfilePublic){
	        
			// create a jlabel with a message about what info was shared and subtract points
	        JLabel birthdayMessage = new JLabel(bd1);
	        birthdayMessage.setAlignmentX(CENTER_ALIGNMENT);
	        add(birthdayMessage);
	        add(new JLabel(" "));
	        healthBarWidth = healthBarWidth-POINTS_PER_CHECK;
	    }

		// check if address is shared publicly
		if(addressCheck && isProfilePublic){
	        
			// create a jlabel with a message about what info was shared and subtract points
	        JLabel addressMessage = new JLabel(address1);
			addressMessage.setAlignmentX(CENTER_ALIGNMENT);
	        add(addressMessage);
	        add(new JLabel(" "));
	        healthBarWidth = healthBarWidth-POINTS_PER_CHECK;
		}
		
		// check if phone number is shared publicly
		if(phoneCheck && isProfilePublic){
	        
			// create a jlabel with a message about what info was shared and subtract points
	        JLabel phoneMessage = new JLabel(phone1);
			phoneMessage.setAlignmentX(CENTER_ALIGNMENT);
	        add(phoneMessage);
	        add(new JLabel(" "));
	        healthBarWidth = healthBarWidth-POINTS_PER_CHECK;
		}
		
		// check if ssn is shared publicly
		if(ssnCheck && isProfilePublic){
	        
			// create a jlabel with a message about what info was shared and subtract points
	        JLabel ssnMessage = new JLabel(ssn1);
			ssnMessage.setAlignmentX(CENTER_ALIGNMENT);
	        add(ssnMessage);
	        add(new JLabel(" "));
	        healthBarWidth = healthBarWidth-POINTS_PER_CHECK;
		}
		
		// / check if gender is shared publicly
		if(genderCheck && isProfilePublic){
	        
			// create a jlabel with a message about what info was shared and subtract points
	        JLabel genderMessage = new JLabel(g1);
			genderMessage.setAlignmentX(CENTER_ALIGNMENT);
	        add(genderMessage);
	        add(new JLabel(" "));
	        healthBarWidth = healthBarWidth-POINTS_PER_CHECK;
		}
		
		// check if credit card is shared publicly
		if(creditCardCheck && isProfilePublic){
	        
			// create a jlabel with a message about what info was shared and subtract points
	        JLabel creditCardMessage = new JLabel(cc1);
	        creditCardMessage.setAlignmentX(CENTER_ALIGNMENT);
	        add(creditCardMessage);
	        add(new JLabel(" "));
	        healthBarWidth = healthBarWidth-POINTS_PER_CHECK;
		}
		
		// check if school is shared publicly
		if(schoolCheck && isProfilePublic){
	        
			// create a jlabel with a message about what info was shared and subtract points
	        JLabel schoolMessage = new JLabel(s1);
	        schoolMessage.setAlignmentX(CENTER_ALIGNMENT);
	        add(schoolMessage);
	        add(new JLabel(" "));
	        healthBarWidth = healthBarWidth-POINTS_PER_CHECK;
		}
		
		// check if graduation year is shared publicly
		if(gradYearCheck && isProfilePublic){
	        
			// create a jlabel with a message about what info was shared and subtract points
	        JLabel gradYearMessage = new JLabel(grad1);
	        gradYearMessage.setAlignmentX(CENTER_ALIGNMENT);
	        add(gradYearMessage);
	        add(new JLabel(" "));
	        healthBarWidth = healthBarWidth-POINTS_PER_CHECK;
		}
			
        //Compute profile security strength in percentage
        double nW = (double) healthBarWidth+2;
        double per = (nW/StatusBar.SCREEN_WIDTH)*100;
        //Now round to 2 decimal places
        String twoDec = new DecimalFormat("#0.00").format(per);
        
        // create a jlabel for the percentage
        JLabel percentage = new JLabel("Profile Strength: " + twoDec + "%");
        percentage.setAlignmentX(CENTER_ALIGNMENT);
        add(percentage);
	}

	// class for the status bar
    class StatusBar extends JPanel {
    	
    	private static final int SCREEN_WIDTH = 1000;
    	private final int PANEL_HEIGHT = 35;
    	private final int STATUS_BAR_WIDTH = 998;
    	private final int STATUS_BAR_HEIGHT = 30;
    	
    	// Constructor
    	public StatusBar(){
    		
    		// set the size of the jpanel
    		setPreferredSize(new Dimension(SCREEN_WIDTH, PANEL_HEIGHT));
    		setMaximumSize(new Dimension(SCREEN_WIDTH, PANEL_HEIGHT));
    		setMinimumSize(new Dimension(SCREEN_WIDTH, PANEL_HEIGHT));
    		
    	}
    	
    	// paint method
        public void paintComponent(Graphics g) {
        	
        	super.paintComponent(g); 
        	
        	// draw the rectangle for the outline
        	g.drawRect(0,  0, STATUS_BAR_WIDTH, STATUS_BAR_HEIGHT);
        	
        	// set the color to green if the bar is less than half the width of the screen
        	if (healthBarWidth >= SCREEN_WIDTH/2){
        		g.setColor(Color.green);
        	}
        	else { // otherwise set the color to red
        		g.setColor(Color.red);
        	}
        	
        	// draw the rectangle for the status bar
        	g.fillRect(1, 1, healthBarWidth, healthBarHeight);
        	
        }
    }
	
}
