/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.elements.Equipe;
import model.elements.Gardien;
import model.elements.Poste;
import model.elements.Tireur;
import model.structure.Championnat;
import model.structure.Coupe;
import model.structure.Jeu;

/**
 *
 * @author toumi
 */
public class Data {
    
    public Data (){
    }
    
    public void  DataChampionsLeague (Jeu jeu){
        Equipe madrid = jeu.getCoupe().getEquipes().get(0);

        // Gardien
        madrid.ajouterJoueur(new Gardien("Courtois", "Thibaut", 31));

        // Défenseurs
        madrid.ajouterJoueur(new Tireur("Carvajal", "Dani", 32, Poste.DEFENSEUR));
        madrid.ajouterJoueur(new Tireur("Alaba", "David", 31, Poste.DEFENSEUR));
        madrid.ajouterJoueur(new Tireur("Rüdiger", "Antonio", 30, Poste.DEFENSEUR));
        madrid.ajouterJoueur(new Tireur("Mendy", "Ferland", 29, Poste.DEFENSEUR));

        // Milieux
        madrid.ajouterJoueur(new Tireur("Modric", "Luka", 37, Poste.MILIEU));
        madrid.ajouterJoueur(new Tireur("Kroos", "Toni", 34, Poste.MILIEU));
        madrid.ajouterJoueur(new Tireur("Camavinga", "Eduardo", 21, Poste.MILIEU));

        // Attaquants
        madrid.ajouterJoueur(new Tireur("Vinicius", "Junior", 22, Poste.ATTAQUANT));
        madrid.ajouterJoueur(new Tireur("Rodrygo", "Goes", 23, Poste.ATTAQUANT));
        madrid.ajouterJoueur(new Tireur("Joselu", "Mato", 34, Poste.ATTAQUANT));
        
        
        Equipe barcelone = jeu.getCoupe().getEquipes().get(1);

        // Gardien
        barcelone.ajouterJoueur(new Gardien("Ter Stegen", "Marc-André", 31));

        // Défenseurs
        barcelone.ajouterJoueur(new Tireur("Koundé", "Jules", 25, Poste.DEFENSEUR));
        barcelone.ajouterJoueur(new Tireur("Araujo", "Ronald", 24, Poste.DEFENSEUR));
        barcelone.ajouterJoueur(new Tireur("Christensen", "Andreas", 27, Poste.DEFENSEUR));
        barcelone.ajouterJoueur(new Tireur("Balde", "Alejandro", 20, Poste.DEFENSEUR));

        // Milieux
        barcelone.ajouterJoueur(new Tireur("Pedri", "Gonzalez", 21, Poste.MILIEU));
        barcelone.ajouterJoueur(new Tireur("De Jong", "Frenkie", 26, Poste.MILIEU));
        barcelone.ajouterJoueur(new Tireur("Gavi", "Pablo", 19, Poste.MILIEU));

        // Attaquants
        barcelone.ajouterJoueur(new Tireur("Lewandowski", "Robert", 35, Poste.ATTAQUANT));
        barcelone.ajouterJoueur(new Tireur("Raphinha", "Dias", 27, Poste.ATTAQUANT));
        barcelone.ajouterJoueur(new Tireur("Ferran", "Torres", 23, Poste.ATTAQUANT));
        
        Equipe manchesterCity = jeu.getCoupe().getEquipes().get(2);

        // Gardien
        manchesterCity.ajouterJoueur(new Gardien("Ederson", "Santana", 30));

        // Défenseurs
        manchesterCity.ajouterJoueur(new Tireur("Walker", "Kyle", 33, Poste.DEFENSEUR));
        manchesterCity.ajouterJoueur(new Tireur("Dias", "Ruben", 26, Poste.DEFENSEUR));
        manchesterCity.ajouterJoueur(new Tireur("Stones", "John", 29, Poste.DEFENSEUR));
        manchesterCity.ajouterJoueur(new Tireur("Ake", "Nathan", 28, Poste.DEFENSEUR));

        // Milieux
        manchesterCity.ajouterJoueur(new Tireur("De Bruyne", "Kevin", 32, Poste.MILIEU));
        manchesterCity.ajouterJoueur(new Tireur("Rodri", "Hernandez", 27, Poste.MILIEU));
        manchesterCity.ajouterJoueur(new Tireur("Gundogan", "Ilkay", 33, Poste.MILIEU));

        // Attaquants
        manchesterCity.ajouterJoueur(new Tireur("Haaland", "Erling", 23, Poste.ATTAQUANT));
        manchesterCity.ajouterJoueur(new Tireur("Foden", "Phil", 24, Poste.ATTAQUANT));
        manchesterCity.ajouterJoueur(new Tireur("Grealish", "Jack", 28, Poste.ATTAQUANT));
    
         Equipe psg = jeu.getCoupe().getEquipes().get(3);

        // Gardien
        psg.ajouterJoueur(new Gardien("Donnarumma", "Gianluigi", 24));

        // Défenseurs
        psg.ajouterJoueur(new Tireur("Hakimi", "Achraf", 25, Poste.DEFENSEUR));
        psg.ajouterJoueur(new Tireur("Marquinhos", "Marcos", 29, Poste.DEFENSEUR));
        psg.ajouterJoueur(new Tireur("Ramos", "Sergio", 37, Poste.DEFENSEUR));
        psg.ajouterJoueur(new Tireur("Mendes", "Nuno", 21, Poste.DEFENSEUR));

        // Milieux
        psg.ajouterJoueur(new Tireur("Verratti", "Marco", 31, Poste.MILIEU));
        psg.ajouterJoueur(new Tireur("Vitinha", "Vitor", 23, Poste.MILIEU));
        psg.ajouterJoueur(new Tireur("Ruiz", "Fabian", 27, Poste.MILIEU));

        // Attaquants
        psg.ajouterJoueur(new Tireur("Mbappé", "Kylian", 24, Poste.ATTAQUANT));
        psg.ajouterJoueur(new Tireur("Neymar", "Junior", 32, Poste.ATTAQUANT));
        psg.ajouterJoueur(new Tireur("Messi", "Lionel", 36, Poste.ATTAQUANT));
        
        Equipe bayern = jeu.getCoupe().getEquipes().get(4);

        // Gardien
        bayern.ajouterJoueur(new Gardien("Neuer", "Manuel", 37));

        // Défenseurs
        bayern.ajouterJoueur(new Tireur("Pavard", "Benjamin", 27, Poste.DEFENSEUR));
        bayern.ajouterJoueur(new Tireur("De Ligt", "Matthijs", 24, Poste.DEFENSEUR));
        bayern.ajouterJoueur(new Tireur("Hernandez", "Lucas", 27, Poste.DEFENSEUR));
        bayern.ajouterJoueur(new Tireur("Davies", "Alphonso", 23, Poste.DEFENSEUR));

        // Milieux
        bayern.ajouterJoueur(new Tireur("Kimmich", "Joshua", 28, Poste.MILIEU));
        bayern.ajouterJoueur(new Tireur("Goretzka", "Leon", 28, Poste.MILIEU));
        bayern.ajouterJoueur(new Tireur("Musiala", "Jamal", 21, Poste.MILIEU));

        // Attaquants
        bayern.ajouterJoueur(new Tireur("Müller", "Thomas", 34, Poste.ATTAQUANT));
        bayern.ajouterJoueur(new Tireur("Coman", "Kingsley", 27, Poste.ATTAQUANT));
        bayern.ajouterJoueur(new Tireur("Sané", "Leroy", 28, Poste.ATTAQUANT));
        
        
        Equipe chelsea = jeu.getCoupe().getEquipes().get(5);

        // Gardien
        chelsea.ajouterJoueur(new Gardien("Kepa", "Arrizabalaga", 29));

        // Défenseurs
        chelsea.ajouterJoueur(new Tireur("James", "Reece", 24, Poste.DEFENSEUR));
        chelsea.ajouterJoueur(new Tireur("Silva", "Thiago", 39, Poste.DEFENSEUR));
        chelsea.ajouterJoueur(new Tireur("Chilwell", "Ben", 27, Poste.DEFENSEUR));
        chelsea.ajouterJoueur(new Tireur("Cucurella", "Marc", 26, Poste.DEFENSEUR));

        // Milieux
        chelsea.ajouterJoueur(new Tireur("Enzo", "Fernandez", 22, Poste.MILIEU));
        chelsea.ajouterJoueur(new Tireur("Kovacic", "Mateo", 29, Poste.MILIEU));
        chelsea.ajouterJoueur(new Tireur("Kante", "N'Golo", 32, Poste.MILIEU));

        // Attaquants
        chelsea.ajouterJoueur(new Tireur("Havertz", "Kai", 24, Poste.ATTAQUANT));
        chelsea.ajouterJoueur(new Tireur("Sterling", "Raheem", 28, Poste.ATTAQUANT));
        chelsea.ajouterJoueur(new Tireur("Felix", "Joao", 23, Poste.ATTAQUANT));
        
        Equipe liverpool = jeu.getCoupe().getEquipes().get(6);

        // Gardien
        liverpool.ajouterJoueur(new Gardien("Alisson", "Becker", 31));

        // Défenseurs
        liverpool.ajouterJoueur(new Tireur("Alexander-Arnold", "Trent", 25, Poste.DEFENSEUR));
        liverpool.ajouterJoueur(new Tireur("Van Dijk", "Virgil", 32, Poste.DEFENSEUR));
        liverpool.ajouterJoueur(new Tireur("Robertson", "Andrew", 30, Poste.DEFENSEUR));
        liverpool.ajouterJoueur(new Tireur("Konaté", "Ibrahima", 24, Poste.DEFENSEUR));

        // Milieux
        liverpool.ajouterJoueur(new Tireur("Thiago", "Alcantara", 32, Poste.MILIEU));
        liverpool.ajouterJoueur(new Tireur("Fabinho", "Tavares", 30, Poste.MILIEU));
        liverpool.ajouterJoueur(new Tireur("Henderson", "Jordan", 33, Poste.MILIEU));

        // Attaquants
        liverpool.ajouterJoueur(new Tireur("Salah", "Mohamed", 31, Poste.ATTAQUANT));
        liverpool.ajouterJoueur(new Tireur("Nunez", "Darwin", 24, Poste.ATTAQUANT));
        liverpool.ajouterJoueur(new Tireur("Diaz", "Luis", 27, Poste.ATTAQUANT));

                Equipe juventus = jeu.getCoupe().getEquipes().get(7);

        // Gardien
        juventus.ajouterJoueur(new Gardien("Szczesny", "Wojciech", 33));

        // Défenseurs
        juventus.ajouterJoueur(new Tireur("Danilo", "Luiz", 32, Poste.DEFENSEUR));
        juventus.ajouterJoueur(new Tireur("Bonucci", "Leonardo", 36, Poste.DEFENSEUR));
        juventus.ajouterJoueur(new Tireur("Alex Sandro", "Lobo", 32, Poste.DEFENSEUR));
        juventus.ajouterJoueur(new Tireur("Bremer", "Gleison", 26, Poste.DEFENSEUR));

        // Milieux
        juventus.ajouterJoueur(new Tireur("Pogba", "Paul", 30, Poste.MILIEU));
        juventus.ajouterJoueur(new Tireur("Locatelli", "Manuel", 25, Poste.MILIEU));
        juventus.ajouterJoueur(new Tireur("Rabiot", "Adrien", 28, Poste.MILIEU));

        // Attaquants
        juventus.ajouterJoueur(new Tireur("Vlahovic", "Dusan", 23, Poste.ATTAQUANT));
        juventus.ajouterJoueur(new Tireur("Chiesa", "Federico", 26, Poste.ATTAQUANT));
        juventus.ajouterJoueur(new Tireur("Di Maria", "Angel", 35, Poste.ATTAQUANT));

        
                Equipe atletico = jeu.getCoupe().getEquipes().get(8);

        // Gardien
        atletico.ajouterJoueur(new Gardien("Oblak", "Jan", 31));

        // Défenseurs
        atletico.ajouterJoueur(new Tireur("Savic", "Stefan", 32, Poste.DEFENSEUR));
        atletico.ajouterJoueur(new Tireur("Hermoso", "Mario", 28, Poste.DEFENSEUR));
        atletico.ajouterJoueur(new Tireur("Reinildo", "Mandava", 29, Poste.DEFENSEUR));
        atletico.ajouterJoueur(new Tireur("Gimenez", "Jose", 28, Poste.DEFENSEUR));

        // Milieux
        atletico.ajouterJoueur(new Tireur("Koke", "Resurreccion", 31, Poste.MILIEU));
        atletico.ajouterJoueur(new Tireur("Llorente", "Marcos", 28, Poste.MILIEU));
        atletico.ajouterJoueur(new Tireur("De Paul", "Rodrigo", 29, Poste.MILIEU));

        // Attaquants
        atletico.ajouterJoueur(new Tireur("Griezmann", "Antoine", 32, Poste.ATTAQUANT));
        atletico.ajouterJoueur(new Tireur("Morata", "Alvaro", 31, Poste.ATTAQUANT));
        atletico.ajouterJoueur(new Tireur("Felix", "Joao", 23, Poste.ATTAQUANT));

        
                Equipe inter = jeu.getCoupe().getEquipes().get(9);

        // Gardien
        inter.ajouterJoueur(new Gardien("Onana", "Andre", 27));

        // Défenseurs
        inter.ajouterJoueur(new Tireur("Skriniar", "Milan", 28, Poste.DEFENSEUR));
        inter.ajouterJoueur(new Tireur("Bastoni", "Alessandro", 24, Poste.DEFENSEUR));
        inter.ajouterJoueur(new Tireur("Dumfries", "Denzel", 27, Poste.DEFENSEUR));
        inter.ajouterJoueur(new Tireur("Dimarco", "Federico", 25, Poste.DEFENSEUR));

        // Milieux
        inter.ajouterJoueur(new Tireur("Brozovic", "Marcelo", 31, Poste.MILIEU));
        inter.ajouterJoueur(new Tireur("Barella", "Nicolo", 26, Poste.MILIEU));
        inter.ajouterJoueur(new Tireur("Calhanoglu", "Hakan", 30, Poste.MILIEU));

        // Attaquants
        inter.ajouterJoueur(new Tireur("Martinez", "Lautaro", 26, Poste.ATTAQUANT));
        inter.ajouterJoueur(new Tireur("Dzeko", "Edin", 37, Poste.ATTAQUANT));
        inter.ajouterJoueur(new Tireur("Lukaku", "Romelu", 31, Poste.ATTAQUANT));

        
                Equipe milan = jeu.getCoupe().getEquipes().get(10);

        // Gardien
        milan.ajouterJoueur(new Gardien("Maignan", "Mike", 28));

        // Défenseurs
        milan.ajouterJoueur(new Tireur("Kalulu", "Pierre", 23, Poste.DEFENSEUR));
        milan.ajouterJoueur(new Tireur("Tomori", "Fikayo", 26, Poste.DEFENSEUR));
        milan.ajouterJoueur(new Tireur("Hernandez", "Theo", 26, Poste.DEFENSEUR));
        milan.ajouterJoueur(new Tireur("Florenzi", "Alessandro", 32, Poste.DEFENSEUR));

        // Milieux
        milan.ajouterJoueur(new Tireur("Tonali", "Sandro", 23, Poste.MILIEU));
        milan.ajouterJoueur(new Tireur("Krunic", "Rade", 30, Poste.MILIEU));
        milan.ajouterJoueur(new Tireur("Bennacer", "Ismael", 26, Poste.MILIEU));

        // Attaquants
        milan.ajouterJoueur(new Tireur("Leao", "Rafael", 24, Poste.ATTAQUANT));
        milan.ajouterJoueur(new Tireur("Giroud", "Olivier", 37, Poste.ATTAQUANT));
        milan.ajouterJoueur(new Tireur("Origi", "Divock", 29, Poste.ATTAQUANT));

        
                Equipe dortmund = jeu.getCoupe().getEquipes().get(11);

        // Gardien
        dortmund.ajouterJoueur(new Gardien("Kobel", "Gregor", 25));

        // Défenseurs
        dortmund.ajouterJoueur(new Tireur("Hummels", "Mats", 35, Poste.DEFENSEUR));
        dortmund.ajouterJoueur(new Tireur("Sule", "Niklas", 28, Poste.DEFENSEUR));
        dortmund.ajouterJoueur(new Tireur("Schlotterbeck", "Nico", 24, Poste.DEFENSEUR));
        dortmund.ajouterJoueur(new Tireur("Ryerson", "Julian", 26, Poste.DEFENSEUR));

        // Milieux
        dortmund.ajouterJoueur(new Tireur("Reus", "Marco", 34, Poste.MILIEU));
        dortmund.ajouterJoueur(new Tireur("Bellingham", "Jude", 20, Poste.MILIEU));
        dortmund.ajouterJoueur(new Tireur("Can", "Emre", 30, Poste.MILIEU));

        // Attaquants
        dortmund.ajouterJoueur(new Tireur("Haller", "Sebastien", 29, Poste.ATTAQUANT));
        dortmund.ajouterJoueur(new Tireur("Moukoko", "Youssoufa", 19, Poste.ATTAQUANT));
        dortmund.ajouterJoueur(new Tireur("Adeyemi", "Karim", 22, Poste.ATTAQUANT));

        
        
                Equipe arsenal = jeu.getCoupe().getEquipes().get(12);

        // Gardien
        arsenal.ajouterJoueur(new Gardien("Ramsdale", "Aaron", 25));

        // Défenseurs
        arsenal.ajouterJoueur(new Tireur("White", "Ben", 26, Poste.DEFENSEUR));
        arsenal.ajouterJoueur(new Tireur("Gabriel", "Magalhaes", 25, Poste.DEFENSEUR));
        arsenal.ajouterJoueur(new Tireur("Saliba", "William", 23, Poste.DEFENSEUR));
        arsenal.ajouterJoueur(new Tireur("Zinchenko", "Oleksandr", 27, Poste.DEFENSEUR));

        // Milieux
        arsenal.ajouterJoueur(new Tireur("Odegaard", "Martin", 25, Poste.MILIEU));
        arsenal.ajouterJoueur(new Tireur("Partey", "Thomas", 30, Poste.MILIEU));
        arsenal.ajouterJoueur(new Tireur("Xhaka", "Granit", 31, Poste.MILIEU));

        // Attaquants
        arsenal.ajouterJoueur(new Tireur("Jesus", "Gabriel", 26, Poste.ATTAQUANT));
        arsenal.ajouterJoueur(new Tireur("Saka", "Bukayo", 22, Poste.ATTAQUANT));
        arsenal.ajouterJoueur(new Tireur("Martinelli", "Gabriel", 23, Poste.ATTAQUANT));

                Equipe tottenham = jeu.getCoupe().getEquipes().get(13);

        // Gardien
        tottenham.ajouterJoueur(new Gardien("Lloris", "Hugo", 37));

        // Défenseurs
        tottenham.ajouterJoueur(new Tireur("Romero", "Cristian", 25, Poste.DEFENSEUR));
        tottenham.ajouterJoueur(new Tireur("Dier", "Eric", 30, Poste.DEFENSEUR));
        tottenham.ajouterJoueur(new Tireur("Davies", "Ben", 30, Poste.DEFENSEUR));
        tottenham.ajouterJoueur(new Tireur("Porro", "Pedro", 24, Poste.DEFENSEUR));

        // Milieux
        tottenham.ajouterJoueur(new Tireur("Hojbjerg", "Pierre-Emile", 28, Poste.MILIEU));
        tottenham.ajouterJoueur(new Tireur("Bentancur", "Rodrigo", 26, Poste.MILIEU));
        tottenham.ajouterJoueur(new Tireur("Bissouma", "Yves", 27, Poste.MILIEU));

        // Attaquants
        tottenham.ajouterJoueur(new Tireur("Kane", "Harry", 30, Poste.ATTAQUANT));
        tottenham.ajouterJoueur(new Tireur("Son", "Heung-min", 31, Poste.ATTAQUANT));
        tottenham.ajouterJoueur(new Tireur("Richarlison", "de Andrade", 26, Poste.ATTAQUANT));

        
                Equipe napoli = jeu.getCoupe().getEquipes().get(14);

        // Gardien
        napoli.ajouterJoueur(new Gardien("Meret", "Alex", 26));

        // Défenseurs
        napoli.ajouterJoueur(new Tireur("Di Lorenzo", "Giovanni", 30, Poste.DEFENSEUR));
        napoli.ajouterJoueur(new Tireur("Kim", "Min-jae", 27, Poste.DEFENSEUR));
        napoli.ajouterJoueur(new Tireur("Rrahmani", "Amir", 29, Poste.DEFENSEUR));
        napoli.ajouterJoueur(new Tireur("Mario Rui", "Silva", 32, Poste.DEFENSEUR));

        // Milieux
        napoli.ajouterJoueur(new Tireur("Anguissa", "Andre-Frank", 28, Poste.MILIEU));
        napoli.ajouterJoueur(new Tireur("Zielinski", "Piotr", 29, Poste.MILIEU));
        napoli.ajouterJoueur(new Tireur("Lobotka", "Stanislav", 29, Poste.MILIEU));

        // Attaquants
        napoli.ajouterJoueur(new Tireur("Osimhen", "Victor", 25, Poste.ATTAQUANT));
        napoli.ajouterJoueur(new Tireur("Kvaratskhelia", "Khvicha", 23, Poste.ATTAQUANT));
        napoli.ajouterJoueur(new Tireur("Politano", "Matteo", 30, Poste.ATTAQUANT));

        
                Equipe benfica = jeu.getCoupe().getEquipes().get(15);

        // Gardien
        benfica.ajouterJoueur(new Gardien("Vlachodimos", "Odysseas", 29));

        // Défenseurs
        benfica.ajouterJoueur(new Tireur("Silva", "Antonio", 20, Poste.DEFENSEUR));
        benfica.ajouterJoueur(new Tireur("Otamendi", "Nicolas", 35, Poste.DEFENSEUR));
        benfica.ajouterJoueur(new Tireur("Bah", "Alexander", 26, Poste.DEFENSEUR));
        benfica.ajouterJoueur(new Tireur("Grimaldo", "Alex", 28, Poste.DEFENSEUR));

        // Milieux
        benfica.ajouterJoueur(new Tireur("Florentino", "Luis", 24, Poste.MILIEU));
        benfica.ajouterJoueur(new Tireur("Joao Mario", "Naval", 31, Poste.MILIEU));
        benfica.ajouterJoueur(new Tireur("Aursnes", "Fredrik", 27, Poste.MILIEU));

        // Attaquants
        benfica.ajouterJoueur(new Tireur("Ramos", "Goncalo", 22, Poste.ATTAQUANT));
        benfica.ajouterJoueur(new Tireur("Neres", "David", 27, Poste.ATTAQUANT));
        benfica.ajouterJoueur(new Tireur("Silva", "Rafa", 30, Poste.ATTAQUANT));

        
    }

