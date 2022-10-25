package com.kunal.SpringBootCrud.controller;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kunal.SpringBootCrud.bean.Subject;
import com.kunal.SpringBootCrud.config.CSVWriterUtility;
import com.kunal.SpringBootCrud.repository.SubjectRepository;
import com.kunal.SpringBootCrud.service.SubjectService;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

	@Autowired
	public SubjectService subjectService;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@GetMapping("/get-all-subjects")
	public List<Subject> getAllSubject(){
		return subjectService.getAllSubject();
		
	}
	@PostMapping("/add-subject")
	public void addSubject(@RequestBody Subject subject) {
		
		subjectService.addSubject(subject);
		}
	@PutMapping("/update-subject/{id}")
	public void updateSubject(@PathVariable String id, @RequestBody Subject subject) {
		subjectService.updateSubject(id,subject);
	}
	@DeleteMapping("/delete-subject/{id}")
	public void deleteSubject(@PathVariable String id) {
		subjectService.deleteSubject(id);
	}
	
	 @GetMapping("/csv")
	    public void subjectDetailsReport(HttpServletResponse response) throws IOException {

	        Random random = new Random();
	        String fileType = "attachment; filename=subject_details_" + random.nextInt(1000) + ".csv";
	        response.setHeader("Content-Disposition", fileType);
	        response.setContentType("text/csv");

	        CSVWriterUtility.subjectDetailReport(response,
	                (List<Subject>) this.subjectRepository.findAll());
	    }
}
