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
import view.GamePreview;

public class BracketController {

    private final BracketView view;
    private final Jeu jeu;


    public BracketController(BracketView view, Jeu jeu) {
        this.view = view;
        this.jeu=jeu;
        view.getBackButton().setOnAction(e -> goBackToChoisirEquipeView());
        view.getNextButton().setOnAction(e-> redirectToGamePreview());
    }
    
     private void goBackToChoisirEquipeView() {
        // Créer la vue de saisie
        ChoisirEquipeView ChoisirEquipeView = new ChoisirEquipeView(this.jeu);
        Stage stage = (Stage) view.getBackButton().getScene().getWindow();
        stage.setScene(ChoisirEquipeView.getScene());
        new ChoisirEquipeController(ChoisirEquipeView, jeu);
    }
     private void redirectToGamePreview(){
        Stage stage = (Stage) view.getNextButton().getScene().getWindow();
        Equipe E1=jeu.getPlayer().getEquipe();
        List <Match> Matchs= jeu.getCoupe().getTours().get(this.jeu.getTour()).getMatchs();
        for (int i=0;i<jeu.getCoupe().getEquipesRestantes().size();i++){
            if (Matchs.get(i).getEquipe1()== E1 || Matchs.get(i).getEquipe2()== E1){
                Match match= Matchs.get(i);
                GamePreview GamePreview= new GamePreview(match,jeu);
                stage.setScene(GamePreview.getScene());
                new GamePreviewController(GamePreview, jeu);
                break;
            }
            
        }
    }
     
    
    
}

   
