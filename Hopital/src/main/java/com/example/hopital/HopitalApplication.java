package com.example.hopital;

import com.example.hopital.repo.PatientRepo;
import com.example.hopital.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Date;

@SpringBootApplication
public class HopitalApplication implements CommandLineRunner {
    @Autowired
    private PatientRepo patientRepo;

    public static void main(String[] args) {
        SpringApplication.run(HopitalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       // patientRepo.save(Patient.builder().nom("jawad").date(new Date()).score(29).malade(true).build());
       // patientRepo.save(Patient.builder().nom("Mouad").date(new Date()).score(99).malade(false).build());
       // patientRepo.save(Patient.builder().nom("marwane").date(new Date()).score(45).malade(true).build());

    }
}
