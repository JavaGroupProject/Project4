import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class Friend {

	// variables to store basic information about the friend
	private String name;
	private String profilePicture;
	private int mutualFriends;
	private String location;
	private int age;
	
	// constants to store the files
	private final String FRIEND_INFO = "friendInfo.txt";
	private final String FRIEND_PICTURES = "friendPictureInfo.txt";
	
	// arraylists to store the friend's messages and pictures 
	private ArrayList<String> messages = new ArrayList<String>();
	private ArrayList<String> pictures = new ArrayList<String>();
	
	public Friend(String name, String profilePicture, int mutualFriends, String location, int age){

		this.name = name;
		this.profilePicture = profilePicture;
		this.mutualFriends = mutualFriends;
		this.location = location;
		this.age = age;
		
		// load the messages and pictures from the correct text files
		try {
			loadMessages();
			loadPictures();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	// get the name
	public String getName(){
		return name;
	}
	
	// get the profile picture
	public String getProfilePicture(){
		return profilePicture;
	}
	
	// return a random picture
	public String getRandomPicture(){
		
			// Create a random number generator
			// Citation: http://www.javapractices.com/topic/TopicAction.do?Id=62
			Random numberGenerator = new Random();
			
	  		// generate a random number from 0 to the size of the pictures list - 1 
			// (a valid index into the ArrayList)
	  		int randomIndex = numberGenerator.nextInt(pictures.size());
	  		
	  		return pictures.get(randomIndex);	
	}
	
	// return a random message
	public String getRandomMessage(){
		
		// Create a random number generator
		// Citation: http://www.javapractices.com/topic/TopicAction.do?Id=62
		Random numberGenerator = new Random();
		
  		// generate a random number from 0 to the size of the pictures list - 1 
		// (a valid index into the ArrayList)
  		int randomIndex = numberGenerator.nextInt(messages.size());
  		
  		return messages.get(randomIndex);
	
	}
	
	// load the messages for this friend from a text file
	// http://www.tutorialspoint.com/javaexamples/applet_readfile.htm
	public void loadMessages() throws FileNotFoundException, IOException {
		
		String line = null;
		URL url = Canvas.class.getResource(FRIEND_INFO);
	     
		// read all of the lines from the file
	    InputStream in = url.openStream();
	    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	    while((line = reader.readLine()) != null){
	    	
			// split the line into two separate strings on "#"
			// Citation: http://docs.oracle.com/javase/tutorial/java/data/manipstrings.html
			String [] splitLine = line.split("#");
			
			// if the name is the same as this friend
			if (splitLine[0].equals(name)){
				for (int i = 1; i < splitLine.length; i++){
					// add the messages
					messages.add(splitLine[i]);
				}
			}	
	    }
	}

	// load the pictures for this friend from a text file
	// http://www.tutorialspoint.com/javaexamples/applet_readfile.htm
	public void loadPictures() throws FileNotFoundException, IOException {
		
		String line = null;
		URL url = Canvas.class.getResource(FRIEND_PICTURES);
		
		// read all of the lines in the file
	    InputStream in = url.openStream();
	    BufferedReader bf = new BufferedReader(new InputStreamReader(in));
	    while((line = bf.readLine()) != null){
	    	
			// split the line into two separate strings on "#"
			// Citation: http://docs.oracle.com/javase/tutorial/java/data/manipstrings.html
			String [] splitLine = line.split("#");
					
			// if the name is the same as this friend
			if (splitLine[0].equals(name)){
				for (int i = 1; i < splitLine.length; i++){
					// add the pictures
					pictures.add(splitLine[i]);
				}
			}	
	    }
	}
	
}