package controller;

import javafx.animation.PauseTransition;
import javafx.util.Duration;
import view.GameView;
import model.structure.Jeu;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.elements.Equipe;
import model.structure.Match;
import model.structure.Player;
import model.structure.exceptions.AjoutTourException;
import view.BracketView;
import view.ChampionsView;
import view.EliminatedView;
import view.RankingView;

public class GameController {

    private GameView gameView;
    private Jeu jeu;
    private boolean isPlayerTurn = true; // Start with the player's turn
    private int playerScore = 0;
    private int aiScore = 0;
    private int maxRounds = 5; // Maximum penalty rounds per side
    private int currentRound = 1; // Current round
    private boolean suddenDeath = false; // Sudden death indicator


    public GameController(GameView gameView, Jeu jeu) {
        this.gameView = gameView;
        this.jeu = jeu;
        setupPlayerControls();
    }

    private void setupPlayerControls() {
        gameView.refereeWhistle();
        Text TurnText = new Text() ;
        TurnText.setText("");
        
            TurnText.setFill(Color.WHITE);
            TurnText.setLayoutX(250); // Center the text horizontally
            TurnText.setLayoutY(200); // Position it vertically
                TurnText.setFont(Font.font("Sports World", 30));
                TurnText.setStyle(
                    "-fx-fill: linear-gradient(from 0% 0% to 100% 100%, #00FF00, #008000);" +  // Dégradé vert clair à vert foncé
                    "-fx-stroke: black;" +                                                   // Contour noir
                    "-fx-stroke-width: 2px;" +                                               // Épaisseur du contour
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 10, 0.5, 0, 4);"   // Ombre portée pour le texte
                );
                gameView.getPane().getChildren().add(TurnText);
          PauseTransition pause1 = new PauseTransition(Duration.seconds(1.4));
        pause1.setOnFinished(e->{
            TurnText.setText("Your Turn to Shoot!");
        });
         pause1.play();
         
          PauseTransition pause3 = new PauseTransition(Duration.seconds(3));
        pause3.setOnFinished(e->{
            TurnText.setText("");
        });
         pause3.play();
                
