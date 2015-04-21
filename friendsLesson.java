import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
//public class GuineaPig extends JPanel implements ActionListener {
public class GuineaPig extends JApplet {
    protected JTextArea textArea;
 
    public GuineaPig() {
    	String tutorial = "Be careful that you know who you add or friend on "
    			+ "social media. Identity thieves might create fake profiles"
    			+ " in order to get information from you: this is"
    			+ " known as social engineering. Be sure you recognize the"
    			+ " person you are considering adding or friending based on"
    			+ " their picture, information, profile details, and mutual friends."
    			+ " If you have any reason to doubt that they are not who they say"
    			+ " they are, do NOT associate with them on social media!";
    	
        textArea = new JTextArea(50, 50);
        textArea.setText(tutorial);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
 
        add(scrollPane);
    } 

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Be safe with who you associate with.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add contents to the window.
        frame.add(new GuineaPig());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}