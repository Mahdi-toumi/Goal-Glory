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

    private final SaisirPlayerView view;
    private final Jeu jeu;

    public SaisirPlayerController(SaisirPlayerView view, Jeu jeu) {
        this.view = view;
        this.jeu = jeu;

        // Gestion du clic sur le bouton "Valider"
        view.getValiderButton().setOnAction(e -> handlePlayerCreation());
    }

    private void handlePlayerCreation() {
        String nom = view.getNomField().getText().trim();

        if (!nom.isEmpty()) {
            Player player = new Player(nom, 0);
            jeu.ajouterPlayer(player);
            redirectToTournamentChoice();
        } else {
            System.out.println("Veuillez saisir un nom valide.");
        }
    }

    private void redirectToTournamentChoice() {
        ChoisirTournoiView choisirTournoiView = new ChoisirTournoiView();
        Stage stage = (Stage) view.getNomField().getScene().getWindow();
        stage.setScene(choisirTournoiView.getScene());
        new ChoisirTournoiController(choisirTournoiView, jeu);
    }
}





