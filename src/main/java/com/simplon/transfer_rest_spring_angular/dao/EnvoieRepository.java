package com.simplon.transfer_rest_spring_angular.dao;

import com.simplon.transfer_rest_spring_angular.entities.Envoie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvoieRepository extends JpaRepository<Envoie, Integer> {
}
