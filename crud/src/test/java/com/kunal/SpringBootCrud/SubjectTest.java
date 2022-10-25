package com.kunal.SpringBootCrud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.kunal.SpringBootCrud.bean.Subject;
import com.kunal.SpringBootCrud.repository.SubjectRepository;
import com.kunal.SpringBootCrud.service.SubjectService;

@SpringBootTest
public class SubjectTest {

    @Autowired
    SubjectService subjectService;
    @MockBean
    SubjectRepository subjectRepository;


    @Test
    public void getAllSubjectsTest() {
        when(subjectRepository.findAll()).thenReturn(Stream
                .of(new Subject("102", "Java"), new Subject("105", "Spring Boot")).collect(Collectors.toList()));
        assertEquals(2, subjectService.getAllSubject().size());
    }

}

