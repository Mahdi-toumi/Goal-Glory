/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import controller.ChampionsController;
import controller.WelcomeController;
import controller.GameController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.elements.Equipe;
import model.structure.Championnat;
import model.structure.Coupe;
import model.structure.Jeu;
import model.structure.Player;
import model.structure.exceptions.AjoutEquipeException;
import model.structure.exceptions.AjoutTourException;

public class NewMain extends Application {

    @Override
    public void start(Stage primaryStage) throws AjoutEquipeException, AjoutTourException {
        // Créer le modèle (Jeu)
        Jeu jeu = new Jeu();
        jeu.setChampionnat(null);
        jeu.setCoupe(null);
        Championnat coupe = new Championnat("La Liga");
        

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
        jeu.setChampionnat(coupe);
        coupe.Initialiser_tournoi();
        Player p = new Player ("Mahdi",0) ;
        jeu.setPlayer(p);
        jeu.getPlayer().setEquipe(coupe.getEquipes().get(0));
        
        // Créer la première vue (WelcomeView)
        GameView gameView = new GameView(jeu);

        // Associer le contrôleur à la vue et au modèle
        new GameController( gameView, jeu);
        primaryStage.setScene(gameView.getScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

