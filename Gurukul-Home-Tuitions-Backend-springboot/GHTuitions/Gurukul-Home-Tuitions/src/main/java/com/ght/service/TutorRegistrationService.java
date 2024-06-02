package com.ght.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ght.model.TutorDetails;
import com.ght.repository.TutorDetailsRepository;

@Service
public class TutorRegistrationService {

    @Autowired
    private TutorDetailsRepository tutorDetailsRepository;

    public TutorDetails registerTutor(TutorDetails tutorDetails) {
        return tutorDetailsRepository.save(tutorDetails);
    }
}
