/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import javafx.stage.Stage;
import model.elements.Equipe;
import model.structure.Jeu;
import model.structure.Match;
import view.ChoisirEquipeView;
import view.GamePreview;
import view.RankingView;
import view.TourMatchsTourView;

/**
 *
 * @author toumi
 */
public class TourMatchsTourContoller {
    

    private final TourMatchsTourView view;
    private final Jeu jeu;
    private List<Match> matchs;
    
    public TourMatchsTourContoller(TourMatchsTourView view, Jeu jeu) {
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
        
        if (jeu.getCoupe() != null) {
            this.matchs = jeu.getCoupe().getTours().get(jeu.getTour()).getMatchs();
        } else if (jeu.getChampionnat() != null) {
            this.matchs = jeu.getChampionnat().getTours().get(jeu.getTour()+1).getMatchs();
        }
        

        for (int i=0;i<8;i++){
            if (matchs.get(i).getEquipe1()== E1 || matchs.get(i).getEquipe2()== E1){
                Match match= matchs.get(i);
                GamePreview GamePreview= new GamePreview(match,jeu);
                stage.setScene(GamePreview.getScene());
                new GamePreviewController(GamePreview, jeu);
                break;
            }
            
        }
    }
}
    

