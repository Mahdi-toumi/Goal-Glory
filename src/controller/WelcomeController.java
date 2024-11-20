/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javafx.stage.Stage;
import model.structure.Jeu;
import view.SaisirPlayerView;
import view.WelcomeView;

public class WelcomeController {

    private WelcomeView welcomeView;
    private Jeu jeu;

    public WelcomeController(WelcomeView welcomeView, Jeu jeu) {
        this.welcomeView = welcomeView;
        this.jeu = jeu;

        // Définir les actions des boutons après qu'ils deviennent interactifs
        initializeButtonActions();
    }

    private void initializeButtonActions() {
        // Gérer le bouton Start
        welcomeView.getStartButton().setOnAction(event -> redirectToPlayerInput());

        // Gérer le bouton Quit
        welcomeView.getQuitButton().setOnAction(event -> quitApplication());
    }
        

    private void redirectToPlayerInput() {
        // Créer la vue de saisie
        SaisirPlayerView saisirPlayerView = new SaisirPlayerView();
        Stage stage = welcomeView.getPrimaryStage();

        // Naviguer vers la vue de saisie
        stage.setScene(saisirPlayerView.getScene());

        // Associer un contrôleur pour gérer les interactions dans cette vue
        new SaisirPlayerController(saisirPlayerView, jeu);
    }

    private void quitApplication() {
        System.exit(0); // Fermer l'application
    }
}
