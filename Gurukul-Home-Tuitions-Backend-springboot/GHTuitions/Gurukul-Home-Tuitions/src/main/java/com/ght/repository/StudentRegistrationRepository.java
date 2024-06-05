package com.ght.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ght.model.Student;


@Repository
public interface StudentRegistrationRepository extends JpaRepository<Student, Long> {

}
