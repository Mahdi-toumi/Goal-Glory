/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.structure;

import model.elements.Equipe;
import model.elements.Joueur;

/**
 *
 * @author toumi
 */
public class Player implements Comparable<Player> {
    private String nom ; 
    private double score ; 
    private Equipe equipe ;
    
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
    
    public Equipe getEquipe (){
        return equipe ; 
    }
    
    public void setEquipe (Equipe e){
        this.equipe = e ;
    }
    

    public void ajouterScore(double points) {
        if (points > 0) {
            this.score += points;
        } else {
            System.out.println("Les points doivent être positifs.");
        }
    }
    
    @Override
    public int compareTo(Player other) {
        return Double.compare(this.score, other.score);
    }
    
    
    @Override
    public String toString() {
        return "Nom du joueur : " + nom + "Score : " + score ;
    }
    
}
