package view;

import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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
    private Rectangle cageRectTR1;
    private Rectangle cageRectTR2;
    private Rectangle cageRectTR3;
    private Rectangle cageRectTR4;
    private Rectangle cageRectTL1;
    private Rectangle cageRectTL2;
    private Rectangle cageRectTL3;
    private Rectangle cageRectTL4;
    private Rectangle cageRectBR1;
    private Rectangle cageRectBR2;
    private Rectangle cageRectBR3;
    private Rectangle cageRectBR4;
    private Rectangle cageRectBL1;
    private Rectangle cageRectBL2;
    private Rectangle cageRectBL3;
    private Rectangle cageRectBL4;
    private Rectangle cageRectM1;
    private Rectangle cageRectM2;
    private Rectangle cageRectM3;
    private Rectangle cageRectM4;
    private Button scoreBoardButton;
    private Jeu jeu ;
    private Text playerNameText;
    private Text TournoiNameText ;
    private ImageView player;
    private ImageView playerGIF;
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
        
        Image shootingImage = new Image(getClass().getResource("/images/playerFirstFrame.png").toExternalForm());
        player = new ImageView(shootingImage);
    
        // Set the size and initial position for the GIF
        player.setFitWidth(178);  // Adjust width as needed
        player.setFitHeight(199); // Adjust height as needed
        player.setLayoutX(217);   // Initial x-position (centered below the ball)
        player.setLayoutY(270);   // Initial y-position (adjust for layout)
        
        Image shootingGIF = new Image(getClass().getResource("/images/Tir.gif").toExternalForm());
        playerGIF = new ImageView(shootingGIF);
    
        // Set the size and initial position for the GIF
        playerGIF.setFitWidth(200);  // Adjust width as needed
        playerGIF.setFitHeight(200); // Adjust height as needed
        playerGIF.setLayoutX(220);   // Initial x-position (centered below the ball)
        playerGIF.setLayoutY(255);   // Initial y-position (adjust for layout)
        
        playerGIF.setVisible(false);
        
               
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


        // Pour le rectangle cageRectTL
        this.cageRectTL1 = new Rectangle(216, 95, 70, 46);
        cageRectTL1.setFill(Color.TRANSPARENT);
        this.cageRectTL2 = new Rectangle(286, 95, 70, 46);
        cageRectTL2.setFill(Color.TRANSPARENT);
        this.cageRectTL3 = new Rectangle(216, 141, 70, 46);
        cageRectTL3.setFill(Color.TRANSPARENT);
        this.cageRectTL4 = new Rectangle(286, 141, 70, 46);
        cageRectTL4.setFill(Color.TRANSPARENT);

        // Pour le rectangle cageRectBL
        this.cageRectBL1 = new Rectangle(216, 180, 70, 46);
        cageRectBL1.setFill(Color.TRANSPARENT);
        this.cageRectBL2 = new Rectangle(286, 180, 70, 46);
        cageRectBL2.setFill(Color.TRANSPARENT);
        this.cageRectBL3 = new Rectangle(216, 226, 70, 46);
        cageRectBL3.setFill(Color.TRANSPARENT);
        this.cageRectBL4 = new Rectangle(286, 226, 70, 46);
        cageRectBL4.setFill(Color.TRANSPARENT);

        // Pour le rectangle cageRectTR
        this.cageRectTR1 = new Rectangle(503, 95, 70, 46);
        cageRectTR1.setFill(Color.TRANSPARENT);
        this.cageRectTR2 = new Rectangle(573, 95, 70, 46);
        cageRectTR2.setFill(Color.TRANSPARENT);
        this.cageRectTR3 = new Rectangle(503, 141, 70, 46);
        cageRectTR3.setFill(Color.TRANSPARENT);
        this.cageRectTR4 = new Rectangle(573, 141, 70, 46);
        cageRectTR4.setFill(Color.TRANSPARENT);

        // Pour le rectangle cageRectBR
        this.cageRectBR1 = new Rectangle(503, 180, 70, 46);
        cageRectBR1.setFill(Color.TRANSPARENT);
        this.cageRectBR2 = new Rectangle(573, 180, 70, 46);
        cageRectBR2.setFill(Color.TRANSPARENT);
        this.cageRectBR3 = new Rectangle(503, 226, 70, 46);
        cageRectBR3.setFill(Color.TRANSPARENT);
        this.cageRectBR4 = new Rectangle(573, 226, 70, 46);
        cageRectBR4.setFill(Color.TRANSPARENT);

        // Pour le rectangle cageRectM
        
        this.cageRectM1 = new Rectangle(357, 95, 75, 90);
        cageRectM1.setFill(Color.TRANSPARENT);
        this.cageRectM2 = new Rectangle(430, 95, 72, 90);
        cageRectM2.setFill(Color.TRANSPARENT);
        this.cageRectM3 = new Rectangle(357, 185, 75, 90);
        cageRectM3.setFill(Color.TRANSPARENT);
        this.cageRectM4 = new Rectangle(430, 185, 72, 90);
        cageRectM4.setFill(Color.TRANSPARENT);

        
        // Player's name and score in the top-left corner
        
        playerNameText = new Text("   "+this.jeu.getPlayer().getNom() + " -   Score: " + this.jeu.getPlayer().getScore());
        playerNameText.setFont(Font.font("Sports World", 24));
        playerNameText.setFill(Color.WHITE);
        playerNameText.setLayoutX(10);
        playerNameText.setLayoutY(60);  // Slightly below the score
        
         // Player's name and score in the top-left corner
        if (jeu.getChampionnat()!=null){
            TournoiNameText = new Text("   "+this.jeu.getChampionnat().getNom());
            TournoiNameText.setFont(Font.font("Sports World", 24));
            TournoiNameText.setFill(Color.WHITE);
            TournoiNameText.setLayoutX(550);
            TournoiNameText.setLayoutY(60);  // Slightly below the score

            // Initialize scoreboard button
            for (Match match : this.jeu.getChampionnat().getTours().get(this.jeu.getTour()+1).getMatchs()) {
                if (match.getEquipe1().getNom()==this.jeu.getPlayer().getEquipe().getNom()){

                    this.equipe1  = match.getEquipe1();
                    this.equipe2 = match.getEquipe2();
                }
                else if ( match.getEquipe2().getNom()==this.jeu.getPlayer().getEquipe().getNom()){
                    this.equipe1  = match.getEquipe2();
                    this.equipe2 = match.getEquipe1();
                }
             
            }   
        }
        else if (jeu.getCoupe()!=null){
            TournoiNameText = new Text("   "+this.jeu.getCoupe().getNom());
            TournoiNameText.setFont(Font.font("Sports World", 24));
            TournoiNameText.setFill(Color.WHITE);
            TournoiNameText.setLayoutX(550);
            TournoiNameText.setLayoutY(60);  // Slightly below the score

            // Initialize scoreboard button
            for (Match match : this.jeu.getCoupe().getTours().get(this.jeu.getTour()).getMatchs()) {
                if (match.getEquipe1().getNom()==this.jeu.getPlayer().getEquipe().getNom()){

                    this.equipe1  = match.getEquipe1();
                    this.equipe2 = match.getEquipe2();
                }
                else if ( match.getEquipe2().getNom()==this.jeu.getPlayer().getEquipe().getNom()){
                    this.equipe1  = match.getEquipe2();
                    this.equipe2 = match.getEquipe1();
                }
             
            }   
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
        Pane.getChildren().addAll(
        terrainView,
        cageRectTL1, cageRectTL2, cageRectTL3, cageRectTL4,
        cageRectBL1, cageRectBL2, cageRectBL3, cageRectBL4,
        cageRectTR1, cageRectTR2, cageRectTR3, cageRectTR4,
        cageRectBR1, cageRectBR2, cageRectBR3, cageRectBR4,
        cageRectM1, cageRectM2, cageRectM3, cageRectM4,
        ballonView, glovesView, scoreBoardButton, playerNameText, TournoiNameText,player, playerGIF
        );

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
    
    public void resetPlayerPosition(){
       
        player.setVisible(true);
        playerGIF.setVisible(false);        
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
    
    public void animation(double targetX, double targetY, double saveX, double saveY){
        startPlayerAnimation();
        PauseTransition pause = new PauseTransition(Duration.seconds(1.35));
        pause.setOnFinished(e -> {
            stopPlayerAnimation();
            animateBallToPosition( targetX,  targetY);
            animateGlovesToPosition( saveX, saveY);
        });
        pause.play();

        
    }
    
    public void resetPlayerGIF() {
        // Reload the GIF to reset its animation
        Image shootingGIF = new Image(getClass().getResource("/images/Tir.gif").toExternalForm());
        playerGIF.setImage(shootingGIF);
        playerGIF.setVisible(true);
    }

    public void startPlayerAnimation() {
        player.setVisible(false);
        resetPlayerGIF(); 
    }
    
    
    public void stopPlayerAnimation() {
        playerGIF.setVisible(false); 
        player.setVisible(true); 
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
    return new Rectangle[]{cageRectTL1, cageRectTL2, cageRectTL3, cageRectTL4,
                           cageRectBL1, cageRectBL2, cageRectBL3, cageRectBL4,
                           cageRectTR1, cageRectTR2, cageRectTR3, cageRectTR4,
                           cageRectBR1, cageRectBR2, cageRectBR3, cageRectBR4,
                           cageRectM1, cageRectM2, cageRectM3, cageRectM4}; 
    }
    
    public void refereeWhistle(){
        String refereeWhistle = getClass().getResource("/audio/whistle.mp3").toExternalForm();
        MediaPlayer whistle = new MediaPlayer(new Media(refereeWhistle));
        whistle.setVolume(0.4);
        whistle.play(); 
    }
    
}