        gameView.getPane().setOnMouseClicked(event -> {
            if (isPlayerTurn) {
                double clickX = event.getX();
                double clickY = event.getY();
                handlePlayerTurn(clickX, clickY);
            }
        });
    }

    private void handlePlayerTurn(double clickX, double clickY) {
        System.out.println("Your Turn to Shoot!");
        
         
        
        // Animate the ball to the target position
        //gameView.animateBallToPosition(clickX, clickY);

        // AI Goalkeeper random position
        double[] aiGlovesPosition = randomGoalkeeperPosition();
        //gameView.animateGlovesToPosition(aiGlovesPosition[0], aiGlovesPosition[1]);

        
        
        
        

        gameView.animation(clickX,clickY,aiGlovesPosition[0], aiGlovesPosition[1]);
        
        PauseTransition pause = new PauseTransition(Duration.seconds(2.7));
        pause.setOnFinished(e -> {
            boolean isSaved = checkIfSaved(new double[]{clickX, clickY}, aiGlovesPosition);

            if (isSaved) {
                
                
                String sound = getClass().getResource("/audio/NGoal.mp3").toExternalForm();
                MediaPlayer Sound = new MediaPlayer(new Media(sound));
                Sound.stop();
                Sound.seek(Duration.ZERO); 
                Sound.play(); 
                
                System.out.println("AI saved your shot!");
                Text TurnText = new Text() ;
                TurnText.setText("Saved!");

                    TurnText.setFill(Color.WHITE);
                    TurnText.setLayoutX(300); // Center the text horizontally
                    TurnText.setLayoutY(290); // Position it vertically
                        TurnText.setFont(Font.font("Sports World", 90));
                        TurnText.setStyle(
                            "-fx-fill: red;" +  // Dégradé vert clair à vert foncé
                            "-fx-stroke: black;" +                                                   // Contour noir
                            "-fx-stroke-width: 2px;" +                                               // Épaisseur du contour
                            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 10, 0.5, 0, 4);"   // Ombre portée pour le texte
                        );
                        gameView.getPane().getChildren().add(TurnText);
                  PauseTransition pause1 = new PauseTransition(Duration.seconds(1.2));
                pause1.setOnFinished(f->{
                    TurnText.setText("");
                });
                 pause1.play();
            } else {
                System.out.println("You scored!");
                String sound = getClass().getResource("/audio/Goal.mp3").toExternalForm();
                MediaPlayer Sound = new MediaPlayer(new Media(sound));
                Sound.stop();
                Sound.seek(Duration.ZERO);                
                Sound.play(); 
                Text TurnText = new Text() ;
                TurnText.setText("Goal!");

                    TurnText.setFill(Color.WHITE);
                    TurnText.setLayoutX(300); // Center the text horizontally
                    TurnText.setLayoutY(290); // Position it vertically
                        TurnText.setFont(Font.font("Sports World", 90));
                        TurnText.setStyle(
                            "-fx-fill: green;" +  // Dégradé vert clair à vert foncé
                            "-fx-stroke: black;" +                                                   // Contour noir
                            "-fx-stroke-width: 2px;" +                                               // Épaisseur du contour
                            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 10, 0.5, 0, 4);"   // Ombre portée pour le texte
                        );
                        gameView.getPane().getChildren().add(TurnText);
                  PauseTransition pause1 = new PauseTransition(Duration.seconds(1.2));
                pause1.setOnFinished(f->{
                    TurnText.setText("");
                });
                 pause1.play();
                 
                this.jeu.getPlayer().setScore(this.jeu.getPlayer().getScore()+10);
                playerScore++;
                gameView.updateScoreBoard(playerScore, aiScore);
            }

            resetPositions();
            isPlayerTurn = false;
            handleAITurn();
        });
        pause.play();
    }

    private void handleAITurn() {
        gameView.refereeWhistle();
        System.out.println("AI's Turn!");

        resetPositions();

        double[] aiShotTarget = randomShotPosition();
        System.out.println("");
        Text TurnText = new Text() ;
        TurnText.setLayoutX(250); // Center the text horizontally
        TurnText.setLayoutY(200); // Position it vertically
        TurnText.setText("");
                TurnText.setFont(Font.font("Sports World", 30));
                TurnText.setStyle(
                    "-fx-fill: linear-gradient(from 0% 0% to 100% 100%, #00FF00, #008000);" +  // Dégradé vert clair à vert foncé
                    "-fx-stroke: black;" +                                                   // Contour noir
                    "-fx-stroke-width: 2px;" +                                               // Épaisseur du contour
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 10, 0.5, 0, 4);"   // Ombre portée pour le texte
                );
         gameView.getPane().getChildren().add(TurnText);
          PauseTransition pause1 = new PauseTransition(Duration.seconds(1.4));
        pause1.setOnFinished(e->{
            TurnText.setText("Your Turn to save!");
        });
         pause1.play();
         
          PauseTransition pause3 = new PauseTransition(Duration.seconds(3));
        pause3.setOnFinished(e->{
            TurnText.setText("");
        });
         pause3.play();

        Pane gamePane = gameView.getPane();
        gamePane.setOnMouseClicked(event -> {
            double playerGlovesX = event.getX();
            double playerGlovesY = event.getY();

            //gameView.animateGlovesToPosition(playerGlovesX, playerGlovesY);
            //gameView.animateBallToPosition(aiShotTarget[0], aiShotTarget[1]);
            gameView.animation(aiShotTarget[0], aiShotTarget[1],playerGlovesX, playerGlovesY);

            PauseTransition pause = new PauseTransition(Duration.seconds(2.7));
            pause.setOnFinished(e -> {
                boolean isSaved = checkIfSaved(aiShotTarget, new double[]{playerGlovesX, playerGlovesY});

                if (isSaved) {
                    System.out.println("You saved the shot!");
                    String sound = getClass().getResource("/audio/Goal.mp3").toExternalForm();
                MediaPlayer Sound = new MediaPlayer(new Media(sound));
                Sound.stop();
                Sound.seek(Duration.ZERO);
                Sound.play(); 
                    Text TurnTextAI = new Text() ;
                    TurnTextAI.setLayoutX(300); // Center the text horizontally
                    TurnTextAI.setLayoutY(290); // Position it vertically
                    TurnTextAI.setText("Saved!");
                            TurnTextAI.setFont(Font.font("Sports World", 90));
                            TurnTextAI.setStyle(
                                "-fx-fill: linear-gradient(from 0% 0% to 100% 100%, #00FF00, #008000);" +  // Dégradé vert clair à vert foncé
                                "-fx-stroke: black;" +                                                   // Contour noir
                                "-fx-stroke-width: 2px;" +                                               // Épaisseur du contour
                                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 10, 0.5, 0, 4);"   // Ombre portée pour le texte
                            );
                     gameView.getPane().getChildren().add(TurnTextAI);
                    PauseTransition pause2 = new PauseTransition(Duration.seconds(1.2));
                    pause2.setOnFinished(s->{
                        TurnTextAI.setText("");
                    });
                    pause2.play();
                    
                    this.jeu.getPlayer().setScore(this.jeu.getPlayer().getScore()+15);
                    
                } else {
                    System.out.println("AI scored!");
                    String sound = getClass().getResource("/audio/NGoal.mp3").toExternalForm();
                    MediaPlayer Sound = new MediaPlayer(new Media(sound));
                    Sound.stop();
                    Sound.seek(Duration.ZERO);
                    Sound.play(); 
                    Text TurnTextAI = new Text() ;
                    TurnTextAI.setText("Goal!");
                    TurnTextAI.setLayoutX(300); // Center the text horizontally
                    TurnTextAI.setLayoutY(290); // Position it vertically
                    
                            TurnTextAI.setFont(Font.font("Sports World", 90));
                            TurnTextAI.setStyle(
                                "-fx-fill: red;" +  // Dégradé vert clair à vert foncé
                                "-fx-stroke: black;" +                                                   // Contour noir
                                "-fx-stroke-width: 2px;" +                                               // Épaisseur du contour
                                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 10, 0.5, 0, 4);"   // Ombre portée pour le texte
                            );
                     gameView.getPane().getChildren().add(TurnTextAI);
                    PauseTransition pause2 = new PauseTransition(Duration.seconds(1.2));
                    pause2.setOnFinished(s->{
                        TurnTextAI.setText("");
                    });
                    pause2.play();
                    
                    aiScore++;
                    gameView.updateScoreBoard(playerScore, aiScore);
                }

                resetPositions();

                if (checkGameOver()) {
                    displayGameOver();
                } else {
                    isPlayerTurn = true;
                    System.out.println("Next Round: Player's Turn!");
                    currentRound++;
                    setupPlayerControls();
                }
            });
            pause.play();
            gamePane.setOnMouseClicked(null); // Clear click handler for AI's turn
        });
    }

    private void resetPositions() {
        gameView.resetBallPosition();
        gameView.resetGlovesPosition();
        gameView.resetPlayerPosition();
    }
    

    
    
    //Hedi Te5demem jawha behi
    public boolean checkIfSaved(double[] ballTarget, double[] glovesTarget) { 
        // Iterate through all cage rectangles
        Rectangle rectangle1 = this.gameView.getCageRects()[0];
        Rectangle rectangle2 = this.gameView.getCageRects()[1];
        Rectangle rectangle3 = this.gameView.getCageRects()[2];
        Rectangle rectangle4 = this.gameView.getCageRects()[3];
        Rectangle rectangle5 = this.gameView.getCageRects()[4];
        Rectangle rectangle6 = this.gameView.getCageRects()[5];
       
        
        
        boolean isBallInRectangle1 = rectangle1.contains(ballTarget[0], ballTarget[1]);
        boolean isBallInRectangle2 = rectangle2.contains(ballTarget[0], ballTarget[1]);
        boolean isBallInRectangle3 = rectangle3.contains(ballTarget[0], ballTarget[1]);
        boolean isBallInRectangle4 = rectangle4.contains(ballTarget[0], ballTarget[1]);
        boolean isBallInRectangle5 = rectangle5.contains(ballTarget[0], ballTarget[1]);
        boolean isBallInRectangle6 = rectangle6.contains(ballTarget[0], ballTarget[1]);
      
        
 
            // If the ball is not in any rectangle, return true
            if (!isBallInRectangle1 && !isBallInRectangle2 && !isBallInRectangle3 && !isBallInRectangle4 && !isBallInRectangle5 &&
                !isBallInRectangle6 ) {
                return true; // If the ball is not in any rectangle, it's a save
            }
            
            else {
                for (int i = 0; i < 6; i++) {
                     Rectangle rectangle = this.gameView.getCageRects()[i]; // Get the current rectangle

                    // Check if both the ball and gloves are in the same rectangle
                    boolean isBallInRectangle = rectangle.contains(ballTarget[0], ballTarget[1]);
                    boolean isGlovesInRectangle = rectangle.contains(glovesTarget[0], glovesTarget[1]);

                    // If both are in the same rectangle, return true
                    if (isBallInRectangle && isGlovesInRectangle) {
                        return true;
                    }
                }
                // If no rectangles match, return false
                return false;
                
            }
    }

    
    

    private double[] randomGoalkeeperPosition() {
        Random random = new Random();
        int choice = random.nextInt(6);
            // Calculate the centers of each rectangle
        double[] topLeftCenter = new double[]{216 + 115 / 2.0, 95 + 82 / 2.0}; // cageRectTL1 center
        double[] bottomLeftCenter = new double[]{216 + 115 / 2.0, 180 + 82 / 2.0}; // cageRectBL1 center
        double[] topRightCenter = new double[]{503 + 115 / 2.0, 95 + 82 / 2.0}; // cageRectTR1 center
        double[] bottomRightCenter = new double[]{503 + 115 / 2.0, 180 + 82 / 2.0}; // cageRectBR1 center
        double[] middle1Center = new double[]{357 + 119 / 2.0, 95 + 76 / 2.0}; // cageRectM1 center
        double[] middle2Center = new double[]{357 + 119 / 2.0, 182 + 78 / 2.0}; // cageRectM2 center


        switch (choice) {
            case 0: return topLeftCenter; // Top left
            case 1: return bottomLeftCenter; // Bottom right
            case 2: return topRightCenter; // Bottom right
            case 3: return bottomRightCenter; // Bottom right
            case 4: return middle1Center; // Bottom right
            case 5: return middle2Center; // Bottom right

            
            default: return new double[]{410, 140}; // Middle
        }
    }

    private double[] randomShotPosition() {
        return randomGoalkeeperPosition();
    }

    
    
    private boolean checkGameOver() {
        // If we're in the normal rounds
        if (!suddenDeath) {
            // Check if the max rounds have been completed
            if (currentRound >= maxRounds) {
                // If scores are not tied, the game is over
                if (playerScore != aiScore) {
                    return true;
                }
                // Trigger sudden death if scores are tied
                suddenDeath = true;
            }
        } else {
            // In sudden death, the game ends as soon as one player scores and the other doesn't
            if (Math.abs(playerScore - aiScore) > 0) {
                return true;
            }
        }

        // Game continues
        return false;
    }


    private void displayGameOver() {
        if (this.jeu.getChampionnat()!= null){
            System.out.println("Game Over!");
            Text gameOverText = new Text();
            gameOverText.setFont(Font.font("Sports World", 30));
            gameOverText.setFill(Color.WHITE);
            gameOverText.setLayoutX(270); // Center the text horizontally
            gameOverText.setLayoutY(200); // Position it vertically

            if (playerScore > aiScore) {
                this.jeu.getChampionnat().AjoutPointsEquipe(3, this.jeu.getPlayer().getEquipe()); // bech yetzedoulek el poinet 
                System.out.println("You win! Final Score: " + playerScore + " - " + aiScore);
                gameOverText.setText("You Win!");
                gameOverText.setFont(Font.font("Sports World", 60));
                gameOverText.setStyle(
                    "-fx-fill: linear-gradient(from 0% 0% to 100% 100%, #00FF00, #008000);" +  // Dégradé vert clair à vert foncé
                    "-fx-stroke: black;" +                                                   // Contour noir
                    "-fx-stroke-width: 2px;" +                                               // Épaisseur du contour
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 10, 0.5, 0, 4);"   // Ombre portée pour le texte
                );

            } else {
                for( Match match : this.jeu.getChampionnat().getTours().get(this.jeu.getTour()).getMatchs() ){
                    if (match.getEquipe1().getNom()==this.jeu.getPlayer().getEquipe().getNom() || match.getEquipe2().getNom()==this.jeu.getPlayer().getEquipe().getNom()){
                        if (match.getEquipe1().getNom()==this.jeu.getPlayer().getEquipe().getNom()){
                            this.jeu.getChampionnat().AjoutPointsEquipe(3, match.getEquipe2()); 
                        }
                        else {
                            this.jeu.getChampionnat().AjoutPointsEquipe(3, match.getEquipe1()); 
                        }
                    }
                    
                }
                System.out.println("You lose! Final Score: " + playerScore + " - " + aiScore);
                gameOverText.setText("You Lose!");
                gameOverText.setFont(Font.font("Sports World", 60));
                gameOverText.setStyle(
                    "-fx-fill: linear-gradient(from 0% 0% to 100% 100%, #FF0000, #8B0000);" + // Dégradé rouge clair à rouge foncé
                    "-fx-stroke: black;" +                                                   // Contour noir
                    "-fx-stroke-width: 2px;" +                                               // Épaisseur du contour
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 10, 0.5, 0, 4);"   // Ombre portée pour le texte
                );
            }

            // Add the game over message to the pane
            gameView.getPane().getChildren().add(gameOverText);

            // Pause for 5 seconds before transitioning to the RankingView
            PauseTransition pause = new PauseTransition(Duration.seconds(5));
            pause.setOnFinished(e -> {
                // Remove the game over text
                gameView.getPane().getChildren().remove(gameOverText);   
                if (this.jeu.getTour()<15 ){
                    // Transition to RankingView (assuming you have a method to switch views)
                    // this.jeu.getChampionnat().randomizeTour(this.jeu.getPlayer().getEquipe(),this.jeu.getTour())  ;
                    for (Match match : this.jeu.getChampionnat().getTours().get(this.jeu.getTour()+1).getMatchs()) {
                        Equipe equipe1 = match.getEquipe1();
                        Equipe equipe2 = match.getEquipe2();

                        // Si l'équipe donnée ne participe pas au match, générer un résultat aléatoire
                        if (!equipe1.equals(this.jeu.getPlayer().getEquipe()) && !equipe2.equals(this.jeu.getPlayer().getEquipe())) {
                            Random rand = new Random();
                            // Générer un gagnant aléatoire
                            Equipe gagnant = rand.nextBoolean() ? equipe1 : equipe2;

                            // Ajouter des points à l'équipe gagnante
                            this.jeu.getChampionnat().AjoutPointsEquipe(3, gagnant);


                            // Afficher le résultat
                            System.out.println("Match entre " + equipe1.getNom() + " et " + equipe2.getNom() + " : " 
                                            + gagnant.getNom() + " gagne !");
                        }
                    }
                    this.jeu.setTour(this.jeu.getTour()+1) ;

                    transitionToRankingView();
                }
                else if (this.jeu.getTour()==15)
                    transitionToChampionsView();
            });
            pause.play(); 
        }
        else if(this.jeu.getCoupe()!= null) {
            System.out.println("Game Over!");
            Text gameOverText = new Text();
            gameOverText.setFont(Font.font("Sports World", 30));
            gameOverText.setFill(Color.WHITE);
            gameOverText.setLayoutX(270); // Center the text horizontally
            gameOverText.setLayoutY(200); // Position it vertically
            if (playerScore > aiScore) {
                for( Match match : this.jeu.getCoupe().getTours().get(this.jeu.getTour()).getMatchs() ){
                    if (match.getEquipe1().getNom()==this.jeu.getPlayer().getEquipe().getNom() || match.getEquipe2().getNom()==this.jeu.getPlayer().getEquipe().getNom()){
                        if (match.getEquipe1().getNom()==this.jeu.getPlayer().getEquipe().getNom()){
                            this.jeu.getCoupe().eliminerEquipe(match.getEquipe2());
                        }
                        else {
                            this.jeu.getCoupe().eliminerEquipe(match.getEquipe1());
                        }
                    }
                    
                }
                System.out.println("You win! Final Score: " + playerScore + " - " + aiScore);
                gameOverText.setText("You Win!");
                gameOverText.setFont(Font.font("Sports World", 60));
                gameOverText.setStyle(
                    "-fx-fill: linear-gradient(from 0% 0% to 100% 100%, #00FF00, #008000);" +  // Dégradé vert clair à vert foncé
                    "-fx-stroke: black;" +                                                   // Contour noir
                    "-fx-stroke-width: 2px;" +                                               // Épaisseur du contour
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 10, 0.5, 0, 4);"   // Ombre portée pour le texte
                );
                gameView.getPane().getChildren().add(gameOverText);
                PauseTransition pause = new PauseTransition(Duration.seconds(5));
                pause.setOnFinished(e -> {
                // Remove the game over text
                gameView.getPane().getChildren().remove(gameOverText);   
                if (this.jeu.getTour()<3 ){
                    // Transition to BracketView (assuming you have a method to switch views)
                    for (Match match : this.jeu.getCoupe().getTours().get(this.jeu.getTour()).getMatchs()) {
                        Equipe equipe1 = match.getEquipe1();
                        Equipe equipe2 = match.getEquipe2();

                        // Si l'équipe donnée ne participe pas au match, générer un résultat aléatoire
                        if (!equipe1.equals(this.jeu.getPlayer().getEquipe()) && !equipe2.equals(this.jeu.getPlayer().getEquipe())) {
                            Random rand = new Random();
                            // Générer un gagnant aléatoire
                            Equipe gagnant = rand.nextBoolean() ? equipe1 : equipe2;
                            Equipe perdant = new Equipe("","","");
                            if (gagnant == equipe1)
                                perdant= equipe2;
                            else
                                perdant=equipe1;
                            
                            // Eliminer lequipe qui a perdue
                            this.jeu.getCoupe().eliminerEquipe(perdant);

                            // Afficher le résultat
                            System.out.println("Match entre " + equipe1.getNom() + " et " + equipe2.getNom() + " : " 
                                            + gagnant.getNom() + " gagne !");
                        }
                    }
                    this.jeu.setTour(this.jeu.getTour()+1);
                    try {
                        this.jeu.getCoupe().Initialiser_tour();
                    } catch (AjoutTourException ex) {
                        Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    transitionToBracketView();
                }
                else if (this.jeu.getTour()==3){
                    transitionToChampionsView();
                }
                });
                pause.play();


            } else{
                this.jeu.getCoupe().eliminerEquipe(jeu.getPlayer().getEquipe());
                System.out.println("You lose! Final Score: " + playerScore + " - " + aiScore);
                gameOverText.setText("You Lose!");
                gameOverText.setFont(Font.font("Sports World", 60));
                gameOverText.setStyle(
                    "-fx-fill: linear-gradient(from 0% 0% to 100% 100%, #FF0000, #8B0000);" + // Dégradé rouge clair à rouge foncé
                    "-fx-stroke: black;" +                                                   // Contour noir
                    "-fx-stroke-width: 2px;" +                                               // Épaisseur du contour
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 10, 0.5, 0, 4);"   // Ombre portée pour le texte
                );
                
                gameView.getPane().getChildren().add(gameOverText);
                PauseTransition pause = new PauseTransition(Duration.seconds(5));
                pause.setOnFinished(e -> {
                // Remove the game over text
                    gameView.getPane().getChildren().remove(gameOverText);   
                    transitionToEliminatedView();      
                });
                pause.play();
            }
            
                // Pause for 5 seconds before transitioning to the BracketView
            
            
            
             
            
            
        }
    }

    private void transitionToRankingView() {
            // Create an instance of RankingView
            RankingView rankingView = new RankingView(jeu);  // Replace with actual ranking view creation

            // Get the current stage (existing window) from the game scene
            Stage currentStage = (Stage) gameView.getScene().getWindow();

            // Set the new scene for the existing stage
            currentStage.setScene(rankingView.getScene());

            // Optionally, create a new controller for the ranking view if needed
            new RankingController(rankingView, jeu);
        }
    private void transitionToBracketView() {
            BracketView BracketView = new BracketView(jeu.getCoupe().getTours().get(this.jeu.getTour()).getMatchs()); 
            Stage currentStage = (Stage) gameView.getScene().getWindow();
            currentStage.setScene(BracketView.getBracketScene());
            new BracketController(BracketView, jeu);
        }
    
    private void transitionToEliminatedView() {
            EliminatedView EliminatedView = new EliminatedView(this.jeu);  
            Stage currentStage = (Stage) gameView.getScene().getWindow();
            currentStage.setScene(EliminatedView.getScene());
            new EliminatedController(EliminatedView, jeu);
        }
    
    private void transitionToChampionsView() {
            ChampionsView ChampionsView = new ChampionsView(this.jeu);  
            Stage currentStage = (Stage) gameView.getScene().getWindow();
            currentStage.setScene(ChampionsView.getScene());
            new ChampionsController(ChampionsView, jeu);
        }

    
    
    
}
