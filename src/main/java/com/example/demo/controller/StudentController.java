package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.services.StudentService;
import com.fasterxml.jackson.annotation.JsonAnyGetter;

@RestController

public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostMapping("/addstudent")
	public Student saveStudent(@RequestBody Student student) {
		return studentService.createStudent(student);

	}

	@PostMapping("/addstudents")
	public List<Student> addStudents(@RequestBody List<Student> students) {
		return studentService.createStudents(students);

	}
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
		
	}
	@GetMapping("/students/{sid}")
	public Optional<Student> getStudentById(@PathVariable int sid){
		return studentService.getStudentById(sid);
		
	}
	@DeleteMapping("/delete/{sid}")
	public void updateSubjectById(@PathVariable int sid) {
		 studentService.deleteStudentById(sid);
		
	}
	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
		
	}

}
