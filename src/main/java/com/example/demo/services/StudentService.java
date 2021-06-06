package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepo;

	public Student createStudent(Student student) {
		return studentRepo.save(student);

	}

	public List<Student> createStudents(List<Student> students) {
		// TODO Auto-generated method stub
		return studentRepo.saveAll(students);
	}

	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

	public Optional<Student> getStudentById(int sid) {
		// TODO Auto-generated method stub
		return studentRepo.findById(sid);
	}

	public void deleteStudentById(int sid) {
		// TODO Auto-generated method stub
		 studentRepo.deleteById(sid);
	}
	public Student updateStudent(Student student) {
		int sid = student.getSid();
		Student std = studentRepo.findById(sid).get();
		std.setFirstname(student.getFirstname());
		std.setLastname(student.getLastname());
		std.setAddress(student.getAddress());
		std.setEmail(student.getEmail());
		std.setPercentage(student.getPercentage());
		
		return studentRepo.save(std);
		
	}

	

}
