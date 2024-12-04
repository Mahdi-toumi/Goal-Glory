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

public class NewMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Créer le modèle (Jeu)
        Jeu jeu = new Jeu();
        Coupe Coupe= new Coupe("World Cup");
        jeu.setCoupe(Coupe);
        Coupe.Initialiser_tournoi();
        Equipe e = new Equipe ("France" , "Hama " , "FRA") ;
        Player p = new Player ("Mahdi",0) ;
        jeu.setPlayer(p);
        jeu.getPlayer().setEquipe(e);
        
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

