/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.structure;

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

    // Getters
    public int getScoreEquipe1() {
        return scoreEquipe1;
    }

    public int getScoreEquipe2() {
        return scoreEquipe2;
    }

    // Setters
    public void setScoreEquipe1(int scoreEquipe1) {
        this.scoreEquipe1 = scoreEquipe1;
    }

    public void setScoreEquipe2(int scoreEquipe2) {
        this.scoreEquipe2 = scoreEquipe2;
    }
    
    @Override
    public String toString() {
        return this.scoreEquipe1 + " - " + this.scoreEquipe2;
    }
}
