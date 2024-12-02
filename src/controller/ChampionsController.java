/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javafx.stage.Stage;
import model.structure.Jeu;
import view.ChampionsView;
import view.ChoisirTournoiView;

/**
 *
 * @author lenovo
 */
public class ChampionsController {
    private final ChampionsView view;
    private final Jeu jeu;

    public ChampionsController(ChampionsView view, Jeu jeu) {
        this.view = view;
        this.jeu = jeu;
        view.getRestartButton().setOnAction(e -> {
            redirectToChoisirTournois();
        });

        view.getQuitButton().setOnAction(e -> {
            quitApplication();
        });
        
        
    }
    
    public void redirectToChoisirTournois(){
        ChoisirTournoiView choisirTournoiView = new ChoisirTournoiView();
        Stage stage = (Stage) view.getScene().getWindow();
        stage.setScene(choisirTournoiView.getScene());
        new ChoisirTournoiController(choisirTournoiView, jeu);
    }
    
    public void quitApplication(){
        System.exit(0);
    }
}
