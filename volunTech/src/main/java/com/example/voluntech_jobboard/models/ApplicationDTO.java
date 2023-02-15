package com.example.voluntech_jobboard.models;



public class ApplicationDTO {


    private Long volunteerId;
    private Long jobId;


    public ApplicationDTO(Long volunteerId, Long jobId){
        this.volunteerId = volunteerId;
        this.jobId = jobId;
//        this.charityId = charityId;
    }

    public ApplicationDTO(){
    }

    public Long getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(Long volunteerId) {
        this.volunteerId = volunteerId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }




}
