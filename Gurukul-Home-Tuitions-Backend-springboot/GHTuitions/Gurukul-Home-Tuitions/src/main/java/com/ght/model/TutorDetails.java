package com.ght.model;

import java.util.Arrays;


import jakarta.persistence.*;

@Entity
public class TutorDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
	public TutorDetails(Long id, PersonalDetails personalDetails, byte[] resume, byte[] drivingLicense,
			byte[] addressProof, byte[] image) {
		super();
		this.id = id;
		this.personalDetails = personalDetails;
		this.resume = resume;
		this.drivingLicense = drivingLicense;
		this.addressProof = addressProof;
		this.image = image;
	}
	public TutorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
