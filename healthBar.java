import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Results extends JPanel{
	private boolean nameCheck = true;	
	private boolean birthdayCheck = true;
	private boolean emailCheck = true;
	private boolean addressCheck;
	private boolean phoneCheck;
	private boolean ssnCheck;
	private boolean profPicCheck;
	
	
	private static String name1 = "You have made your name public to other viewers";
	private static String bd1 = "You have made your birthday public to other viewers";
	private static String email1 = "You have made your email public to other viewers";
	private static String address1 = "You have made your address public to other viewers";
	private static String phone1 = "You have made your phone number public"
			+ " to other viewers.";
	private static String ssn1 = "You have made your social security numbers public"
			+ " to other viewers";
	private static String pp1 = "You have made your profile picture public to"
			+ " other viewers";
	
	private double health = 0.0;
	private double maxHealth = 8.0;
	private int healthBarX = 80;
	private int HealthBarY = 20;
	private int healthBarWidth = 800;
	private int healthBarHeight = 30;	
	
	
	
//  private JLabel title;
  private JScrollPane top;
  
  JButton picB1; 
  JButton picB2;
  JButton picB3;
	JButton forwardButton = new JButton("FORWARD");
	JButton returnButton = new JButton("RETURN");
	Image img1;
	Image img2;
	Image img3;
	Icon icon1 = null;
	Icon icon2 = null;
	Icon icon3 = null;
	
	
	public Results() {	
		
		JPanel rPanel = new JPanel();
	
		if(nameCheck) {
			JTextArea textArea = new JTextArea(name1);
	        textArea.setEditable(false);
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        JScrollPane areaScrollPane = new JScrollPane(textArea);
	        areaScrollPane.setPreferredSize(new Dimension(300, 200));
	        
	        healthBarWidth = healthBarWidth-100;
		}
	
		if(birthdayCheck) {
			JTextArea textArea = new JTextArea(bd1);
	        textArea.setEditable(false);
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        JScrollPane areaScrollPane = new JScrollPane(textArea);
	        areaScrollPane.setPreferredSize(new Dimension(300, 200));
	        
	        healthBarWidth = healthBarWidth-100;
		}
		
		if(emailCheck) {
			JTextArea textArea = new JTextArea(email1);
	        textArea.setEditable(false);
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        JScrollPane areaScrollPane = new JScrollPane(textArea);
	        areaScrollPane.setPreferredSize(new Dimension(300, 200));
	        
	        healthBarWidth = healthBarWidth-100;
		}
		
		if(addressCheck) {
			JTextArea textArea = new JTextArea(address1);
	        textArea.setEditable(false);
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        JScrollPane areaScrollPane = new JScrollPane(textArea);
	        areaScrollPane.setPreferredSize(new Dimension(300, 200));
	        
	        healthBarWidth = healthBarWidth-100;
		}
		
		if(phoneCheck) {
			JTextArea textArea = new JTextArea(phone1);
	        textArea.setEditable(false);
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        JScrollPane areaScrollPane = new JScrollPane(textArea);
	        areaScrollPane.setPreferredSize(new Dimension(300, 200));
	        
	        healthBarWidth = healthBarWidth-100;
		}
		
		if(ssnCheck) {
			JTextArea textArea = new JTextArea(ssn1);
	        textArea.setEditable(false);
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        JScrollPane areaScrollPane = new JScrollPane(textArea);
	        areaScrollPane.setPreferredSize(new Dimension(300, 200));
	        
	        healthBarWidth = healthBarWidth-100;
		}
		
		if(profPicCheck) {
			JTextArea textArea = new JTextArea(pp1);
	        textArea.setEditable(false);
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        JScrollPane areaScrollPane = new JScrollPane(textArea);
	        areaScrollPane.setPreferredSize(new Dimension(300, 200));
	        
	        healthBarWidth = healthBarWidth-100;
		}
		
 		//add panel on page for health status bar
		JPanel healthPanel = new JPanel(new BorderLayout());
		healthPanel.setBackground(Color.WHITE);
		
        MyDrawing drawing = new MyDrawing();
        
        healthPanel.setPreferredSize(new Dimension(1000, 1000));
        healthPanel.add(drawing, BorderLayout.CENTER);
		
		add(healthPanel,BorderLayout.CENTER);
		
	}
	
	double healthScale;
	
    //DRAW RECTANGLE
    class MyDrawing extends JPanel {
        public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
//        health = 2.0;
//        
//        healthScale = health/maxHealth;
//        double nWidth = healthBarWidth*healthScale;
//        int newWidth = (int)nWidth;
        
        g.setColor(Color.green);
        g.fillRect(0, 0, healthBarWidth, healthBarHeight);
        }
    }
	
}