import java.awt.CardLayout;
import java.awt.Dimension;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JApplet;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyApplet extends JApplet{
		
	private final String passwordMsg = "1. Passwords should be at least 10 characters long\n\n2. Use a mix of upper "
			+ "case letters, lower case letters, symbols, and numbers\n\n3. Don't include personal information"
			+ " in your password\n\n4. Don't pick a word from the dictionary\n\n5. Consider using a pass phrase "
			+ "- think of a sentence, add punctuation, capitalize some letters, and then add numbers and "
			+ "symbols\n\n6. Remember to change your password every few months";
	
	private final String infoMsg = "- Remember that the information you post online can be seen by "
			+ "anyone\n\n- Information to avoid posting:\n\n\t1. address\n\n\t2. phone number\n\n\t3. "
			+ "passwords\n\n\t4. social security number\n\n\t5. birth date\n\n\t6. credit card numbers";
	
	private final String friendMsg = "Be careful that you know who you add or friend on "
			+ "social media. Identity thieves might create fake profiles"
			+ " in order to get information from you: this is"
			+ " known as social engineering. Be sure you recognize the"
			+ " person you are considering adding or friending based on"
			+ " their picture, information, profile details, and mutual friends."
			+ " If you have any reason to doubt that they are not who they say"
			+ " they are, do NOT associate with them on social media!";
	
	private final String profPicMsg = "Think twice before putting up just any profile picture"
			+ " for your social media account! There's a saying that once something"
			+ " is put online, it's up there forever. Even if you delete it, what"
			+ " is to stop someone else from accessing and obtaining that"
			+ " information before it is taken down? You must consider that"
			+ " whatever picture you post online will represent YOU. That"
			+ " picture can be a strong first impression for people you meet"
			+ " online, potential employers, that guy or girl you just went on"
			+ " a first date with, and the list goes on! To play it safe, Don't"
			+ " put any picture (or information) online that you wouldn't want"
			+ " your mother to see!";
	
	private final String privacySettingMsg = "You may not even realize to make your social"
			+ " media account private because some social media sites"
			+ " automatically make your account public for anyone to view"
			+ " by default. For instance, anyone can add you and view your"
			+ " 'Story' on snapchat and most people don't even realize this."
			+ " So make sure that you set your account settings to PRIVATE if"
			+ " the option is availble. If you have the option, only let your"
			+ " friends or people you know on that form of social media view"
			+ " your profile information and whatever you post. Most forms of"
			+ " social media have privacy setting options. Take the extra minute"
			+ " to check them out and keep your information private!";
	
	private final String badLinksMsg = "Guidelines for Safe Downloads: \n\n"
			+ "1. While downloading any file close all the applications that "
			+ "are running on your computer, let only one set-up file run "
			+ "at a time of downloading. \n\n2. Close all the important applications "
			+ "in order to be safe if something goes wrong while downloading. "
			+ "\n\n3. Set firewalls, set antivirus to actively scan all the files "
			+ "you download. \n\n4. Scan all the files after you download whether "
			+ "from websites or links received from e-mails. \n\n5. Always use "
			+ "updated antivirus, spam filter and spyware to help detect "
			+ "and remove virus, spyware from the application you want to "
			+ "download. \n\n6. Never download any files like music, video, games "
			+ "and many more from untrusted sites and don’t go by the "
			+ "recommendations given by your friends or made by any random "
			+ "website's comments. \n\n7. Check that the URLs are same and always "
			+ "download games, music or videos from the secure websites like "
			+ "which use HTTPS websites instead of HTTP. In the web address, "
			+ "it replaces “http” to https”. The https refers to the hypertext "
			+ "transfer protocol secure. \n\n8. Download anything only from "
			+ "thrust worthy websites. Don’t click links to download anything "
			+ "you see on unauthorized sites. \n\n9. If any dirty words appear "
			+ "on the website just close the window no matter how important it "
			+ "is, because  spyware may be installed on your PC from such websites. "
			+ "\n\n 10. Check the size of the file before you download, sometimes "
			+ "it shows a very small size but after you click it increases the size "
			+ "of the file. \n\n11. Never believe anything which says click on this "
			+ "link and  your computer settings will be changed and your PC can be "
			+ "turned into XBOX and can play unlimited games on your computer. "
			+ "\n\n12. Don’t accept anything that offers you free download because "
			+ "that may contain malicious software. \n\n13. Don’t click the link "
			+ "or file and let it start download automatically, download the file "
			+ "and save where you want save and then run on the application. \n\n"
			+ "14. Set secure browser settings before you download anything. \n\n"
			+ "15. Read carefully before you click on install or run application. "
			+ "That means read terms and conditions. \n\n16. Don’t download anything "
			+ "until you know complete information of the website and know whether "
			+ "it is an original site of an original company. \n\n17. Never download "
			+ "from the links that offer free antivirus or anti spyware software, "
			+ "always download from trusted sites, if you are not sure about the site "
			+ "you are downloading, enter the site into favourite search engine to see "
			+ "anyone posted or reported that it contains unwanted technologies.";
	
	// Create card layout
	private CardLayout cardLayout = new CardLayout();
	
	// Create a JPanel to store the card layout
	private JPanel cards;
	
	// Initialize constants
	private final int WIDTH = 500;
	private final int HEIGHT = 500;
	
	// Initialize  Panels
	Welcome myWelcome = new Welcome(this);
	private Lesson lesson1 = new Lesson(this, 1, passwordMsg);
	private Lesson lesson2 = new Lesson(this, 2, infoMsg);
	private Lesson lesson3 = new Lesson(this, 3, friendMsg);
	private Lesson lesson4 = new Lesson(this, 4, profPicMsg);
	private Lesson lesson5 = new Lesson(this, 5, privacySettingMsg);
	private Lesson lesson6 = new Lesson(this, 6, badLinksMsg);
	private TeacherInfo teacher = new TeacherInfo(this);
	private PasswordTest password = new PasswordTest(this, 1);
	private InfoTest info = new InfoTest(this, 2);
	
	// Set Strings for Panels
	final static String WELCOME = "Welcome";
	final static String LESSON1 = "Lesson1";
	final static String LESSON2 = "Lesson2";
	final static String LESSON3 = "Lesson3";
	final static String LESSON4 = "Lesson4";
	final static String LESSON5 = "Lesson5";
	final static String LESSON6 = "Lesson6";
	final static String TEACHER = "Teacher";
	final static String PASSWORD = "Test1";
	final static String INFO = "Test2";
	
	
	
	public MyApplet(){
		
		// Set the size of the applet
		setSize(new Dimension(WIDTH, HEIGHT));
		
		// Set cardlayout
		cards = new JPanel(cardLayout);
		
		// Add the cards to the cardlayout
		cards.add(myWelcome, WELCOME);
		cards.add(lesson1, LESSON1);
		cards.add(lesson2, LESSON2);
		cards.add(lesson3, LESSON3);
		cards.add(lesson4, LESSON4);
		cards.add(lesson5, LESSON5);
		cards.add(lesson6, LESSON6);
		cards.add(teacher, TEACHER);
		cards.add(password, PASSWORD);
		cards.add(info, INFO);
		
		// Add the cardlayout to the applet
		add(cards);	
	}
	
	
	// Shows the next lesson
	public void showNextTest(int number){
		
		// Check if the page exists
		number++;
		String newCardName = "Test" + number;
		
		cardLayout.show(cards, newCardName);
	}
	
	// Shows the next lesson
	public void showNextLesson(int number){
		
		// Check if the page exists
		number++;
		if (number == 6){
			cardLayout.show(cards, PASSWORD);
		}else{
			String newCardName = "Lesson" + number;
		
			cardLayout.show(cards, newCardName);
		}
	}
	
	
	// Shows the previous lesson
	public void showPreviousLesson(int number){
		
		// Check if the page exists
		number--;
		if (number == 0){
			cardLayout.show(cards, WELCOME);
		}
		else {
			String newCardName = "Lesson" + number;
			cardLayout.show(cards, newCardName);
		}
		
	}
	
	// Shows the first lesson
	public void showLesson1(){
		
		cardLayout.show(cards, LESSON1);	
	}

	// Shows the first lesson
	public void showWelcome(){
		
		cardLayout.show(cards, WELCOME);	
	}
	
	public void showTeacher(){
		
		cardLayout.show(cards, TEACHER);
	}
	
	// Main
	public static void main(String[] args) {
		
		try {
			javax.swing.SwingUtilities.invokeAndWait(new Runnable(){
				public void run(){
					@SuppressWarnings("unused")
					MyApplet applet = new MyApplet();
				}
			});
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}