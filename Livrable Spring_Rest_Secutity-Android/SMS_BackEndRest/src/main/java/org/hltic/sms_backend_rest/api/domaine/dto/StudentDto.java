package org.hltic.sms_backend_rest.api.domaine.dto;

public class StudentDto extends PersonDto{
	
	private int idStud;
	private int age;
	private String studentRef;
	private String classRoom;

	public StudentDto() {
		super();
	}
	

	public StudentDto(int idStud, String studentRef, String firstName, String lastName, String gender, String adress,int age, String classRoom) {
		super(firstName, lastName, gender, adress);
		this.idStud = idStud;
		this.studentRef = studentRef;
		this.age = age;
		this.classRoom = classRoom;
	}

	public StudentDto(String studentRef, String firstName, String lastName, String gender, String adress,int age, String classRoom) {
		super(firstName, lastName, gender, adress);
		this.studentRef = studentRef;
		this.age = age;
		this.classRoom = classRoom;
	}


	public int getAge() {
		return age;
	}

	public int getIdStud() {
		return idStud;
	}


	public void setIdStud(int idStud) {
		this.idStud = idStud;
	}


	public String getStudentRef() {
		return studentRef;
	}


	public void setStudentRef(String studentRef) {
		this.studentRef = studentRef;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getClassRoom() {
		return classRoom;
	}


	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}


}
