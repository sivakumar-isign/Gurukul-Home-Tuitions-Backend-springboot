package com.ght.service;

import java.util.List;

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

	    
}
