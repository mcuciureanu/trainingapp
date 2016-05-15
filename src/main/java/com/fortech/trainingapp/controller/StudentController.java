package com.fortech.trainingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fortech.trainingapp.model.Student;
import com.fortech.trainingapp.service.StudentService;

@Controller
public class StudentController {

	private StudentService studentService;

	@Autowired(required = true)
	@Qualifier(value = "studentService")
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public String listStudents(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("listStudents", this.studentService.listStudents());
		return "student";
	}
	
	@RequestMapping(value = "/assignments/{studentId}", method = RequestMethod.GET)
	public String listAssignments(Model model, @PathVariable("studentId") int studentId) {
		model.addAttribute("studentId", studentId);
		model.addAttribute("listAssignments", this.studentService.listStudents());
		return "assignment";
	}

	// For add and update student both
	@RequestMapping(value = "/student/add", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") Student student) {

		if (student.getId() == 0) {
			// new student, add it
			this.studentService.addStudent(student);
		} else {
			// existing student, call update
			this.studentService.updateStudent(student);
		}

		return "redirect:/students";

	}

	@RequestMapping("/remove/{id}")
	public String removeStudent(@PathVariable("id") int id) {

		this.studentService.removeStudent(id);
		return "redirect:/students";
	}

	@RequestMapping("/edit/{id}")
	public String editStudent(@PathVariable("id") int id, Model model) {
		model.addAttribute("student", this.studentService.getStudentById(id));
		model.addAttribute("listStudents", this.studentService.listStudents());
		return "student";
	}
}
