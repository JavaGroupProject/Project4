import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Lesson extends JPanel{

	// Frame object
	private OurController anApplet;
	
	// Variable to hold screen number
	Integer number;
	
	// Lesson Images
	private Image lesson;
	private Image passwordMsg;
	private Image infoMsg;
	private Image friendMsg;
	private Image profPicMsg;
	private Image privacySettingMsg;
	private Image badLinksMsg;
	
	// Pull image url from bin
	URL passwordURL = OurController.class.getResource("PasswordLesson-01.png");
	URL infoURL = OurController.class.getResource("InfoLesson-01.png");
	URL friendURL = OurController.class.getResource("FriendLesson-01.png");
	URL profPicURL = OurController.class.getResource("PictureLesson-01.png");
	URL privacyURL = OurController.class.getResource("PrivacyLesson-01.png");
	URL linkURL = OurController.class.getResource("LinkLesson-01.png");
	URL forwardURL = OurController.class.getResource("ForwardButton.png");
	URL returnURL = OurController.class.getResource("ReturnButton.png");
	
	// Purple
	public Color purple = new Color(55, 29, 145);
	
	// Create buttons
	JButton forwardButton = new JButton();
	JButton returnButton = new JButton();
	
	// Constructor
	public Lesson(OurController thisApplet, int lessonNum) {
		
		// Set the screen number
		number = lessonNum;

		// Pass in the applet
		this.anApplet = thisApplet;
		
		// Initialize the GUI
		initLesson();
	}

	// Init
	public void initLesson(){
		
		// Set layout
		setLayout(new BorderLayout());
		
		// Set lesson background
		try {
			passwordMsg = ImageIO.read(passwordURL);
			infoMsg  = ImageIO.read(infoURL);
			friendMsg = ImageIO.read(friendURL);
			profPicMsg = ImageIO.read(profPicURL);
			privacySettingMsg = ImageIO.read(privacyURL);
			badLinksMsg = ImageIO.read(linkURL);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// chooses background
		switch (number){
		case 1:
			lesson = passwordMsg;
			break;
		case 2:
			lesson = infoMsg;
			break;	
		case 3:
			lesson = friendMsg;
			break;
		case 4:
			lesson = profPicMsg;
			break;
		case 5:
			lesson = privacySettingMsg;
			break;
		case 6:
			lesson = badLinksMsg;
			break;
		}
		
		// Add Buttons
		// http://stackoverflow.com/questions/15311316/how-to-put-two-components-to-a-jpanel-with-borderlayout
		JPanel buttonsPanel = new JPanel(new BorderLayout());
		buttonsPanel.setBackground(purple);
		buttonsPanel.add(returnButton, BorderLayout.WEST);
		buttonsPanel.add(forwardButton, BorderLayout.EAST);
		
		// Set up forward button
		forwardButton.setOpaque(false);
        forwardButton.setBorderPainted(false);
        forwardButton.setContentAreaFilled(false);
        ImageIcon forwardB = new ImageIcon(forwardURL);
     	forwardButton.setIcon((forwardB));
     	
     	// Set up return button
     	returnButton.setOpaque(false);
     	returnButton.setBorderPainted(false);
     	returnButton.setContentAreaFilled(false);
        ImageIcon returnB = new ImageIcon(returnURL);
     	returnButton.setIcon((returnB));
     	
     	// Add the button panel
		add(buttonsPanel, BorderLayout.PAGE_END);
		
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
	
	// Paint the background
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(lesson, 0, 0, this);
    }
}
