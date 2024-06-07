package com.ght.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ght.model.StudentDashboard;
import com.ght.model.TutorDashboard;
import com.ght.repository.StudentDashboardRepository;

@Service
public class StudentDashboardService {

	  @Autowired
	    private StudentDashboardRepository studentDashboardRepository;

	    public List<StudentDashboard> getAllStudents() {
	        return studentDashboardRepository.findAll();
	    }

	    public StudentDashboard saveStudent(StudentDashboard studentDashboard) {
	        return studentDashboardRepository.save(studentDashboard);
	    }


	    public Optional<StudentDashboard> findById(Long id) {
	        return studentDashboardRepository.findById(id);
	    }

	
	
}
