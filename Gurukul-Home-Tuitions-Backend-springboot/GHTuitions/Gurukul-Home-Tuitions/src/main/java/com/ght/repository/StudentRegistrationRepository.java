package com.ght.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ght.model.Student;


@Repository
public interface StudentRegistrationRepository extends JpaRepository<Student, Long> {



    @Query("SELECT s FROM Student s WHERE s.email = :email")
   public Student findByEmail(@Param("email") String email);

	
}
