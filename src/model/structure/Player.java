/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.structure;

/**
 *
 * @author toumi
 */
public class Player {
    private String nom ; 
    private double score ; 
    
    public Player(String nom, double score) {
        this.nom = nom;
        this.score = score;
    }
    
    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void ajouterScore(double points) {
        if (points > 0) {
            this.score += points;
        } else {
            System.out.println("Les points doivent être positifs.");
        }
    }
    
    @Override
    public String toString() {
        return "Nom du joueur : " + nom + "Score : " + score ;
    }
    
}
