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
 * @author lenovo
 */
public class RankingController {
    private final RankingView view;
    private final Jeu jeu;
    
    public RankingController(RankingView view, Jeu jeu) {
        this.view = view;
        this.jeu=jeu;
        view.getBackButton().setOnAction(e -> goBackToChoisirEquipeView());
        view.getNextButton().setOnAction(e-> redirectToGameMatchs());
    }
    private void goBackToChoisirEquipeView() {
        // Créer la vue de saisie
        ChoisirEquipeView ChoisirEquipeView = new ChoisirEquipeView(this.jeu);
        Stage stage = (Stage) view.getBackButton().getScene().getWindow();
        stage.setScene(ChoisirEquipeView.getScene());
        new ChoisirEquipeController(ChoisirEquipeView, jeu);
    }
    private void redirectToGameMatchs(){
        Stage stage = (Stage) view.getNextButton().getScene().getWindow();
        Equipe E1=jeu.getPlayer().getEquipe();
        List <Match> Matchs= jeu.getChampionnat().getTours().get(this.jeu.getTour()).getMatchs();
        for (int i=0;i<8;i++){
            if (Matchs.get(i).getEquipe1()== E1 || Matchs.get(i).getEquipe2()== E1){
                Match match= Matchs.get(i);
                TourMatchsTourView tourMatchsTourView= new TourMatchsTourView(jeu ,  Matchs );
                stage.setScene(tourMatchsTourView.getScene());
                new TourMatchsTourContoller(tourMatchsTourView, jeu);
                break;
            }
            
        }
    }
}


    


    
    
     
    


   
