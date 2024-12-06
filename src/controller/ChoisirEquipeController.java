/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.control.Button;
import model.structure.Jeu;
import model.elements.Equipe;
import view.ChoisirEquipeView;

import java.util.List;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.structure.Match;
import view.BracketView;
import view.ChoisirTournoiView;
import view.JoeursEquipeView;
import view.RankingView;
import view.SaisirPlayerView;

public class ChoisirEquipeController {

    private final ChoisirEquipeView view;
    private final Jeu jeu;
    private Equipe equipeSelectionnee;
    private  List <Equipe> equipes  ;
    
  

    public ChoisirEquipeController(ChoisirEquipeView view, Jeu jeu) {
        this.view = view;
        this.jeu = jeu;

        // Ajouter des actions aux boutons représentant les équipes
        for (int i = 0; i < view.getEquipesContainer().getChildren().size(); i++) {
        VBox vboxEquipe = (VBox) view.getEquipesContainer().getChildren().get(i);  // Récupérer le VBox
        for (int j = 0; j < vboxEquipe.getChildren().size(); j++) {
            Button equipeButton = (Button) vboxEquipe.getChildren().get(j);  // Récupérer le Button à l'intérieur du VBox
            int finalI = i * 4 + j;  // Calculer l'index global
            equipeButton.setOnAction(e -> {
                handleEquipeSelection(finalI);
                view.getEquipeButton().setVisible(true);
                view.selectButton(equipeButton);
            });
        }
        view.getBackButton().setOnAction(e -> goBackToChoisirTournoisView());
        view.getEquipeButton().setOnAction(e -> goToEquipejoeurView());

    }

    // Action pour le bouton "Valider"
    view.getValiderButton().setOnAction(e -> handleValidation());
    }

    private void handleEquipeSelection(int index) {
        if (jeu.getCoupe()!= null ){
        equipes = jeu.getCoupe().getEquipes() ;}
        else if (jeu.getChampionnat()!= null ){
        equipes = jeu.getChampionnat().getEquipes() ;}
        if (index >= 0 && index < equipes.size()) {
            equipeSelectionnee = equipes.get(index);
            System.out.println("Équipe choisie : " + equipeSelectionnee.getNom());
        }
    }

      private void handleValidation() {
        if (equipeSelectionnee != null) {
            if (jeu.getCoupe()!= null){
                System.out.println("Lancement du tournoi avec l'équipe : " + equipeSelectionnee.getNom());
                // Generate the bracket
                this.jeu.getPlayer().setEquipe(equipeSelectionnee);
                BracketView bracketView = new BracketView(jeu.getCoupe().getTours().get(0).getMatchs());
                Stage stage = (Stage) view.getValiderButton().getScene().getWindow();
                stage.setScene(bracketView.getBracketScene());
                new BracketController(bracketView, jeu);
            }
            else  {
                System.out.println("Lancement du tournoi avec l'équipe : " + equipeSelectionnee.getNom());
                // Generate the bracket
                this.jeu.getPlayer().setEquipe(equipeSelectionnee);
                RankingView rankingView = new RankingView(jeu);
                Stage stage = (Stage) view.getValiderButton().getScene().getWindow();
                stage.setScene(rankingView.getScene());
                new RankingController(rankingView, jeu);

            }
                
            } 

         else {
            System.out.println("Aucune équipe sélectionnée.");
        }
    }
    
     private void goBackToChoisirTournoisView() {
        // Créer la vue de saisie
        ChoisirTournoiView ChoisirTournoiView = new ChoisirTournoiView();
        Stage stage = (Stage) view.getBackButton().getScene().getWindow();
        stage.setScene(ChoisirTournoiView.getScene());
        new ChoisirTournoiController(ChoisirTournoiView, jeu);
    }
     
    private void goToEquipejoeurView(){
        JoeursEquipeView joeursEquipeView = new JoeursEquipeView(jeu,equipeSelectionnee);
        Stage stage = (Stage) view.getBackButton().getScene().getWindow();
        stage.setScene(joeursEquipeView.getScene());
        new JoeursEquipeController(joeursEquipeView, jeu);
        
    }
}


