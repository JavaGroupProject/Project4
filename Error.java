import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Error extends JPanel{

	// Applet object
	private myApplet anApplet;
	
	// Determines Test Screen that called the error page
	Integer number;
	
	// Create the return button
	JButton returnButton = new JButton("RETURN");

	// Constructor
	public Error(myApplet thisApplet, int incomingTest) {

		// Set test screen
		number = incomingTest;

		// Pass in the applet
		this.anApplet = thisApplet;
	}
	
	// Sets the screen to return to
	public void setIncomingScreen(int incomingScreen){
		number = incomingScreen;
	}
	
	// Init
	public void initError(){
		
		// listener to take the user to the previous screen
		returnButton.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	anApplet.showNextTest(number);
		    }
		});
	}
	

}
