/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jeu.structure;

import com.jeu.elements.Equipe ;
import java.util.ArrayList;

/**
 *
 * @author toumi
 */
public abstract class Tournoi {
    protected ArrayList<Equipe> equipes;
    protected ArrayList<Match> matchs;
    protected int tourActuel;

    public Tournoi() {
        this.equipes = new ArrayList<>();
        this.matchs = new ArrayList<>();
        this.tourActuel = 0;
    }
    
    // Getters
    public ArrayList<Equipe> getEquipes() {
        return equipes;
    }

    public ArrayList<Match> getMatchs() {
        return matchs;
    }

    public int getTourActuel() {
        return tourActuel;
    }

    // Setters
    public void setEquipes(ArrayList<Equipe> equipes) {
        this.equipes = equipes;
    }

    public void setMatchs(ArrayList<Match> matchs) {
        this.matchs = matchs;
    }

    public void setTourActuel(int tourActuel) {
        this.tourActuel = tourActuel;
    }

    public void ajouterEquipe(Equipe equipe) {
        equipes.add(equipe);
    }
    
    public void supprimerEquipe(Equipe equipe) {
        equipes.remove(equipe);
    }

    public abstract void organiserMatchs() ;

    public abstract void obtenirVainqueur(); 
}
