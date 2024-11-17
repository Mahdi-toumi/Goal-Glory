/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jeu.structure;



/**
 *
 * @author toumi
 */
public class Jeu {
    
    private Match matchActuel;
    private Tournoi tournoi;

    public Jeu(Match matchActuel, Tournoi tournoi) {
        this.matchActuel = matchActuel;
        this.tournoi = tournoi;
    }

    // Getters
    public Match getMatchActuel() {
        return matchActuel;
    }

  

    public Tournoi getTournoi() {
        return tournoi;
    }

    // Setters
    public void setMatchActuel(Match matchActuel) {
        this.matchActuel = matchActuel;
    }


    public void setTournoi(Tournoi tournoi) {
        this.tournoi = tournoi;
    }

    
}

