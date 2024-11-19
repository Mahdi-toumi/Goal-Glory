/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tests;


import model.elements.Equipe;
import model.structure.exceptions.AjoutEquipeException;
import model.structure.Tournoi;


/**
 *
 * @author toumi
 */
public class TestTournoi {
    public static void main(String[] args) throws  AjoutEquipeException {
        // Création des équipes
        Equipe E1 = new Equipe("Real", "Zidane");
        Equipe E2 = new Equipe("Barca", "Xavi");
        Equipe E3 = new Equipe("Manchester", "Ten Hag");
        /*
        // Création du tournoi
        Tournoi T = new Tournoi("LaLiga");

        try {
            // Ajout des équipes au tournoi
            T.Ajouter_Equipe(E3);
            T.Ajouter_Equipe(E2);
            T.Ajouter_Equipe(E1);
        } catch (AjoutEquipeException e) {
            // Gestion des erreurs si une équipe existe déjà
            System.out.println("Erreur : " + e.getMessage());
        }

        // Affichage de la liste des équipes du tournoi
        System.out.println("Liste des équipes dans le tournoi : ");
        T.Afficher_list_equipes();*/
    }
}
