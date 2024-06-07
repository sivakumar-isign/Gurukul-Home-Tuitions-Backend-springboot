package com.ght.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ght.model.TutorDetails;

@Repository
public interface TutorDetailsRepository extends JpaRepository<TutorDetails, Long>
{

}
