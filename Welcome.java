import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Welcome extends JPanel {

	// Frame object
	private myApplet anApplet;
		
	// Create buttons
	JButton forwardButton = new JButton("FORWARD");
	
	// Constructor
	public Welcome(myApplet thisApplet) {
		
		// Pass in the frame
		this.anApplet = thisApplet;
			
		// Initilize GUI
		initWelcome();
	}

	// Init
	private void initWelcome(){
		
		// Set layout
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.BLACK);
		
		// Set button
		forwardButton.setAlignmentX(RIGHT_ALIGNMENT);
		add(forwardButton);
	
		// Listener to take user to first screen of lesson
		forwardButton.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	anApplet.showLesson1();
		    }
		});
	}

}
