package com.simplon.transfer_rest_spring_angular;

import com.simplon.transfer_rest_spring_angular.dao.EmeteurRepository;
import com.simplon.transfer_rest_spring_angular.entities.Emeteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransferRestSpringAngularApplication implements CommandLineRunner {
    @Autowired
    EmeteurRepository emeteurReposi;
    public static void main(String[] args) {
        SpringApplication.run(TransferRestSpringAngularApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Emeteur em=new Emeteur();
        em.setNci("1392567323");
        em.setNom("Mballo");
        em.setPrenom("Ousmane");
        em.setTelephone("771979043");

        emeteurReposi.save(em);
    }
}
