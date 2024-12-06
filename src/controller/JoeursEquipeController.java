/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.structure.Jeu;
import view.ChoisirEquipeView;
import view.ChoisirTournoiView;
import view.JoeursEquipeView;

/**
 *
 * @author toumi
 */
public class JoeursEquipeController {
    private final JoeursEquipeView view;
    private final Jeu jeu;
    
    public JoeursEquipeController(JoeursEquipeView view, Jeu jeu) {
        this.view = view;
        this.jeu = jeu;

        
        view.getBackButton().setOnAction(e -> goBackToChoisirEquipeView());

    }

    
    
    
    private void goBackToChoisirEquipeView() {
        // Créer la vue de saisie
        ChoisirEquipeView choisirEquipeView = new ChoisirEquipeView(this.jeu);
        Stage stage = (Stage) view.getBackButton().getScene().getWindow();
        stage.setScene(choisirEquipeView.getScene());
        new ChoisirEquipeController(choisirEquipeView, jeu);
    }
    
}
