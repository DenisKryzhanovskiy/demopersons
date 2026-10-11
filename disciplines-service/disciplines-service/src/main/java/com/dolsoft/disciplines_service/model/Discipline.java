package com.dolsoft.disciplines_service.model;

import java.io.Serializable;
import org.springframework.hateoas.RepresentationModel;

public class Discipline extends RepresentationModel<Discipline> implements Serializable {
	private static final long serialVersionUID = 1L;
	 
	private int id;
	private String name;       // Название
	private String lessonType; // Вид занятия

	public Discipline() {}

	public Discipline(int id, String name, String lessonType) {
		this.id = id;
		this.name = name;
		this.lessonType = lessonType;
	}

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getLessonType() { return lessonType; }
	public void setLessonType(String lessonType) { this.lessonType = lessonType; }

	@Override
	public String toString() {
		return "Discipline(id=" + id + ", name=" + name + ", lessonType=" + lessonType + ")";
	}
}