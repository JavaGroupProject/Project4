import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

// https://docs.oracle.com/javase/tutorial/uiswing/components/textfield.html
// https://docs.oracle.com/javase/tutorial/uiswing/examples/components/TextDemoProject/src/components/TextDemo.java
// https://docs.oracle.com/javase/tutorial/uiswing/components/textarea.html
// http://www.coderanch.com/t/332055/GUI/java/JTextField-getText-Enter-pressed

// https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/SpringDemo2Project/src/layout/SpringDemo2.java

public class PanelTest2 extends JPanel{

	CardTest cardtest;
	JButton forwardButton;
	JButton backButton;
	JButton submitButton;
	JTextField textField;
	JTextField textField2;
	JTextArea textArea;
	JLabel textFieldLabel;
	JLabel textFieldLabel2;
	
	
	public PanelTest2(CardTest cardtest){
		        
		this.cardtest = cardtest;
		forwardButton = new JButton("   NEXT   ");
		backButton = new JButton("   BACK   ");
		submitButton = new JButton("SUBMIT");
		forwardButton.addActionListener(new ButtonListener());
		backButton.addActionListener(new ButtonListener1());
		submitButton.addActionListener(new TextListener());
		add(forwardButton);
		add(backButton);
		
		
		textField = new JTextField(20);
        //textField.addActionListener(new TextListener());
		
		textField2 = new JTextField(20);
        
        textFieldLabel = new JLabel("Enter info: ");
        textFieldLabel2 = new JLabel("Enter info 2: ");

        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        
		SpringLayout layout = new SpringLayout();
        setLayout(layout);
		
        layout.putConstraint(SpringLayout.WEST, forwardButton,100,SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, forwardButton,10, SpringLayout.NORTH, this);
        
        layout.putConstraint(SpringLayout.WEST, backButton,10,SpringLayout.EAST, forwardButton);
        layout.putConstraint(SpringLayout.NORTH, backButton,10, SpringLayout.NORTH, this);
        
        // adjust constraints for the label
        // at coordinates (10, 15)
        // north coordinate needs to be lower on the screen than the text field so they line up
        layout.putConstraint(SpringLayout.WEST, textFieldLabel,10,SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, textFieldLabel,15 + 30, SpringLayout.NORTH, this);
 
        // adjust constraints for the text field
        // at coordinates (<label's right edge> + 5, 10).
        layout.putConstraint(SpringLayout.WEST, textField, 5,SpringLayout.EAST, textFieldLabel);
        layout.putConstraint(SpringLayout.NORTH, textField,10 + 30,SpringLayout.NORTH, this);
        
        layout.putConstraint(SpringLayout.WEST, textFieldLabel2,10,SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, textFieldLabel2,15 + 30 + 15+10, SpringLayout.NORTH, this);
        
        layout.putConstraint(SpringLayout.WEST, textField2, 5,SpringLayout.EAST, textFieldLabel);
        // 30 has to do with the text field parameter being 20??? (add 10 down from first coordinates,
        // then add 20 for the size of the next text box, then add 5 to put some space between them)
        layout.putConstraint(SpringLayout.NORTH, textField2,30 + 5 + 30,SpringLayout.NORTH, this);
        
        layout.putConstraint(SpringLayout.NORTH, submitButton,30,SpringLayout.NORTH, textField2);
        layout.putConstraint(SpringLayout.WEST, submitButton,200, SpringLayout.WEST, this);
        
        layout.putConstraint(SpringLayout.NORTH, scrollPane,30,SpringLayout.NORTH, submitButton);
        layout.putConstraint(SpringLayout.WEST, scrollPane,20, SpringLayout.WEST, this);
        
        add(textFieldLabel);
        add(textFieldLabel2);
        add(textField);
        add(textField2);
        add(submitButton);
        add(scrollPane);
        

		
	}
	
	class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e){
			CardLayout cardLayout = cardtest.getCardLayout();
			cardLayout.show(cardtest.getCards(), "card4");
		}
		
	}
	
	class ButtonListener1 implements ActionListener {
		
		public void actionPerformed(ActionEvent e){
			CardLayout cardLayout = cardtest.getCardLayout();
			// could pass the forward and back information in through the constructor
			cardLayout.show(cardtest.getCards(), "card2");
		}
		
	}
	
	class TextListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e){
			
	        String text = textField.getText();
	        String text2 = textField2.getText();
	        
	        textArea.append("Field 1: " + text + "\n");
	        textArea.append("Field 2: " + text2 + "\n");

	        //textField.selectAll();

	        //Make sure the new text is visible, even if there
	        //was a selection in the text area.
	        textArea.setCaretPosition(textArea.getDocument().getLength());
			
		}
		
	}
	
}
