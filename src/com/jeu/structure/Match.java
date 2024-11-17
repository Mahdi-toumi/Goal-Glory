/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.jeu.structure;

import com.jeu.elements.TirAuBut;
import com.jeu.elements.Equipe;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author toumi
 */
public class Match {
    private Equipe equipe1;
    private Equipe equipe2;
    private Equipe gagnant;
    private Score score;
    private Stade stade ; 
    private ArrayList<TirAuBut> tirAubuts;

    public Match(Equipe equipe1, Equipe equipe2 , Stade stade) {
        this.equipe1 = equipe1;
        this.equipe2 = equipe2; 
        this.score = new Score();
        this.stade = stade ; 
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
    
    public Equipe getGagnant() {
        return gagnant;
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
    
    public void Obtenir_gagnants(){
        if (score.getScoreEquipe1() > score.getScoreEquipe2() ) {
            this.gagnant = equipe1 ;
        }
        if (score.getScoreEquipe1() < score.getScoreEquipe2() ) {
            this.gagnant = equipe2 ;
        }
    }
    
    
    //juste pour tester jouerMatch
    private int tirerPenalty(Scanner scanner) {
    System.out.println("Saisir le résultat : 1 - But, 0 - Raté (ou laisser l'ordinateur décider en appuyant sur Entrée)");
    String input = scanner.nextLine().trim();

    if (input.isEmpty()) {
        // Simulation aléatoire si l'utilisateur ne veut pas décider
        int result = new Random().nextBoolean() ? 1 : 0;
        System.out.println("Résultat simulé : " + (result == 1 ? "But !" : "Raté !"));
        return result;
    } else {
        // Vérification de l'entrée utilisateur
        int result = Integer.parseInt(input);
        if (result == 1) {
            System.out.println("But !");
        } else if (result == 0) {
            System.out.println("Raté !");
        } else {
            System.out.println("Entrée invalide, considéré comme Raté !");
            result = 0;
        }
        return result;
    }
}
    
    public void jouerMatch() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Match entre : " + equipe1.getNom() + " et " + equipe2.getNom());
        System.out.println("Séance de tirs au but !");

        int scoreEquipe1 = 0;
        int scoreEquipe2 = 0;
        int tirsMax = 5;

        // Phase initiale de 5 tirs pour chaque équipe
        for (int i = 1; i <= tirsMax; i++) {
            System.out.println("Tir n°" + i + " pour " + equipe1.getNom());
            scoreEquipe1 += tirerPenalty(scanner);
            score.setScoreEquipe1(scoreEquipe1);

            System.out.println("Tir n°" + i + " pour " + equipe2.getNom());
            scoreEquipe2 += tirerPenalty(scanner);
            score.setScoreEquipe2(scoreEquipe2);
        }

        // Vérifier si une équipe a déjà gagné après les 5 tirs
        if (scoreEquipe1 != scoreEquipe2) {
            this.Obtenir_gagnants() ;
            return;
        }

        // Tirs supplémentaires jusqu'à départage
        System.out.println("Égalité après les 5 tirs, tirs supplémentaires !");
        while (scoreEquipe1 == scoreEquipe2) {
            System.out.println("Tir pour " + equipe1.getNom());
            scoreEquipe1 += tirerPenalty(scanner);
            score.setScoreEquipe1(scoreEquipe1);

            System.out.println("Tir pour " + equipe2.getNom());
            scoreEquipe2 += tirerPenalty(scanner);
            score.setScoreEquipe2(scoreEquipe2);
        }  
        this.Obtenir_gagnants() ;
    }
    
     
    // Surcharge de la méthode equals pour comparer les matchs
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Comparaison par référence
        if (obj == null || getClass() != obj.getClass()) return false;

        Match match = (Match) obj;
        return (equipe1.equals(match.equipe1) && equipe2.equals(match.equipe2)) || 
               (equipe1.equals(match.equipe2) && equipe2.equals(match.equipe1)); // Matchs en inversé aussi
    }
    
    
    @Override
    public String toString() {
        if (this.score.getScoreEquipe1()== 0 && this.score.getScoreEquipe2()== 0){
             return equipe1.getNom() + " vs " + equipe2.getNom();
        }
        else {
            return equipe1.getNom() +" "+ this.score + " "+ equipe2.getNom() ;
        }
    }

    
}
