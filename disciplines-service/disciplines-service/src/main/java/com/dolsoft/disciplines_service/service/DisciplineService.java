package com.dolsoft.disciplines_service.service;

import org.springframework.stereotype.Service;
import com.dolsoft.disciplines_service.model.Discipline;

@Service
public class DisciplineService {
	public Discipline getDiscipline(int id) {
		Discipline discipline = new Discipline();
		discipline.setId(id);
		discipline.setName("Разработка микросервисных архитектур");
		discipline.setLessonType("Лабораторная работа");
		return discipline;
	}
	 
	public String createDiscipline(Discipline discipline) {
		return String.format("This is the post and the object is: %s", discipline.toString());
	}
	 
	public String updateDiscipline(Discipline discipline) {
		return String.format("This is the put and the object is: %s", discipline.toString());
	}
	   
	public String deleteDiscipline(int id) {
		return String.format("Deleting discipline with id %d", id);
	}
}