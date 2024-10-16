/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jeu.modele;

/**
 *
 * @author toumi
 */
public class Gardien extends Joueur {
    private double pourcentageDeSauvetage; // Pourcentage de réussite des arrêts

    public Gardien(String nom, String prenom, int age, Equipe equipe, double pourcentageDeSauvetage) {
        super(nom, prenom, age, "Gardien", equipe);
        this.pourcentageDeSauvetage = pourcentageDeSauvetage;
    }

    // Getters et Setters
    public double getPourcentageDeSauvetage() {
        return pourcentageDeSauvetage;
    }

    public void setPourcentageDeSauvetage(double pourcentageDeSauvetage) {
        this.pourcentageDeSauvetage = pourcentageDeSauvetage;
    }

    @Override
    public void jouer() {
        
    }
}

