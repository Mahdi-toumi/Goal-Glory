/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jeu.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author toumi
 */

public class  Equipe {
    private String nom;
    private String entraineur;
    private ArrayList<Joueur> joueurs;

    public Equipe(String nom, String entraineur) {
        this.nom = nom;
        this.entraineur = entraineur;
        this.joueurs = new ArrayList<>();
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public String getEntraineur() {
        return entraineur;
    }

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEntraineur(String entraineur) {
        this.entraineur = entraineur;
    }

    public void setJoueurs(ArrayList<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public void ajouterJoueur(Joueur joueur) {
        joueurs.add(joueur);
    }

    public void supprimerJoueur(Joueur joueur) { // Correction : nom de méthode en minuscule
        joueurs.remove(joueur);
    }

    public Map<String, String> obtenirCompositionEquipe() {
        Map<String, String> nomsJoueurs = new HashMap<>();
        for (Joueur joueur : joueurs) {
            nomsJoueurs.put(joueur.getNom(), joueur.getPosition());
        }
        return nomsJoueurs;
    }
    
    
    @Override
    public String toString() {
        return nom + " | Entraîneur: " + entraineur;
    }
    
    
    
    
}
