package com.ght.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.ght.model.TutorDashboard;
import com.ght.model.TutorDetails;
import com.ght.repository.TutorDetailsRepository;

@Service
public class TutorRegistrationService {

    @Autowired
    private TutorDetailsRepository tutorDetailsRepository;

    public TutorDetails registerTutor(TutorDetails tutorDetails) {
        return tutorDetailsRepository.save(tutorDetails);
    }
    
    
    public Optional<TutorDetails> findById(Long id) {
        return tutorDetailsRepository.findById(id);
    }

    
}
