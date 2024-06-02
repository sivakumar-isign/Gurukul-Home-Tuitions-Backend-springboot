package com.ght.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ght.model.TutorDetails;

public interface TutorDetailsRepository extends JpaRepository<TutorDetails, Long>
{

}
