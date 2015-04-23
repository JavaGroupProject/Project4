import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class UserInfo {

	private String name;	
	private String birthday;
	private String email;
	private String address;
	private String phone;
	private String ssn;
	
	
	
	private Image profilePicture;
	
	public void setName(String aName){
		name = aName;
	}
	
	public String getName(){
		return name;
	}	
	
	public void setBirthday(String aBirthday){
		birthday = aBirthday;
	}
	
	public String getBirthday(){
		return birthday;
	}
	
	public void setEmail(String anEmail){
		email = anEmail;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setAddress(String anAddress){
		address = anAddress;
	}
	
	public String getAdress(){
		return address;
	}
	
	public void setPhone(String aPhone){
		phone = aPhone;
	}
	
	public String getPhone(){
		return phone;
	}
	
	public void setSsn(String aSsn){
		ssn = aSsn;
	}
	
	public void setProfilePicture(String imagePath){
		try {
			profilePicture = ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Image getProfilePicture(){
		return profilePicture;
	}

}


