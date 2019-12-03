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
@Table(name = "registration")
public class Registration implements Serializable{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idReg;
	@NotEmpty
	 @Column(unique = true, nullable = false)
	private String registerRef;
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private Student student;
    private BigDecimal fees;
    @DateTimeFormat(pattern="dd-mm-yyyy")
    private Date date;
    private String year;
    private String urlImage;
   
    public Registration() {
		super();
	}


	public Registration(@NotEmpty String registerRef, Student student, BigDecimal fees, Date date, String year, String urlImage) {
		
		super();
		this.registerRef = registerRef;
		this.student = student;
		this.fees = fees;
		this.date = date;
		this.year = year;
		this.urlImage = urlImage;
	}


	public Registration(long idReg, String registerRef, Student student, BigDecimal fees, Date date,
			String year, String urlImage) {
		super();
		this.idReg = idReg;
		this.registerRef = registerRef;
		this.student = student;
		this.fees = fees;
		this.date = date;
		this.year = year;
		this.urlImage = urlImage;
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


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public BigDecimal getFees() {
		return fees;
	}


	public void setFees(BigDecimal fees) {
		this.fees = fees;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
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
	
	
	@Override
	public String toString() {
		return "Registration [idReg=" + idReg + ", registerRef=" + registerRef + ", student=" + student + ", fees="
				+ fees + ", date=" + date + ", year=" + year + ", urlImage=" + urlImage + "]";
	}

   
   
}
