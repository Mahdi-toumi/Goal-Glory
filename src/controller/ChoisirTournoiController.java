/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javafx.stage.Stage;
import model.elements.Equipe;
import model.structure.Coupe;
import model.structure.Jeu;
import view.ChoisirEquipeView;
import view.ChoisirTournoiView;

public class ChoisirTournoiController {

    private final ChoisirTournoiView view;
    private final Jeu jeu;

    public ChoisirTournoiController(ChoisirTournoiView view, Jeu jeu) {
        this.view = view;
        this.jeu = jeu;

        // Gestion du clic sur le bouton "World Cup"
        view.getWorldCupButton().setOnAction(e -> handleTournamentSelection("World Cup"));

        // Gestion du clic sur le bouton "Champions League"
        view.getChampionsLeagueButton().setOnAction(e -> handleTournamentSelection("Champions League"));
    }

    private void handleTournamentSelection(String tournamentName) {
        System.out.println("Tournoi sélectionné : " + tournamentName);
        if ("World Cup".equals(tournamentName)) {
            setupWorldCup();
        }
        // Ajouter la gestion pour "Champions League" ici si nécessaire
        redirectToEquipeSelection();
    }

    private void setupWorldCup() {
        Coupe coupe = new Coupe("World Cup");

        // Ajouter les équipes à la coupe
        String[][] equipesData = {
            {"Real Madrid", "Carlo Ancelotti"}, {"Barcelona", "Xavi Hernandez"}, {"Manchester City", "Pep Guardiola"},
            {"Paris Saint-Germain", "Luis Enrique"}, {"Bayern Munich", "Thomas Tuchel"}, {"Chelsea", "Mauricio Pochettino"},
            {"Liverpool", "Jurgen Klopp"}, {"Juventus", "Massimiliano Allegri"}, {"Atletico Madrid", "Diego Simeone"},
            {"Inter Milan", "Simone Inzaghi"}, {"AC Milan", "Stefano Pioli"}, {"Borussia Dortmund", "Edin Terzic"},
            {"Arsenal", "Mikel Arteta"}, {"Tottenham Hotspur", "Ange Postecoglou"}, {"Napoli", "Rudi Garcia"}, {"Benfica", "Roger Schmidt"}
        };

        for (String[] data : equipesData) {
            coupe.ajouterEquipe(new Equipe(data[0], data[1]));
        }

        jeu.setCoupe(coupe);
        System.out.println("Tournoi 'World Cup' configuré avec " + coupe.getEquipes().size() + " équipes.");
    }

    private void redirectToEquipeSelection() {
        if (jeu.getCoupe() != null && !jeu.getCoupe().getEquipes().isEmpty()) {
            ChoisirEquipeView choisirEquipeView = new ChoisirEquipeView(jeu.getCoupe().getEquipes());
            Stage stage = (Stage) view.getWorldCupButton().getScene().getWindow();
            stage.setScene(choisirEquipeView.getScene());
            new ChoisirEquipeController(choisirEquipeView, jeu);
        } else {
            System.out.println("Erreur : Aucune équipe n'est disponible pour le tournoi.");
        }
    }
}

