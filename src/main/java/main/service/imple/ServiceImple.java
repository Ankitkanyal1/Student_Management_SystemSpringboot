package main.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.entity.Student;
import main.repository.StudentRepository;
import main.service.StudentService;

@Service
public class ServiceImple implements StudentService{

	@Autowired
	StudentRepository studentRepo;
	@Override
	public List<Student> getAllStudents() {
		List<Student> list=studentRepo.findAll();
		return list;
	}
	@Override
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}
	@Override
	public Student getById(int id) {
		
		return studentRepo.findById(id).get();
	}
	@Override
	public void deleteById(int id) {
		studentRepo.deleteById(id);
	}
	
}
