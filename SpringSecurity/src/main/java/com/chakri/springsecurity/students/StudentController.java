package com.chakri.springsecurity.students;

import com.chakri.springsecurity.login.LoginRequestDto;
import com.chakri.springsecurity.login.LoginResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @RequestMapping("students")
    public String helloStudent(){
        return "Hello Student";
    }


    @PostMapping("login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDto login){




        return null;


    }
}
