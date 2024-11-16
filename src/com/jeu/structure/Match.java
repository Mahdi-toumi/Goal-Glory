/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.jeu.structure;

import com.jeu.elements.TirAuBut;
import com.jeu.elements.Equipe;
import java.util.ArrayList;

/**
 *
 * @author toumi
 */
class Match {
    private Equipe equipe1;
    private Equipe equipe2;
    private Score score;
    private Stade stade ; 
    private ArrayList<TirAuBut> tirAubuts;

    public Match(Equipe equipe1, Equipe equipe2, Stade stade) {
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.stade = stade ; 
        this.score = new Score();
        this.tirAubuts = new ArrayList<>(); 
    }

    // Getters
    public Equipe getEquipe1() {
        return equipe1;
    }

    public Equipe getEquipe2() {
        return equipe2;
    }

    public Score getScore() {
        return score;
    }

    public ArrayList<TirAuBut> getTirAubuts() {
        return tirAubuts;
    }

    // Setters
    public void setEquipe1(Equipe equipe1) {
        this.equipe1 = equipe1;
    }

    public void setEquipe2(Equipe equipe2) {
        this.equipe2 = equipe2;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public void setTirAubuts(ArrayList<TirAuBut> tirAubuts) {
        this.tirAubuts = tirAubuts;
    }

    public void ajouterTirAuBut(TirAuBut tirAuBut) {
        this.tirAubuts.add(tirAuBut);
    }

    public void supprimerTirAuBut(TirAuBut tirAuBut) {
        this.tirAubuts.remove(tirAuBut);
    }

    
}
