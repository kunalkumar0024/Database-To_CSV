package com.kunal.SpringBootCrud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kunal.SpringBootCrud.bean.Subject;
import com.kunal.SpringBootCrud.repository.SubjectRepository;


@Service 
public class SubjectService {
	@Autowired
	public SubjectRepository subjectRepo;
	//@RequestMapping(value="/subjects", method=RequestMethod.GET)
	//@GetMapping("/subjects")
	public List<Subject> getAllSubject(){
		List<Subject> subjects=new ArrayList<>();
		subjectRepo.findAll().forEach(subjects::add);
		return subjects;
	}
	public void addSubject(Subject subject) {
		// TODO Auto-generated method stub
		subjectRepo.save(subject);
		
	}
	public void updateSubject(String id, Subject subject) {
		// TODO Auto-generated method stub
		subjectRepo.save(subject);
		
	}
	public void deleteSubject(String id) {
		// TODO Auto-generated method stub
		subjectRepo.deleteById(id);
		
	}

}
