package com.ght.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.ght.model.PersonalDetails;
import com.ght.model.TutorDashboard;
import com.ght.model.TutorDetails;
import com.ght.service.TutorRegistrationService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tutors")
@CrossOrigin(origins = "*")
public class TutorRegistrationController {

    @Autowired
    private TutorRegistrationService tutorRegistrationService;

    private final Path rootLocation = Paths.get("uploads");	

    public TutorRegistrationController() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage location", e);
        }
    }

    
    private byte[] storeFile(MultipartFile file) {
        try {
            // Validate filename
            String filename = file.getOriginalFilename();
            if (filename == null || filename.contains("..")) {
                throw new RuntimeException("Invalid file path");
            }

            // Return the byte array of the file content
            return file.getBytes();
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file", e);
        }
    }


    @PostMapping("/register")
    public ResponseEntity<?> registerTutor(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("gender") String gender,
            @RequestParam("dob") String dob,
            @RequestParam("city") String city,
            @RequestParam("mobileNo") String mobileNo,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("resume") MultipartFile resume,
            @RequestParam("drivingLicense") MultipartFile drivingLicense,
            @RequestParam("addressProof") MultipartFile addressProof,
            @RequestParam("photo") MultipartFile photo
    ) {
        try {
            PersonalDetails personalDetails = new PersonalDetails();
            personalDetails.setName(name);
            personalDetails.setSurname(surname);
            personalDetails.setGender(gender);
            personalDetails.setDob(dob);
            personalDetails.setCity(city);
            personalDetails.setMobileNo(mobileNo);
            personalDetails.setEmail(email);
            personalDetails.setPassword(password);

            TutorDetails tutorDetails = new TutorDetails();
            tutorDetails.setPersonalDetails(personalDetails);
            tutorDetails.setResume(storeFile(resume));
            tutorDetails.setDrivingLicense(storeFile(drivingLicense));
            tutorDetails.setAddressProof(storeFile(addressProof));

            if (!photo.isEmpty()) {
//                tutorDetails.setImage(photo.getBytes());
            	 tutorDetails.setImage(storeFile(photo));
            }

            TutorDetails registeredTutor = tutorRegistrationService.registerTutor(tutorDetails);
            return new ResponseEntity<>(registeredTutor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to register tutor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    @GetMapping("/{id}")
    public Optional<TutorDetails> getEntityById(@PathVariable Long id) {
        return tutorRegistrationService.findById(id);
    }
    
    @GetMapping
    public List<TutorDetails> getAllTutors() {
        return tutorRegistrationService.getAllTutors();
    }
    
    
}
