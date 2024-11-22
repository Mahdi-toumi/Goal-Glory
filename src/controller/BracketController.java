package controller;

import java.util.ArrayList;
import javafx.stage.Stage;
import model.structure.Match;
import model.elements.Equipe;
import view.BracketView;
import java.util.Collections;
import java.util.List;
import model.structure.Jeu;
import view.ChoisirEquipeView;

public class BracketController {

    private final BracketView view;
    private final List<Equipe> equipes;
    private final Jeu jeu;

    public BracketController(BracketView view, List<Equipe> equipes, Jeu jeu) {
        this.view = view;
        this.equipes = equipes;
        this.jeu=jeu;

        // Generate the bracket matches randomly
        List<Match> matches = generateBracketMatches();
        // Pass the generated matches to the view
        view = new BracketView(equipes);

        // Set back button action
        //view.getBackButton().setOnAction(e -> goBackToChoisirEquipeView());
    }

    private List<Match> generateBracketMatches() {
        // Shuffle the teams randomly
        Collections.shuffle(equipes);

        // Create the matches for the first round (last 16)
        List<Match> matches = new ArrayList<>();
        for (int i = 0; i < equipes.size(); i += 2) {
            Equipe equipe1 = equipes.get(i);
            Equipe equipe2 = equipes.get(i + 1);
            matches.add(new Match(equipe1, equipe2));
        }
        return matches;
    }

    /*private void goBackToChoisirEquipeView() {
        // Navigate back to the team selection screen
        Stage stage = (Stage) view.getBackButton().getScene().getWindow();
        stage.setScene(new ChoisirEquipeView(equipes).getScene());
        new ChoisirEquipeController(new ChoisirEquipeView(equipes), jeu);
    }*/
}
