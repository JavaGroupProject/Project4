import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PicturesPanel extends JPanel {

	private OurController aController;
	
	private Newsfeed newsfeed;
	
	// Constructor
	public PicturesPanel(OurController thisController, Newsfeed newsfeed){
		
		this.aController = thisController;
		this.newsfeed = newsfeed;
		
		// set the size and the background
		setPreferredSize(new Dimension(300, 280));
		setBackground(Color.WHITE);
		
		init();
		
	}
	
	public void init(){
		
		// get the user's pictures
		ArrayList<String> pictures = aController.getUser().getPictures();
		
		// loop through all of the pictures
		for (int i = 0; i < pictures.size(); i++){
			
			// TODO might be able to get rid of some of this
			// create a an image for each button
			// http://www.coderanch.com/t/331731/GUI/java/Resize-ImageIcon
			String imageName = pictures.get(i);
			URL imageURL = OurController.class.getResource(imageName);
			ImageIcon postPic = new ImageIcon(imageURL);
	        Image img = postPic.getImage();
	        Image newimg = img.getScaledInstance(85, 85, java.awt.Image.SCALE_SMOOTH);
	        postPic = new ImageIcon(newimg);
			
	        // create the button and place the image on it
	        JButton pictureButton = new JButton(postPic);
	        pictureButton.setSize(new Dimension(85,85));
	        pictureButton.setOpaque(false);
	        pictureButton.setBorderPainted(false);
	        pictureButton.setContentAreaFilled(false);
	        pictureButton.setName(imageName);
	        pictureButton.addActionListener(new PictureListener());
	        add(pictureButton);
	        
		}
		
	}
	
	// listener for all of the pictures
	class PictureListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e){
			
			// get the name of the button
			// http://stackoverflow.com/questions/7867834/get-button-name-from-actionlistener
			JButton selectedImage = (JButton) e.getSource();
			String imageName = selectedImage.getName();
			
			// create a joptionpane to ask the user if they want to post the picture
			String answer = (String)JOptionPane.showInputDialog(aController, "Add a caption:",
															    "Do you want to post this picture?",
															    JOptionPane.PLAIN_MESSAGE,
															    null, null, null);
			
			if (answer != null){
				// add the picture to the newsfeed
				if (answer.equals("")){ // if the user didn't add a caption
					newsfeed.addPicture("You posted a picture:", imageName);
				}
				else { // if the user did add a caption
					newsfeed.addPicture("You: " + answer, imageName);
				}
				
			}
			
		}
		
	}
	
}