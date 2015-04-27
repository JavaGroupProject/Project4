import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FriendPanel extends JPanel {

	private OurController anApplet;
	
	public FriendPanel(OurController thisApplet){
		
		this.anApplet = thisApplet;
		
		//setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//setLayout(new BorderLayout());
		setPreferredSize(new Dimension(300, 200));
		setBackground(Color.WHITE);
		
		init();
		
	}
	
	public void init(){
		
		ArrayList<Friend> friends = anApplet.getFriends();
		
		for (int i = 0; i < friends.size(); i++){
			
			String imageName = friends.get(i).getProfilePicture();
			URL imageURL = OurController.class.getResource(imageName);
			ImageIcon profpic = new ImageIcon(imageURL);
			
			// create an image icon for the profile picture
			// will need to change this
	        //ImageIcon profpic = new ImageIcon("/Users/Zoe/Desktop/picture.png", "profile picture");
	        
	        // http://www.coderanch.com/t/331731/GUI/java/Resize-ImageIcon
	        Image img = profpic.getImage();
	        Image newimg = img.getScaledInstance(85, 85, java.awt.Image.SCALE_SMOOTH);
	        profpic = new ImageIcon(newimg);
	        
	        JLabel profpicLabel = new JLabel(profpic);
	        profpicLabel.setSize(new Dimension(85,85));
			
	        add(profpicLabel);
	        
		}
		
	}
	
}