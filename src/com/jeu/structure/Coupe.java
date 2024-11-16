/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jeu.structure;

import com.jeu.structure.Tournoi;
import com.jeu.elements.Equipe;
import java.util.ArrayList;

/**
 *
 * @author toumi
 */
public class Coupe extends Tournoi {
    private ArrayList<Equipe> equipesEliminees;

    public Coupe() {
        super();
        this.equipesEliminees = new ArrayList<>();
    }

    // Getters
    public ArrayList<Equipe> getEquipesEliminees() {
        return equipesEliminees;
    }

    // Setters
    public void setEquipesEliminees(ArrayList<Equipe> equipesEliminees) {
        this.equipesEliminees = equipesEliminees;
    }

    public void eliminerEquipe(Equipe equipe) {
        equipesEliminees.add(equipe);
        equipes.remove(equipe);
    }

    

    @Override
    public void obtenirVainqueur() {
        
    }

    @Override
    public void organiserMatchs() {
    }
}
