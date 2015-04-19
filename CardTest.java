import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

// http://stackoverflow.com/questions/14821952/changing-panels-using-the-card-layout
// http://www.java2s.com/Tutorial/Java/0240__Swing/LoadingaJTextPanewithContentusingStyleConstantstosetAlignFontsizeSpace.htm
// https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/components/TextSamplerDemoProject/src/components/TextSamplerDemo.java

public class CardTest extends JApplet{

	public static int screenWidth = 500;
	public static int screenHeight = 500;
	
	private static String message = "A styled text component can display editable text using more than one "
			+ "font. Some styled text components allow embedded images and even embedded components. Styled "
			+ "text components are powerful and multi-faceted components suitable for high-end needs, and "
			+ "offer more avenues for customization than the other text components.Because they are so "
			+ "powerful and flexible, styled text components typically require more initial programming to "
			+ "set up and use. One exception is that editor panes can be easily loaded with formatted text "
			+ "from a URL, which makes them useful for displaying uneditable help information.";
	
	JPanel cards;
    JButton button1, button2, button3;	
	
	public CardTest(){
		
		button1 = new JButton("   NEXT   ");
        button2 = new JButton("   NEXT   ");
        button3 = new JButton("   NEXT   ");
        
        button1.addActionListener(new ButtonListener1());
        button2.addActionListener(new ButtonListener2());
        button3.addActionListener(new ButtonListener3());
        
        /*
        // use this version if you want styled text instead of just a plain text area
        StyleContext context = new StyleContext();
        StyledDocument document = new DefaultStyledDocument(context);

        Style style = context.getStyle(StyleContext.DEFAULT_STYLE);
        StyleConstants.setAlignment(style, StyleConstants.ALIGN_RIGHT);
        StyleConstants.setFontSize(style, 14);
        StyleConstants.setSpaceAbove(style, 4);
        StyleConstants.setSpaceBelow(style, 4);

        try {
          document.insertString(document.getLength(), message, style);
        } catch (BadLocationException badLocationException) {
          System.err.println("ERROR");
        }
        
        JTextPane textPane = new JTextPane(document);
        textPane.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textPane);
        //scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        //paneScrollPane.setMinimumSize(new Dimension(10, 10));
        */
        
        JTextArea textArea = new JTextArea(message);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane areaScrollPane = new JScrollPane(textArea);
        areaScrollPane.setPreferredSize(new Dimension(300, 200));
        
        JPanel card1 = new JPanel();
        card1.add(button1);
        card1.add(new JLabel("Page 1"));
        //card1.add(scrollPane);
        card1.add(areaScrollPane);

        JPanel card2 = new JPanel();
        card2.add(button2);
        card2.add(new JLabel("Page 2"));

        /*JPanel card3 = new JPanel();
        card3.add(button3);
        card3.add(new JButton("Page 3"));*/
        PanelTest2 card3 = new PanelTest2(this);
        
        PasswordTest card4 = new PasswordTest(this);
        
        cards = new JPanel(new CardLayout());

        cards.add(card1, "card1");
        cards.add(card2, "card2");
        cards.add(card3, "card3");
        cards.add(card4, "card4");
        
        //getContentPane().add(cards); 
        //setVisible(true);
        
        add(cards);
		
	}
	
	public static void main(String [] args){
	
		CardTest test = new CardTest();
		
	}
	
	public CardLayout getCardLayout(){
		
		return (CardLayout) cards.getLayout();
		
	}
	
	public JPanel getCards(){
		
		return cards;
		
	}
	
	class ButtonListener1 implements ActionListener {
		
		public void actionPerformed(ActionEvent e){
			CardLayout cardLayout = (CardLayout) cards.getLayout();
			cardLayout.show(cards, "card2");
		}
		
	}
	
	class ButtonListener2 implements ActionListener {
		
		public void actionPerformed(ActionEvent e){
			CardLayout cardLayout = (CardLayout) cards.getLayout();
			cardLayout.show(cards, "card3");
		}
		
	}
	
	class ButtonListener3 implements ActionListener {
		
		public void actionPerformed(ActionEvent e){
			CardLayout cardLayout = (CardLayout) cards.getLayout();
			cardLayout.show(cards, "card1");
		}
		
	}
	
}