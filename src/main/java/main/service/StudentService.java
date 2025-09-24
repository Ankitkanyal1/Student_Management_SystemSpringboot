package main.service;

import java.util.List;

import main.entity.Student;

public interface StudentService {
	
	public List<Student>getAllStudents();
	
	public Student saveStudent(Student student);
	
	public Student getById(int id);
	public void deleteById(int id);

}
