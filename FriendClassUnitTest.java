import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

// unit test for the Friend class
public class FriendClassUnitTest {

	// friend object
	private Friend testFriend;
	
	// name
	private String friendName = "Test Name";
	
	// image
	private String friendImage = "image1.jpg";
	
	// age
	private int friendAge = 20;
	
	// location
	private String friendLocation = "test location";
	
	// mutual friends
	private int friendMutualFriends = 9;
	
	// arraylist of pictures
	private ArrayList<String> pictures = new ArrayList<String>();
	
	// arraylist of messages
	private ArrayList<String> messages = new ArrayList<String>();
	
	// method to set up the tests
	@Before
	public void setUpFriend(){
		
		// create the test friend object
		testFriend = new Friend(friendName, friendImage, friendMutualFriends, friendLocation, friendAge);
		
		// add the same pictures that are in the file
		pictures.add("image1.jpg");
		pictures.add("image2.jpg");
		pictures.add("image3.jpg");
		pictures.add("image4.jpg");
		
		// add the same messages that are in the file
		messages.add("message one");
		messages.add("message two");
		messages.add("message three");
		
	}
	
	// test the constructor
	@Test
	public void constructorTest(){
		
		// check that the private member variables are set correctly
		assertEquals(friendName, testFriend.getName());
		assertEquals(friendImage, testFriend.getProfilePicture());
		assertEquals(friendAge, testFriend.getAge());
		assertEquals(friendLocation, testFriend.getLocation());
		assertEquals(friendMutualFriends, testFriend.getMutualFriends());
		
	}
	
	// test the random picture method
	@Test
	public void getRandomPictureTest(){
		
		// get a random picture
		String randomPicture = testFriend.getRandomPicture();
		// check if the random picture is in the list of pictures
		assertTrue(pictures.contains(randomPicture));
		
		// repeat the same test 2 more times
		randomPicture = testFriend.getRandomPicture();
		assertTrue(pictures.contains(randomPicture));
		randomPicture = testFriend.getRandomPicture();
		assertTrue(pictures.contains(randomPicture));

	}
	
	// test the random message method
	@Test
	public void getRandomMessageTest(){
		
		// get a random message
		String randomMessage = testFriend.getRandomMessage();
		// check if the random message is in the list of messages
		assertTrue(messages.contains(randomMessage));
		
		// repeat the same test 2 more times
		randomMessage = testFriend.getRandomMessage();
		assertTrue(messages.contains(randomMessage));
		randomMessage = testFriend.getRandomMessage();
		assertTrue(messages.contains(randomMessage));

	}

}
