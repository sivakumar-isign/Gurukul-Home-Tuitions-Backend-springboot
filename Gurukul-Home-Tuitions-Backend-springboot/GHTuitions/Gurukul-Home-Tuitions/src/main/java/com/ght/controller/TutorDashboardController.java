package com.ght.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ght.model.TutorDashboard;
import com.ght.service.TutorDashboardService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/tutordashboard")
public class TutorDashboardController {

	   @Autowired
	    private TutorDashboardService service;

	    @PostMapping("/save")
	    public TutorDashboard saveDashboard(@RequestBody TutorDashboard dashboard) {
	        return service.saveDashboard(dashboard);
	    }

	    @GetMapping
	    public List<TutorDashboard> getAllDashboards() {
	        return service.getAllDashboards();
	    }
	    
	    

	    @GetMapping("/{id}")
	    public Optional<TutorDashboard> getEntityById(@PathVariable Long id) {
	        return service.findById(id);
	    }
	    
	
}
