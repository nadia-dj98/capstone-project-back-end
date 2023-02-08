package com.example.voluntech_jobboard.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;



@Entity
@Table (name = "charities")
public class Charity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "charity_cause")
    private String charityCause;

    @OneToMany(mappedBy = "charity")
    @JsonIgnoreProperties({"charity"})
    private List<Job> jobs;


    public Charity(String name, String description, String charityCause) {
        this.name = name;
        this.description = description;
        this.charityCause = charityCause;
        this.jobs = new ArrayList<>();
    }


    public Charity () {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCharityCause() {
        return charityCause;
    }

    public void setCharityCause(String charityCause) {
        this.charityCause = charityCause;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    // Methods

//    public void addCharity(Charity charity) {
//
//    }

//    public void removeCharity() {
//
//    }

//    public List getAllCharities<Charity>() {
//
//    }
}
