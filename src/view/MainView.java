package view;

import controller.GameController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainView extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Créer la vue du jeu
        GameView gameView = new GameView();

        // Créer le contrôleur et l'associer à la vue
        GameController gameController = new GameController(primaryStage);

        // Créer une scène avec la vue
        Scene scene = new Scene(gameView, 900, 600);

        // Configurer le stage
        primaryStage.setTitle("Goal Glory");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
