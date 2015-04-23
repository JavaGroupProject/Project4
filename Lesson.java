import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Lesson extends JPanel{

	// Frame object
	private MyApplet anApplet;
	
	// Variable to hold screen number
	Integer number;
	
	// String with the lesson information
	private String msg;
	
	// Area for the text
	private JTextArea textArea;
	
	// Create buttons
	JButton forwardButton = new JButton("FORWARD");
	JButton returnButton = new JButton("RETURN");
	
	// Constructor
	public Lesson(MyApplet thisApplet, int lessonNum, String msg) {
		
		// Set the screen number
		number = lessonNum;

		// Pass in the applet
		this.anApplet = thisApplet;
		
		// Pass in the message
		this.msg = msg;
		
		// Initialize the GUI
		initLesson();
	}

	// Init
	public void initLesson(){
		
		// Set layout
		setLayout(new BorderLayout());
		setBackground(Color.BLUE);
		
		// Add the text area
        textArea = new JTextArea();
		textArea.setText(msg);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setMargin(new Insets(20, 20, 20, 20));
 
        //add(textArea, BorderLayout.CENTER);
		add(scrollPane, BorderLayout.CENTER);
        
		// Add Buttons
		// http://stackoverflow.com/questions/15311316/how-to-put-two-components-to-a-jpanel-with-borderlayout
		JPanel buttonsPanel = new JPanel(new BorderLayout());
		buttonsPanel.setBackground(Color.WHITE);
		buttonsPanel.add(returnButton, BorderLayout.WEST);
		buttonsPanel.add(forwardButton, BorderLayout.EAST);

		add(buttonsPanel,BorderLayout.PAGE_END);
		
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
