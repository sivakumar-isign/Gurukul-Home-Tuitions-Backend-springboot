package com.ght.controller;

import com.ght.model.PersonalDetails;
import com.ght.model.TutorDetails;

public class TutorRegistrationRequest {

	private PersonalDetails personalDetails;
    private TutorDetails tutorDetails;
	public TutorRegistrationRequest() {
		super();
	}
	public TutorRegistrationRequest(PersonalDetails personalDetails, TutorDetails tutorDetails) {
		super();
		this.personalDetails = personalDetails;
		this.tutorDetails = tutorDetails;
	}
	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}
	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}
	public TutorDetails getTutorDetails() {
		return tutorDetails;
	}
	public void setTutorDetails(TutorDetails tutorDetails) {
		this.tutorDetails = tutorDetails;
	}
    
    
    
}
