/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import controller.WelcomeController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.structure.Jeu;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Modèle principal du jeu
        Jeu jeu = new Jeu();

        // Vue d'accueil (WelcomeView)
        WelcomeView welcomeView = new WelcomeView(primaryStage);

        // Contrôleur associé à la vue et au modèle
        new WelcomeController(welcomeView, jeu);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
