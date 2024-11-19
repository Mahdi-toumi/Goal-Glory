package view;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class GameView extends Pane {

    private ImageView terrainView;
    private ImageView ballonView;
    private double ballonStartX = 425;
    private double ballonStartY = 540;
    private Rectangle cageRect;

    public GameView() {
        // Charger les images
        Image terrainImage = new Image(getClass().getResource("/images/terrain.jpg").toExternalForm());
        Image ballonImage = new Image(getClass().getResource("/images/ballon.png").toExternalForm());

        // Initialiser l'image du terrain
        terrainView = new ImageView(terrainImage);
        terrainView.setFitWidth(900);
        terrainView.setFitHeight(600);

        // Initialiser l'image du ballon
        ballonView = new ImageView(ballonImage);
        ballonView.setFitWidth(50);
        ballonView.setFitHeight(50);

        // Initialiser le rectangle pour la cage
        cageRect = new Rectangle(110, 195, 680, 230);
        cageRect.setFill(Color.TRANSPARENT);
        cageRect.setStroke(Color.TRANSPARENT);
        cageRect.setStrokeWidth(2);

        // Ajouter les éléments à la scène
        getChildren().addAll(terrainView, cageRect, ballonView);

        // Réinitialiser la position du ballon
        resetBallPosition();

        // Gérer l'événement de clic sur le terrain
        setOnMouseClicked(event -> {
            double clickX = event.getX();
            double clickY = event.getY();
            animateBallToPosition(clickX, clickY);
        });
    }

    private void resetBallPosition() {
        ballonView.setLayoutX(ballonStartX);
        ballonView.setLayoutY(ballonStartY);
    }

    public void animateBallToPosition(double targetX, double targetY) {
        // Calcul des déplacements nécessaires
        double deltaX = targetX - ballonView.getLayoutX();
        double deltaY = targetY - ballonView.getLayoutY();

        // Transition de déplacement
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(ballonView);
        translateTransition.setByX(deltaX);
        translateTransition.setByY(deltaY);
        translateTransition.setDuration(Duration.seconds(1));
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(false);

        // Transition de rotation
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setNode(ballonView);
        rotateTransition.setByAngle(720);  // 2 tours complets
        rotateTransition.setDuration(Duration.seconds(0.1));
        rotateTransition.setCycleCount(8);
        rotateTransition.setAutoReverse(false);

        // Lancer les transitions
        translateTransition.play();
        rotateTransition.play();
    }

    public ImageView getBallonView() {
        return ballonView;
    }

    public Rectangle getCageRect() {
        return cageRect;
    }
}
