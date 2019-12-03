package org.hltic.sms_androidfrontend.domaine.dto;

import java.math.BigDecimal;

/**
 * Created by Khalil Hisseine  hamdane.khalil.hisseine@gmail.com on 07/2019.
 */

public class RegistrationDto{
	
	private long idReg;
	private String registerRef;
	private StudentDto student;
    private BigDecimal fees;
    private String date;
    private String year;
	private String urlImage;
	private String image;
	
	
	public RegistrationDto() {
		super();
	}


	public RegistrationDto(long idReg, String registerRef, StudentDto student, BigDecimal fees, String date,
			String year, String urlImage, String image) {
		super();
		this.idReg = idReg;
		this.registerRef = registerRef;
		this.student = student;
		this.fees = fees;
		this.date = date;
		this.year = year;
		this.urlImage = urlImage;
		this.image = image;
	}


	public long getIdReg() {
		return idReg;
	}

	public void setIdReg(long idReg) {
		this.idReg = idReg;
	}

	public String getRegisterRef() {
		return registerRef;
	}

	public void setRegisterRef(String registerRef) {
		this.registerRef = registerRef;
	}

	public StudentDto getStudent() {
		return student;
	}


	public void setStudent(StudentDto student) {
		this.student = student;
	}


	public BigDecimal getFees() {
		return fees;
	}


	public void setFees(BigDecimal fees) {
		this.fees = fees;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "RegistrationDto{" +
				", registrationRef='" + registerRef + '\'' +
				", student=" + student +
				", fees=" + fees +
				", date='" + date + '\'' +
				", year='" + year + '\'' +
				", imageUrl='" + urlImage + '\'' +
				'}';
	}
}
