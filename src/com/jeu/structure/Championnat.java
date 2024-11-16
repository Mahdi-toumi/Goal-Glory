/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jeu.structure;

import com.jeu.structure.Tournoi;
import com.jeu.elements.Equipe;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author toumi
 */
public class Championnat extends Tournoi {
    
    private Map<Equipe, Integer> pointsEquipes;

    public Championnat() {
        super();
        this.pointsEquipes = new HashMap<>();
    }

    // Getters
    public Map<Equipe, Integer> getPointsEquipes() {
        return pointsEquipes;
    }

    // Setters
    public void setPointsEquipes(Map<Equipe, Integer> pointsEquipes) {
        this.pointsEquipes = pointsEquipes;
    }

    public void mettreAJourPoints(Equipe equipe, int points) {
        pointsEquipes.put(equipe, pointsEquipes.getOrDefault(equipe, 0) + points);
    }

    public ArrayList<Equipe> obtenirClassement() {
        ArrayList<Equipe> classement = new ArrayList<>(pointsEquipes.keySet());
        classement.sort((e1, e2) -> pointsEquipes.get(e2).compareTo(pointsEquipes.get(e1)));
        return classement;
    }

    @Override
    public void obtenirVainqueur() {
        
    }

    @Override
    public void organiserMatchs() {
    }
}
