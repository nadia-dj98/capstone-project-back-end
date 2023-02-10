package com.example.voluntech_jobboard.repositories;

import com.example.voluntech_jobboard.models.Charity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharityRepository extends JpaRepository<Charity, Long> {
    List<Charity> findByCharityCauseContainingIgnoreCase(String charityCause);
}
