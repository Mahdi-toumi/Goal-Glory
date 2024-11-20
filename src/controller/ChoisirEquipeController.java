/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javafx.scene.control.Button;
import model.structure.Jeu;
import model.elements.Equipe;
import view.ChoisirEquipeView;

import java.util.List;
import javafx.scene.layout.VBox;

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
        } else {
            System.out.println("Aucune équipe sélectionnée.");
        }
    }
}


