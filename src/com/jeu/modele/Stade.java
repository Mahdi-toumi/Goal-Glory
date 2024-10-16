/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jeu.modele;

/**
 *
 * @author toumi
 */
public class Stade {
    private String nom;
    private String localisation;
    private int capacite;

    public Stade(String nom, String localisation, int capacite) {
        this.nom = nom;
        this.localisation = localisation;
        this.capacite = capacite;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public String getLocalisation() {
        return localisation;
    }

    public int getCapacite() {
        return capacite;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    
}

