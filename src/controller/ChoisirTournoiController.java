/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;
import model.elements.Equipe;
import model.elements.Gardien;
import model.elements.Joueur;
import model.elements.Poste;
import model.elements.Tireur;
import model.structure.Championnat;
import model.structure.Coupe;
import model.structure.Jeu;
import model.structure.exceptions.AjoutEquipeException;
import model.structure.exceptions.AjoutTourException;
import view.ChoisirEquipeView;
import view.ChoisirTournoiView;

public class ChoisirTournoiController {

    private final ChoisirTournoiView view;
    private final Jeu jeu;

    public ChoisirTournoiController(ChoisirTournoiView view, Jeu jeu) {
        this.view = view;
        this.jeu = jeu;

        // Gestion du clic sur le bouton "World Cup"
        view.getWorldCupButton().setOnAction(e -> {
            try {
                handleTournamentSelection("World Cup");
            } catch (AjoutEquipeException ex) {
            } catch (AjoutTourException ex) {
                Logger.getLogger(ChoisirTournoiController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        // Gestion du clic sur le bouton "Champions League"
        view.getChampionsLeagueButton().setOnAction(e -> {
            try {
                handleTournamentSelection("Champions League");
            } catch (AjoutEquipeException ex) {
            } catch (AjoutTourException ex) {
                Logger.getLogger(ChoisirTournoiController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        // Gestion du clic sur le bouton "La Liga"
        view.getlaLigaButton().setOnAction(e -> {
            try {
                handleTournamentSelection("La Liga");
            } catch (AjoutEquipeException ex) {
            } catch (AjoutTourException ex) {
                Logger.getLogger(ChoisirTournoiController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        // Gestion du clic sur le bouton "Premier League"
        view.getpremierLeagueButton().setOnAction(e -> {
            try {
                handleTournamentSelection("Premier League");
            } catch (AjoutEquipeException ex) {
            } catch (AjoutTourException ex) {
                Logger.getLogger(ChoisirTournoiController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    private void handleTournamentSelection(String tournamentName) throws AjoutEquipeException, AjoutTourException {
        System.out.println("Tournoi sélectionné : " + tournamentName);
        if ("World Cup".equals(tournamentName)) {
            setupWorldCup();
        }
        else if ("La Liga".equals(tournamentName)) {
            setupLaLiga();
        }
        else if ("Premier League".equals(tournamentName)){
            setupPremierLeague();
        }
        else if ("Champions League".equals(tournamentName)){
            setupChampionsLeague();
        }
        else {
            System.out.println("Erreur");
        }
        // Ajouter la gestion pour "Champions League" ici si nécessaire
        redirectToEquipeSelection();
    }

    private void setupChampionsLeague() throws AjoutEquipeException, AjoutTourException {
        
        jeu.setChampionnat(null);
        jeu.setCoupe(null);
        Coupe coupe = new Coupe("Champions League");
        

        // Ajouter les équipes à la coupe
        String[][] equipesData = {
            {"Madrid", "Carlo Ancelotti", "RMA"}, {"Barcelona", "Xavi Hernandez","BAR"}, {"City", "Pep Guardiola","MCY"},
            {"PSG", "Luis Enrique","PSG"}, {"Bayern", "Thomas Tuchel","FCB"}, {"Chelsea", "Mauricio Pochettino","CHE"},
            {"Liverpool", "Jurgen Klopp","LIV"}, {"Juventus", "Massimiliano Allegri","JUV"}, {"Atletico", "Diego Simeone","ATM"},
            {"Inter", "Simone Inzaghi","INT"}, {"Milan", "Stefano Pioli","MIL"}, {"Dortmund", "Edin Terzic","DOR"},
            {"Arsenal", "Mikel Arteta","ARS"}, {"Tottenham", "Ange Postecoglou","TOT"}, {"Napoli", "Rudi Garcia","NAP"}, 
            {"Benfica", "Roger Schmidt","BEN"}
                
        };

        for (String[] data : equipesData) {
            coupe.ajouterEquipe(new Equipe(data[0], data[1],data[2]));
        }
        jeu.setCoupe(coupe);
        
        Data data = new Data () ;
        data.DataChampionsLeague(jeu);

        coupe.Initialiser_tournoi();
        coupe.Initialiser_tour();
        System.out.println("Tournoi 'Champions League' configuré avec " + coupe.getEquipes().size() + " équipes.");
    }
    
    
    private void setupWorldCup() throws AjoutEquipeException, AjoutTourException {
        Coupe coupe = new Coupe("World Cup");
        jeu.setChampionnat(null);
        jeu.setCoupe(null);

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
        Data data = new Data () ;
        data.DataWorldCup(jeu);
        
        coupe.Initialiser_tournoi();
        coupe.Initialiser_tour();
        System.out.println("Tournoi 'World Cup' configuré avec " + coupe.getEquipes().size() + " équipes.");
    }
    
    private void setupLaLiga() throws AjoutEquipeException{
        Championnat championnat = new Championnat("La Liga");
        jeu.setCoupe(null);
        jeu.setChampionnat(null);

        // Ajouter les équipes à la coupe
        String[][] equipesData = {
            {"Madrid", "Carlo Ancelotti", "RMA"}, {"Barcelona", "Xavi Hernandez", "BAR"}, {"Atletico", "Diego Simeone", "ATM"},
            {"Sevilla", "Diego Alonso", "SEV"}, {"Sociedad", "Imanol Alguacil", "RSO"}, {"Betis", "Manuel Pellegrini", "BET"},
            {"Villarreal", "Quique Setien", "VIL"}, {"Valencia", "Ruben Baraja", "VAL"}, {"Athletic", "Ernesto Valverde", "ATH"},
            {"Vigo", "Rafael Benitez", "CEL"}, {"Osasuna", "Jagoba Arrasate", "OSA"}, {"Espanyol", "Luis Garcia", "ESP"},
            {"Mallorca", "Javier Aguirre", "MAL"}, {"Granada", "Paco Lopez", "GRA"}, {"Alaves", "Luis Garcia Plaza", "ALA"}, {"Getafe", "Jose Bordalas", "GET"}
        };
        

        for (String[] data : equipesData) {
            championnat.ajouterEquipe(new Equipe(data[0], data[1],data[2]));
        }

        jeu.setChampionnat(championnat);
        Data data = new Data () ;
        data.DataLaliga(jeu);
        championnat.Initialiser_tournoi();
        System.out.println("Tournoi 'La Liga' configuré avec " + championnat.getEquipes().size() + " équipes.");
        
    }
    
    
    private void setupPremierLeague() throws AjoutEquipeException{
        Championnat championnat = new Championnat("Premier League");
        jeu.setCoupe(null);
        jeu.setChampionnat(null);
        // Ajouter les équipes à la coupe
        String[][] equipesData = {
            {"City", "Pep Guardiola", "MCY"}, {"Arsenal", "Mikel Arteta", "ARS"}, {"Liverpool", "Jurgen Klopp", "LIV"},
            {"United", "Erik ten Hag", "MUN"}, {"Chelsea", "Mauricio Pochettino", "CHE"}, {"Tottenham", "Ange Postecoglou", "TOT"},
            {"Newcastle", "Eddie Howe", "NEW"}, {"Brighton", "Roberto De Zerbi", "BHA"}, {"Aston", "Unai Emery", "AVL"},
            {"West Ham", "David Moyes", "WHU"}, {"Crystal", "Roy Hodgson", "CRY"}, {"Fulham", "Marco Silva", "FUL"},
            {"Wolverhampton", "Gary O'Neil", "WOL"}, {"Everton", "Sean Dyche", "EVE"}, {"Brentford", "Thomas Frank", "BRE"}, {"Bournemouth", "Andoni Iraola", "BOU"}
        };
        

        for (String[] data : equipesData) {
            championnat.ajouterEquipe(new Equipe(data[0], data[1],data[2]));
        }

        jeu.setChampionnat(championnat);
        Data data = new Data () ;
        data.DataPL(jeu);
        
        championnat.Initialiser_tournoi();
        System.out.println("Tournoi 'Premier League' configuré avec " + championnat.getEquipes().size() + " équipes.");
        
    }


    private void redirectToEquipeSelection() {
        if (jeu.getCoupe() != null && !jeu.getCoupe().getEquipes().isEmpty()) {
            ChoisirEquipeView choisirEquipeView = new ChoisirEquipeView(jeu);
            Stage stage = (Stage) view.getWorldCupButton().getScene().getWindow();
            stage.setScene(choisirEquipeView.getScene());
            new ChoisirEquipeController(choisirEquipeView, jeu);
        } else if (jeu.getChampionnat() != null && !jeu.getChampionnat().getEquipes().isEmpty()) {
            ChoisirEquipeView choisirEquipeView = new ChoisirEquipeView(jeu);
            Stage stage = (Stage) view.getlaLigaButton().getScene().getWindow();
            stage.setScene(choisirEquipeView.getScene());
            new ChoisirEquipeController(choisirEquipeView, jeu);
        }
        else{
            System.out.println("Erreur : Aucune équipe n'est disponible pour le tournoi.");
        }
    }
}

