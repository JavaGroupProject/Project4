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
public class TeacherInfo extends JPanel {

	// Applet object
	private OurController anApplet;
	
	// Background Image
	private Image backgroundImage;
	
	// Get image URLs
	URL backgroundURL = OurController.class.getResource("TeacherInfo-01.png");
	URL returnURL = OurController.class.getResource("ReturnButton.png");
	
	public Color purple = new Color(55, 29, 145);
	
	// Create the return button
	JButton returnButton = new JButton();
	
	// Constructor
	public TeacherInfo(OurController thisApplet) {

		// Pass in the applet
		this.anApplet = thisApplet;
		
		initTeacher();
	}
	
	// Init
	public void initTeacher(){
		
		// Set layout
		setLayout(new BorderLayout());
		
		// Set background
		try {
			backgroundImage = ImageIO.read(backgroundURL);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// Add button
		JPanel buttonsPanel = new JPanel(new BorderLayout());
		buttonsPanel.setBackground(purple);
		buttonsPanel.add(returnButton, BorderLayout.WEST);
		add(buttonsPanel,BorderLayout.PAGE_END);
		
		// Set button image
		returnButton.setOpaque(false);
     	returnButton.setBorderPainted(false);
     	returnButton.setContentAreaFilled(false);
        ImageIcon returnB = new ImageIcon(returnURL);
     	returnButton.setIcon((returnB));
		
		// listener to take the user to the previous screen
		returnButton.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	anApplet.showWelcome();
		    }
		});
	}
	
	// Paint the background
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this);
    }
}
