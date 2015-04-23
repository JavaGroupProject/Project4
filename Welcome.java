import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;


@SuppressWarnings("serial")
public class Welcome extends JPanel {

	// Frame object
	private MyApplet anApplet;
	
	// string with the teacher information
	private String msg = "WELCOME!";
	private JTextArea textArea;
		
	// Create buttons
	JButton forwardButton = new JButton("NEXT");
	JButton teacherButton = new JButton("Information for Instructors");
	
	// Constructor
	public Welcome(MyApplet thisApplet) {
		
		// Pass in the frame
		this.anApplet = thisApplet;
			
		// Initilize GUI
		initWelcome();
	}

	// Init
	private void initWelcome(){
		
		// Set layout
		setLayout(new BorderLayout());
		
		// Set Text area
		textArea = new JTextArea();
		textArea.setText(msg);
	    textArea.setEditable(false);
	    textArea.setWrapStyleWord(true);
	    textArea.setMargin(new Insets(20, 20, 20, 20));
		add(textArea, BorderLayout.CENTER);
		
		// Add button
		JPanel buttonsPanel = new JPanel(new BorderLayout());
		buttonsPanel.setBackground(Color.WHITE);
		buttonsPanel.add(forwardButton, BorderLayout.EAST);
		buttonsPanel.add(teacherButton, BorderLayout.WEST);
		add(buttonsPanel,BorderLayout.PAGE_END);
	
		// Listener to take user to first screen of lesson
		forwardButton.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	anApplet.showLesson1();
		    }
		});
		
		// Listener to take user to first screen of lesson
		teacherButton.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	anApplet.showTeacher();
		    }
		});
	}

}