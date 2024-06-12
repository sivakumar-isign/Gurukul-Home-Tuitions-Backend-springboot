package com.ght.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ght.model.PersonalDetails;
import com.ght.model.TutorDetails;
import com.ght.repository.TutorDetailsRepository;
import com.ght.service.TutorRegistrationService;

@RestController
@RequestMapping("/api/tutors")
@CrossOrigin(origins = "*")
public class TutorRegistrationController {

    @Autowired
    private TutorRegistrationService tutorRegistrationService;
    
    @Autowired
    private TutorDetailsRepository  tutorDetailsRepository;

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
            @RequestParam(value = "maths", required = false) String maths,
            @RequestParam(value = "physics", required = false) String physics,
            @RequestParam(value = "chemistry", required = false) String chemistry,
            @RequestParam(value = "social", required = false) String social,
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
            StringBuilder selectedSubjects = new StringBuilder();

            if (maths.equals("true")) {
                selectedSubjects.append("Maths ");
            }
            if (chemistry.equals("true")) {
                selectedSubjects.append("Chemistry ");
            }
            if (physics.equals("true")) {
                selectedSubjects.append("Physics ");
            }
            if (social.equals("true")) {
                selectedSubjects.append("Social ");
            }
            tutorDetails.setExpertinclass(String.join(",", selectedSubjects));

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
