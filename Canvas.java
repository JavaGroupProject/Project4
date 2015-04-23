import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class Canvas extends JPanel {

	// Frame object
	private MyApplet anApplet;
	
	// Store the spring layout
	private SpringLayout springLayout;
	
	private JTextArea status;
	private JPanel newsfeedPanel;
	
	public Canvas(MyApplet thisApplet){
		
		this.anApplet = thisApplet;
		
		initCanvas();
		
	}
	
	public void initCanvas(){
		
		// initialize the spring layout
		springLayout = new SpringLayout();
        setLayout(springLayout);
		             
        // replace this with a text field??
        status = new JTextArea(3, 30);
        status.setEditable(true);
        status.setLineWrap(true);
        JScrollPane statusScrollPane = new JScrollPane(status);
        
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, statusScrollPane,0,SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.NORTH, statusScrollPane, 10, SpringLayout.NORTH, this);
                
        add(statusScrollPane);
        
        JButton statusButton = new JButton("POST");
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, statusButton,0,SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.NORTH, statusButton, 5, SpringLayout.SOUTH, statusScrollPane);
        
        statusButton.addActionListener(new StatusListener());
        
        add(statusButton);
        
		newsfeedPanel = new JPanel();
		newsfeedPanel.setLayout(new BoxLayout(newsfeedPanel, BoxLayout.Y_AXIS));
		newsfeedPanel.setBackground(Color.WHITE);

		JScrollPane newsfeedScrollPane = new JScrollPane(newsfeedPanel);
		newsfeedScrollPane.setPreferredSize(new Dimension(360,600));
		
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, newsfeedScrollPane,0,SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.NORTH, newsfeedScrollPane, 100, SpringLayout.NORTH, this);
		
		add(newsfeedScrollPane);
        
        ImageIcon profpic = new ImageIcon("/Users/Zoe/Desktop/picture.png", "profile picture");
        
        // http://www.coderanch.com/t/331731/GUI/java/Resize-ImageIcon
        Image img = profpic.getImage();
        Image newimg = img.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH);
        profpic = new ImageIcon(newimg);
        
        JLabel profpicLabel = new JLabel(profpic);
        profpicLabel.setSize(new Dimension(150,150));
        
        springLayout.putConstraint(SpringLayout.EAST, profpicLabel, -10,SpringLayout.WEST, statusScrollPane);
        springLayout.putConstraint(SpringLayout.NORTH, profpicLabel, 10, SpringLayout.NORTH, this);
        
        add(profpicLabel);
		
		JPanel privacyPanel = new JPanel();
		privacyPanel.setPreferredSize(new Dimension(160, 250));
		privacyPanel.setBackground(Color.WHITE);
		
		springLayout.putConstraint(SpringLayout.EAST, privacyPanel, -10, SpringLayout.WEST, statusScrollPane);
        springLayout.putConstraint(SpringLayout.NORTH, privacyPanel, 10, SpringLayout.SOUTH, profpicLabel);
		
        add(privacyPanel);
        
		JPanel infoPanel = new JPanel();
		infoPanel.setPreferredSize(new Dimension(160, 250));
		infoPanel.setBackground(Color.WHITE);
		
		springLayout.putConstraint(SpringLayout.EAST, infoPanel, -10, SpringLayout.WEST, statusScrollPane);
        springLayout.putConstraint(SpringLayout.NORTH, infoPanel, 10, SpringLayout.SOUTH, privacyPanel);
		
        add(infoPanel);
        
		JPanel friendsPanel = new JPanel();
		friendsPanel.setPreferredSize(new Dimension(160, 350));
		friendsPanel.setBackground(Color.WHITE);
		
		springLayout.putConstraint(SpringLayout.WEST, friendsPanel, 10, SpringLayout.EAST, statusScrollPane);
        springLayout.putConstraint(SpringLayout.NORTH, friendsPanel, 10, SpringLayout.NORTH, this);
		
        add(friendsPanel);
        
		JPanel picturesPanel = new JPanel();
		picturesPanel.setPreferredSize(new Dimension(160, 300));
		picturesPanel.setBackground(Color.WHITE);
		
		springLayout.putConstraint(SpringLayout.WEST, picturesPanel, 10, SpringLayout.EAST, statusScrollPane);
        springLayout.putConstraint(SpringLayout.NORTH, picturesPanel, 10, SpringLayout.SOUTH, friendsPanel);
		
        add(picturesPanel);
        
        
	}
	
	class StatusListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e){

			// this doesn't work, not sure why
			// might need to repaint
			newsfeedPanel.add(new JLabel(status.getText(), 0));

		}
		
	}
	
}
