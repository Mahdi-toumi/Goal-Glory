package view;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class GameView {

    private ImageView terrainView;
    private ImageView ballonView;
    private double ballonStartX = 425;
    private double ballonStartY = 400;
    private Rectangle cageRectTR;
    private Rectangle cageRectTL;
    private Rectangle cageRectBR;
    private Rectangle cageRectBL;
    private Rectangle cageRectM;
    private Rectangle test;
    private Scene scene;
    private Pane Pane;

    public GameView() {
        // Charger les images
        Image terrainImage = new Image(getClass().getResource("/images/backgroud_penalty.png").toExternalForm());
        Image ballonImage = new Image(getClass().getResource("/images/ballon.png").toExternalForm());

        // Initialiser l'image du terrain
        terrainView = new ImageView(terrainImage);
        terrainView.setFitWidth(900);
        terrainView.setFitHeight(600);

        // Initialiser l'image du ballon
        ballonView = new ImageView(ballonImage);
        ballonView.setFitWidth(27);
        ballonView.setFitHeight(27);

        // Initialiser le rectangle pour la cage
        cageRectTL =  new Rectangle(216,95,140,92);
        cageRectTL.setFill(Color.RED);
        cageRectTL.setStroke(Color.RED);
        cageRectTL.setStrokeWidth(2);
        
        cageRectBL =  new Rectangle(216,180,140,92);
        cageRectBL.setFill(Color.BLUE);
        cageRectBL.setStroke(Color.BLUE);
        cageRectBL.setStrokeWidth(2);
        
        cageRectTR =  new Rectangle(503,95,140,92);
        cageRectTR.setFill(Color.BLUE);
        cageRectTR.setStroke(Color.BLUE);
        cageRectTR.setStrokeWidth(2);
        
        cageRectBR =  new Rectangle(503,180,140,92);
        cageRectBR.setFill(Color.RED);
        cageRectBR.setStroke(Color.RED);
        cageRectBR.setStrokeWidth(2);
        
        cageRectM =  new Rectangle(360,95,140,180);
        cageRectM.setFill(Color.WHITE);
        cageRectM.setStroke(Color.WHITE);
        cageRectM.setStrokeWidth(2);

        // Ajouter les éléments à la scène
        Pane = new Pane();
        Pane.getChildren().addAll(terrainView, cageRectTL,cageRectBL,cageRectTR,cageRectBR,cageRectM, ballonView);

        scene = new Scene(Pane, 900, 600);
        // Réinitialiser la position du ballon
        resetBallPosition();

        // Gérer l'événement de clic sur le terrain
        Pane.setOnMouseClicked(event -> {
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

    
    public void setBallonXY(double X, double Y){
        this.ballonStartX=X;
        this.ballonStartY=Y;
    }
    
    public double getBallonX(){
        return this.ballonStartX;
    }
    
    public double getBallonY(){
        return this.ballonStartY;
    }
    
    public Scene getScene(){
        return scene;
    }
    
    public Pane getPane(){
        return Pane;
    }
}
