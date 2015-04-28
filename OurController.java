import java.awt.CardLayout;
import java.awt.Dimension;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.swing.JApplet;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class OurController extends JApplet{
		
	// Create card layout
	private CardLayout cardLayout = new CardLayout();
	
	// Create a JPanel to store the card layout
	private JPanel cards;
	
	// Create user
	private UserInfo user;
	
	// Create the canvas
	private Canvas canvas;
	
	// Create the results
	private Results results;
	
	// Initialize constants
	private final int WIDTH = 750;
	private final int HEIGHT = 750;
	
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
	final static String PICTURE = "Test3";
	final static String FRIEND = "Test4";
	final static String CANVAS = "Canvas";
	final static String RESULTS = "Results";
	
	// Array list to store all of the friends
	private ArrayList<Friend> friends = new ArrayList<Friend>();
	
	public OurController(){
				
		// Set the size of the applet
		setSize(new Dimension(WIDTH, HEIGHT));
		
		// Set cardlayout
		cards = new JPanel(cardLayout);
		
		// Create user
		user = new UserInfo();
		
		// Initialize  Panels
		Welcome myWelcome = new Welcome(this);
		Lesson lesson1 = new Lesson(this, 1);
		Lesson lesson2 = new Lesson(this, 2);
		Lesson lesson3 = new Lesson(this, 3);
		Lesson lesson4 = new Lesson(this, 4);
		Lesson lesson5 = new Lesson(this, 5);
		Lesson lesson6 = new Lesson(this, 6);
		TeacherInfo teacher = new TeacherInfo(this);
		PasswordTest password = new PasswordTest(this, 1);
		InfoTest info = new InfoTest(this, 2);
		PictureTest picture = new PictureTest(this, 3);
		FriendTest friend = new FriendTest(this, 4);
			
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
		cards.add(picture, PICTURE);
		cards.add(friend, FRIEND);
		
		// Add the cardlayout to the applet
		add(cards);	
	}
	
	// get the user
	public UserInfo getUser(){
		return user;
	}
	
	// get the array list of friends
	public ArrayList<Friend> getFriends(){
		return friends;
	}
		
	// Shows the next test
	public void showNextTest(int number){
		
		number++;
		String newCardName = "Test" + number;
		
		cardLayout.show(cards, newCardName);
	}
	
	// Shows the next lesson
	public void showNextLesson(int number){
		
		number++;
		
		// if the lessons are finished, then show the password card
		if (number == 7){
			cardLayout.show(cards, PASSWORD);
		}
		else{ // otherwise show the next lesson
			String newCardName = "Lesson" + number;
			cardLayout.show(cards, newCardName);
		}
	}
	
	
	// Shows the previous lesson
	public void showPreviousLesson(int number){
		
		number--;
		
		// return to the welcome page if they were only on the first lesson
		if (number == 0){
			cardLayout.show(cards, WELCOME);
		}
		else { // otherwise show the previous lesson
			String newCardName = "Lesson" + number;
			cardLayout.show(cards, newCardName);
		}
		
	}
	
	// Shows the first lesson
	public void showLesson1(){
		
		cardLayout.show(cards, LESSON1);	
	}

	// Shows the welcome page
	public void showWelcome(){
		
		cardLayout.show(cards, WELCOME);	
	}
	
	// Shows the teacher page
	public void showTeacher(){
		
		cardLayout.show(cards, TEACHER);
	}
	
	// Shows the canvas
	public void showCanvas(){
		
		// create the canvas, add it to the cards, and call the display method
		canvas = new Canvas(this);
		cards.add(canvas, CANVAS);
		canvas.display();
		
		// show the canvas card
		cardLayout.show(cards, CANVAS);
		
	}
	
	// Show the friends list page
	public void showFriendList(){
		
		cardLayout.show(cards, FRIEND);
	}
	
	// Show the results page
	public void showResults(){
		
		// create the results page and add it to the cards
		results = new Results(this);
		cards.add(results, RESULTS);

		// show the results page
		cardLayout.show(cards, RESULTS);
	}
	
	// Main
	public static void main(String[] args) {
		
		try {
			javax.swing.SwingUtilities.invokeAndWait(new Runnable(){
				public void run(){
					@SuppressWarnings("unused")
					OurController applet = new OurController();
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}	
	}
}