/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jeu.modele;

/**
 *
 * @author toumi
 */
class Match {
    private Equipe equipe1;
    private Equipe equipe2;
    private Score score;

    public Match(Equipe equipe1, Equipe equipe2) {
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.score = new Score();
    }

    public void demarrerMatch() {
        
    }

    public void terminerMatch() {
        
    }

    public void obtenirVainqueur() {
        // Logique pour déterminer le vainqueur
        
    }
}
