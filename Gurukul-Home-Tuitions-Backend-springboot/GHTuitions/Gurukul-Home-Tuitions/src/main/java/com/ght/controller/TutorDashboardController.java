package com.ght.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
}
