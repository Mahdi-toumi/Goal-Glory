/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import controller.WelcomeController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.structure.Jeu;

public class NewMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Créer les objets nécessaires
        Jeu jeu = new Jeu(); // Initialisez votre objet Jeu
        WelcomeView welcomeView = new WelcomeView(primaryStage);

        // Associer le contrôleur à la vue et au modèle
        WelcomeController welcomeController = new WelcomeController(welcomeView, jeu);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
