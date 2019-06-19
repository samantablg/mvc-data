package com.openwebinars.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.openwebinars.model.Student;
import com.openwebinars.repo.StudentRepository;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@GetMapping(value = "/newstudent")
	public String showForm(Model model) { //dar información del usuario
		
		Student student = new Student();
		model.addAttribute("studentForm", student);
		
		return "form";
	}

	@PostMapping(value = "/addstudent")
	public String submit(@ModelAttribute("studentForm") Student student, Model model) { //guardar usuario en la base de datos y mostrarlo en lista

		studentRepository.save(student);

		return "redirect:/list";
	}

	@GetMapping(value = "/list")
	public String listStudents(Model model) { //ver lista

		model.addAttribute("listStudents", studentRepository.findAll());

		return "list";
	}

	@GetMapping(value = "/find")
	public String search(@RequestParam(name = "first_name", required = false) String firstName,
			@RequestParam(name = "last_name", required = true) String lastName, Model model) { //buscar usuario
		
		List<Student> result = null;
		
		if(firstName.isEmpty() && lastName.isEmpty()) {
			result = studentRepository.findAll();
		} else if(!firstName.isEmpty() && lastName.isEmpty()) {
			result = studentRepository.findByFirstName(firstName);
		} else if(firstName.isEmpty() && !lastName.isEmpty()) {
			result = studentRepository.findByLastName(lastName);
		} else {
			result = studentRepository.findByFirstNameAndLastName(firstName, lastName);
		}
		
		model.addAttribute("listStudents", result);

		return "list";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable("id") Long id, Model model) { //borrar usuario de la base de datos
		
		studentRepository.deleteById(id);
		return "redirect:/list";
	}
	
	@GetMapping(value = "/edit/{id}")
	public String showFormEdit(@PathVariable("id") Long id, Model model) { //editar usuario elegido en el formulario
		
	    Optional<Student> student = studentRepository.findById(id);
		model.addAttribute("studentForm", student);
		model.addAttribute("op", "edit");
		
		return "form";
	}
	
	@PostMapping(value = "/edit")
	@Transactional
	public String submitEdit(@ModelAttribute("studentForm") Student student, Model model) { //actualizar cambios de la edición y mostrarlos en la base de datos
		
		studentRepository.save(student);//se guarda este nuevo estudiante por el otro
		//studentRepository.setFirstNameAndLastNameFor(student.getFirstName(), student.getLastName(), student.getId());
		
		return "redirect:/list";
	}

}