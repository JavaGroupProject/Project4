import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;


@SuppressWarnings("serial")
public class TeacherInfo extends JPanel {

	// Applet object
	private MyApplet anApplet;
	
	// Create the return button
	JButton returnButton = new JButton("BACK");
	
	// string with the teacher information
	private String msg = "Info will go here.";
	private JTextArea textArea;
	
	
	// Constructor
	public TeacherInfo(MyApplet thisApplet) {

		// Pass in the applet
		this.anApplet = thisApplet;
		
		initTeacher();
	}
	
	// Init
	public void initTeacher(){
		
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
		buttonsPanel.add(returnButton, BorderLayout.WEST);
		add(buttonsPanel,BorderLayout.PAGE_END);
		
		// listener to take the user to the previous screen
		returnButton.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	anApplet.showWelcome();
		    }
		});
	}
}
