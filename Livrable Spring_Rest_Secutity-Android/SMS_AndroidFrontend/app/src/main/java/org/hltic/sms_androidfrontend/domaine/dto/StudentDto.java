package org.hltic.sms_androidfrontend.domaine.dto;

/**
 * Created by Khalil Hisseine  hamdane.khalil.hisseine@gmail.com on 07/2019.
 */

public class StudentDto extends PersonDto{
	
	private Long idStud;
	private int age;
	private String studentRef;
	private String classRoom;

	public StudentDto() {
		super();
	}
	

	public StudentDto(Long idStud, String studentRef, String firstName, String lastName, String gender, String adress,int age, String classRoom) {
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




	public Long getIdStud() {
		return idStud;
	}

	public void setIdStud(Long idStud) {
		this.idStud = idStud;
	}

	public String getStudentRef() {
		return studentRef;
	}


	public void setStudentRef(String studentRef) {
		this.studentRef = studentRef;
	}


    public int getAge() {
        return age;
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

	@Override
	public String toString() {
		return "StudentDto{" +
				", studentRef='" + studentRef + '\'' +
				", classRoom='" + classRoom + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", age=" + age + '\'' +
				", gender='" + gender + '\'' +
				", adress='" + adress + '\'' +
				'}';
	}
}
