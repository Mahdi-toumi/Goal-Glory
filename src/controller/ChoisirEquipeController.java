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
import view.SaisirPlayerView;

public class ChoisirEquipeController {

    private final ChoisirEquipeView view;
    private final Jeu jeu;
    private Equipe equipeSelectionnee;

    public ChoisirEquipeController(ChoisirEquipeView view, Jeu jeu) {
        this.view = view;
        this.jeu = jeu;

        // Ajouter des actions aux boutons représentant les équipes
        for (int i = 0; i < view.getEquipesContainer().getChildren().size(); i++) {
        VBox vboxEquipe = (VBox) view.getEquipesContainer().getChildren().get(i);  // Récupérer le VBox
        for (int j = 0; j < vboxEquipe.getChildren().size(); j++) {
            Button equipeButton = (Button) vboxEquipe.getChildren().get(j);  // Récupérer le Button à l'intérieur du VBox
            int finalI = i * 4 + j;  // Calculer l'index global
            equipeButton.setOnAction(e -> handleEquipeSelection(finalI));
        }
        view.getBackButton().setOnAction(e -> goBackToSaisirPlayerView());

    }

    // Action pour le bouton "Valider"
    view.getValiderButton().setOnAction(e -> handleValidation());
    }

    private void handleEquipeSelection(int index) {
        List<Equipe> equipes = jeu.getCoupe().getEquipes();
        if (index >= 0 && index < equipes.size()) {
            equipeSelectionnee = equipes.get(index);
            System.out.println("Équipe choisie : " + equipeSelectionnee.getNom());
        }
    }

      private void handleValidation() {
        if (equipeSelectionnee != null) {
            System.out.println("Lancement du tournoi avec l'équipe : " + equipeSelectionnee.getNom());
            // Generate the bracket
            this.jeu.getPlayer().setEquipe(equipeSelectionnee);
            BracketView bracketView = new BracketView(jeu.getCoupe().getTours().get(1).getMatchs());
            Stage stage = (Stage) view.getValiderButton().getScene().getWindow();
            stage.setScene(bracketView.getBracketScene());

        } else {
            System.out.println("Aucune équipe sélectionnée.");
        }
    }
    
     private void goBackToSaisirPlayerView() {
        // Créer la vue de saisie
        SaisirPlayerView SaisirPlayerView = new SaisirPlayerView();
        Stage stage = (Stage) view.getBackButton().getScene().getWindow();
        stage.setScene(SaisirPlayerView.getScene());
        new SaisirPlayerController(SaisirPlayerView, jeu);
    }
     
}


