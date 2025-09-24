package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import main.entity.Student;
import main.service.StudentService;

@org.springframework.stereotype.Controller

public class Controller {
	
	@Autowired
	private StudentService service;

	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/students")
	public String getAllStudents(Model model) {
		model.addAttribute("students", service.getAllStudents());
		return "students";
		
	}
	
	@GetMapping("students/new")
	public String createStudentForm(Model model) {
		Student student=new Student();
		model.addAttribute("student",student);
		return "create_form";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		service.saveStudent(student);
		return "redirect:/students";	
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentFrom(@PathVariable int id,Model model) {
		model.addAttribute("student",service.getById(id));
		return "edit_student";
		
	}
	@PostMapping("/students/edit/{id}")
	public String updateStudent(@PathVariable int id,@ModelAttribute("student") Student student) {
		Student exitingStudent=service.getById(id);
		exitingStudent.setFirstName(student.getFirstName());
		exitingStudent.setLastName(student.getLastName());
		exitingStudent.setEmail(student.getEmail());
		service.saveStudent(exitingStudent);
		return "redirect:/students";
		
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable int id) {
		service.deleteById(id);
		return "redirect:/students";
		
	}
}
