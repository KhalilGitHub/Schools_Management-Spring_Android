package org.hltic.sms_androidfrontend.domaine.dto;


public class TeacherDto extends PersonDto{
	
	private long idTeach;
	private String teacherRef;
	private int  utNumber;
	private String firstUt;
	private String secondUt;
	
	public TeacherDto() {
		super();
	}

	public TeacherDto(long idTeach, String teacherRef, int utNumber, String firstUt, String secondUt) {
		super();
		this.idTeach = idTeach;
		this.teacherRef = teacherRef;
		this.utNumber = utNumber;
		this.firstUt = firstUt;
		this.secondUt = secondUt;
	}

	

	public long getIdTeach() {
		return idTeach;
	}

	public void setIdTeach(long idTeach) {
		this.idTeach = idTeach;
	}

	public String getTeacherRef() {
		return teacherRef;
	}

	public void setTeacherRef(String teacherRef) {
		this.teacherRef = teacherRef;
	}

	public int getUtNumber() {
		return utNumber;
	}

	public void setUtNumber(int utNumber) {
		this.utNumber = utNumber;
	}

	public String getFirstUt() {
		return firstUt;
	}

	public void setFirstUt(String firstUt) {
		this.firstUt = firstUt;
	}

	public String getSecondUt() {
		return secondUt;
	}

	public void setSecondUt(String secondUt) {
		this.secondUt = secondUt;
	}
	
}
