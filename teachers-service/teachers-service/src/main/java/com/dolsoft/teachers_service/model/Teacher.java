package com.dolsoft.teachers_service.model;

import java.io.Serializable;
import org.springframework.hateoas.RepresentationModel;

public class Teacher extends RepresentationModel<Teacher> implements Serializable {
	private static final long serialVersionUID = 1L;
	 
	private int id;
	private String fullName;       // ФИО преподавателя
	private String academicRank;   // Ученое звание
	private String academicDegree; // Ученая степень
	private String position;       // Должность

	public Teacher() {}

	public Teacher(int id, String fullName, String academicRank, String academicDegree, String position) {
		this.id = id;
		this.fullName = fullName;
		this.academicRank = academicRank;
		this.academicDegree = academicDegree;
		this.position = position;
	}

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getFullName() { return fullName; }
	public void setFullName(String fullName) { this.fullName = fullName; }

	public String getAcademicRank() { return academicRank; }
	public void setAcademicRank(String academicRank) { this.academicRank = academicRank; }

	public String getAcademicDegree() { return academicDegree; }
	public void setAcademicDegree(String academicDegree) { this.academicDegree = academicDegree; }

	public String getPosition() { return position; }
	public void setPosition(String position) { this.position = position; }

	@Override
	public String toString() {
		return "Teacher(id=" + id + ", fullName=" + fullName + ", academicRank=" + academicRank 
				+ ", academicDegree=" + academicDegree + ", position=" + position + ")";
	}
}