package com.chakri.springsecurity.students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
