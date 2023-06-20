package com.chakri.springsecurity.teachers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

    @RequestMapping("teacher")
    public String helloTeacher( ){
        return "Hello Teacher";
    }
}
