import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelTest extends JPanel{

	CardTest cardtest;
	JButton forwardButton;
	JButton backButton;
	
	public PanelTest(CardTest cardtest){
		
		this.cardtest = cardtest;
		forwardButton = new JButton("   NEXT   ");
		backButton = new JButton("   BACK   ");
		forwardButton.addActionListener(new ButtonListener());
		backButton.addActionListener(new ButtonListener1());
		add(forwardButton);
		add(backButton);
		
	}
	
	class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e){
			CardLayout cardLayout = cardtest.getCardLayout();
			cardLayout.show(cardtest.getCards(), "card1");
		}
		
	}
	
	class ButtonListener1 implements ActionListener {
		
		public void actionPerformed(ActionEvent e){
			CardLayout cardLayout = cardtest.getCardLayout();
			// could pass the forward and back information in through the constructor
			cardLayout.show(cardtest.getCards(), "card2");
		}
		
	}
	
}
