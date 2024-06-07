package com.ght.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ght.model.TutorDashboard;
import com.ght.repository.TutorDashboardRepository;

@Service
public class TutorDashboardService {
	
	    @Autowired
	    private TutorDashboardRepository repository;

	    public TutorDashboard saveDashboard(TutorDashboard dashboard) {
	        return repository.save(dashboard);
	    }

	    public List<TutorDashboard> getAllDashboards() {
	        return repository.findAll();
	    }
	    
	    public Optional<TutorDashboard> findById(Long id) {
	        return repository.findById(id);
	    }

	    
}