    public void  DataWorldCup (Jeu jeu){
        // Equipe France
Equipe france = jeu.getCoupe().getEquipes().get(0);
france.ajouterJoueur(new Gardien("Lloris", "Hugo", 37));
france.ajouterJoueur(new Tireur("Pavard", "Benjamin", 28, Poste.DEFENSEUR));
france.ajouterJoueur(new Tireur("Varane", "Raphaël", 30, Poste.DEFENSEUR));
france.ajouterJoueur(new Tireur("Kimpembe", "Presnel", 28, Poste.DEFENSEUR));
france.ajouterJoueur(new Tireur("Hernandez", "Lucas", 27, Poste.DEFENSEUR));

france.ajouterJoueur(new Tireur("Tchouaméni", "Aurélien", 24, Poste.MILIEU));
france.ajouterJoueur(new Tireur("Rabiot", "Adrien", 29, Poste.MILIEU));
france.ajouterJoueur(new Tireur("Griezmann", "Antoine", 33, Poste.MILIEU));

france.ajouterJoueur(new Tireur("Mbappé", "Kylian", 25, Poste.ATTAQUANT));
france.ajouterJoueur(new Tireur("Giroud", "Olivier", 37, Poste.ATTAQUANT));
france.ajouterJoueur(new Tireur("Dembele", "Ousmane", 26, Poste.ATTAQUANT));

// Equipe Spain
Equipe spain = jeu.getCoupe().getEquipes().get(1);
spain.ajouterJoueur(new Gardien("Simón", "Unai", 27));
spain.ajouterJoueur(new Tireur("Carvajal", "Dani", 32, Poste.DEFENSEUR));
spain.ajouterJoueur(new Tireur("Pau", "Torres", 27, Poste.DEFENSEUR));
spain.ajouterJoueur(new Tireur("Laporte", "Aymeric", 29, Poste.DEFENSEUR));
spain.ajouterJoueur(new Tireur("Alba", "Jordi", 35, Poste.DEFENSEUR));

spain.ajouterJoueur(new Tireur("Busquets", "Sergio", 35, Poste.MILIEU));
spain.ajouterJoueur(new Tireur("Pedri", "Pedro", 21, Poste.MILIEU));
spain.ajouterJoueur(new Tireur("Gavi", "Pablo", 19, Poste.MILIEU));

spain.ajouterJoueur(new Tireur("Ferran", "Torres", 23, Poste.ATTAQUANT));
spain.ajouterJoueur(new Tireur("Morata", "Álvaro", 32, Poste.ATTAQUANT));
spain.ajouterJoueur(new Tireur("Olmo", "Dani", 25, Poste.ATTAQUANT));

// Equipe Germany
Equipe germany = jeu.getCoupe().getEquipes().get(2);
germany.ajouterJoueur(new Gardien("Neuer", "Manuel", 37));
germany.ajouterJoueur(new Tireur("Kimmich", "Joshua", 28, Poste.DEFENSEUR));
germany.ajouterJoueur(new Tireur("Rudiger", "Antonio", 30, Poste.DEFENSEUR));
germany.ajouterJoueur(new Tireur("Schlotterbeck", "Nico", 24, Poste.DEFENSEUR));
germany.ajouterJoueur(new Tireur("Gosens", "Robin", 29, Poste.DEFENSEUR));

germany.ajouterJoueur(new Tireur("Goretzka", "Leon", 28, Poste.MILIEU));
germany.ajouterJoueur(new Tireur("Müller", "Thomas", 34, Poste.MILIEU));
germany.ajouterJoueur(new Tireur("Sané", "Leroy", 28, Poste.MILIEU));

germany.ajouterJoueur(new Tireur("Havertz", "Kai", 25, Poste.ATTAQUANT));
germany.ajouterJoueur(new Tireur("Müller", "Leroy", 34, Poste.ATTAQUANT));
germany.ajouterJoueur(new Tireur("Füllkrug", "Niclas", 31, Poste.ATTAQUANT));

// Equipe Argentina
Equipe argentina = jeu.getCoupe().getEquipes().get(3);
argentina.ajouterJoueur(new Gardien("Martínez", "Emiliano", 31));
argentina.ajouterJoueur(new Tireur("Otamendi", "Nicolas", 35, Poste.DEFENSEUR));
argentina.ajouterJoueur(new Tireur("Romero", "Cristian", 26, Poste.DEFENSEUR));
argentina.ajouterJoueur(new Tireur("Acuña", "Marcos", 32, Poste.DEFENSEUR));
argentina.ajouterJoueur(new Tireur("Foyth", "Juan", 26, Poste.DEFENSEUR));

argentina.ajouterJoueur(new Tireur("De Paul", "Rodrigo", 29, Poste.MILIEU));
argentina.ajouterJoueur(new Tireur("Fernández", "Enzo", 23, Poste.MILIEU));
argentina.ajouterJoueur(new Tireur("Paredes", "Leandro", 29, Poste.MILIEU));

argentina.ajouterJoueur(new Tireur("Messi", "Lionel", 36, Poste.ATTAQUANT));
argentina.ajouterJoueur(new Tireur("Di María", "Ángel", 35, Poste.ATTAQUANT));
argentina.ajouterJoueur(new Tireur("Álvarez", "Julián", 24, Poste.ATTAQUANT));

// Equipe Italia
Equipe italia = jeu.getCoupe().getEquipes().get(4);
italia.ajouterJoueur(new Gardien("Donnarumma", "Gianluigi", 25));
italia.ajouterJoueur(new Tireur("Florenzi", "Alessandro", 33, Poste.DEFENSEUR));
italia.ajouterJoueur(new Tireur("Bastoni", "Alessandro", 25, Poste.DEFENSEUR));
italia.ajouterJoueur(new Tireur("Chiellini", "Giorgio", 39, Poste.DEFENSEUR));
italia.ajouterJoueur(new Tireur("Spinazzola", "Leonardo", 31, Poste.DEFENSEUR));

italia.ajouterJoueur(new Tireur("Jorginho", "Luigi", 32, Poste.MILIEU));
italia.ajouterJoueur(new Tireur("Verratti", "Marco", 31, Poste.MILIEU));
italia.ajouterJoueur(new Tireur("Barella", "Nicolo", 27, Poste.MILIEU));

italia.ajouterJoueur(new Tireur("Immobile", "Ciro", 34, Poste.ATTAQUANT));
italia.ajouterJoueur(new Tireur("Insigne", "Lorenzo", 32, Poste.ATTAQUANT));
italia.ajouterJoueur(new Tireur("Belotti", "Andrea", 30, Poste.ATTAQUANT));

// Equipe Brazil
Equipe brazil = jeu.getCoupe().getEquipes().get(5);
brazil.ajouterJoueur(new Gardien("Alisson", "Becker", 31));
brazil.ajouterJoueur(new Tireur("Thiago Silva", "Thiago", 40, Poste.DEFENSEUR));
brazil.ajouterJoueur(new Tireur("Marquinhos", "Marquinhos", 30, Poste.DEFENSEUR));
brazil.ajouterJoueur(new Tireur("Militão", "Éder", 26, Poste.DEFENSEUR));
brazil.ajouterJoueur(new Tireur("Alex Sandro", "Alex", 32, Poste.DEFENSEUR));

brazil.ajouterJoueur(new Tireur("Casemiro", "Carlos", 32, Poste.MILIEU));
brazil.ajouterJoueur(new Tireur("Paquetá", "Lucas", 26, Poste.MILIEU));
brazil.ajouterJoueur(new Tireur("Neymar", "Júnior", 31, Poste.MILIEU));

brazil.ajouterJoueur(new Tireur("Richarlison", "Richarlison", 26, Poste.ATTAQUANT));
brazil.ajouterJoueur(new Tireur("Vinícius", "Vinícius", 24, Poste.ATTAQUANT));
brazil.ajouterJoueur(new Tireur("Raphinha", "Raphinha", 27, Poste.ATTAQUANT));

// Equipe Uruguay
Equipe uruguay = jeu.getCoupe().getEquipes().get(6);
uruguay.ajouterJoueur(new Gardien("Muslera", "Fernando", 37));
uruguay.ajouterJoueur(new Tireur("Godín", "Diego", 38, Poste.DEFENSEUR));
uruguay.ajouterJoueur(new Tireur("Cáceres", "Martín", 35, Poste.DEFENSEUR));
uruguay.ajouterJoueur(new Tireur("Jiménez", "José", 29, Poste.DEFENSEUR));
uruguay.ajouterJoueur(new Tireur("Olivera", "Matías", 26, Poste.DEFENSEUR));

uruguay.ajouterJoueur(new Tireur("Bentancur", "Rodrigo", 26, Poste.MILIEU));
uruguay.ajouterJoueur(new Tireur("Valverde", "Federico", 26, Poste.MILIEU));
uruguay.ajouterJoueur(new Tireur("Pereira", "Gastón", 27, Poste.MILIEU));

uruguay.ajouterJoueur(new Tireur("Suárez", "Luis", 37, Poste.ATTAQUANT));
uruguay.ajouterJoueur(new Tireur("Cavani", "Edinson", 37, Poste.ATTAQUANT));
uruguay.ajouterJoueur(new Tireur("Darwin", "Darwin", 24, Poste.ATTAQUANT));

// Equipe Belgium
Equipe belgium = jeu.getCoupe().getEquipes().get(7);
belgium.ajouterJoueur(new Gardien("Courtois", "Thibaut", 32));
belgium.ajouterJoueur(new Tireur("Alderweireld", "Toby", 35, Poste.DEFENSEUR));
belgium.ajouterJoueur(new Tireur("Vertonghen", "Jan", 37, Poste.DEFENSEUR));
belgium.ajouterJoueur(new Tireur("Meunier", "Thomas", 32, Poste.DEFENSEUR));
belgium.ajouterJoueur(new Tireur("Castagne", "Timothy", 27, Poste.DEFENSEUR));

belgium.ajouterJoueur(new Tireur("Tielemans", "Youri", 26, Poste.MILIEU));
belgium.ajouterJoueur(new Tireur("Witsel", "Axel", 35, Poste.MILIEU));
belgium.ajouterJoueur(new Tireur("De Bruyne", "Kevin", 32, Poste.MILIEU));

belgium.ajouterJoueur(new Tireur("Lukaku", "Romelu", 31, Poste.ATTAQUANT));
belgium.ajouterJoueur(new Tireur("Hazard", "Eden", 33, Poste.ATTAQUANT));
belgium.ajouterJoueur(new Tireur("Mertens", "Dries", 36, Poste.ATTAQUANT));

// Equipe Portugal
Equipe portugal = jeu.getCoupe().getEquipes().get(8);
portugal.ajouterJoueur(new Gardien("Costa", "Diogo", 25));
portugal.ajouterJoueur(new Tireur("Pepe", "Pepe", 41, Poste.DEFENSEUR));
portugal.ajouterJoueur(new Tireur("Dias", "Ruben", 26, Poste.DEFENSEUR));
portugal.ajouterJoueur(new Tireur("Cancelo", "Joao", 30, Poste.DEFENSEUR));
portugal.ajouterJoueur(new Tireur("Guerreiro", "Raphaël", 30, Poste.DEFENSEUR));

portugal.ajouterJoueur(new Tireur("Bento", "João", 25, Poste.MILIEU));
portugal.ajouterJoueur(new Tireur("Fernandes", "Bruno", 29, Poste.MILIEU));
portugal.ajouterJoueur(new Tireur("Neves", "Ruben", 27, Poste.MILIEU));

portugal.ajouterJoueur(new Tireur("Ronaldo", "Cristiano", 39, Poste.ATTAQUANT));
portugal.ajouterJoueur(new Tireur("Felix", "João", 24, Poste.ATTAQUANT));
portugal.ajouterJoueur(new Tireur("Leao", "Rafael", 24, Poste.ATTAQUANT));

// Equipe Morocco
Equipe morocco = jeu.getCoupe().getEquipes().get(9);
morocco.ajouterJoueur(new Gardien("Bounou", "Yassine", 33));
morocco.ajouterJoueur(new Tireur("Hakimi", "Achraf", 25, Poste.DEFENSEUR));
morocco.ajouterJoueur(new Tireur("Said", "Yassine", 28, Poste.DEFENSEUR));
morocco.ajouterJoueur(new Tireur("Mazraoui", "Noussair", 26, Poste.DEFENSEUR));
morocco.ajouterJoueur(new Tireur("Aguerd", "Romain", 28, Poste.DEFENSEUR));

morocco.ajouterJoueur(new Tireur("Amrabat", "Sofyan", 27, Poste.MILIEU));
morocco.ajouterJoueur(new Tireur("Ounahi", "Azzedine", 23, Poste.MILIEU));
morocco.ajouterJoueur(new Tireur("Ziyech", "Hakim", 31, Poste.MILIEU));

morocco.ajouterJoueur(new Tireur("En-Nesyri", "Youssef", 26, Poste.ATTAQUANT));
morocco.ajouterJoueur(new Tireur("Boufal", "Sofiane", 30, Poste.ATTAQUANT));
morocco.ajouterJoueur(new Tireur("Cheddira", "Abdelhamid", 27, Poste.ATTAQUANT));

// Equipe Croatia
Equipe croatia = jeu.getCoupe().getEquipes().get(10);
croatia.ajouterJoueur(new Gardien("Livaković", "Dominik", 29));
croatia.ajouterJoueur(new Tireur("Vida", "Domagoj", 35, Poste.DEFENSEUR));
croatia.ajouterJoueur(new Tireur("Lovren", "Dejan", 35, Poste.DEFENSEUR));
croatia.ajouterJoueur(new Tireur("Barišić", "Borna", 30, Poste.DEFENSEUR));
croatia.ajouterJoueur(new Tireur("Juranović", "Josip", 28, Poste.DEFENSEUR));

croatia.ajouterJoueur(new Tireur("Modrić", "Luka", 38, Poste.MILIEU));
croatia.ajouterJoueur(new Tireur("Brozović", "Marcelo", 31, Poste.MILIEU));
croatia.ajouterJoueur(new Tireur("Kovacić", "Mateo", 29, Poste.MILIEU));

croatia.ajouterJoueur(new Tireur("Kramarić", "Andrej", 32, Poste.ATTAQUANT));
croatia.ajouterJoueur(new Tireur("Perišić", "Ivan", 35, Poste.ATTAQUANT));
croatia.ajouterJoueur(new Tireur("Petković", "Mislav", 28, Poste.ATTAQUANT));

// Equipe Netherlands
Equipe netherlands = jeu.getCoupe().getEquipes().get(11);
netherlands.ajouterJoueur(new Gardien("Noppert", "Andries", 30));
netherlands.ajouterJoueur(new Tireur("De Ligt", "Matthijs", 24, Poste.DEFENSEUR));
netherlands.ajouterJoueur(new Tireur("Van Dijk", "Virgil", 33, Poste.DEFENSEUR));
netherlands.ajouterJoueur(new Tireur("Blind", "Daley", 34, Poste.DEFENSEUR));
netherlands.ajouterJoueur(new Tireur("Dumfries", "Denzel", 28, Poste.DEFENSEUR));

netherlands.ajouterJoueur(new Tireur("De Jong", "Frenkie", 26, Poste.MILIEU));
netherlands.ajouterJoueur(new Tireur("Klaassen", "Davy", 31, Poste.MILIEU));
netherlands.ajouterJoueur(new Tireur("Bergwijn", "Steven", 26, Poste.MILIEU));

netherlands.ajouterJoueur(new Tireur("Gakpo", "Cody", 25, Poste.ATTAQUANT));
netherlands.ajouterJoueur(new Tireur("Memphis", "Depay", 29, Poste.ATTAQUANT));
netherlands.ajouterJoueur(new Tireur("Weghorst", "Wout", 31, Poste.ATTAQUANT));

// Equipe Senegal
Equipe senegal = jeu.getCoupe().getEquipes().get(12);
senegal.ajouterJoueur(new Gardien("Mendy", "Edouard", 31));
senegal.ajouterJoueur(new Tireur("Koulibaly", "Kalidou", 33, Poste.DEFENSEUR));
senegal.ajouterJoueur(new Tireur("Sabaly", "Youssouf", 30, Poste.DEFENSEUR));
senegal.ajouterJoueur(new Tireur("Famara", "Diedhiou", 31, Poste.DEFENSEUR));
senegal.ajouterJoueur(new Tireur("Cissé", "Aliou", 30, Poste.DEFENSEUR));

senegal.ajouterJoueur(new Tireur("Sarr", "Ismaila", 26, Poste.MILIEU));
senegal.ajouterJoueur(new Tireur("Idrissa", "Gana Gueye", 34, Poste.MILIEU));
senegal.ajouterJoueur(new Tireur("Kouyaté", "Cheikhou", 34, Poste.MILIEU));

senegal.ajouterJoueur(new Tireur("Mane", "Sadio", 31, Poste.ATTAQUANT));
senegal.ajouterJoueur(new Tireur("Dia", "Boulaye", 28, Poste.ATTAQUANT));
senegal.ajouterJoueur(new Tireur("Diatta", "Krépin", 27, Poste.ATTAQUANT));

// Equipe England
Equipe england = jeu.getCoupe().getEquipes().get(13);
england.ajouterJoueur(new Gardien("Pickford", "Jordan", 30));
england.ajouterJoueur(new Tireur("Stones", "John", 30, Poste.DEFENSEUR));
england.ajouterJoueur(new Tireur("Maguire", "Harry", 31, Poste.DEFENSEUR));
england.ajouterJoueur(new Tireur("Shaw", "Luke", 29, Poste.DEFENSEUR));
england.ajouterJoueur(new Tireur("Alexander-Arnold", "Trent", 26, Poste.DEFENSEUR));

england.ajouterJoueur(new Tireur("Rice", "Declan", 25, Poste.MILIEU));
england.ajouterJoueur(new Tireur("Bellingham", "Jude", 20, Poste.MILIEU));
england.ajouterJoueur(new Tireur("Henderson", "Jordan", 33, Poste.MILIEU));

england.ajouterJoueur(new Tireur("Kane", "Harry", 30, Poste.ATTAQUANT));
england.ajouterJoueur(new Tireur("Sterling", "Raheem", 29, Poste.ATTAQUANT));
england.ajouterJoueur(new Tireur("Saka", "Bukayo", 22, Poste.ATTAQUANT));

// Equipe Poland
Equipe poland = jeu.getCoupe().getEquipes().get(14);
poland.ajouterJoueur(new Gardien("Szczęsny", "Wojciech", 34));
poland.ajouterJoueur(new Tireur("Kiwior", "Jakub", 24, Poste.DEFENSEUR));
poland.ajouterJoueur(new Tireur("Bednarek", "Jan", 28, Poste.DEFENSEUR));
poland.ajouterJoueur(new Tireur("Glik", "Kamil", 36, Poste.DEFENSEUR));
poland.ajouterJoueur(new Tireur("Bereszynski", "Bartosz", 31, Poste.DEFENSEUR));

poland.ajouterJoueur(new Tireur("Krychowiak", "Grzegorz", 34, Poste.MILIEU));
poland.ajouterJoueur(new Tireur("Zielinski", "Piotr", 29, Poste.MILIEU));
poland.ajouterJoueur(new Tireur("Góralski", "Kamil", 30, Poste.MILIEU));

poland.ajouterJoueur(new Tireur("Lewandowski", "Robert", 35, Poste.ATTAQUANT));
poland.ajouterJoueur(new Tireur("Świderski", "Karol", 26, Poste.ATTAQUANT));
poland.ajouterJoueur(new Tireur("Milik", "Arkadiusz", 29, Poste.ATTAQUANT));

Equipe polande = jeu.getCoupe().getEquipes().get(15);
polande.ajouterJoueur(new Gardien("Szczęsny", "Wojciech", 34));
polande.ajouterJoueur(new Tireur("Kiwior", "Jakub", 24, Poste.DEFENSEUR));
polande.ajouterJoueur(new Tireur("Bednarek", "Jan", 28, Poste.DEFENSEUR));
polande.ajouterJoueur(new Tireur("Glik", "Kamil", 36, Poste.DEFENSEUR));
polande.ajouterJoueur(new Tireur("Bereszynski", "Bartosz", 31, Poste.DEFENSEUR));

polande.ajouterJoueur(new Tireur("Krychowiak", "Grzegorz", 34, Poste.MILIEU));
polande.ajouterJoueur(new Tireur("Zielinski", "Piotr", 29, Poste.MILIEU));
polande.ajouterJoueur(new Tireur("Góralski", "Kamil", 30, Poste.MILIEU));

polande.ajouterJoueur(new Tireur("Lewandowski", "Robert", 35, Poste.ATTAQUANT));
polande.ajouterJoueur(new Tireur("Świderski", "Karol", 26, Poste.ATTAQUANT));
polande.ajouterJoueur(new Tireur("Milik", "Arkadiusz", 29, Poste.ATTAQUANT));

    }

