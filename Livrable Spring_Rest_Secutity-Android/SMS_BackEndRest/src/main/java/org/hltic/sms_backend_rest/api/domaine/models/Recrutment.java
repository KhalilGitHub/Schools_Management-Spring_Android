package org.hltic.sms_backend_rest.api.domaine.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "recrutment")
//@Data
//@Builder
public class Recrutment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idRec;
	@NotEmpty
	@Column(unique = true, nullable = false)
	private String recrutmentRef;
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private Teacher teacher;
	private int numberHourTeached;
    private BigDecimal hourFees;
    private BigDecimal salary;
    @DateTimeFormat(pattern="dd-mm-yyyy")
    private Date date;
    private String urlImage;
    
	public Recrutment() {
		super();
	}

	public Recrutment(@NotEmpty String recrutmentRef, Teacher teacher, int numberHourTeached, BigDecimal hourFees,
			BigDecimal salary, Date date, String urlImage) {
		super();
		this.recrutmentRef = recrutmentRef;
		this.teacher = teacher;
		this.numberHourTeached = numberHourTeached;
		this.hourFees = hourFees;
		this.salary = salary;
		this.date = date;
		this.urlImage = urlImage;
	}

	public Recrutment(long idRec, @NotEmpty String recrutmentRef, Teacher teacher, int numberHourTeached,
			BigDecimal hourFees, BigDecimal salary, Date date, String urlImage) {
		super();
		this.idRec = idRec;
		this.recrutmentRef = recrutmentRef;
		this.teacher = teacher;
		this.numberHourTeached = numberHourTeached;
		this.hourFees = hourFees;
		this.salary = salary;
		this.date = date;
		this.urlImage = urlImage;
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

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
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
		return salary ;
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

	@Override
	public String toString() {
		return "Recrutment [idRec=" + idRec + ", recrutmentRef=" + recrutmentRef + ", teacher=" + teacher
				+ ", numberHourTeached=" + numberHourTeached + ", hourFees=" + hourFees + ", salary=" + salary
				+ ", date=" + date + ", urlImage=" + urlImage + "]";
	}

	
}
