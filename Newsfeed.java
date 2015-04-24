import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

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
		scroll.setMaximumSize(new Dimension(330, 50));
		scroll.setMinimumSize(new Dimension(330, 50));
		scroll.setPreferredSize(new Dimension(330, 50));
		
		// add the scroll pane to the top of the newsfeed
		add(scroll, 0);
		
		// revalidate and repaint so that the new post appears on the screen
		revalidate();
		repaint();
		
	}
	
	public void addPicturePost(){
		
		JTextPane pane = new JTextPane();
		pane.setEditable(false);
		pane.setBackground(Color.BLUE);
		

		
		// http://www.java2s.com/Tutorial/Java/0240__Swing/InsertinganImageintoaJTextPaneComponent.htm
		try {
			StyledDocument doc = (StyledDocument) pane.getDocument();
			doc.insertString(doc.getLength(), "this is a really long caption that is going to cause formatting problems", null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// need to figure out a better way to access the pictures
        ImageIcon image = new ImageIcon("/Users/Zoe/Desktop/picture.png", "picture");
        
        // http://www.coderanch.com/t/331731/GUI/java/Resize-ImageIcon
        Image img = image.getImage();
        Image newimg = img.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
        image = new ImageIcon(newimg);

		pane.insertIcon(image);
		
		pane.setMaximumSize(new Dimension(200, 200));
		pane.setMinimumSize(new Dimension(150, 150));
		pane.setPreferredSize(new Dimension(200, 200));
		
		add(pane, 0);
		
		// revalidate and repaint so that the new post appears on the screen
		revalidate();
		repaint();
		
	}
	
}