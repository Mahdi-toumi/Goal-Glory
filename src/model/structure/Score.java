/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model.structure;



public class Score {
    private int scoreEquipe1 ; 
    private int scoreEquipe2 ;

    public Score() {
        this.scoreEquipe1 = 0;
        this.scoreEquipe2 = 0;// Default constructor with score set to 0-0
    }
    
    public int getScoreEquipe1 (){ return this.scoreEquipe1 ; }
    public int getScoreEquipe2 (){ return this.scoreEquipe2 ; }
    
    public void setScoreEquipe1 (int score ){ this.scoreEquipe1 = score  ; }
    public void setScoreEquipe2 (int score ){ this.scoreEquipe2 = score  ; }

    public void incrementEquipe1() {
        this.scoreEquipe1 = scoreEquipe1+1 ;
    }

    public void incrementEquipe2() {
        this.scoreEquipe2 = scoreEquipe1+2 ;
    }
    
    @Override
    public String toString() {
        return scoreEquipe1 + " - " + scoreEquipe2;
    }
}
