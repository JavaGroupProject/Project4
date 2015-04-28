import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FriendPanel extends JPanel {

	// OurController object
	private OurController aController;
	
	// Constructor
	public FriendPanel(OurController thisController){
		
		this.aController = thisController;
		
		// set the size and the background
		setPreferredSize(new Dimension(300, 200));
		setBackground(Color.WHITE);
		
		init();
		
	}
	
	// initialization method
	public void init(){
		
		// get the list of friends that the user has
		ArrayList<Friend> friends = aController.getFriends();
		
		// loop through all of the friends
		for (int i = 0; i < friends.size(); i++){
			
			// create a jlabel with a picture for each of the friends
			String imageName = friends.get(i).getProfilePicture();
			URL imageURL = OurController.class.getResource(imageName);
			ImageIcon profpic = new ImageIcon(imageURL);	        
	        JLabel profpicLabel = new JLabel(profpic);
	        profpicLabel.setSize(new Dimension(85,85));
			
	        // add the picture to the jpanel
	        add(profpicLabel);
	        
		}
		
	}
	
}