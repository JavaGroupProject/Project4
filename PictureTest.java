import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class PictureTest extends JPanel {
    
	// Applet object
	private MyApplet anApplet;
	
	// Variable to hold screen number
	int number;
	
	private JLabel title;
    private JScrollPane top;
    
    //Declare Buttons
    JButton picB1; 
    JButton picB2;
    JButton picB3;
	JButton forwardButton = new JButton("NEXT");
	JButton returnButton = new JButton("BACK");
	
	//Declare Images
	Image img1;
	Image img2;
	Image img3;
	
	//Declare Icons
	Icon icon1 = null;
	Icon icon2 = null;
	Icon icon3 = null;
    
    public PictureTest(MyApplet thisApplet, int aNumber) {
     
//REFERENCES:
   	 //http://stackoverflow.com/questions/15311316/how-to-put-two-components-to-a-jpanel-with-borderlayout
     //http://stackoverflow.com/questions/17880182/set-size-dimension-of-image-in-jbutton		
     //http://stackoverflow.com/questions/6810581/how-to-center-the-text-in-a-jlabel
     //http://stackoverflow.com/questions/11536089/making-all-button-size-same
     //http://stackoverflow.com/questions/4898584/java-using-an-image-as-a-button
     //http://stackoverflow.com/questions/2235569/add-and-remove-an-icon-on-a-jlabel
     //http://www.coderanch.com/t/342324/GUI/java/Changing-ImageIcon-JButton-click	
    	
    	// Set the applet
		this.anApplet = thisApplet;
		
		// Set the screen number
		number = aNumber;
    	
    	//add panel for image buttons
    	JPanel picPanel = new JPanel();
     		
    	//Add Buttons
     		BufferedImage buttonIcon;
			try {
			
				//1st Prof Pic Button
				buttonIcon = ImageIO.read(new File("/Users/gerrythiers/Pictures/frat1.jpg"));
				img1 = buttonIcon.getScaledInstance(300, 500, java.awt.Image.SCALE_SMOOTH);
				picB1 = new JButton(new ImageIcon(img1));
				icon1 = new ImageIcon(img1);
	     	    picB1.setBorder(BorderFactory.createEmptyBorder());
	     	    picB1.setContentAreaFilled(false);
	     	    picB1.setSize(100, 150);
	        
	     	    //2nd Prof Pic Button   
				buttonIcon = ImageIO.read(new File("/Users/gerrythiers/Pictures/ProPicture.jpg"));
				img2 = buttonIcon.getScaledInstance(300, 500, java.awt.Image.SCALE_SMOOTH);
				picB2 = new JButton(new ImageIcon(img2));
				icon2 = new ImageIcon(img2);
	     	    picB2.setBorder(BorderFactory.createEmptyBorder());
	     	    picB2.setContentAreaFilled(false);
	     	    
	     	    //3rd Prof Pic Button
				buttonIcon = ImageIO.read(new File("/Users/gerrythiers/Pictures/DrunkGirl.jpg"));
				img3 = buttonIcon.getScaledInstance(300, 500, java.awt.Image.SCALE_SMOOTH);
				picB3 = new JButton(new ImageIcon(img3));
				icon3 = new ImageIcon(img3);
	     	    picB3.setBorder(BorderFactory.createEmptyBorder());
	     	    picB3.setContentAreaFilled(false);
	     	    
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
     		
			//Adjusting layout and size of Panel for Prof Pics
     		picPanel.setPreferredSize(new Dimension(1000, 1000));
     		picPanel.setLayout(new GridLayout(1, 3));
     		
     		//Now actually add the buttons to the panel
     		picPanel.add(picB1); 
     		picPanel.add(picB2); 
     		picPanel.add(picB3);

     		//Add picPanel to frame
     		add(picPanel, BorderLayout.CENTER);
     		
     		//add label at top of screen to give directions
     		title = new JLabel("Click on the image that you think would be an"
     				+ " appropiate profile picture for your social"
     				+ " media account.", SwingConstants.CENTER);
     		
     		//Add title label to frame
     		top = new JScrollPane(title);
     		add(top, BorderLayout.PAGE_START);
     		
     		//add panel at bottom of page for return and forward buttons
    		JPanel buttonsPanel = new JPanel(new BorderLayout());
    		buttonsPanel.setBackground(Color.WHITE);
    		buttonsPanel.add(returnButton, BorderLayout.WEST);
    		buttonsPanel.add(forwardButton, BorderLayout.EAST);

    		//Add Return/Forward Buttons Panel to frame
    		add(buttonsPanel,BorderLayout.PAGE_END);
     	
    	//Action Listeners for 3 image buttons
    	picB1.addActionListener(new ActionListener() {
            @Override
           	public void actionPerformed(ActionEvent e) {
           		//Display image on panel and record image selected as profPic
           		picB1.setIcon(null);
           		picB1.revalidate();
            	
           		//When clicked, change image of button to check mark and change
           		//other two pictures to their original profile picture
           		BufferedImage buttonIcon;
        		try {
        			buttonIcon = ImageIO.read(new File("/Users/gerrythiers/Pictures/checkmark.png"));
        			Image img4 = buttonIcon.getScaledInstance(300, 500, java.awt.Image.SCALE_SMOOTH);
       				final Icon icon4 = new ImageIcon(img4);
       				picB1.setIcon(icon4);
       	     	    picB1.setBorder(BorderFactory.createEmptyBorder());
       	     	    picB1.setContentAreaFilled(false);
       	     	    picB1.setSize(100, 150);
       			} catch (IOException e1) {
       				// TODO Auto-generated catch block
       				e1.printStackTrace();
       			} 		
            	
        		//Set other two buttons back to their original image icons
           		picB2.setIcon(icon2);
           		picB2.revalidate();
           		
           		picB3.setIcon(icon3);
           		picB3.revalidate();
        		
            }
        });   		
    		
        picB2.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		//Display image on panel and record image selected as profPic
        		picB2.setIcon(null);
        		picB2.revalidate();
        		
         		BufferedImage buttonIcon;
    			try {
    				buttonIcon = ImageIO.read(new File("/Users/gerrythiers/Pictures/checkmark.png"));
    				Image img4 = buttonIcon.getScaledInstance(300, 500, java.awt.Image.SCALE_SMOOTH);
    				final Icon icon1 = new ImageIcon(img4);
    				picB2.setIcon(icon1);
    	     	    picB2.setBorder(BorderFactory.createEmptyBorder());
    	     	    picB2.setContentAreaFilled(false);
    	     	    picB2.setSize(100, 150);
    			} catch (IOException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			} 		
        		
           		picB1.setIcon(icon1);
           		picB1.revalidate();
           		
           		picB3.setIcon(icon3);
           		picB3.revalidate();
    			
        	}
        });
        
        picB3.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		
        		//Display image on panel and record image selected as profPic
        		picB3.setIcon(null);
        		picB3.revalidate();
        		
         		BufferedImage buttonIcon;
    			try {
    				buttonIcon = ImageIO.read(new File("/Users/gerrythiers/Pictures/checkmark.png"));
    				Image img4 = buttonIcon.getScaledInstance(300, 500, java.awt.Image.SCALE_SMOOTH);
    				final Icon icon1 = new ImageIcon(img4);
    				picB3.setIcon(icon1);
    	     	    picB3.setBorder(BorderFactory.createEmptyBorder());
    	     	    picB3.setContentAreaFilled(false);
    	     	    picB3.setSize(100, 150);
    			} catch (IOException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			} 		
        		
           		picB1.setIcon(icon1);
           		picB1.revalidate();
    			
           		picB2.setIcon(icon2);
           		picB2.revalidate();
        	}
        });
        
        // Takes user to the next lesson
		forwardButton.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	anApplet.showNextTest(number);
		    }
		});
		
		// Takes user to the previous lesson
		returnButton.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	anApplet.showPreviousTest(number);
		    }
		});
    }  

}
