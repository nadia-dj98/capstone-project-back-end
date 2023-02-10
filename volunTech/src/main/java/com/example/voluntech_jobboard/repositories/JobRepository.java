package com.example.voluntech_jobboard.repositories;

import com.example.voluntech_jobboard.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job>findByLocationIgnoreCase(String location);

    List<Job>findByRoleIgnoreCase(String role);
}
