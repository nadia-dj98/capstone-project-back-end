package com.example.voluntech_jobboard.components;


import com.example.voluntech_jobboard.models.Charity;
import com.example.voluntech_jobboard.models.Experience;
import com.example.voluntech_jobboard.models.Job;
import com.example.voluntech_jobboard.models.Volunteer;
import com.example.voluntech_jobboard.repositories.CharityRepository;
import com.example.voluntech_jobboard.repositories.JobRepository;
import com.example.voluntech_jobboard.repositories.VolunteerRepository;
import com.example.voluntech_jobboard.services.CharityService;
import com.example.voluntech_jobboard.services.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static com.example.voluntech_jobboard.models.Experience.*;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CharityRepository charityRepository;

    @Autowired
    JobRepository jobRepository;

    @Autowired
    VolunteerRepository volunteerRepository;

    @Autowired
    CharityService charityService;

    @Override

    public  void run(ApplicationArguments args) throws Exception{

        //charities - Radhika

        Charity britishHeart = new Charity("British Heart", "A charity helping orphans with heart conditions", "health");

        Charity globalCancerConcern = new Charity("Global Cancer Concern", "A charity helping patients with cancer", "health");

        Charity enviroLove = new Charity("Enviro Love", "A charity helping environment", "environment");

        Charity guideDogs = new Charity("Guide dogs", "A charity promoting wellbeing of dogs", "animals");

        Charity samaritans = new Charity("Samaritans", "A mental health charity", "mental health");

        Charity sightSavers = new Charity("Sight Savers", "A charity helping children who go blind from illnesses", "health");

        Charity saveTheChildren = new Charity("Save The Children", "A charity fighting for children's rights and improving lives through education and healthcare", "wellbeing");

        Charity marieCurie = new Charity("Marie Curie", "A charity dedicated to supporting and caring for people with terminal illness as well as their families", "wellbeing");

        Charity alzheimersSociety = new Charity("Alzheimer's Society", "The Alzheimer’s Society helps fund groundbreaking research, support centres, advice, and campaigns to help those with dementia and their families.", "health");

        Charity shelter = new Charity("Shelter", "A charity with a mission that everyone should have a home", "wellbeing");

        charityRepository.save(britishHeart);
        charityRepository.save(globalCancerConcern);
        charityRepository.save(enviroLove);
        charityRepository.save(guideDogs);
        charityRepository.save(samaritans);
        charityRepository.save(sightSavers);
        charityRepository.save(saveTheChildren);
        charityRepository.save(marieCurie);
        charityRepository.save(alzheimersSociety);
        charityRepository.save(shelter);

        //jobs - Fatimah & Nadia

        Job uxDesigner = new Job("UX Designer", "We're seeking a talented individual to join our team on a short project creating a new feature for our website", LocalDate.of(2023, 03, 25), LocalDate.of(2023, 04, 30),"remote", britishHeart);
        jobRepository.save(uxDesigner);

        Job frontEndDeveloper = new Job("Front-end Developer", "We're seeking a talented individual to revamp our website", LocalDate.of(2023, 04, 01), LocalDate.of(2023, 05, 30),"london", globalCancerConcern);
        jobRepository.save(frontEndDeveloper);

        Job backEndDeveloper = new Job("Back-end Developer", "We're seeking a talented individual to help us ", LocalDate.of(2023, 03, 25), LocalDate.of(2023, 04, 30),"Essex", enviroLove);
        jobRepository.save(backEndDeveloper);

        Job productManager = new Job("Product Manager", "We're seeking a talented individual to join our team to help us refine our mvp", LocalDate.of(2023, 05, 25), LocalDate.of(2023, 06, 30),"Halifax", guideDogs);
        jobRepository.save(productManager);

        Job uiDesigner = new Job("UI Designer", "We are looking for a talented UI Designer to create amazing user experiences. The ideal candidate should have an eye for clean and artful design, possess superior UI skills and be able to translate high-level requirements into interaction flows and artifacts, and transform them into beautiful, intuitive, and functional user interfaces.", LocalDate.of(2023, 02, 14), LocalDate.of(2023, 02, 27), "London", guideDogs);
        jobRepository.save(uiDesigner);

        Job webDeveloper= new Job("Web Developer", "We are looking for an outstanding Web Developer to be responsible for the coding, innovative design and layout of our website. Web developer responsibilities include building our website from concept all the way to completion from the bottom up, fashioning everything from the home page to site layout and function.", LocalDate.of(2023, 02, 20), LocalDate.of(2023, 03, 10),"Glasgow", samaritans);
        jobRepository.save(webDeveloper);

        Job dataScientist = new Job("Data Scientist", "We are looking for a Data Scientist to analyze large amounts of raw information to find patterns that will help improve our company. We will rely on you to build data products to extract valuable business insights.", LocalDate.of(2023, 03, 10), LocalDate.of(2023, 03, 20), "Cambridge", sightSavers);
        jobRepository.save(dataScientist);

        Job javaDeveloper = new Job("Java Developer", "We are looking for a Java Developer with experience in building high-performing, scalable, enterprise-grade applications. You will be part of a talented software team that works on mission-critical applications. Java developer roles and responsibilities include managing Java/Java EE application development while providing expertise in the full software development lifecycle, from concept and design to testing. Java developer responsibilities include designing, developing and delivering high-volume, low-latency applications for mission-critical systems.",LocalDate.of(2023, 03, 23), LocalDate.of(2023, 03, 30), "Bristol", saveTheChildren);
        jobRepository.save(javaDeveloper);

        Job fullStackDeveloper = new Job("Full Stack Developer", "We are looking for a Full Stack Developer to produce scalable software solutions. You’ll be part of a cross-functional team that’s responsible for the full software development life cycle, from conception to deployment.", LocalDate.of(2023, 04, 07), LocalDate.of(2023, 04, 17), "Oxford", marieCurie);
        jobRepository.save(fullStackDeveloper);


        //volunteers = Salma ENTRY_LEVEL

        Volunteer salma = new Volunteer("Salma", ENTRY_LEVEL);
        Volunteer nadia = new Volunteer("Nadia",JUNIOR_LEVEL);
        Volunteer isabel = new Volunteer("Isabel",MID_LEVEL);
        Volunteer radhika = new Volunteer("Radhika",SENIOR_LEVEL);
        Volunteer fatimah = new Volunteer("Fatimah",ENTRY_LEVEL);
        Volunteer zsolt = new Volunteer("Zsolt",JUNIOR_LEVEL);
        Volunteer anna = new Volunteer("Anna",MID_LEVEL);
        Volunteer iain = new Volunteer("Iain", SENIOR_LEVEL);
        Volunteer eoan = new Volunteer("Eoan",ENTRY_LEVEL);
        Volunteer phil = new Volunteer("Phil",JUNIOR_LEVEL);
        Volunteer colin = new Volunteer("Colin",MID_LEVEL);
        Volunteer richard = new Volunteer("Richard",SENIOR_LEVEL);
        Volunteer ed = new Volunteer("Ed",ENTRY_LEVEL);



        volunteerRepository.save(salma);
        volunteerRepository.save(nadia);
        volunteerRepository.save(isabel);
        volunteerRepository.save(radhika);
        volunteerRepository.save(fatimah);
        volunteerRepository.save(zsolt);
        volunteerRepository.save(anna);
        volunteerRepository.save(iain);
        volunteerRepository.save(eoan);
        volunteerRepository.save(phil);
        volunteerRepository.save(colin);
        volunteerRepository.save(richard);
        volunteerRepository.save(ed);










    }







}

