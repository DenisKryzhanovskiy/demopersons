package com.dolsoft.teachers_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dolsoft.teachers_service.model.Teacher;
import com.dolsoft.teachers_service.service.TeacherService;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

@RestController
@RequestMapping(value="v1/teachers")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Teacher> getTeacher(@PathVariable("id") int id) {
		
		Teacher teacher = teacherService.getTeacher(id);

		teacher.add(
			WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TeacherController.class)
				.getTeacher(teacher.getId())).withSelfRel(),
			WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TeacherController.class)
				.createTeacher(teacher)).withRel("createTeacher"),
			WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TeacherController.class)
				.updateTeacher(teacher)).withRel("updateTeacher"),
			WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TeacherController.class)
				.deleteTeacher(teacher.getId())).withRel("deleteTeacher")
		);

		return ResponseEntity.ok(teacher);
	}

	@PutMapping
	public ResponseEntity<String> updateTeacher(@RequestBody Teacher request) {
		return ResponseEntity.ok(teacherService.updateTeacher(request));
	}
	
	@PostMapping
	public ResponseEntity<String> createTeacher(@RequestBody Teacher request) {
		return ResponseEntity.ok(teacherService.createTeacher(request));
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<String> deleteTeacher(@PathVariable("id") int id) {
		return ResponseEntity.ok(teacherService.deleteTeacher(id));
	}
}