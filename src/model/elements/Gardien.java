/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.elements;

/**
 *
 * @author toumi
 */
// Gardien.java
public class Gardien extends Joueur {
    private double pourcentageDeSauvetage;

    public Gardien(String nom, String prenom, int age, Equipe equipe, double pourcentageDeSauvetage) {
        super(nom, prenom, age, "Gardien", equipe);
        this.pourcentageDeSauvetage = pourcentageDeSauvetage;
    }

    // Méthode pour essayer d'arrêter un tir
    public boolean arreterTir(Ballon ballon) {
        double chanceArrêt = this.pourcentageDeSauvetage;
        return Math.random() < chanceArrêt;
    }

    @Override
    public void jouer() {
        // Logique de jeu du gardien
    }

    public double getPourcentageDeSauvetage() {
        return pourcentageDeSauvetage;
    }

    public void setPourcentageDeSauvetage(double pourcentageDeSauvetage) {
        this.pourcentageDeSauvetage = pourcentageDeSauvetage;
    }
}


