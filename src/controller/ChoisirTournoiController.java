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
        else{
            setupChampionsLeague();
        }
        // Ajouter la gestion pour "Champions League" ici si nécessaire
        redirectToEquipeSelection();
    }

    private void setupChampionsLeague() {
        Coupe coupe = new Coupe("Champions League");

        // Ajouter les équipes à la coupe
        String[][] equipesData = {
            {"Real Madrid", "Carlo Ancelotti", "RMA"}, {"Barcelona", "Xavi Hernandez","BAR"}, {"Manchester City", "Pep Guardiola","MCY"},
            {"Paris Saint-Germain", "Luis Enrique","PSG"}, {"Bayern Munich", "Thomas Tuchel","FCB"}, {"Chelsea", "Mauricio Pochettino","CHE"},
            {"Liverpool", "Jurgen Klopp","LIV"}, {"Juventus", "Massimiliano Allegri","JUV"}, {"Atletico Madrid", "Diego Simeone","ATM"},
            {"Inter Milan", "Simone Inzaghi","INT"}, {"AC Milan", "Stefano Pioli","MIL"}, {"Borussia Dortmund", "Edin Terzic","DOR"},
            {"Arsenal", "Mikel Arteta","ARS"}, {"Tottenham Hotspur", "Ange Postecoglou","TOT"}, {"Napoli", "Rudi Garcia","NAP"}, {"Benfica", "Roger Schmidt","BEN"}
        };

        for (String[] data : equipesData) {
            coupe.ajouterEquipe(new Equipe(data[0], data[1],data[2]));
        }

        jeu.setCoupe(coupe);
       // coupe.Commencer_tournoi();
        System.out.println("Tournoi 'Champions League' configuré avec " + coupe.getEquipes().size() + " équipes.");
    }
    
    private void setupWorldCup() {
        Coupe coupe = new Coupe("World Cup");

        // Ajouter les équipes à la coupe
        String[][] equipesData = {
            {"France", "Didier Deschamps","FRA"}, {"Spain", "De La Fuente","SPA"}, {"Germany", "Nagelsmann","GER"},
            {"Argentina", "Lionel Scaloni","ARG"}, {"Italia", "Spaletti","ITA"}, {"Brazil", "Dorival Junior ","BRA"},
            {"Uruguay", "Marcelo Bielsa","URG"}, {"Colombia", "Néstor Lorenzo ","COL"}, {"Belguim", "Domenico Tedesco","BEL"},
            {"Portugal", "Martinez","POR"}, {"Morroco", "Walid Regragui","MOR"}, {"Croatia", "Zlatko Dalić","CRO"},
            {"Netherlands", "Ronald Koeman","NET"}, {"Senegal", "Aliou Cissé","SEN"}, {"England", "Thomas Tuchel ","ENG"}, {"Poland", "Michał Probierz","POL"}
        };

        for (String[] data : equipesData) {
            coupe.ajouterEquipe(new Equipe(data[0], data[1],data[2]));
        }

        jeu.setCoupe(coupe);
        coupe.Initialiser_tournoi();
        coupe.Initialiser_tour(); 
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

