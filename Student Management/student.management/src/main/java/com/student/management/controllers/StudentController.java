package com.student.management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.entities.Student;
import com.student.management.services.StudentService;

//@RestController
@Controller
public class StudentController {
		
	@Autowired
	StudentService service;
	
	@PostMapping("/addStudent")
	public String addStudent(@ModelAttribute Student st, Model model) {
		service.addStudent(st);
		String msg="Student Added";
		model.addAttribute("addMsg",msg);
		return "index";
	}
	
	@GetMapping("/searchStudent")
	public String searchStudent(@RequestParam int roll, Model model) {
		Student st=service.searchStudent(roll);
		model.addAttribute("student",st);
		return "displayStudent";
	}
	
	@PostMapping("/updateStudent")
	public String updateStudent(@ModelAttribute Student st, Model model) {
		service.updateStudent(st);
		String msg="Student Updated";
		model.addAttribute("updateMsg",msg);
		return "index";
	}
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam int roll, Model model) {
		service.deleteStudent(roll);
		String msg="Student deleted";
		model.addAttribute("deleteMsg",msg);
		return "index";
	}
	
	@GetMapping("/fetchAllStudents")
	public String fetchAllStudents(Model model){
		List<Student> stList = service.fetchAllStudents();
		model.addAttribute("studentList",stList);
		return "displayAllStudents";
	}
	
	@GetMapping("/deleteAllStudents")
	public String deleteAllStudents(Model model) {
		service.deleteAllStudents();
		String msg="All Students Deleted";
		model.addAttribute("deleteAllMsg",msg);
		return "index";
	}
}



//@GetMapping("/hello")
//public String sayHello() {
//	return "Hello from SpringBoot";
//}
//
//@GetMapping("/bye")
//public String sayBye() {
//	return "Bye from SpringBoot";
//}
//
//@GetMapping("/data/{data}")
//public String acceptData(@PathVariable String data) {
//	return "data received: "+data;
//}
//
//@GetMapping("/data2")
//public String acceptValues(@RequestParam String d1, @RequestParam String d2) {
//	return "Data received: "+d1+"."+d2;
//}
//
//@GetMapping("/acceptStudent")
//public String acceptStudent(
//		@RequestParam int roll, 
//		@RequestParam String name, 
//		@RequestParam String branch, 
//		@RequestParam int yop, 
//		@RequestParam double cgpa) {
//	
//	Student st=new Student(roll, name, branch, yop, cgpa);
//	System.out.println(st);
//	return "Student data received";
//}