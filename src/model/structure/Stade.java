/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.structure;

/**
 *
 * @author toumi
 */
public class Stade {
    private String nom;
    private String localisation;
    private double capacite;

    public Stade(String nom, String localisation, double capacite) {
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

    public double getCapacite() {
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
    
    @Override
    public String toString() {
        return this.nom + " Lacoation : " + this.localisation +" Capacite : "+ this.capacite;
    }

    
}

