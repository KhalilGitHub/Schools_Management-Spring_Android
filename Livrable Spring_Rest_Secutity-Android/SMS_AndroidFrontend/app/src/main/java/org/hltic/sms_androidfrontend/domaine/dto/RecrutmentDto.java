package org.hltic.sms_androidfrontend.domaine.dto;

import java.math.BigDecimal;
import java.util.Date;


public class RecrutmentDto {
	
	private long idRec;
	private String recrutmentRef;
	private TeacherDto teacherDto;
	private int numberHourTeached;
    private BigDecimal hourFees;
    private BigDecimal salary;
    private Date date;
    private String urlImage;
    
    private String image;
    
	public RecrutmentDto() {
		super();
	}

	

	public RecrutmentDto(String recrutmentRef, TeacherDto teacherDto, int numberHourTeached, BigDecimal hourFees,
			BigDecimal salary, Date date, String urlImage, String image) {
		super();
		this.recrutmentRef = recrutmentRef;
		this.teacherDto = teacherDto;
		this.numberHourTeached = numberHourTeached;
		this.hourFees = hourFees;
		this.salary = salary;
		this.date = date;
		this.urlImage = urlImage;
		this.image = image;
	}
	

	public RecrutmentDto(long idRec, String recrutmentRef, TeacherDto teacherDto, int numberHourTeached, BigDecimal hourFees,
			BigDecimal salary, Date date, String urlImage, String image) {
		super();
		this.idRec = idRec;
		this.recrutmentRef = recrutmentRef;
		this.teacherDto = teacherDto;
		this.numberHourTeached = numberHourTeached;
		this.hourFees = hourFees;
		this.salary = salary;
		this.date = date;
		this.urlImage = urlImage;
		this.image = image;
	}

	

	public long getIdRec() {
		return idRec;
	}



	public void setIdRec(long idRec) {
		this.idRec = idRec;
	}



	public String getRecrutmentRef() {
		return recrutmentRef;
	}

	public void setRecrutmentRef(String recrutmentRef) {
		this.recrutmentRef = recrutmentRef;
	}

	

	public TeacherDto getTeacherDto() {
		return teacherDto;
	}



	public void setTeacherDto(TeacherDto teacherDto) {
		this.teacherDto = teacherDto;
	}



	public int getNumberHourTeached() {
		return numberHourTeached;
	}

	public void setNumberHourTeached(int numberHourTeached) {
		this.numberHourTeached = numberHourTeached;
	}

	public BigDecimal getHourFees() {
		return hourFees;
	}

	public void setHourFees(BigDecimal hourFees) {
		this.hourFees = hourFees;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
	
	
    
}
