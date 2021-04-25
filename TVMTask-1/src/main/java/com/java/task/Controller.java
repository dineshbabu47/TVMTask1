package com.java.task;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/")
public class Controller {
	@Autowired
	private studentRepository repo;
	@Autowired
	private studentService service;

	@GetMapping(name = "/hello")
	public String gethello() {
		return "HEllo";
	}

	@GetMapping("/student")
	public List<Student> list() {
		return service.listAll();
	}

	@GetMapping("/dept/student/{dept}")
	public List<Student> get(@PathVariable String dept) {
		List<Student> stud = null;
		for(int i=0; i<=stud.size();i++){
			if(stud.isEmpty()) {
				List<Student> obj = repo.findAll();
				if(obj.equals(dept)) {
					List<Student> obj1=obj;
					return obj1;
				}
				else {
					return null;
				}
					
			}
			else {
				return null;
			}
			
		}
		return stud;
		
		
		/*
		 * try { List<Student> student = service.getdept(dept); return student; } catch
		 * (Exception e) { return null; }
		 */
	}

	

	@GetMapping("/student/{id}")
	public ResponseEntity<Student> get(@PathVariable Integer id) {
		try {
			Student student = service.get(id);
			return new ResponseEntity<Student>(student, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/savestudent")
	public ResponseEntity<Student> getList(@RequestBody Student student) {
		try {
			repo.save(student);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}

	 @PutMapping(value = "/product/putmethod/{studentId}")
	    public Student updateStudent(@PathVariable("studentId") int studentId, @RequestBody Student student) {
	        return service.updateStudent(studentId, student);
	    }

	@DeleteMapping("/student/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
