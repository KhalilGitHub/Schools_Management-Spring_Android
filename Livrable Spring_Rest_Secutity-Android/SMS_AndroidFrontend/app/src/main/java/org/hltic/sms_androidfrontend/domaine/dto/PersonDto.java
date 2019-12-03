package org.hltic.sms_androidfrontend.domaine.dto;


/**
 * Created by Khalil Hisseine  hamdane.khalil.hisseine@gmail.com on 07/2019.
 */

public class PersonDto {


	protected String firstName;
	protected String lastName;
	protected String gender;
	protected String adress;
	
	public PersonDto() {
		super();
	}

	public PersonDto(String firstName, String lastName, String gender, String adress) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.adress = adress;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	
	
}
