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

	private OurController anApplet;
	
	private Newsfeed newsfeed;
	
	//private URL updateURL = OurController.class.getResource("PostButton.png");
	
	public PicturesPanel(OurController thisApplet, Newsfeed newsfeed){
		
		this.anApplet = thisApplet;
		this.newsfeed = newsfeed;
		
		//setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//setLayout(new BorderLayout());
		setPreferredSize(new Dimension(300, 280));
		setBackground(Color.WHITE);
		
		init();
		
	}
	
	public void init(){
		
		ArrayList<String> pictures = anApplet.getUser().getPictures();
		
		for (int i = 0; i < pictures.size(); i++){
			
			String imageName = pictures.get(i);
			URL imageURL = OurController.class.getResource(imageName);
			ImageIcon postPic = new ImageIcon(imageURL);
	        
	        // http://www.coderanch.com/t/331731/GUI/java/Resize-ImageIcon
	        Image img = postPic.getImage();
	        Image newimg = img.getScaledInstance(85, 85, java.awt.Image.SCALE_SMOOTH);
	        postPic = new ImageIcon(newimg);
			
	        JButton pictureButton = new JButton(postPic);
	        pictureButton.setSize(new Dimension(85,85));
	        pictureButton.setOpaque(false);
	        pictureButton.setBorderPainted(false);
	        pictureButton.setContentAreaFilled(false);
	        //ImageIcon post = new ImageIcon(updateURL);
	        pictureButton.setName(imageName);
	    	//pictureButton.setIcon(post);
	        pictureButton.addActionListener(new PictureListener());
	        
	        add(pictureButton);
	        
		}
		
	}
	
	class PictureListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e){
			
			// http://stackoverflow.com/questions/7867834/get-button-name-from-actionlistener
			JButton selectedImage = (JButton) e.getSource();
			String imageName = selectedImage.getName();
			
			// https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
			String answer = (String)JOptionPane.showInputDialog(anApplet, "Do you want to post this picture?",
                    											"Customized Dialog", JOptionPane.PLAIN_MESSAGE,
                    											null, null, null);
			
			if (answer != null){
				
				if (answer.equals("")){
					newsfeed.addPicture("You posted a picture:", imageName);
				}
				else {
					newsfeed.addPicture("You: " + answer, imageName);
				}
				
			}
			
		}
		
	}
	
}