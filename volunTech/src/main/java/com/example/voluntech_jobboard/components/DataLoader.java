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
        Charity stoneBridgeFoodBank = new Charity("Stonebridge food bank", "A local food bank in NW London providing the homeless with hot meals.", "food poverty");
        Charity globalCancerConcern = new Charity("Global Cancer Concern", "A charity helping patients with cancer find a community", "health");
        Charity enviroLove = new Charity("Enviro Love", "A charity helping environment", "environment");
        Charity guideDogs = new Charity("Guide dogs", "A charity promoting wellbeing of dogs", "animals");
        Charity towerHamletsMentalHealth = new Charity("Tower Hamlets mind matters", "A mental health charity helping the community in the Tower Hamlets", "mental health");
        Charity sightSavers = new Charity("Sight Savers", "A charity helping children who go blind from illnesses", "health");
        Charity brickLaneHelpTheChildren = new Charity("Brick Lane Help the Children", "A charity fighting for children's rights and improving lives through education and healthcare", "wellbeing");
        Charity harlesdenCommunity = new Charity("Harlesden Community Center", "A community tackling digital exclusion", "education");
        Charity alzheimersSociety = new Charity("Alzheimers Friends Alliance", "We create a community for those suffering with Alzheimers.", "health");
        Charity shelter = new Charity("Shelter", "A charity with a mission that everyone should have a home", "wellbeing");

        charityRepository.save(stoneBridgeFoodBank);
        charityRepository.save(globalCancerConcern);
        charityRepository.save(enviroLove);
        charityRepository.save(guideDogs);
        charityRepository.save(towerHamletsMentalHealth);
        charityRepository.save(sightSavers);
        charityRepository.save(brickLaneHelpTheChildren);
        charityRepository.save(harlesdenCommunity);
        charityRepository.save(alzheimersSociety);
        charityRepository.save(shelter);

        //jobs - Fatimah & Nadia
        Job uxDesigner = new Job("UX Designer", "We're seeking a talented individual to join our team on a short project creating a new feature for our website", LocalDate.of(2023, 03, 25), LocalDate.of(2023, 04, 30),"remote", harlesdenCommunity);
        Job frontEndDeveloper = new Job("Front-end Developer", "We're seeking a talented individual to revamp our website", LocalDate.of(2023, 04, 01), LocalDate.of(2023, 05, 30),"london", globalCancerConcern);
        Job backEndDeveloper = new Job("Back-end Developer", "We're seeking a talented individual to help us ", LocalDate.of(2023, 03, 25), LocalDate.of(2023, 04, 30),"Essex", enviroLove);
        Job productManager = new Job("Product Manager", "We're seeking a talented individual to join our team to help us refine our mvp", LocalDate.of(2023, 05, 25), LocalDate.of(2023, 06, 30),"Halifax", guideDogs);
        Job uiDesigner = new Job("UI Designer", "We are looking for a talented UI Designer to create amazing user experiences.", LocalDate.of(2023, 02, 14), LocalDate.of(2023, 02, 27), "London", guideDogs);
        Job webDeveloper= new Job("Web Developer", "We are looking for an outstanding Web Developer to be responsible for the coding, innovative design and layout of our website.", LocalDate.of(2023, 02, 20), LocalDate.of(2023, 03, 10),"Glasgow", stoneBridgeFoodBank);
        Job dataScientist = new Job("Data Scientist", "We are looking for a Data Scientist to analyze large amounts of information to help.", LocalDate.of(2023, 03, 10), LocalDate.of(2023, 03, 20), "Cambridge", sightSavers);
        Job javaDeveloper = new Job("Java Developer", "We are looking for a Java Developer with experience in building applications.",LocalDate.of(2023, 03, 23), LocalDate.of(2023, 03, 30), "Bristol", towerHamletsMentalHealth);
        Job fullStackDeveloper = new Job("Full Stack Developer", "We are looking for a Full Stack Developer to produce scalable software solution.", LocalDate.of(2023, 04, 07), LocalDate.of(2023, 04, 17), "Oxford", brickLaneHelpTheChildren);

        jobRepository.save(uxDesigner);
        jobRepository.save(frontEndDeveloper);
        jobRepository.save(backEndDeveloper);
        jobRepository.save(productManager);
        jobRepository.save(uiDesigner);
        jobRepository.save(webDeveloper);
        jobRepository.save(dataScientist);
        jobRepository.save(javaDeveloper);
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

