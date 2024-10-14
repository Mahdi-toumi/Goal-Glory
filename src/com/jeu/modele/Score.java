/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jeu.modele;

/**
 *
 * @author toumi
 */
class Score {
    private int scoreEquipe1;
    private int scoreEquipe2;

    public Score() {
        this.scoreEquipe1 = 0;
        this.scoreEquipe2 = 0;
    }

    public void incrementerScore(Equipe equipe) {
      /*  if (equipe == ) {
            scoreEquipe1++;
        } else if (equipe == ) {
            scoreEquipe2++;
        }
       */
    }

    public String obtenirScore() {
        return scoreEquipe1 + " - " + scoreEquipe2;
    }
}
