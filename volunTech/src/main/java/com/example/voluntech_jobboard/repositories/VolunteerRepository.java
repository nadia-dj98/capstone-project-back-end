package com.example.voluntech_jobboard.repositories;

import com.example.voluntech_jobboard.models.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {

}
