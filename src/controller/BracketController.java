package controller;

import java.util.ArrayList;
import javafx.stage.Stage;
import model.structure.Match;
import model.elements.Equipe;
import view.BracketView;
import java.util.Collections;
import java.util.List;
import javafx.scene.Scene;
import model.structure.Jeu;
import view.ChoisirEquipeView;

public class BracketController {

    private final BracketView view;
    private final Jeu jeu;


    public BracketController(BracketView view, Jeu jeu) {
        this.view = view;
        this.jeu=jeu;
        view.getBackButton().setOnAction(e -> goBackToChoisirEquipeView());

    }
    
     private void goBackToChoisirEquipeView() {
        // Créer la vue de saisie
        ChoisirEquipeView ChoisirEquipeView = new ChoisirEquipeView(this.jeu);
        Stage stage = (Stage) view.getBackButton().getScene().getWindow();
        stage.setScene(ChoisirEquipeView.getScene());
        new ChoisirEquipeController(ChoisirEquipeView, jeu);
    }
    
}

   
