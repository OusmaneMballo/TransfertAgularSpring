package com.simplon.transfer_rest_spring_angular.dao;

import com.simplon.transfer_rest_spring_angular.entities.Emeteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmeteurRepository extends JpaRepository<Emeteur, Integer> {
    Emeteur findById(int id);
    void deleteById(int id);
    List<Emeteur> findAll();

}
