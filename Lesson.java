import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Lesson extends JPanel{

	// Frame object
	private myApplet anApplet;
	
	// Variable to hold screen number
	Integer number;
			
	// Create buttons
	JButton forwardButton = new JButton("FORWARD");
	JButton returnButton = new JButton("RETURN");
	
	// Constructor
	public Lesson(myApplet thisApplet, int lessonNum) {
		
		// Set the screen number
		number = lessonNum;

		// Pass in the frame
		this.anApplet = thisApplet;
			
		// Initialize the GUI
		initLesson();
	}

	// Init
	public void initLesson(){
		
		// Set layout
		setLayout(new BorderLayout());
		setBackground(Color.BLUE);
		
		// Add Buttons
		add(forwardButton, BorderLayout.LINE_END);
		add(returnButton, BorderLayout.LINE_START);
	
		// Takes user to the next lesson
		forwardButton.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	anApplet.showNextLesson(number);
		    }
		});
		
		// Takes user to the previous lesson
		returnButton.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	anApplet.showPreviousLesson(number);
		    }
		});
	}
}
