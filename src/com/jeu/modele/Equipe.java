/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jeu.modele;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author toumi
 */
class Equipe {
    private String nom;
    private String entraineur;
    private ArrayList<Joueur> joueurs;

    public Equipe(String nom, String entraineur) {
        this.nom = nom;
        this.entraineur = entraineur;
        this.joueurs = new ArrayList<>();
    }

    public void ajouterJoueur(Joueur joueur) {
        joueurs.add(joueur);
    }
    
    public void SupprimerJoueur(Joueur joueur) {
        joueurs.remove(joueur);
    }

    public Map<String,String> obtenirCompositionEquipe() {
        Map<String , String> nomsJoueurs = new HashMap<>(); 
        for (Joueur joueur : joueurs) {
            nomsJoueurs.put(joueur.getNom(),joueur.getPosition());
        }
        return nomsJoueurs;
    }
}
