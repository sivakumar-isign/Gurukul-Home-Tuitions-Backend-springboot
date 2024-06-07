package com.ght.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TutorDashboard {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String title;
	    private String firstName;
	    private String lastName;
	    private String location;
	    private String subjects;
	    private String notes;
	    private Double feeAmount;
	    private String materialSubject;
	    private String materialChapter;
	    private String testClass;
	    private String testSubject;
	    private String testChapter;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getSubjects() {
			return subjects;
		}
		public void setSubjects(String subjects) {
			this.subjects = subjects;
		}
		public String getNotes() {
			return notes;
		}
		public void setNotes(String notes) {
			this.notes = notes;
		}
		public Double getFeeAmount() {
			return feeAmount;
		}
		public void setFeeAmount(Double feeAmount) {
			this.feeAmount = feeAmount;
		}
		public String getMaterialSubject() {
			return materialSubject;
		}
		public void setMaterialSubject(String materialSubject) {
			this.materialSubject = materialSubject;
		}
		public String getMaterialChapter() {
			return materialChapter;
		}
		public void setMaterialChapter(String materialChapter) {
			this.materialChapter = materialChapter;
		}
		public String getTestClass() {
			return testClass;
		}
		public void setTestClass(String testClass) {
			this.testClass = testClass;
		}
		public String getTestSubject() {
			return testSubject;
		}
		public void setTestSubject(String testSubject) {
			this.testSubject = testSubject;
		}
		public String getTestChapter() {
			return testChapter;
		}
		public void setTestChapter(String testChapter) {
			this.testChapter = testChapter;
		}
	    
	    
        

}
