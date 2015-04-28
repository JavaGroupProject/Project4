import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PrivacyPanel extends JPanel {

	private OurController aController;
	
	private PrivacyPanel myPanel;
	
	// jlabel for the privacy setting
	private JLabel privacySetting;
	
	// button for the privacy setting
	private JButton changeSetting;
	
	// stores the privacy setting
	private String setting = "Public";
	
	// constant to store the button image
	private final String UPDATE_BUTTON_IMAGE = "UpdateButton.png";
	
	private URL updateURL = OurController.class.getResource(UPDATE_BUTTON_IMAGE);
	
	public PrivacyPanel(OurController thisController){
	
		this.aController = thisController;
		
		// stores itself so the action listener can revalidate it
		myPanel = this;
		
		// set the layout, size, and background
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(300, 45));
		setBackground(Color.WHITE);
		
		init();
		
	}
	
	// initializes the jpanel
	public void init(){
		
		// create the jlabel for the privacy setting
		privacySetting = new JLabel(setting);
		privacySetting.setAlignmentX(CENTER_ALIGNMENT);
		add(privacySetting);
		
		// create the button to change the privacy setting
		changeSetting = new JButton();
		changeSetting.setOpaque(false);
		changeSetting.setBorderPainted(false);
		changeSetting.setContentAreaFilled(false);
		ImageIcon post = new ImageIcon(updateURL);
	    changeSetting.setIcon(post);
		changeSetting.setAlignmentX(CENTER_ALIGNMENT);
		changeSetting.addActionListener(new ButtonListener());
		add(changeSetting);
		
	}
	
	// method to display the privacy setting label and button
	public void display(){

		privacySetting.setText(setting);
		add(privacySetting);
		add(changeSetting);
		
	}
	
	// button listener for the update button
	class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e){

			// create a joptionpane that allows the user to change their privacy setting
			// http://stackoverflow.com/questions/6555040/multiple-input-in-joptionpane-showinputdialog
        	// https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
			Object[] possibilities = {"Public", "Private", "Friends of Friends"};
			String newSetting = (String)JOptionPane.showInputDialog(
			                    aController,
			                    "Choose a privacy setting: ",
			                    "Privacy Setting",
			                    JOptionPane.PLAIN_MESSAGE,
			                    null,
			                    possibilities,
			                    "Public");
			
			
			// store the new setting
	    	setting = newSetting;

            // display the updated version of the privacy setting
            myPanel.display();
            myPanel.revalidate();
            myPanel.repaint();

			
		}
		
	}
	
}
