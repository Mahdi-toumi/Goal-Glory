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
    private ImageView scoreView;
    private double ballonStartX = 410;
    private double ballonStartY = 400;
    private double glovesStartX = 410;
    private double glovesStartY = 175;
    private Rectangle cageRectTR;
    private Rectangle cageRectTL;
    private Rectangle cageRectBR;
    private Rectangle cageRectBL;
    private Rectangle cageRectMU;
    private Rectangle cageRectMD;

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
        
        Image scoreImage = new Image(getClass().getResource("/images/Scoreboard.png").toExternalForm());
        
        if (this.jeu.getCoupe()!= null && this.jeu.getCoupe().getNom() == "Champions League" ){
            scoreImage = new Image(getClass().getResource("/images/Cscore.jpg").toExternalForm());
            scoreView = new ImageView(scoreImage);
            scoreView.setFitWidth(580);
            scoreView.setFitHeight(80);
            scoreView.setLayoutX(150);   // Initial x-position (centered below the ball)
            scoreView.setLayoutY(490);   // Initial y-position (adjust for layout)
        }
        if (this.jeu.getChampionnat()!= null && this.jeu.getChampionnat().getNom() == "Premier League" ){
            scoreImage = new Image(getClass().getResource("/images/PLscore.png").toExternalForm());
            scoreView = new ImageView(scoreImage);
            scoreView.setFitWidth(550);
            scoreView.setFitHeight(300);
            scoreView.setLayoutX(170);   // Initial x-position (centered below the ball)
            scoreView.setLayoutY(395);   // Initial y-position (adjust for layout)
        }
        if (this.jeu.getCoupe()!= null && this.jeu.getCoupe().getNom() == "World Cup" ){
            scoreImage = new Image(getClass().getResource("/images/WCScore.png").toExternalForm());
            scoreView = new ImageView(scoreImage);
            scoreView.setFitWidth(530);
            scoreView.setFitHeight(80);
            scoreView.setLayoutX(180);   // Initial x-position (centered below the ball)
            scoreView.setLayoutY(483);   // Initial y-position (adjust for layout)
        }
        if (this.jeu.getChampionnat()!= null && this.jeu.getChampionnat().getNom() == "La Liga" ){
            scoreImage = new Image(getClass().getResource("/images/LLScore.png").toExternalForm());
            scoreView = new ImageView(scoreImage);
            scoreView.setFitWidth(600);
            scoreView.setFitHeight(70);
            scoreView.setLayoutX(150);   // Initial x-position (centered below the ball)
            scoreView.setLayoutY(500);   // Initial y-position (adjust for layout)
        }
        
        
        
        
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
        this.cageRectTL = new Rectangle(216, 95, 140, 92);
        cageRectTL.setFill(Color.TRANSPARENT);
        // Pour le rectangle cageRectBL
        this.cageRectBL = new Rectangle(216, 180, 140, 92);
        cageRectBL.setFill(Color.TRANSPARENT);
        // Pour le rectangle cageRectTR
        this.cageRectTR = new Rectangle(503, 95, 140, 92);
        cageRectTR.setFill(Color.TRANSPARENT);
        // Pour le rectangle cageRectBR
        this.cageRectBR = new Rectangle(503, 180, 140, 92);
        cageRectBR.setFill(Color.TRANSPARENT);
        // Pour le rectangle cageRectM
        this.cageRectMU = new Rectangle(357, 95, 144, 86);
        cageRectMU.setFill(Color.TRANSPARENT);
        this.cageRectMD = new Rectangle(357, 182, 144, 88);
        cageRectMD.setFill(Color.TRANSPARENT);


        
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
        
        int fixedLength = 34; // Longueur totale pour "Team Alpha" et l'espace avant "0"
        int espaceavantnom2 = fixedLength  - equipe2.getAbr().length() ;
        


        


        /*// Formater le texte de chaque équipe
        String equipe1Formatted = "   0      "+equipe1.getAbr()  ;
        String equipe2Formatted = " ".repeat(espaceavantnom2) + equipe2.getAbr()+"      0   " ;



        // Créer le texte final
        String buttonText = equipe1Formatted + equipe2Formatted;*/

        // Appliquer le texte au bouton
        scoreBoardButton = new Button("");
        
        updateScoreBoard(0, 0);

        //scoreBoardButton = new Button(buttonText);
        scoreBoardButton.setFont(Font.font("Sports World", 20));
        scoreBoardButton.setTextFill(Color.WHITE);
        scoreBoardButton.setStyle(
            "-fx-background-color: transparent; " + // Football field gradient
            "-fx-border-color: transparent; " +                                // White border
            "-fx-border-width: 1px; " +                                   // Thick border
            "-fx-background-radius: 20; " +                               // Rounded corners
            "-fx-border-radius: 20; " +                                   // Match background radius
            "-fx-padding: 0 ; "   +                                        // Padding for better spacing
            "-fx-background-opacity: 0;"          
        );
        scoreBoardButton.setMaxWidth(500);  // Set button width
        scoreBoardButton.setMinWidth(500);  // Set button width
        scoreBoardButton.setPrefWidth(500);  // Set button width
        scoreBoardButton.setPrefHeight(200); // Set button height
        scoreBoardButton.setLayoutX(190);   // Center the button horizontally
        scoreBoardButton.setLayoutY(430);   // Position at the bottom of the screen
        scoreBoardButton.setFocusTraversable(false); // Remove focus highlight

        // Add all elements to the pane
        Pane = new Pane();
        Pane.getChildren().addAll(
        terrainView,
        cageRectTL,
        cageRectBL, 
        cageRectTR, 
        cageRectBR, 
        cageRectMU, cageRectMD,glovesView ,
        ballonView ,scoreView, scoreBoardButton, playerNameText, TournoiNameText,player, playerGIF
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
        
        for (int i=0 ; i<6 ; i++) {
            if (getCageRects()[i].contains(targetX, targetY)){
                targetX = getCageRectsMil()[i][0];
                targetY = getCageRectsMil()[i][1];
            }
        }
        
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
        
        for (int i=0 ; i<6 ; i++) {
            if (getCageRects()[i].contains(targetX, targetY)){
                targetX = getCageRectsMil()[i][0];
                targetY = getCageRectsMil()[i][1];
            }
        }
        
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
        
        int fixedLength = 34; // Longueur totale pour "Team Alpha" et l'espace avant "0"
        int espaceavantnom2 = fixedLength -  equipe2.getAbr().length() ;

        // Formater le texte de chaque équipe
        String equipe1Formatted = "   "+equipe1.getAbr()+"    " +playerScore ;
        String equipe2Formatted = " ".repeat(espaceavantnom2)+aiScore+"    " + equipe2.getAbr()+"   " ;

        // Créer le texte final
        String buttonText = equipe1Formatted + equipe2Formatted;        
        scoreBoardButton.setText( buttonText);
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
    return new Rectangle[]{cageRectTL,  cageRectBL, cageRectTR, cageRectBR,
                           cageRectMU, cageRectMD}; 
    }
    
    public double[][] getCageRectsMil() {
    
    
        double[] topLeftCenter = new double[]{216 + 110 / 2.0, 95 + 77 / 2.0}; // cageRectTL1 center
        double[] bottomLeftCenter = new double[]{216 + 110 / 2.0, 180 + 77 / 2.0}; // cageRectBL1 center
        double[] topRightCenter = new double[]{503 + 110 / 2.0, 95 + 77 / 2.0}; // cageRectTR1 center
        double[] bottomRightCenter = new double[]{503 + 110 / 2.0, 180 + 77 / 2.0}; // cageRectBR1 center
        double[] middle1Center = new double[]{357 + 114 / 2.0, 95 + 71 / 2.0}; // cageRectM1 center
        double[] middle2Center = new double[]{357 + 114 / 2.0, 182 + 73 / 2.0}; // cageRectM2 center
        
        return new double[][]{topLeftCenter,  bottomLeftCenter, topRightCenter, bottomRightCenter,
                           middle1Center, middle2Center}; 
    }
    
    public void refereeWhistle(){
        String refereeWhistle = getClass().getResource("/audio/whistle.mp3").toExternalForm();
        MediaPlayer whistle = new MediaPlayer(new Media(refereeWhistle));
        whistle.setVolume(0.4);
        whistle.play(); 
    }
    
}
