package com.simplon.transfer_rest_spring_angular.dao;

import com.simplon.transfer_rest_spring_angular.entities.Envoie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnvoieRepository extends JpaRepository<Envoie, Integer> {
    Envoie findById(int id);
    Envoie findByEmeteur_Id(int id);
    Envoie findByEmeteur_Nci(String nci);
    Envoie findByRecepteur_Id(int id);
    Envoie findByRecepteur_NomAndRecepteur_Prenom(String nom, String prenom);
    Envoie findByRecepteur_Tel(String tel);
    //Envoie update(Envoie envoie);
}

