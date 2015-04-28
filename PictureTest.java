import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class PictureTest extends JPanel implements MyQuestion {

    // OurController object
    private OurController aController;

    // Variable to hold screen number
    int number;
    
    // User object
    UserInfo myUser;

    // Image for background
    private Image backgroundImage;

    // JLabel and Scroll Pane
    private JLabel title;
    private JScrollPane top;
    
    //Declare Buttons
    private JButton picture1; 
    private JButton picture2;
    private JButton picture3;
    
    private JButton submitButton = new JButton();
	
	// Add friend list images
    private Image friendImage1;
    private Image friendImage2;
    private Image friendImage3;
    private Image friendImage4;
    private Image friendImage5;
    private Image friendImage6;

	// Get image URLs
    private URL backgroundURL = OurController.class.getResource("PicQuiz-01.png");
    private URL pic1URL = OurController.class.getResource("profPic1-01.png");
    private URL pic2URL = OurController.class.getResource("profPic2-01.png");
    private URL pic3URL = OurController.class.getResource("profPic3-01.png");
    private URL pic1_2URL = OurController.class.getResource("profPic1-2-01.png");
    private URL pic2_2URL = OurController.class.getResource("profPic2-2-01.png");
    private URL pic3_2URL = OurController.class.getResource("profPic3-2-01.png");
    private URL submitURL = OurController.class.getResource("Submit Button.png");
	
	//Declare Images
    private Image img1;
    private Image img2;
    private Image img3;
    private Image img1_2;
    private Image img2_2;
    private Image img3_2;
	
    private String finalPicture = "";
    private String picString1 = "profPic1-01.png";
    private String picString2 = "profPic2-01.png"; 
    private String picString3 = "profPic3-01.png";
	
    public PictureTest(OurController thisController, int aNumber) {
     
//REFERENCES:
   	 //http://stackoverflow.com/questions/15311316/how-to-put-two-components-to-a-jpanel-with-borderlayout
     //http://stackoverflow.com/questions/17880182/set-size-dimension-of-image-in-jbutton		
     //http://stackoverflow.com/questions/6810581/how-to-center-the-text-in-a-jlabel
     //http://stackoverflow.com/questions/11536089/making-all-button-size-same
     //http://stackoverflow.com/questions/4898584/java-using-an-image-as-a-button
     //http://stackoverflow.com/questions/2235569/add-and-remove-an-icon-on-a-jlabel
     //http://www.coderanch.com/t/342324/GUI/java/Changing-ImageIcon-JButton-click	

    // Set the applet
    this.aController = thisController;

    // Set the screen number
    number = aNumber;
    
    myUser = thisController.getUser();
		
        // Get images
	    try{
	    	//add background 
	    	backgroundImage = ImageIO.read(backgroundURL);
	    	
	    	//add image button #1
	    	img1 = ImageIO.read(pic1URL);
	    	img2 = ImageIO.read(pic2URL); 
	    	img3 = ImageIO.read(pic3URL);
	    	
	    	img1_2 = ImageIO.read(pic1_2URL);
	    	img2_2 = ImageIO.read(pic2_2URL); 
	    	img3_2 = ImageIO.read(pic3_2URL);
	    	
	    	
	    	
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }

        // Set Questions and Answers
        setQuestion();
        setAnswer();
        
    	//Add Button
    	submitButton = new JButton();
    	submitButton.setOpaque(false);
    	submitButton.setBorderPainted(false);
    	submitButton.setContentAreaFilled(false);
    	ImageIcon submit = new ImageIcon(submitURL);
    	submitButton.setIcon(submit);
		add(submitButton, BorderLayout.CENTER);

        // Listener to take user to first screen of lesson
        submitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	if (!finalPicture.equals("")){
            		myUser.setProfilePicture(finalPicture);
                	
                    aController.showNextTest(number);
            	}

            }
        });			
	}

	@Override
	public Boolean isCorrect() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setAnswer() {
	
    	//add panel for image buttons
    	JPanel picPanel = new JPanel();
			
    	//Add Button
    	picture1 = new JButton();
    	picture1.setOpaque(false);
    	picture1.setBorderPainted(false);
    	picture1.setContentAreaFilled(false);
    	final ImageIcon pic1 = new ImageIcon(img1);
    	picture1.setIcon(pic1);
    	
    	//Add Button
    	picture2 = new JButton();
    	picture2.setOpaque(false);
    	picture2.setBorderPainted(false);
    	picture2.setContentAreaFilled(false);
    	final ImageIcon pic2 = new ImageIcon(img2);
    	picture2.setIcon(pic2);
	     	    
    	//Add Button
    	picture3 = new JButton();
    	picture3.setOpaque(false);
    	picture3.setBorderPainted(false);
    	picture3.setContentAreaFilled(false);
    	final ImageIcon pic3 = new ImageIcon(img3);
    	picture3.setIcon(pic3);
	
		//Adjusting layout and size of Panel for Prof Pics
 		picPanel.setPreferredSize(new Dimension(500, 500));
 		picPanel.setLayout(new GridLayout(1, 3));
 		picPanel.setOpaque(false);
 		
 		//Now actually add the buttons to the panel
 		picPanel.add(picture1); 
 		picPanel.add(picture2); 
 		picPanel.add(picture3);

 		//Add picPanel to frame
 		add(picPanel, BorderLayout.CENTER);
 		
    	// Action Listeners for 3 image buttons
    	picture1.addActionListener(new ActionListener() {
            @Override
           	public void actionPerformed(ActionEvent e) {
            	
           		//When clicked, change image of button and change
           		//other two pictures to their original profile picture 
           		ImageIcon pic1_2 = new ImageIcon(img1_2);
   				picture1.setIcon(pic1_2);
   				picture1.revalidate();
   				finalPicture = picString1;
            	
        		//Set other two buttons back to their original image icons
           		picture2.setIcon(pic2);
           		picture2.revalidate();
           		
           		picture3.setIcon(pic3);
           		picture3.revalidate();
        		
            }
        });   		
    		
        picture2.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		
    	    	ImageIcon pic2_2 = new ImageIcon(img2_2);
				picture2.setIcon(pic2_2);
				picture2.revalidate();
   				finalPicture = picString2;
    				  		
           		picture1.setIcon(pic1);
           		picture1.revalidate();
           		
           		picture3.setIcon(pic3);
           		picture3.revalidate();
    			
        	}
        });
        
        picture3.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {

    	    	ImageIcon pic3_2 = new ImageIcon(img3_2);
    	    	picture3.setIcon(pic3_2);
    	    	picture3.revalidate();
   				finalPicture = picString3;
        		
           		picture1.setIcon(pic1);
           		picture1.revalidate();
    			
           		picture2.setIcon(pic2);
           		picture2.revalidate();
        	}
        }); 	
    } 	
	
	@Override
	public void setQuestion() {
		
	}

	// Paint the background
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this);
    }
	
}