package com.dolsoft.disciplines_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dolsoft.disciplines_service.model.Discipline;
import com.dolsoft.disciplines_service.service.DisciplineService;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

@RestController
@RequestMapping(value="v1/disciplines")
public class DisciplineController {

	@Autowired
	private DisciplineService disciplineService;

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Discipline> getDiscipline(@PathVariable("id") int id) {
		
		Discipline discipline = disciplineService.getDiscipline(id);

		// Реализация Spring HATEOAS для Дисциплин (Листинг 2.7)
		discipline.add(
			WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DisciplineController.class)
				.getDiscipline(discipline.getId())).withSelfRel(),
			WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DisciplineController.class)
				.createDiscipline(discipline)).withRel("createDiscipline"),
			WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DisciplineController.class)
				.updateDiscipline(discipline)).withRel("updateDiscipline"),
			WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DisciplineController.class)
				.deleteDiscipline(discipline.getId())).withRel("deleteDiscipline")
		);

		return ResponseEntity.ok(discipline);
	}

	@PutMapping
	public ResponseEntity<String> updateDiscipline(@RequestBody Discipline request) {
		return ResponseEntity.ok(disciplineService.updateDiscipline(request));
	}
	
	@PostMapping
	public ResponseEntity<String> createDiscipline(@RequestBody Discipline request) {
		return ResponseEntity.ok(disciplineService.createDiscipline(request));
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<String> deleteDiscipline(@PathVariable("id") int id) {
		return ResponseEntity.ok(disciplineService.deleteDiscipline(id));
	}
}