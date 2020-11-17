package com.simplon.transfer_rest_spring_angular.dao;

import com.simplon.transfer_rest_spring_angular.entities.Recepteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecepteurRepository extends JpaRepository<Recepteur, Integer> {

    Recepteur findById(int id);
    void deleteById(int id);
}
