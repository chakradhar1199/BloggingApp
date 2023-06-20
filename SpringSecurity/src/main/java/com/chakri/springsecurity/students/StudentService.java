package com.chakri.springsecurity.students;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class StudentService {
    private StudentRepository studentRepository;



    private List<Student> getStudent(){
        return studentRepository.findAll();
    }

    private Student getStudentById(int rollnumber){
        return studentRepository.getReferenceById(rollnumber);
    }


}
