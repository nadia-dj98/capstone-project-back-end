package com.example.voluntech_jobboard.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class Volunteer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "experience")
    private Experience experience;

    @ManyToMany(mappedBy = "volunteers")
    @JsonIgnoreProperties({"volunteers"})
    private List<Job> jobs;

    public Volunteer(String name, Experience experience) {
        this.name = name;
        this.experience = experience;
        this.jobs = new ArrayList<>();
    }

    public Volunteer(){}


    //getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public void applyToJob(Job job){
        this.jobs.add(job);
    }

    public void withdrawFromJob(Job job){
        this.jobs.remove(job);
    }
}
