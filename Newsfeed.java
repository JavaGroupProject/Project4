import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Newsfeed extends JPanel {

	private Canvas canvas;
	
	public Newsfeed(Canvas canvas){
		
		// not sure if this is necessary
		this.canvas = canvas;
		
		initNewsfeed();
		
	}
	
	public void initNewsfeed(){
		
		// set the layout as a box layout
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// set the background color to white
		setBackground(Color.WHITE);
		
	}
	
	public void addPost(String text){
		
		//add(new JLabel("    "), 0);
		
		// create a new text area
		JTextArea post = new JTextArea();
		
		// set the text to the string passed as an argument
		post.setText(text);
		
		// format the text area
		post.setEditable(false);
		post.setLineWrap(true);
		post.setWrapStyleWord(true);
		
		// create a scroll pane for the text area 
		JScrollPane scroll = new JScrollPane(post);
		
		// set the dimensions of the scroll pane
		scroll.setMaximumSize(new Dimension(300, 50));
		scroll.setMinimumSize(new Dimension(300, 50));
		scroll.setPreferredSize(new Dimension(300, 50));
		
		//scroll.setBorder(null);
		
		// add the scroll pane to the top of the newsfeed
		add(scroll, 0);
		
		// revalidate and repaint so that the new post appears on the screen
		revalidate();
		repaint();
		
	}
	
	public void addPicture(String caption){
		
		add(new JLabel("    "), 0);
		
		// need to figure out a better way to access the pictures
        ImageIcon image = new ImageIcon("/Users/Zoe/Desktop/picture.png", "picture");
        
        // http://www.coderanch.com/t/331731/GUI/java/Resize-ImageIcon
        Image img = image.getImage();
        Image newimg = img.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
        image = new ImageIcon(newimg);
        
        JLabel imageLabel = new JLabel(image);
        imageLabel.setSize(new Dimension(150,150));
        
        imageLabel.setAlignmentX(CENTER_ALIGNMENT);
        
        add(imageLabel, 0);
        
		if (!caption.equals("")){
			addPost(caption);
		}
		
	}
		
	public void addLink(String linkText){
		
		// create a new text area
		JTextArea linkPost = new JTextArea();
		
		// set the text to the string passed as an argument
		linkPost.setText(linkText);
		
		// format the text area
		linkPost.setEditable(false);
		linkPost.setLineWrap(true);
		linkPost.setWrapStyleWord(true);
		
		// http://stackoverflow.com/questions/10133366/how-to-clear-jtextfield-when-mouse-clicks-the-jtextfield
		linkPost.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	
            	// TODO
            	// might need to have different looking panels depending on the post
            	// will also need to process the information differently (in the ok option if statement)
            	
            	// http://stackoverflow.com/questions/6555040/multiple-input-in-joptionpane-showinputdialog
            	// https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
            	JPanel optionPanel = new JPanel();
            	optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.Y_AXIS));
            	optionPanel.add(new JLabel("Name:"));
            	JTextField nameField = new JTextField(20);
            	optionPanel.add(nameField);
            	optionPanel.add(new JLabel("Email:"));
            	JTextField emailField = new JTextField(20);
            	optionPanel.add(emailField);
            	optionPanel.add(new JLabel("Address:"));
            	JTextField addressField = new JTextField(20);
            	optionPanel.add(addressField);
            	
            	int result = JOptionPane.showConfirmDialog(canvas, optionPanel, "Enter your information", 
            											   JOptionPane.OK_CANCEL_OPTION);
            	
                if (result == JOptionPane.OK_OPTION) {
                	// TODO need to figure out what to do with this information/what to do if it is empty
                	String name = nameField.getText();
                	String email = emailField.getText();
                	String address = addressField.getText();
                    //System.out.println("name: " + nameField.getText());
                    //System.out.println("email: " + emailField.getText());
                    //System.out.println("address: " + addressField.getText());
                 }
            	
            }
        });
		
		// create a scroll pane for the text area 
		JScrollPane scroll = new JScrollPane(linkPost);
		
		// set the dimensions of the scroll pane
		scroll.setMaximumSize(new Dimension(300, 50));
		scroll.setMinimumSize(new Dimension(300, 50));
		scroll.setPreferredSize(new Dimension(300, 50));
		
		//scroll.setBorder(null);

		// add the scroll pane to the top of the newsfeed
		add(scroll, 0);
		
		// revalidate and repaint so that the new post appears on the screen
		revalidate();
		repaint();
		
	}
		
}