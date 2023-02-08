package com.example.voluntech_jobboard.repositories;

import com.example.voluntech_jobboard.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
