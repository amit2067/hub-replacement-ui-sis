package uk.syntel.hackathon.sis.app.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

@Document(collection = "Customer")
public class Customer {

	@Id
    @ApiModelProperty(notes="Customer Id")
	private String id;
    
    @ApiModelProperty(notes="First name")
	private String firstName;
    
    @ApiModelProperty(notes="Last name")
	private String lastName;
    
    @ApiModelProperty(notes="Email Address")
	private String emailAddress;
    
    @ApiModelProperty(notes="Address Line 1")
	private String addressLine1;
    
    @ApiModelProperty(notes="Address Line 2")
	private String addressLine2;
    
    @ApiModelProperty(notes="City")
	private String city;
    
    @ApiModelProperty(notes="Postal Code")
	private String postalCode;
    
    @ApiModelProperty(notes="Phone Number")
	private String phoneNumber;
    
    @ApiModelProperty(notes="Created By")
	private String createdBy;

	public Customer() {
	}
	
	public Customer(String id, String firstName, String lastName, String emailAddress, String addressLine1,
			String addressLine2, String city, String postalCode, String phoneNumber, String createdBy) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.postalCode = postalCode;
		this.phoneNumber = phoneNumber;
		this.createdBy = createdBy;
	}

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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailAddress="
				+ emailAddress + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city
				+ ", postalCode=" + postalCode + ", phoneNumber=" + phoneNumber + ", createdBy=" + createdBy + "]";
	}
	
}
