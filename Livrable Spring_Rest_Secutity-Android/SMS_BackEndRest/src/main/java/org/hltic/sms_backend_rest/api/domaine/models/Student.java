package org.hltic.sms_backend_rest.api.domaine.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "student")
@EntityListeners(AuditingEntityListener.class)
public class Student extends Person implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idStud;
	private int age;
	@Column(unique = true, nullable = false)
	private String studentRef;
	private String classRoom;

	
	
	public Student() {
		super();
	}
	
	public Student(@NotEmpty String studentRef, int age, String classRoom) {
		this.studentRef = studentRef;
		this.age = age;
		this.classRoom = classRoom;
	}
	
	public Student(@NotEmpty String studentRef, String firstName, String lastName, String gender, String adress,int age, String classRoom) {
		super(firstName, lastName, gender, adress);
		this.studentRef = studentRef;
		this.age = age;
		this.classRoom = classRoom;
	}
	
	public Student(int idStud, String firstName, String lastName, String gender, String adress,int age, String classRoom) {
		super(firstName, lastName, gender, adress);
		this.idStud = idStud;
		this.age = age;
		this.classRoom = classRoom;
	}

	public int getIdStud() {
		return idStud;
	}

	public void setIdStud(int idStud) {
		this.idStud = idStud;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getStudentRef() {
		return studentRef;
	}

	public void setStudentRef(String studentRef) {
		this.studentRef = studentRef;
	}

	public String getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}

	@Override
	public String toString() {
		return "Student [idStud=" + idStud + ", age=" + age + ", studentRef=" + studentRef + ", classRoom=" + classRoom
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", adress=" + adress
				+ "]";
	}
				
}
