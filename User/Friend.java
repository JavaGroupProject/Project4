import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class Friend {

	private String name;
	private String profilePicture;
	private int mutualFriends;
	private String location;
	private int age;
	
	private ArrayList<String> messages = new ArrayList<String>();
	private ArrayList<String> pictures = new ArrayList<String>();
	
	public Friend(String name, String profilePicture, int mutualFriends, String location, int age){

		this.name = name;
		this.profilePicture = profilePicture;
		this.mutualFriends = mutualFriends;
		this.location = location;
		this.age = age;
		
		try {
			loadMessages();
			loadPictures();
			//loadMessagesURL();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public String getName(){
		return name;
	}
		
	public String getRandomPicture(){
		
			// Create a random number generator
			// Citation: http://www.javapractices.com/topic/TopicAction.do?Id=62
			Random numberGenerator = new Random();
			
	  		// generate a random number from 0 to the size of the pictures list - 1 
			// (a valid index into the ArrayList)
	  		int randomIndex = numberGenerator.nextInt(pictures.size());
	  		
	  		return pictures.get(randomIndex);
		
	}
	
	public String getRandomMessage(){
		
		// Create a random number generator
		// Citation: http://www.javapractices.com/topic/TopicAction.do?Id=62
		Random numberGenerator = new Random();
		
  		// generate a random number from 0 to the size of the pictures list - 1 
		// (a valid index into the ArrayList)
  		int randomIndex = numberGenerator.nextInt(messages.size());
  		
  		return messages.get(randomIndex);
	
}
	
	public void loadMessages() throws FileNotFoundException, IOException {
		
		// http://www.tutorialspoint.com/javaexamples/applet_readfile.htm
		// this version of the method reads from a file placed in bin
		String line = null;
		URL url = Canvas.class.getResource("friendInfo.txt");
	         
	    InputStream in = url.openStream();
	    BufferedReader bf = new BufferedReader(new InputStreamReader(in));
	    while((line = bf.readLine()) != null){
	    	
			// split the line into two separate strings on "#"
			// Citation: http://docs.oracle.com/javase/tutorial/java/data/manipstrings.html
			String [] splitLine = line.split("#");
					
			if (splitLine[0].equals(name)){
				for (int i = 1; i < splitLine.length; i++){
					messages.add(splitLine[i]);
				}
			}
	    	
	    }

	}

	public void loadPictures() throws FileNotFoundException, IOException {
		
		// http://www.tutorialspoint.com/javaexamples/applet_readfile.htm
		// this version of the method reads from a file placed in bin
		String line = null;
		URL url = Canvas.class.getResource("friendPictureInfo.txt");
	         
	    InputStream in = url.openStream();
	    BufferedReader bf = new BufferedReader(new InputStreamReader(in));
	    while((line = bf.readLine()) != null){
	    	
			// split the line into two separate strings on "#"
			// Citation: http://docs.oracle.com/javase/tutorial/java/data/manipstrings.html
			String [] splitLine = line.split("#");
					
			if (splitLine[0].equals(name)){
				for (int i = 1; i < splitLine.length; i++){
					pictures.add(splitLine[i]);
				}
			}
	    	
	    }

	}
	
	/*public void loadMessages() throws FileNotFoundException, IOException {
		
		String filename = "/Users/Zoe/Desktop/friendInfo.txt";
		
		// open the file and create a BufferedReader object to read it
		File file = new File(filename);
		BufferedReader reader = new BufferedReader(new FileReader(file));
			
		// string to store the information on each line
		String line = null;
			
		// loop through all the lines in the file
		while ((line = reader.readLine()) != null){
			
			// split the line into two separate strings on "#"
			// Citation: http://docs.oracle.com/javase/tutorial/java/data/manipstrings.html
			String [] splitLine = line.split("#");
					
			if (splitLine[0].equals(name)){
				for (int i = 1; i < splitLine.length; i++){
					messages.add(splitLine[i]);
				}
			}
				
		}
		
		// close the input file
		reader.close();
				
	}
	
	public void loadPictures() throws FileNotFoundException, IOException {
		
		String filename = "/Users/Zoe/Desktop/friendPictureInfo.txt";
		
		// open the file and create a BufferedReader object to read it
		File file = new File(filename);
		BufferedReader reader = new BufferedReader(new FileReader(file));
			
		// string to store the information on each line
		String line = null;
			
		// loop through all the lines in the file
		while ((line = reader.readLine()) != null){
			
			// split the line into two separate strings on "#"
			// Citation: http://docs.oracle.com/javase/tutorial/java/data/manipstrings.html
			String [] splitLine = line.split("#");
					
			if (splitLine[0].equals(name)){
				for (int i = 1; i < splitLine.length; i++){
					pictures.add(splitLine[i]);
				}
			}
				
		}
		
		// close the input file
		reader.close();

	}*/
	
}