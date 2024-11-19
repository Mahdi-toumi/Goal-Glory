/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.structure.Jeu;
import model.structure.Player;
import view.GameView;
import view.SaisirPlayerView;
import view.WelcomeView;

public class WelcomeController {

    private WelcomeView welcomeView;
    private Jeu jeu;

    public WelcomeController(WelcomeView welcomeView, Jeu jeu) {
        this.welcomeView = welcomeView;
        this.jeu = jeu;

        // Gérer le bouton Start
        welcomeView.getStartButton().setOnAction(event -> redirectToPlayerInput());

        // Gérer le bouton Quit
        welcomeView.getQuitButton().setOnAction(event -> quitApplication());
    }

    // Méthode pour rediriger vers la saisie du joueur
    private void redirectToPlayerInput() {
        // Créer la vue de saisie
        SaisirPlayerView saisirPlayerView = new SaisirPlayerView();
        Stage stage = welcomeView.getPrimaryStage(); // Utiliser le stage principal
        stage.setScene(saisirPlayerView.getScene());

        // Gérer l'action de validation
        saisirPlayerView.getValiderButton().setOnAction(event -> {
            String playerName = saisirPlayerView.getNomField().getText().trim();

            if (!playerName.isEmpty()) {
                // Ajouter le joueur
                Player newPlayer = new Player(playerName, 0);
                jeu.getJoueurs().add(newPlayer);

                // Démarrer le jeu
                startGame(stage);
            } else {
                System.out.println("Veuillez saisir un nom valide.");
            }
        });
    }

    // Méthode pour démarrer le jeu
    private void startGame(Stage stage) {
        // Créer et afficher la vue du jeu
        GameView gameView = new GameView();
        Scene gameScene = new Scene(gameView, 900, 600);
        stage.setScene(gameScene);
    }

    // Méthode pour quitter l'application
    private void quitApplication() {
        System.exit(0); // Fermer l'application
    }
}


