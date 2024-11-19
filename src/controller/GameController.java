package controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import view.GameView;

public class GameController {

    private Stage primaryStage;
    private GameView gameView;

    public GameController(Stage primaryStage) {
        this.primaryStage = primaryStage;

        // Créer la vue de jeu
        gameView = new GameView();

        // Réinitialiser l'événement de clic de la souris dans la vue de jeu
        gameView.setOnMouseClicked(event -> {
            double clickX = event.getX();
            double clickY = event.getY();
            gameView.animateBallToPosition(clickX, clickY);  // Déplacer le ballon vers la position cliquée
        });

        // Créer une scène avec la vue de jeu
        Scene gameScene = new Scene(gameView, 900, 600);

        // Afficher la scène de jeu
        primaryStage.setScene(gameScene);
        primaryStage.show();
    }
}