    public void  DataPL (Jeu jeu){
        // Equipe Manchester City
Equipe city = jeu.getChampionnat().getEquipes().get(0);
city.ajouterJoueur(new Gardien("Ederson", "Santana", 30));
city.ajouterJoueur(new Tireur("Walker", "Kyle", 34, Poste.DEFENSEUR));
city.ajouterJoueur(new Tireur("Stones", "John", 30, Poste.DEFENSEUR));
city.ajouterJoueur(new Tireur("Dias", "Ruben", 27, Poste.DEFENSEUR));
city.ajouterJoueur(new Tireur("Akanji", "Manuel", 28, Poste.DEFENSEUR));

city.ajouterJoueur(new Tireur("Rodri", "Rodriguez", 28, Poste.MILIEU));
city.ajouterJoueur(new Tireur("De Bruyne", "Kevin", 33, Poste.MILIEU));
city.ajouterJoueur(new Tireur("Gundogan", "Ilkay", 33, Poste.MILIEU));

city.ajouterJoueur(new Tireur("Haaland", "Erling", 24, Poste.ATTAQUANT));
city.ajouterJoueur(new Tireur("Foden", "Phil", 24, Poste.ATTAQUANT));
city.ajouterJoueur(new Tireur("Mahrez", "Riyad", 33, Poste.ATTAQUANT));

// Equipe Arsenal
Equipe arsenal = jeu.getChampionnat().getEquipes().get(1);
arsenal.ajouterJoueur(new Gardien("Ramsdale", "Aaron", 26));
arsenal.ajouterJoueur(new Tireur("Ben White", "Benjamin", 26, Poste.DEFENSEUR));
arsenal.ajouterJoueur(new Tireur("Gabriel", "Magalhães", 26, Poste.DEFENSEUR));
arsenal.ajouterJoueur(new Tireur("Saliba", "William", 23, Poste.DEFENSEUR));
arsenal.ajouterJoueur(new Tireur("Zinchenko", "Oleksandr", 27, Poste.DEFENSEUR));

arsenal.ajouterJoueur(new Tireur("Partey", "Thomas", 30, Poste.MILIEU));
arsenal.ajouterJoueur(new Tireur("Xhaka", "Granit", 31, Poste.MILIEU));
arsenal.ajouterJoueur(new Tireur("Odegaard", "Martin", 25, Poste.MILIEU));

arsenal.ajouterJoueur(new Tireur("Saka", "Bukayo", 22, Poste.ATTAQUANT));
arsenal.ajouterJoueur(new Tireur("Nketiah", "Eddie", 25, Poste.ATTAQUANT));
arsenal.ajouterJoueur(new Tireur("Jesus", "Gabriel", 26, Poste.ATTAQUANT));

// Equipe Liverpool
Equipe liverpool = jeu.getChampionnat().getEquipes().get(2);
liverpool.ajouterJoueur(new Gardien("Alisson", "Becker", 31));
liverpool.ajouterJoueur(new Tireur("Alexander-Arnold", "Trent", 26, Poste.DEFENSEUR));
liverpool.ajouterJoueur(new Tireur("Van Dijk", "Virgil", 33, Poste.DEFENSEUR));
liverpool.ajouterJoueur(new Tireur("Gomez", "Joe", 26, Poste.DEFENSEUR));
liverpool.ajouterJoueur(new Tireur("Robertson", "Andrew", 30, Poste.DEFENSEUR));

liverpool.ajouterJoueur(new Tireur("Fabinho", "Fabio", 30, Poste.MILIEU));
liverpool.ajouterJoueur(new Tireur("Henderson", "Jordan", 34, Poste.MILIEU));
liverpool.ajouterJoueur(new Tireur("Salah", "Mohamed", 32, Poste.MILIEU));

liverpool.ajouterJoueur(new Tireur("Nunez", "Darwin", 24, Poste.ATTAQUANT));
liverpool.ajouterJoueur(new Tireur("Diaz", "Luis", 27, Poste.ATTAQUANT));
liverpool.ajouterJoueur(new Tireur("Jota", "Diogo", 27, Poste.ATTAQUANT));

// Equipe Manchester United
Equipe united = jeu.getChampionnat().getEquipes().get(3);
united.ajouterJoueur(new Gardien("De Gea", "David", 33));
united.ajouterJoueur(new Tireur("Shaw", "Luke", 29, Poste.DEFENSEUR));
united.ajouterJoueur(new Tireur("Martinez", "Lisandro", 25, Poste.DEFENSEUR));
united.ajouterJoueur(new Tireur("Varane", "Raphaël", 31, Poste.DEFENSEUR));
united.ajouterJoueur(new Tireur("Dalot", "Diogo", 25, Poste.DEFENSEUR));

united.ajouterJoueur(new Tireur("Casemiro", "Carlos", 32, Poste.MILIEU));
united.ajouterJoueur(new Tireur("Eriksen", "Christian", 32, Poste.MILIEU));
united.ajouterJoueur(new Tireur("Bruno Fernandes", "Bruno", 30, Poste.MILIEU));

united.ajouterJoueur(new Tireur("Rashford", "Marcus", 26, Poste.ATTAQUANT));
united.ajouterJoueur(new Tireur("Antony", "Antony", 23, Poste.ATTAQUANT));
united.ajouterJoueur(new Tireur("Martial", "Anthony", 28, Poste.ATTAQUANT));

// Equipe Chelsea
Equipe chelsea = jeu.getChampionnat().getEquipes().get(4);
chelsea.ajouterJoueur(new Gardien("Kepa", "Arrizabalaga", 30));
chelsea.ajouterJoueur(new Tireur("Thiago Silva", "Thiago", 39, Poste.DEFENSEUR));
chelsea.ajouterJoueur(new Tireur("Chalobah", "Trevoh", 24, Poste.DEFENSEUR));
chelsea.ajouterJoueur(new Tireur("Colwill", "Levi", 21, Poste.DEFENSEUR));
chelsea.ajouterJoueur(new Tireur("Reece James", "Reece", 24, Poste.DEFENSEUR));

chelsea.ajouterJoueur(new Tireur("Enzo Fernandez", "Enzo", 23, Poste.MILIEU));
chelsea.ajouterJoueur(new Tireur("Kovacic", "Mateo", 29, Poste.MILIEU));
chelsea.ajouterJoueur(new Tireur("Sterling", "Raheem", 29, Poste.MILIEU));

chelsea.ajouterJoueur(new Tireur("Jackson", "Nicolas", 22, Poste.ATTAQUANT));
chelsea.ajouterJoueur(new Tireur("Nkunku", "Christopher", 26, Poste.ATTAQUANT));
chelsea.ajouterJoueur(new Tireur("Mudryk", "Mykhailo", 23, Poste.ATTAQUANT));

// Equipe Tottenham
Equipe tottenham = jeu.getChampionnat().getEquipes().get(5);
tottenham.ajouterJoueur(new Gardien("Vicario", "Guglielmo", 27));
tottenham.ajouterJoueur(new Tireur("Romero", "Cristian", 26, Poste.DEFENSEUR));
tottenham.ajouterJoueur(new Tireur("Dier", "Eric", 30, Poste.DEFENSEUR));
tottenham.ajouterJoueur(new Tireur("Udogie", "Destiny", 21, Poste.DEFENSEUR));
tottenham.ajouterJoueur(new Tireur("Emerson", "Royal", 25, Poste.DEFENSEUR));

tottenham.ajouterJoueur(new Tireur("Bissouma", "Yves", 27, Poste.MILIEU));
tottenham.ajouterJoueur(new Tireur("Madueke", "Noni", 21, Poste.MILIEU));
tottenham.ajouterJoueur(new Tireur("Son", "Heung-min", 31, Poste.MILIEU));

tottenham.ajouterJoueur(new Tireur("Richarlison", "Richarlison", 26, Poste.ATTAQUANT));
tottenham.ajouterJoueur(new Tireur("Kane", "Harry", 30, Poste.ATTAQUANT));
tottenham.ajouterJoueur(new Tireur("Kulusevski", "Dejan", 24, Poste.ATTAQUANT));

// Equipe Newcastle
Equipe newcastle = jeu.getChampionnat().getEquipes().get(6);
newcastle.ajouterJoueur(new Gardien("Pope", "Nick", 32));
newcastle.ajouterJoueur(new Tireur("Trippier", "Kieran", 34, Poste.DEFENSEUR));
newcastle.ajouterJoueur(new Tireur("Schar", "Fabian", 32, Poste.DEFENSEUR));
newcastle.ajouterJoueur(new Tireur("Burn", "Dan", 32, Poste.DEFENSEUR));
newcastle.ajouterJoueur(new Tireur("Targett", "Matt", 28, Poste.DEFENSEUR));

newcastle.ajouterJoueur(new Tireur("Guimaraes", "Bruno", 26, Poste.MILIEU));
newcastle.ajouterJoueur(new Tireur("Longstaff", "Sean", 26, Poste.MILIEU));
newcastle.ajouterJoueur(new Tireur("Joelinton", "Joelinton", 28, Poste.MILIEU));

newcastle.ajouterJoueur(new Tireur("Wilson", "Callum", 32, Poste.ATTAQUANT));
newcastle.ajouterJoueur(new Tireur("Almiron", "Miguel", 30, Poste.ATTAQUANT));
newcastle.ajouterJoueur(new Tireur("Isak", "Alexander", 24, Poste.ATTAQUANT));

// Equipe Brighton
Equipe brighton = jeu.getChampionnat().getEquipes().get(7);
brighton.ajouterJoueur(new Gardien("Sanchez", "Robert", 25));
brighton.ajouterJoueur(new Tireur("Veltman", "Joel", 32, Poste.DEFENSEUR));
brighton.ajouterJoueur(new Tireur("Webster", "Lewis", 28, Poste.DEFENSEUR));
brighton.ajouterJoueur(new Tireur("Estupinan", "Pervis", 26, Poste.DEFENSEUR));
brighton.ajouterJoueur(new Tireur("Dunk", "Lewis", 32, Poste.DEFENSEUR));

brighton.ajouterJoueur(new Tireur("Caicedo", "Moises", 22, Poste.MILIEU));
brighton.ajouterJoueur(new Tireur("Mwepu", "Enock", 26, Poste.MILIEU));
brighton.ajouterJoueur(new Tireur("Gross", "Pascal", 32, Poste.MILIEU));

brighton.ajouterJoueur(new Tireur("Mitoma", "Kaoru", 27, Poste.ATTAQUANT));
brighton.ajouterJoueur(new Tireur("Welbeck", "Danny", 33, Poste.ATTAQUANT));
brighton.ajouterJoueur(new Tireur("Undav", "Deniz", 27, Poste.ATTAQUANT));

// Equipe Aston Villa
Equipe aston = jeu.getChampionnat().getEquipes().get(8);
aston.ajouterJoueur(new Gardien("Martinez", "Emiliano", 32));
aston.ajouterJoueur(new Tireur("Cash", "Matty", 27, Poste.DEFENSEUR));
aston.ajouterJoueur(new Tireur("Mings", "Tyrone", 31, Poste.DEFENSEUR));
aston.ajouterJoueur(new Tireur("Konza", "Ezri", 26, Poste.DEFENSEUR));
aston.ajouterJoueur(new Tireur("Digne", "Lucas", 30, Poste.DEFENSEUR));

aston.ajouterJoueur(new Tireur("Douglas Luiz", "Douglas", 26, Poste.MILIEU));
aston.ajouterJoueur(new Tireur("McGinn", "John", 30, Poste.MILIEU));
aston.ajouterJoueur(new Tireur("Kamara", "Boubacar", 24, Poste.MILIEU));

aston.ajouterJoueur(new Tireur("Watkins", "Ollie", 28, Poste.ATTAQUANT));
aston.ajouterJoueur(new Tireur("Ings", "Danny", 31, Poste.ATTAQUANT));
aston.ajouterJoueur(new Tireur("Bailey", "Leon", 26, Poste.ATTAQUANT));

// Equipe West Ham
Equipe westHam = jeu.getChampionnat().getEquipes().get(9);
westHam.ajouterJoueur(new Gardien("Fabianski", "Lukasz", 38));
westHam.ajouterJoueur(new Tireur("Coufal", "Vladimir", 31, Poste.DEFENSEUR));
westHam.ajouterJoueur(new Tireur("Zouma", "Kurt", 29, Poste.DEFENSEUR));
westHam.ajouterJoueur(new Tireur("Aguerd", "Nayef", 27, Poste.DEFENSEUR));
westHam.ajouterJoueur(new Tireur("Cresswell", "Aaron", 34, Poste.DEFENSEUR));

westHam.ajouterJoueur(new Tireur("Rice", "Declan", 25, Poste.MILIEU));
westHam.ajouterJoueur(new Tireur("Soucek", "Tomas", 29, Poste.MILIEU));
westHam.ajouterJoueur(new Tireur("Benrahma", "Said", 28, Poste.MILIEU));

westHam.ajouterJoueur(new Tireur("Antonio", "Michail", 34, Poste.ATTAQUANT));
westHam.ajouterJoueur(new Tireur("Bowen", "Jarrod", 27, Poste.ATTAQUANT));
westHam.ajouterJoueur(new Tireur("Ings", "Danny", 31, Poste.ATTAQUANT));

// Equipe Crystal Palace
Equipe crystal = jeu.getChampionnat().getEquipes().get(10);
crystal.ajouterJoueur(new Gardien("Guaita", "Vicente", 37));
crystal.ajouterJoueur(new Tireur("Ward", "Joel", 30, Poste.DEFENSEUR));
crystal.ajouterJoueur(new Tireur("Andersen", "Joachim", 27, Poste.DEFENSEUR));
crystal.ajouterJoueur(new Tireur("Mitchell", "Tyrick", 24, Poste.DEFENSEUR));
crystal.ajouterJoueur(new Tireur("Clyne", "Nathaniel", 33, Poste.DEFENSEUR));

crystal.ajouterJoueur(new Tireur("Schlupp", "Jeffrey", 31, Poste.MILIEU));
crystal.ajouterJoueur(new Tireur("Eze", "Michael", 25, Poste.MILIEU));
crystal.ajouterJoueur(new Tireur("Ayew", "Jordan", 32, Poste.MILIEU));

crystal.ajouterJoueur(new Tireur("Zaha", "Wilfried", 31, Poste.ATTAQUANT));
crystal.ajouterJoueur(new Tireur("Edouard", "Odsonne", 26, Poste.ATTAQUANT));
crystal.ajouterJoueur(new Tireur("Mateta", "Jean-Philippe", 26, Poste.ATTAQUANT));

// Equipe Fulham
Equipe fulham = jeu.getChampionnat().getEquipes().get(11);
fulham.ajouterJoueur(new Gardien("Leno", "Bernd", 32));
fulham.ajouterJoueur(new Tireur("Tete", "Kenny", 28, Poste.DEFENSEUR));
fulham.ajouterJoueur(new Tireur("Adarabioyo", "Tosin", 26, Poste.DEFENSEUR));
fulham.ajouterJoueur(new Tireur("Ream", "Tim", 36, Poste.DEFENSEUR));
fulham.ajouterJoueur(new Tireur("Robinson", "Antonee", 26, Poste.DEFENSEUR));

fulham.ajouterJoueur(new Tireur("Pereira", "Andreas", 28, Poste.MILIEU));
fulham.ajouterJoueur(new Tireur("Palhinha", "Joao", 28, Poste.MILIEU));
fulham.ajouterJoueur(new Tireur("Harrison Reed", "Reed", 28, Poste.MILIEU));

fulham.ajouterJoueur(new Tireur("Mitrovic", "Aleksandar", 29, Poste.ATTAQUANT));
fulham.ajouterJoueur(new Tireur("James", "Willian", 32, Poste.ATTAQUANT));
fulham.ajouterJoueur(new Tireur("Wilson", "Harry", 27, Poste.ATTAQUANT));

// Equipe Wolverhampton
Equipe wolverhampton = jeu.getChampionnat().getEquipes().get(12);
wolverhampton.ajouterJoueur(new Gardien("Sarr", "Boubacar", 29));
wolverhampton.ajouterJoueur(new Tireur("Semedo", "Nelson", 30, Poste.DEFENSEUR));
wolverhampton.ajouterJoueur(new Tireur("Kilman", "Max", 26, Poste.DEFENSEUR));
wolverhampton.ajouterJoueur(new Tireur("Collins", "Nathan", 26, Poste.DEFENSEUR));
wolverhampton.ajouterJoueur(new Tireur("Ait-Nouri", "Rayan", 23, Poste.DEFENSEUR));

wolverhampton.ajouterJoueur(new Tireur("Neves", "Ruben", 27, Poste.MILIEU));
wolverhampton.ajouterJoueur(new Tireur("Nunes", "Matheus", 25, Poste.MILIEU));
wolverhampton.ajouterJoueur(new Tireur("Moutinho", "João", 37, Poste.MILIEU));

wolverhampton.ajouterJoueur(new Tireur("Hwang", "Hee-Chan", 27, Poste.ATTAQUANT));
wolverhampton.ajouterJoueur(new Tireur("Costa", "Diego", 35, Poste.ATTAQUANT));
wolverhampton.ajouterJoueur(new Tireur("Podence", "Daniel", 28, Poste.ATTAQUANT));

// Equipe Everton
Equipe everton = jeu.getChampionnat().getEquipes().get(13);
everton.ajouterJoueur(new Gardien("Pickford", "Jordan", 30));
everton.ajouterJoueur(new Tireur("Coleman", "Seamus", 35, Poste.DEFENSEUR));
everton.ajouterJoueur(new Tireur("Tarkowski", "James", 31, Poste.DEFENSEUR));
everton.ajouterJoueur(new Tireur("Mina", "Yerry", 29, Poste.DEFENSEUR));
everton.ajouterJoueur(new Tireur("Godfrey", "Ben", 26, Poste.DEFENSEUR));

everton.ajouterJoueur(new Tireur("Onana", "Amadou", 22, Poste.MILIEU));
everton.ajouterJoueur(new Tireur("Gueye", "Idrissa", 34, Poste.MILIEU));
everton.ajouterJoueur(new Tireur("Iwobi", "Alex", 28, Poste.MILIEU));

everton.ajouterJoueur(new Tireur("Calvert-Lewin", "Dominic", 26, Poste.ATTAQUANT));
everton.ajouterJoueur(new Tireur("McNeil", "Dwight", 23, Poste.ATTAQUANT));
everton.ajouterJoueur(new Tireur("Gordon", "Anthony", 23, Poste.ATTAQUANT));

// Equipe Brentford
Equipe brentford = jeu.getChampionnat().getEquipes().get(14);
brentford.ajouterJoueur(new Gardien("Raya", "David", 28));
brentford.ajouterJoueur(new Tireur("Jansson", "Pontus", 32, Poste.DEFENSEUR));
brentford.ajouterJoueur(new Tireur("Mee", "Ben", 34, Poste.DEFENSEUR));
brentford.ajouterJoueur(new Tireur("Hickey", "Aaron", 22, Poste.DEFENSEUR));
brentford.ajouterJoueur(new Tireur("Rico Henry", "Rico", 26, Poste.DEFENSEUR));

brentford.ajouterJoueur(new Tireur("Janelt", "Vitaly", 25, Poste.MILIEU));
brentford.ajouterJoueur(new Tireur("Norgaard", "Christian", 29, Poste.MILIEU));
brentford.ajouterJoueur(new Tireur("Mbeumo", "Bryan", 24, Poste.MILIEU));

brentford.ajouterJoueur(new Tireur("Toney", "Ivan", 28, Poste.ATTAQUANT));
brentford.ajouterJoueur(new Tireur("Wissa", "Yoane", 27, Poste.ATTAQUANT));
brentford.ajouterJoueur(new Tireur("Baptiste", "Shandon", 23, Poste.ATTAQUANT));

// Equipe Bournemouth
Equipe bournemouth = jeu.getChampionnat().getEquipes().get(15);
bournemouth.ajouterJoueur(new Gardien("Neto", "Marcelo", 34));
bournemouth.ajouterJoueur(new Tireur("Kelly", "Mark", 24, Poste.DEFENSEUR));
bournemouth.ajouterJoueur(new Tireur("Senesi", "Marcos", 26, Poste.DEFENSEUR));
bournemouth.ajouterJoueur(new Tireur("Zemura", "Musa", 25, Poste.DEFENSEUR));
bournemouth.ajouterJoueur(new Tireur("Smith", "Jack", 32, Poste.DEFENSEUR));

bournemouth.ajouterJoueur(new Tireur("Lerma", "Jefferson", 29, Poste.MILIEU));
bournemouth.ajouterJoueur(new Tireur("Billing", "Philip", 27, Poste.MILIEU));
bournemouth.ajouterJoueur(new Tireur("Christie", "Ryan", 26, Poste.MILIEU));

bournemouth.ajouterJoueur(new Tireur("Solanke", "Dominic", 26, Poste.ATTAQUANT));
bournemouth.ajouterJoueur(new Tireur("Moore", "Kieffer", 31, Poste.ATTAQUANT));
bournemouth.ajouterJoueur(new Tireur("Ouattara", "Ibrahime", 22, Poste.ATTAQUANT));

    }

