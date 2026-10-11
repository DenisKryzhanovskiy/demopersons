package com.dolsoft.teachers_service.service;

import org.springframework.stereotype.Service;
import com.dolsoft.teachers_service.model.Teacher;

@Service
public class TeacherService {
	public Teacher getTeacher(int id) {
		Teacher teacher = new Teacher();
		teacher.setId(id);
		teacher.setFullName("Алексеев Алексей Алексеевич");
		teacher.setAcademicRank("Доцент");
		teacher.setAcademicDegree("Кандидат технических наук");
		teacher.setPosition("Преподаватель кафедры ИС");
		return teacher;
	}
	 
	public String createTeacher(Teacher teacher) {
		return String.format("This is the post and the object is: %s", teacher.toString());
	}
	 
	public String updateTeacher(Teacher teacher) {
		return String.format("This is the put and the object is: %s", teacher.toString());
	}
	   
	public String deleteTeacher(int id) {
		return String.format("Deleting teacher with id %d", id);
	}
}