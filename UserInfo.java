import java.util.ArrayList;

public class UserInfo {

	// strings to store all of the user's info
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
	
	private ArrayList<String> pictures = new ArrayList<String>();
	
	// get the users pictures
	public ArrayList<String> getPictures(){
		return pictures;
	}
	
	// add a picture
	public void addPicture(String picture){
		pictures.add(picture);
	}
	
	// get the gender
	public String getGender() {
		return gender;
	}

	// set the gender
	public void setGender(String gender) {
		this.gender = gender;
	}

	// get the credit card number
	public String getCreditCard() {
		return creditCard;
	}

	// set the credit card number
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	// get the school
	public String getSchool() {
		return school;
	}

	// set the school
	public void setSchool(String school) {
		this.school = school;
	}

	// get the grad year
	public String getGradYear() {
		return gradYear;
	}

	// set the grad year
	public void setGradYear(String gradYear) {
		this.gradYear = gradYear;
	}
	
	// set the name
	public void setName(String aName){
		name = aName;
	}
	
	// get the name
	public String getName(){
		return name;
	}	
	
	// set the birthday
	public void setBirthday(String aBirthday){
		birthday = aBirthday;
	}
	
	// get the birthday
	public String getBirthday(){
		return birthday;
	}
	
	// set the email
	public void setEmail(String anEmail){
		email = anEmail;
	}
	
	// get the email
	public String getEmail(){
		return email;
	}
	
	// set the address
	public void setAddress(String anAddress){
		address = anAddress;
	}
	
	// get the address
	public String getAddress(){
		return address;
	}
	
	// set the phone number
	public void setPhone(String aPhone){
		phone = aPhone;
	}
	
	// get the phone number
	public String getPhone(){
		return phone;
	}
	
	// set the social security number
	public void setSsn(String aSsn){
		ssn = aSsn;
	}
	
	// get the social security number
	public String getSsn(){
		return ssn;
	}
	
	// set the profile picture
	public void setProfilePicture(String aProfilePicture){
		profilePicture = aProfilePicture;
	}
	
	// get the profile picture
	public String getProfilePicture(){
		return profilePicture;
	}

}