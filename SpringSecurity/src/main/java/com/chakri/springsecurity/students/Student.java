package com.chakri.springsecurity.students;

import com.chakri.springsecurity.User.User;
import com.chakri.springsecurity.teachers.Teacher;
import jakarta.persistence.OneToMany;

public class Student {
    private String name;
    private String username;
    private String password;

    @OneToMany
    private Teacher classTeacher;

    private String guardianName;

    private int rollNumber;

    private int standard;


}
