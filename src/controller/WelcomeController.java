/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.structure.Jeu;
import view.SaisirPlayerView;
import view.WelcomeView;

public class WelcomeController {

    private final WelcomeView welcomeView;
    private final Jeu jeu;
    

    public WelcomeController(WelcomeView welcomeView, Jeu jeu) {
        this.welcomeView = welcomeView;
        this.jeu = jeu;

        initializeButtonActions();
    }

    // Définir les actions des boutons
    private void initializeButtonActions() {
        welcomeView.getStartButton().setOnAction(event -> redirectToPlayerInput());
        welcomeView.getQuitButton().setOnAction(event -> quitApplication());
    }

    private void redirectToPlayerInput() {
        SaisirPlayerView saisirPlayerView = new SaisirPlayerView();
        Stage stage = welcomeView.getPrimaryStage();
        stage.setScene(saisirPlayerView.getScene());
        new SaisirPlayerController(saisirPlayerView, jeu);
        
    }

    private void quitApplication() {
        System.exit(0);
    }
    
   
    
}

