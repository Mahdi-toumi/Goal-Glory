package view;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import model.elements.Equipe;
import model.structure.Jeu;
import model.structure.Match;

public class GameView {

    private ImageView terrainView;
    private ImageView ballonView;
    private ImageView glovesView;
    private double ballonStartX = 410;
    private double ballonStartY = 400;
    private double glovesStartX = 410;
    private double glovesStartY = 175;
    private Rectangle cageRectTR;
    private Rectangle cageRectTL;
    private Rectangle cageRectBR;
    private Rectangle cageRectBL;
    private Rectangle cageRectM;
    private Button scoreBoardButton;
    private Jeu jeu ;
    private Text playerNameText;
    private Text TournoiNameText ;
    Equipe equipe1 ;
    Equipe equipe2 ;
    

    private Scene scene;
    private Pane Pane;

    // Scoreboard Text
    private Text scoreBoard;

    public GameView(Jeu jeu) {
        this.jeu = jeu ;
        // Load images
        Image terrainImage = new Image(getClass().getResource("/images/backgroud_penalty.png").toExternalForm());
        Image ballonImage = new Image(getClass().getResource("/images/ballon.png").toExternalForm());
        Image glovesImage = new Image(getClass().getResource("/images/gloves.png").toExternalForm());

        // Initialize terrain image
        terrainView = new ImageView(terrainImage);
        terrainView.setFitWidth(900);
        terrainView.setFitHeight(600);

        // Initialize ball image
        ballonView = new ImageView(ballonImage);
        ballonView.setFitWidth(27);
        ballonView.setFitHeight(27);
        
        // Initialize gloves image
        glovesView = new ImageView(glovesImage);
        glovesView.setFitWidth(37);
        glovesView.setFitHeight(37);

        // Initialize goal rectangles
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
        
        // Player's name and score in the top-left corner
        
        playerNameText = new Text("   "+this.jeu.getPlayer().getNom() + " -   Score: " + this.jeu.getPlayer().getScore());
        playerNameText.setFont(Font.font("Sports World", 24));
        playerNameText.setFill(Color.WHITE);
        playerNameText.setLayoutX(10);
        playerNameText.setLayoutY(60);  // Slightly below the score
        
         // Player's name and score in the top-left corner
        
        TournoiNameText = new Text("   "+this.jeu.getChampionnat().getNom());
        TournoiNameText.setFont(Font.font("Sports World", 24));
        TournoiNameText.setFill(Color.WHITE);
        TournoiNameText.setLayoutX(550);
        TournoiNameText.setLayoutY(60);  // Slightly below the score

        
        
        
        // Initialize scoreboard button
        for (Match match : this.jeu.getChampionnat().getTours().get(this.jeu.getTour()+1).getMatchs()) {
             if (match.getEquipe1().getNom()==this.jeu.getPlayer().getEquipe().getNom() || match.getEquipe2().getNom()==this.jeu.getPlayer().getEquipe().getNom()){

                     this.equipe1  = match.getEquipe1();
                     this.equipe2 = match.getEquipe2();}
             
        }
        

        scoreBoardButton = new Button(equipe1.getNom() + "    0 | 0    " + equipe2.getNom());
        scoreBoardButton.setFont(Font.font("Sports World", 20));
        scoreBoardButton.setTextFill(Color.WHITE);
        scoreBoardButton.setStyle(
            "-fx-background-color: linear-gradient(#4caf50, #087f23); " + // Football field gradient
            "-fx-border-color: #ffffff; " +                                // White border
            "-fx-border-width: 3px; " +                                   // Thick border
            "-fx-background-radius: 20; " +                               // Rounded corners
            "-fx-border-radius: 20; " +                                   // Match background radius
            "-fx-padding: 10; "   +                                        // Padding for better spacing
            "-fx-background-opacity: 0.5;"          
        );
        scoreBoardButton.setPrefWidth(450);  // Set button width
        scoreBoardButton.setPrefHeight(60); // Set button height
        scoreBoardButton.setLayoutX(225);   // Center the button horizontally
        scoreBoardButton.setLayoutY(530);   // Position at the bottom of the screen
        scoreBoardButton.setFocusTraversable(false); // Remove focus highlight

        // Add all elements to the pane
        Pane = new Pane();
        Pane.getChildren().addAll(terrainView, cageRectTL, cageRectBL, cageRectTR, cageRectBR, cageRectM, ballonView, glovesView, scoreBoardButton, playerNameText,TournoiNameText);

        // Set scene
        scene = new Scene(Pane, 900, 600);

        // Reset positions
        resetBallPosition();
        resetGlovesPosition();
    }

    public void resetBallPosition() {
        ballonView.setLayoutX(410);
        ballonView.setLayoutY(400);
        ballonView.setTranslateX(0);
        ballonView.setTranslateY(0);
    }
    
    public void resetGlovesPosition() {
        glovesView.setLayoutX(410);
        glovesView.setLayoutY(175);
        glovesView.setTranslateX(0);
        glovesView.setTranslateY(0);
    }

    public void animateBallToPosition(double targetX, double targetY) {
        // Calculate movement
        double deltaX = targetX - ballonView.getLayoutX();
        double deltaY = targetY - ballonView.getLayoutY();

        // Translate transition for the ball
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(ballonView);
        translateTransition.setByX(deltaX);
        translateTransition.setByY(deltaY);
        translateTransition.setDuration(Duration.seconds(1));
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(false);

        // Rotate transition for the ball
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setNode(ballonView);
        rotateTransition.setByAngle(720);  // 2 full spins
        rotateTransition.setDuration(Duration.seconds(0.1));
        rotateTransition.setCycleCount(8);
        rotateTransition.setAutoReverse(false);

        // Play transitions
        translateTransition.play();
        rotateTransition.play();
    }
    
    public void animateGlovesToPosition(double targetX, double targetY) {
        // Calculate movement
        double deltaX = targetX - glovesView.getLayoutX();
        double deltaY = targetY - glovesView.getLayoutY();

        // Translate transition for the gloves
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(glovesView);
        translateTransition.setByX(deltaX);
        translateTransition.setByY(deltaY);
        translateTransition.setDuration(Duration.seconds(0.5));
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(false);

        // Play transition
        translateTransition.play();
    }

    // Method to update the scoreboard
    public void updateScoreBoard(int playerScore, int aiScore) {
        scoreBoardButton.setText( equipe1.getNom()+ "   " + playerScore + "    |    " + aiScore + "   "+ equipe2.getNom());
        playerNameText.setText("   "+this.jeu.getPlayer().getNom() + " -   Score: " + this.jeu.getPlayer().getScore()); // Update player's name and score
    }

    public ImageView getBallonView() {
        return ballonView;
    }

    public void setBallonXY(double X, double Y){
        this.ballonStartX = X;
        this.ballonStartY = Y;
    }
    
    public double getBallonX() {
        return this.ballonStartX;
    }
    
    public double getBallonY() {
        return this.ballonStartY;
    }
    
    public ImageView getGlovesView() {
        return glovesView;
    }

    public void setGlovesXY(double X, double Y) {
        this.glovesStartX = X;
        this.glovesStartY = Y;
    }
    
    public double getGlovesX() {
        return this.glovesStartX;
    }
    
    public double getGlovesY() {
        return this.glovesStartY;
    }
    
    public Scene getScene() {
        return scene;
    }
    
    public Pane getPane() {
        return Pane;
    }
    
    public Rectangle[] getCageRects() {
        return new Rectangle[]{cageRectTL, cageRectBL, cageRectTR, cageRectBR, cageRectM};
    }
    
    
}
