/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javafx.stage.Stage;
import model.structure.Jeu;
import model.structure.Player;
import view.ChoisirTournoiView;
import view.SaisirPlayerView;

public class SaisirPlayerController {

    private SaisirPlayerView view;
    private Jeu jeu;

    public SaisirPlayerController(SaisirPlayerView view, Jeu jeu) {
        this.view = view;
        this.jeu = jeu;

        // Gérer l'événement de clic sur le bouton "Valider"
        view.getValiderButton().setOnAction(e -> {
            String nom = view.getNomField().getText().trim();

            if (!nom.isEmpty()) {
                // Ajouter le joueur dans le modèle
                Player player = new Player(nom, 0);
                jeu.ajouterPlayer(player);

                // Naviguer vers la vue de choix de tournoi
                redirectToTournamentChoice();
            } else {
                System.out.println("Veuillez saisir un nom valide.");
            }
        });
    }

    private void redirectToTournamentChoice() {
        // Créer la vue de choix de tournoi
        ChoisirTournoiView choisirTournoiView = new ChoisirTournoiView();
        Stage stage = (Stage) view.getNomField().getScene().getWindow();

        // Naviguer vers cette vue
        stage.setScene(choisirTournoiView.getScene());

        // Associer un contrôleur pour gérer les interactions dans cette vue
        new ChoisirTournoiController(choisirTournoiView, jeu);
    }
}