    public void  DataLaliga (Jeu jeu){
        // Equipe Real Madrid
Equipe madrid = jeu.getChampionnat().getEquipes().get(0);
madrid.ajouterJoueur(new Gardien("Courtois", "Thibaut", 32));
madrid.ajouterJoueur(new Tireur("Alaba", "David", 31, Poste.DEFENSEUR));
madrid.ajouterJoueur(new Tireur("Militao", "Eder", 26, Poste.DEFENSEUR));
madrid.ajouterJoueur(new Tireur("Carvajal", "Dani", 32, Poste.DEFENSEUR));
madrid.ajouterJoueur(new Tireur("Mendy", "Ferland", 28, Poste.DEFENSEUR));

madrid.ajouterJoueur(new Tireur("Modric", "Luka", 38, Poste.MILIEU));
madrid.ajouterJoueur(new Tireur("Kroos", "Toni", 34, Poste.MILIEU));
madrid.ajouterJoueur(new Tireur("Valverde", "Federico", 26, Poste.MILIEU));

madrid.ajouterJoueur(new Tireur("Benzema", "Karim", 36, Poste.ATTAQUANT));
madrid.ajouterJoueur(new Tireur("Vinicius", "Júnior", 23, Poste.ATTAQUANT));
madrid.ajouterJoueur(new Tireur("Rodrygo", "Rodrygo", 23, Poste.ATTAQUANT));

// Equipe Barcelona
Equipe barcelona = jeu.getChampionnat().getEquipes().get(1);
barcelona.ajouterJoueur(new Gardien("Ter Stegen", "Marc-André", 31));
barcelona.ajouterJoueur(new Tireur("Piqué", "Gerard", 37, Poste.DEFENSEUR));
barcelona.ajouterJoueur(new Tireur("Koundé", "Jules", 25, Poste.DEFENSEUR));
barcelona.ajouterJoueur(new Tireur("Araujo", "Ronald", 24, Poste.DEFENSEUR));
barcelona.ajouterJoueur(new Tireur("Balde", "Jordi", 20, Poste.DEFENSEUR));

barcelona.ajouterJoueur(new Tireur("De Jong", "Frenkie", 26, Poste.MILIEU));
barcelona.ajouterJoueur(new Tireur("Pedri", "Pedro", 21, Poste.MILIEU));
barcelona.ajouterJoueur(new Tireur("Gavi", "Pablo", 19, Poste.MILIEU));

barcelona.ajouterJoueur(new Tireur("Lewandowski", "Robert", 36, Poste.ATTAQUANT));
barcelona.ajouterJoueur(new Tireur("Raphinha", "Raphael", 27, Poste.ATTAQUANT));
barcelona.ajouterJoueur(new Tireur("Ansu Fati", "Ansu", 21, Poste.ATTAQUANT));

// Equipe Atletico Madrid
Equipe atletico = jeu.getChampionnat().getEquipes().get(2);
atletico.ajouterJoueur(new Gardien("Oblak", "Jan", 31));
atletico.ajouterJoueur(new Tireur("Savic", "Stefan", 33, Poste.DEFENSEUR));
atletico.ajouterJoueur(new Tireur("Felipe", "Felipe", 35, Poste.DEFENSEUR));
atletico.ajouterJoueur(new Tireur("Trippier", "Kieran", 33, Poste.DEFENSEUR));
atletico.ajouterJoueur(new Tireur("Lodi", "Renan", 26, Poste.DEFENSEUR));

atletico.ajouterJoueur(new Tireur("Koke", "Jorge", 32, Poste.MILIEU));
atletico.ajouterJoueur(new Tireur("Llorente", "Marcos", 29, Poste.MILIEU));
atletico.ajouterJoueur(new Tireur("Saul", "Saul", 29, Poste.MILIEU));

atletico.ajouterJoueur(new Tireur("Griezmann", "Antoine", 32, Poste.ATTAQUANT));
atletico.ajouterJoueur(new Tireur("Morata", "Álvaro", 31, Poste.ATTAQUANT));
atletico.ajouterJoueur(new Tireur("Correa", "Ángel", 29, Poste.ATTAQUANT));

// Equipe Sevilla
Equipe sevilla = jeu.getChampionnat().getEquipes().get(3);
sevilla.ajouterJoueur(new Gardien("Bono", "Yassine", 33));
sevilla.ajouterJoueur(new Tireur("Koundé", "Jules", 25, Poste.DEFENSEUR));
sevilla.ajouterJoueur(new Tireur("Carlos", "Diego", 26, Poste.DEFENSEUR));
sevilla.ajouterJoueur(new Tireur("Navas", "Jesús", 38, Poste.DEFENSEUR));
sevilla.ajouterJoueur(new Tireur("Acuña", "Marcos", 32, Poste.DEFENSEUR));

sevilla.ajouterJoueur(new Tireur("Rakitic", "Ivan", 36, Poste.MILIEU));
sevilla.ajouterJoueur(new Tireur("Fernando", "Fernando", 36, Poste.MILIEU));
sevilla.ajouterJoueur(new Tireur("Gudelj", "Nemanja", 31, Poste.MILIEU));

sevilla.ajouterJoueur(new Tireur("En-Nesyri", "Youssef", 26, Poste.ATTAQUANT));
sevilla.ajouterJoueur(new Tireur("Lamelá", "Erik", 32, Poste.ATTAQUANT));
sevilla.ajouterJoueur(new Tireur("Rafa Mir", "Rafa", 26, Poste.ATTAQUANT));

// Equipe Real Sociedad
Equipe sociedad = jeu.getChampionnat().getEquipes().get(4);
sociedad.ajouterJoueur(new Gardien("Remiro", "Alex", 28));
sociedad.ajouterJoueur(new Tireur("Le Normand", "Aritz", 27, Poste.DEFENSEUR));
sociedad.ajouterJoueur(new Tireur("Zubeldia", "Jon", 25, Poste.DEFENSEUR));
sociedad.ajouterJoueur(new Tireur("Oyarzabal", "Mikel", 26, Poste.MILIEU));
sociedad.ajouterJoueur(new Tireur("Zubimendi", "Martin", 24, Poste.MILIEU));

sociedad.ajouterJoueur(new Tireur("Isak", "Alexander", 24, Poste.ATTAQUANT));
sociedad.ajouterJoueur(new Tireur("Kubo", "Takefusa", 23, Poste.ATTAQUANT));
sociedad.ajouterJoueur(new Tireur("Sorloth", "Alexander", 28, Poste.ATTAQUANT));

// Equipe Betis
Equipe betis = jeu.getChampionnat().getEquipes().get(5);
betis.ajouterJoueur(new Gardien("Bravo", "Claudio", 41));
betis.ajouterJoueur(new Tireur("Pezzella", "Germán", 32, Poste.DEFENSEUR));
betis.ajouterJoueur(new Tireur("Ruiz", "Edgar", 26, Poste.DEFENSEUR));
betis.ajouterJoueur(new Tireur("Canales", "Sergio", 32, Poste.MILIEU));
betis.ajouterJoueur(new Tireur("Guardado", "Andrés", 37, Poste.MILIEU));

betis.ajouterJoueur(new Tireur("Fekir", "Nabil", 30, Poste.ATTAQUANT));
betis.ajouterJoueur(new Tireur("Juanmi", "Juan", 31, Poste.ATTAQUANT));
betis.ajouterJoueur(new Tireur("Joaquín", "Joaquín", 42, Poste.ATTAQUANT));

// Equipe Villarreal
Equipe villarreal = jeu.getChampionnat().getEquipes().get(6);
villarreal.ajouterJoueur(new Gardien("Rulli", "Gerónimo", 32));
villarreal.ajouterJoueur(new Tireur("Albiol", "Raúl", 38, Poste.DEFENSEUR));
villarreal.ajouterJoueur(new Tireur("Foyth", "Juan", 26, Poste.DEFENSEUR));
villarreal.ajouterJoueur(new Tireur("Parejo", "Dani", 35, Poste.MILIEU));
villarreal.ajouterJoueur(new Tireur("Trigueros", "Manu", 31, Poste.MILIEU));

villarreal.ajouterJoueur(new Tireur("Lo Celso", "Giovani", 28, Poste.ATTAQUANT));
villarreal.ajouterJoueur(new Tireur("Morales", "José", 36, Poste.ATTAQUANT));
villarreal.ajouterJoueur(new Tireur("Danjuma", "Arnaut", 27, Poste.ATTAQUANT));

// Equipe Valencia
Equipe valencia = jeu.getChampionnat().getEquipes().get(7);
valencia.ajouterJoueur(new Gardien("Mamardashvili", "Giorgi", 23));
valencia.ajouterJoueur(new Tireur("Diakhaby", "Mouctar", 27, Poste.DEFENSEUR));
valencia.ajouterJoueur(new Tireur("Gaya", "Jose Luis", 28, Poste.DEFENSEUR));
valencia.ajouterJoueur(new Tireur(" Paulista", "Gabriel", 33, Poste.DEFENSEUR));
valencia.ajouterJoueur(new Tireur("Vezo", "Ricard", 29, Poste.DEFENSEUR));

valencia.ajouterJoueur(new Tireur("Kondogbia", "Geoffrey", 31, Poste.MILIEU));
valencia.ajouterJoueur(new Tireur("Soler", "Carlos", 26, Poste.MILIEU));
valencia.ajouterJoueur(new Tireur("Musah", "Yunus", 21, Poste.MILIEU));

valencia.ajouterJoueur(new Tireur("Guedes", "Gonçalo", 27, Poste.ATTAQUANT));
valencia.ajouterJoueur(new Tireur("Lato", "Toni", 24, Poste.ATTAQUANT));
valencia.ajouterJoueur(new Tireur("Cavani", "Edinson", 37, Poste.ATTAQUANT));

// Equipe Athletic Bilbao
Equipe athletic = jeu.getChampionnat().getEquipes().get(8);
athletic.ajouterJoueur(new Gardien("Unai Simón", "Unai", 26));
athletic.ajouterJoueur(new Tireur("Yeray", "Álvar", 28, Poste.DEFENSEUR));
athletic.ajouterJoueur(new Tireur("Iñigo", "Martínez", 33, Poste.DEFENSEUR));
athletic.ajouterJoueur(new Tireur("De Marcos", "Ander", 35, Poste.DEFENSEUR));
athletic.ajouterJoueur(new Tireur("Balenziaga", "Mikel", 35, Poste.DEFENSEUR));

athletic.ajouterJoueur(new Tireur("Dani García", "Dani", 34, Poste.MILIEU));
athletic.ajouterJoueur(new Tireur("Zarraga", "Oier", 24, Poste.MILIEU));
athletic.ajouterJoueur(new Tireur("Vencedor", "Unai", 25, Poste.MILIEU));

athletic.ajouterJoueur(new Tireur("Iñaki Williams", "Iñaki", 30, Poste.ATTAQUANT));
athletic.ajouterJoueur(new Tireur("Álex Berenguer", "Álex", 28, Poste.ATTAQUANT));
athletic.ajouterJoueur(new Tireur("Raúl García", "Raúl", 37, Poste.ATTAQUANT));

// Equipe Celta Vigo
Equipe vigo = jeu.getChampionnat().getEquipes().get(9);
vigo.ajouterJoueur(new Gardien("Iván Villar", "Iván", 26));
vigo.ajouterJoueur(new Tireur("Aidoo", "Joseph", 29, Poste.DEFENSEUR));
vigo.ajouterJoueur(new Tireur("Mallo", "Hugo", 32, Poste.DEFENSEUR));
vigo.ajouterJoueur(new Tireur("Araujo", "Jeison", 28, Poste.DEFENSEUR));
vigo.ajouterJoueur(new Tireur("Junca", "Carlos", 28, Poste.DEFENSEUR));

vigo.ajouterJoueur(new Tireur("Brais Méndez", "Brais", 26, Poste.MILIEU));
vigo.ajouterJoueur(new Tireur("Beltrán", "Fran", 24, Poste.MILIEU));
vigo.ajouterJoueur(new Tireur("Tapia", "Renato", 28, Poste.MILIEU));

vigo.ajouterJoueur(new Tireur("Aspas", "Iago", 36, Poste.ATTAQUANT));
vigo.ajouterJoueur(new Tireur("Santi Mina", "Santi", 28, Poste.ATTAQUANT));
vigo.ajouterJoueur(new Tireur("Cervi", "Franco", 27, Poste.ATTAQUANT));

// Equipe Osasuna
Equipe osasuna = jeu.getChampionnat().getEquipes().get(10);
osasuna.ajouterJoueur(new Gardien("Sergio Herrera", "Sergio", 31));
osasuna.ajouterJoueur(new Tireur("David García", "David", 30, Poste.DEFENSEUR));
osasuna.ajouterJoueur(new Tireur("Aridane", "José", 33, Poste.DEFENSEUR));
osasuna.ajouterJoueur(new Tireur("Unai García", "Unai", 31, Poste.DEFENSEUR));
osasuna.ajouterJoueur(new Tireur("Juan Cruz", "Juan", 29, Poste.DEFENSEUR));

osasuna.ajouterJoueur(new Tireur("Torres", "Javi", 28, Poste.MILIEU));
osasuna.ajouterJoueur(new Tireur("Barja", "Rubén", 28, Poste.MILIEU));
osasuna.ajouterJoueur(new Tireur("Oier", "Oier", 34, Poste.MILIEU));

osasuna.ajouterJoueur(new Tireur("Budimir", "Ante", 32, Poste.ATTAQUANT));
osasuna.ajouterJoueur(new Tireur("Kike García", "Kike", 35, Poste.ATTAQUANT));
osasuna.ajouterJoueur(new Tireur("Ávila", "Chimy", 29, Poste.ATTAQUANT));

// Equipe Espanyol
Equipe espanyol = jeu.getChampionnat().getEquipes().get(11);
espanyol.ajouterJoueur(new Gardien("Diego López", "Diego", 43));
espanyol.ajouterJoueur(new Tireur("David López", "David", 33, Poste.DEFENSEUR));
espanyol.ajouterJoueur(new Tireur("Cabrera", "Leandro", 31, Poste.DEFENSEUR));
espanyol.ajouterJoueur(new Tireur("Pedrosa", "Adrián", 27, Poste.DEFENSEUR));
espanyol.ajouterJoueur(new Tireur("Víctor Gómez", "Víctor", 25, Poste.DEFENSEUR));

espanyol.ajouterJoueur(new Tireur("Vargas", "Javi", 30, Poste.MILIEU));
espanyol.ajouterJoueur(new Tireur("Morlanes", "Álex", 24, Poste.MILIEU));
espanyol.ajouterJoueur(new Tireur("Sergi Darder", "Sergi", 30, Poste.MILIEU));

espanyol.ajouterJoueur(new Tireur("Raúl de Tomás", "Raúl", 29, Poste.ATTAQUANT));
espanyol.ajouterJoueur(new Tireur("Puado", "Javi", 25, Poste.ATTAQUANT));
espanyol.ajouterJoueur(new Tireur("Embarba", "Adrián", 31, Poste.ATTAQUANT));

// Equipe Mallorca
Equipe mallorca = jeu.getChampionnat().getEquipes().get(12);
mallorca.ajouterJoueur(new Gardien("Rajkovic", "Predrag", 29));
mallorca.ajouterJoueur(new Tireur("Valjent", "Martin", 27, Poste.DEFENSEUR));
mallorca.ajouterJoueur(new Tireur("Raíllo", "Antonio", 30, Poste.DEFENSEUR));
mallorca.ajouterJoueur(new Tireur("Maffeo", "Antonio", 27, Poste.DEFENSEUR));
mallorca.ajouterJoueur(new Tireur("Cufré", "Francesco", 27, Poste.DEFENSEUR));

mallorca.ajouterJoueur(new Tireur("Salva Sevilla", "Salva", 38, Poste.MILIEU));
mallorca.ajouterJoueur(new Tireur("Rodríguez", "Antonio", 28, Poste.MILIEU));
mallorca.ajouterJoueur(new Tireur("Baba", "Ibrahim", 29, Poste.MILIEU));

mallorca.ajouterJoueur(new Tireur("Ángel", "Ángel", 36, Poste.ATTAQUANT));
mallorca.ajouterJoueur(new Tireur("Murilo", "Murilo", 22, Poste.ATTAQUANT));
mallorca.ajouterJoueur(new Tireur("Muriqi", "Vedat", 29, Poste.ATTAQUANT));


// Equipe Granada
Equipe granada = jeu.getChampionnat().getEquipes().get(13);
granada.ajouterJoueur(new Gardien("Maximiano", "Luis", 24));
granada.ajouterJoueur(new Tireur("González", "Carlos", 29, Poste.DEFENSEUR));
granada.ajouterJoueur(new Tireur("Cuenca", "Carlos", 26, Poste.DEFENSEUR));
granada.ajouterJoueur(new Tireur("Víctor Díaz", "Víctor", 34, Poste.DEFENSEUR));
granada.ajouterJoueur(new Tireur("Baja", "Raúl", 31, Poste.DEFENSEUR));

granada.ajouterJoueur(new Tireur("Azeez", "Oghenekaro", 30, Poste.MILIEU));
granada.ajouterJoueur(new Tireur("Puertas", "Antonio", 31, Poste.MILIEU));
granada.ajouterJoueur(new Tireur("Gonalons", "Maxime", 34, Poste.MILIEU));

granada.ajouterJoueur(new Tireur("Soria", "Jorge", 26, Poste.ATTAQUANT));
granada.ajouterJoueur(new Tireur("Soldado", "Roberto", 38, Poste.ATTAQUANT));
granada.ajouterJoueur(new Tireur("Luis Suárez", "Luis", 27, Poste.ATTAQUANT));

// Equipe Alaves
Equipe alaves = jeu.getChampionnat().getEquipes().get(14);
alaves.ajouterJoueur(new Gardien("Pacheco", "Fernando", 32));
alaves.ajouterJoueur(new Tireur("Magallán", "Lisandro", 30, Poste.DEFENSEUR));
alaves.ajouterJoueur(new Tireur("Lejeune", "Florian", 32, Poste.DEFENSEUR));
alaves.ajouterJoueur(new Tireur("Escalante", "Fernando", 32, Poste.DEFENSEUR));
alaves.ajouterJoueur(new Tireur("Ximo", "Ximo", 28, Poste.DEFENSEUR));

alaves.ajouterJoueur(new Tireur("Rovira", "Rubén", 29, Poste.MILIEU));
alaves.ajouterJoueur(new Tireur("Pina", "José", 35, Poste.MILIEU));
alaves.ajouterJoueur(new Tireur("Javi López", "Javi", 28, Poste.MILIEU));

alaves.ajouterJoueur(new Tireur("José Luis", "José Luis", 30, Poste.ATTAQUANT));
alaves.ajouterJoueur(new Tireur("Bebé", "Tiago", 33, Poste.ATTAQUANT));
alaves.ajouterJoueur(new Tireur("Joselu", "José", 34, Poste.ATTAQUANT));

// Equipe Getafe
Equipe getafe = jeu.getChampionnat().getEquipes().get(15);
getafe.ajouterJoueur(new Gardien("Soria", "David", 32));
getafe.ajouterJoueur(new Tireur("Djené", "Djené", 32, Poste.DEFENSEUR));
getafe.ajouterJoueur(new Tireur("Damián", "Damián", 34, Poste.DEFENSEUR));
getafe.ajouterJoueur(new Tireur("Maksimović", "Nemanja", 30, Poste.DEFENSEUR));
getafe.ajouterJoueur(new Tireur("Mitrovic", "Filip", 31, Poste.DEFENSEUR));

getafe.ajouterJoueur(new Tireur("Arambarri", "Mauro", 28, Poste.MILIEU));
getafe.ajouterJoueur(new Tireur("Mata", "Jorge", 30, Poste.MILIEU));
getafe.ajouterJoueur(new Tireur("Ndiaye", "Ibrahima", 29, Poste.MILIEU));

getafe.ajouterJoueur(new Tireur("Enes Ünal", "Enes", 26, Poste.ATTAQUANT));
getafe.ajouterJoueur(new Tireur("Sergio", "Sergio", 30, Poste.ATTAQUANT));
getafe.ajouterJoueur(new Tireur("Bordalas", "José", 32, Poste.ATTAQUANT));

    }
}


        