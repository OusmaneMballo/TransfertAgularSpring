package com.simplon.transfer_rest_spring_angular.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Envoie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private float montant;
    @Column
    private String date;
    @OneToOne
    @JoinColumn(name="emeteur_id")
    private Emeteur emeteur;
    @OneToOne
    @JoinColumn(name = "recepteur_id")
    private Recepteur recepteur;

    public Envoie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Emeteur getEmeteur() {
        return emeteur;
    }

    public void setEmeteur(Emeteur emeteur) {
        this.emeteur = emeteur;
    }

    public Recepteur getRecepteur() {
        return recepteur;
    }

    public void setRecepteur(Recepteur recepteur) {
        this.recepteur = recepteur;
    }
}
