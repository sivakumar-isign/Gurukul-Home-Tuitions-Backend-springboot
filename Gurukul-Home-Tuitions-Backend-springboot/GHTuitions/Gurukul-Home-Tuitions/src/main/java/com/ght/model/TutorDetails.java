package com.ght.model;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
//@JsonIgnoreProperties(ignoreUnknown = true)
public class TutorDetails {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany(mappedBy = "tutorDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> students;
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_details_id", referencedColumnName = "id")
    private PersonalDetails personalDetails;

    @Lob
   	@Column(name="resume",columnDefinition="LONGBLOB")
    private byte[] resume;
    
    @Lob
   	@Column(name="drivingLicense",columnDefinition="LONGBLOB")
    private byte[] drivingLicense;
    
    @Lob
   	@Column(name="addressProof",columnDefinition="LONGBLOB")
    private byte[] addressProof;
    
    @Lob
	@Column(name="image",columnDefinition="LONGBLOB")
	private byte[] image;
    
    
    
  
    private String expertinclass;
    
    
    
    
    
	public String getExpertinclass() {
		return expertinclass;
	}
	public void setExpertinclass(String expertinclass) {
		this.expertinclass = expertinclass;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}
	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}
	public byte[] getResume() {
		return resume;
	}
	public void setResume(byte[] resume) {
		this.resume = resume;
	}
	public byte[] getDrivingLicense() {
		return drivingLicense;
	}
	public void setDrivingLicense(byte[] drivingLicense) {
		this.drivingLicense = drivingLicense;
	}
	public byte[] getAddressProof() {
		return addressProof;
	}
	public void setAddressProof(byte[] addressProof) {
		this.addressProof = addressProof;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	
	@Override
	public String toString() {
		return "TutorDetails [id=" + id + ", personalDetails=" + personalDetails + ", resume=" + resume
				+ ", drivingLicense=" + drivingLicense + ", addressProof=" + addressProof + ", image="
				+ Arrays.toString(image) + "]";
	}
	
	public TutorDetails(Long id, List<Student> students, PersonalDetails personalDetails, byte[] resume,
			byte[] drivingLicense, byte[] addressProof, byte[] image, String expertinclass) {
		super();
		this.id = id;
		this.students = students;
		this.personalDetails = personalDetails;
		this.resume = resume;
		this.drivingLicense = drivingLicense;
		this.addressProof = addressProof;
		this.image = image;
		this.expertinclass = expertinclass;
	}

	public TutorDetails() {
		super();
	}
    
    
}
