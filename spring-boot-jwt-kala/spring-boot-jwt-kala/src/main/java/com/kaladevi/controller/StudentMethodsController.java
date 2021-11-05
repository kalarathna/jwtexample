package com.kaladevi.controller;

import com.kaladevi.model.StudentModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping({ "/students" })
public class StudentMethodsController {

	private List<StudentModel> student = createList();

	@GetMapping(produces = "application/json")
	public List<StudentModel> firstPage() {
		return student;
	}

	@DeleteMapping(path = { "/{id}" })
	public StudentModel delete(@PathVariable("id") int id) {
		StudentModel deletedEmp = null;
		for (StudentModel std : student) {
			if (std.getStudentId().equals(id)) {
				student.remove(std);
				deletedEmp = std;
				break;
			}
		}
		return deletedEmp;
	}

	@PostMapping
	public StudentModel create(@RequestBody StudentModel user) {
		student.add(user);
		return user;
	}

	private static List<StudentModel> createList() {
		List<StudentModel> tempStudents = new ArrayList<>();
		StudentModel emp1 = new StudentModel();
		emp1.setStudentName("kaladevi");
		emp1.setStudentDepartment("Computer Science");
		emp1.setStudentId("1956841");

		StudentModel emp2 = new StudentModel();
		emp2.setStudentName("test");
		emp2.setStudentDepartment("Computer Science");
		emp2.setStudentId("178526");
		tempStudents.add(emp1);
		tempStudents.add(emp2);
		return tempStudents;
	}

}