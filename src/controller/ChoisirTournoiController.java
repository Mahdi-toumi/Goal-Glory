/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.structure.Jeu;
import view.ChoisirTournoiView;

public class ChoisirTournoiController {

    private ChoisirTournoiView view;
    private Jeu jeu;

    public ChoisirTournoiController(ChoisirTournoiView view, Jeu jeu) {
        this.view = view;
        this.jeu = jeu;

        // Gérer les événements de clic sur les boutons
        view.getCoupeButton().setOnAction(e -> {
            System.out.println("Tournoi Coupe sélectionné.");
            // Logique pour démarrer un tournoi Coupe
        });

        view.getChampionnatButton().setOnAction(e -> {
            System.out.println("Tournoi Championnat sélectionné.");
            // Logique pour démarrer un tournoi Championnat
        });
    }
}
