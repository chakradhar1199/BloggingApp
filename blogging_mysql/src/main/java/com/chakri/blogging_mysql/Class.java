package com.chakri.blogging_mysql;

import jakarta.persistence.Entity;

@Entity(name = "class")
public class Class extends BaseEntity{

    private int noOfStudents;

    private String className;

    private String teacherName;


}
