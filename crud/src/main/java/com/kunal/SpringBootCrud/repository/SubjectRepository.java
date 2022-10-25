package com.kunal.SpringBootCrud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kunal.SpringBootCrud.bean.Subject;

@Repository
public interface SubjectRepository extends CrudRepository<Subject,String> {

}
