package com.java.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class studentService {
	@Autowired
	private studentRepository repo;

	public List<Student> listAll() {
		return repo.findAll();
	}

	public Student updateStudent(int studentId, Student student) {
		student.setId(studentId);
		return repo.save(student);
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}

	public Student get(Integer id) {
		return repo.findById(id).get();

	}

	public List<Student> getdept(String dept) {
		List<Student> student = getdept(dept);
		return student;
	}
}
