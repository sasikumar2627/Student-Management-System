package com.student.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.entities.Student;
import com.student.management.repositories.StudentRepository;

@Service
public class StudentServiceImplementation implements StudentService{
	
	@Autowired
	StudentRepository repo;
	
	public String addStudent(Student st) {
		
		repo.save(st);
		return "Student added";
	}
	
	public Student searchStudent(int roll) {
		Student st=repo.findById(roll).get();
		return st;
	}
	
	public String updateStudent(Student st) {
		repo.save(st);
		return "Student updated";
	}
	
	public String deleteStudent(int roll) {
		repo.deleteById(roll);
		return "Student deleted";
	}

	public List<Student> fetchAllStudents() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	public String deleteAllStudents() {
		repo.deleteAll();
		return "Deleted";
	}
}
