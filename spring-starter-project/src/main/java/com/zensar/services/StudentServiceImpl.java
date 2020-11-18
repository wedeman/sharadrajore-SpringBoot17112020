package com.zensar.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.zensar.entites.Student;
import com.zensar.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repository;
	
		// @RequestMapping(value = "/students")
		public List<Student> getAllStudents() {
			return repository.getAllStudents();
		}

		// http://localhost:8080/{studentId}
		
		public Student getStudent(int studentId) {
			
			return repository.getStudent(studentId);
		}

		
		public boolean insertStudent(@RequestBody Student student) {
			return repository.insertStudent(student);
		}
		
		
	
		public boolean deleteStudent(@PathVariable int studentId) {
			return repository.deleteStudent(studentId);
		}
		
		// updating student object
		@PatchMapping("/students/{studentId}")
		public Student updateStudent(@PathVariable("studentId")int studentId,@RequestBody Student updatedStudent) {
			return repository.updateStudent(studentId, updatedStudent);
		}

}
