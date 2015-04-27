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
public class Welcome extends JPanel {

	// Frame object
	private OurController anApplet;
	
	// Background
	private Image backgroundImage;
	
	// Get image URLs
	URL backgroundURL = OurController.class.getResource("Welcome-01.png");
	URL forwardURL = OurController.class.getResource("ForwardButton.png");
	URL teacherURL = OurController.class.getResource("InfoInstructor.png");
	
	public Color purple = new Color(55, 29, 145);
	
	// Create buttons
	JButton forwardButton = new JButton();
	JButton teacherButton = new JButton();
	
	// Constructor
	public Welcome(OurController thisApplet) {
		
		// Pass in the frame
		this.anApplet = thisApplet;
		
		// Initilize GUI
		initWelcome();
	}

	// Init
	private void initWelcome(){
		
		// Set layout
		setLayout(new BorderLayout());
		
		// Set background
		try {
			backgroundImage = ImageIO.read(backgroundURL);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// Add buttons
		JPanel buttonsPanel = new JPanel(new BorderLayout());
		buttonsPanel.setBackground(purple);
		buttonsPanel.add(forwardButton, BorderLayout.EAST);
		buttonsPanel.add(teacherButton, BorderLayout.WEST);
		add(buttonsPanel,BorderLayout.PAGE_END);
		
		forwardButton.setOpaque(false);
        forwardButton.setBorderPainted(false);
        forwardButton.setContentAreaFilled(false);
        ImageIcon forward = new ImageIcon(forwardURL);
     	forwardButton.setIcon((forward));
	
     	// Set Up Button
     	teacherButton.setOpaque(false);
     	teacherButton.setBorderPainted(false);
     	teacherButton.setContentAreaFilled(false);
        ImageIcon teacher = new ImageIcon(teacherURL);
        teacherButton.setIcon((teacher));
     	
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
	
	// Paint the background
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this);
    }
}