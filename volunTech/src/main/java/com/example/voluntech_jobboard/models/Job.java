package com.example.voluntech_jobboard.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table (name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private String role;

    @Column(name = "description")
    private String description;

    @Column(name = "duration")
    private Integer duration;

    @Column(name= "location")
    private  String location;

    @ManyToOne
    @JoinColumn(name = "charity_id")
    @JsonIgnoreProperties({"jobs"})
    private Charity charity;

    @ManyToMany
    @JoinTable(name = "application",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns =@JoinColumn(name = "volunteer_id")

    )

    public Job(String role, String description,Integer duration, String location) {
        this.role = role;
        this.description = description;
        this.duration = duration;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Charity getCharity() {
        return charity;
    }

    public void setCharity(Charity charity) {
        this.charity = charity;
    }
}

