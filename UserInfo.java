import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class UserInfo {

	private String name = "";	
	private String birthday = "";
	private String email = "";
	private String address = "";
	private String phone = "";
	private String ssn = "";
	private String profilePicture = "";
	private String gender = "";
	private String creditCard = "";
	private String school = "";
	private String gradYear = "";
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getGradYear() {
		return gradYear;
	}

	public void setGradYear(String gradYear) {
		this.gradYear = gradYear;
	}
	
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
	
	public String getAddress(){
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
	
	public String getSsn(){
		return ssn;
	}
	
	public void setProfilePicture(String aProfilePicture){
		profilePicture = aProfilePicture;
	}
	
	public String getProfilePicture(){
		return profilePicture;
	}

}