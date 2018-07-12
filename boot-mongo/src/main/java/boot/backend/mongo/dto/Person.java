package boot.backend.mongo.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Person {
	
	@Id
	private String id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String contactNumber;
	private String countryName;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", contactNumber=" + contactNumber + ", countryName=" + countryName + "]";
	}
	
	

}
