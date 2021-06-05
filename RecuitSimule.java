package com.codewithanas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RecuitSimule extends Method{

    public RecuitSimule() {
        super();
    }
    public RecuitSimule(ArrayList<Objet> objets, int capacite) {
        super(objets, capacite);
    }

    private Solution genererSolutionAleatoir(Solution s)
    {
        ArrayList<Solution> voisins = getVoisins(s);
        return (voisins.get((int)Math.floor(Math.random()*(voisins.size() - 1))));
    }

    public Solution solution() {
        SacDos sac = new SacDos(this.objets,this.capacite);
        Solution solutionCourante = sac.glouton1();
        Solution meilleurSol = solutionCourante;

        double temperature = 1000;
        while ( temperature > 1 ){
            boolean conditionEquilibre = false;
            do {
                Solution solutionAleatoire = genererSolutionAleatoir(solutionCourante);
                if ( boltezman(solutionCourante, solutionAleatoire, temperature) > Math.random()){
                    solutionCourante = solutionAleatoire;
                    conditionEquilibre = true;
                }
            } while (!conditionEquilibre);
            if (solutionCourante.getValeur() >= meilleurSol.getValeur())
                meilleurSol = solutionCourante;
            temperature = temperature / 10;
        }
        return meilleurSol;
    }

    private double boltezman(Solution solutionCourante, Solution solutionAleatoire, double temperature) {
        if ( solutionCourante.getValeur() < solutionAleatoire.getValeur())
            return 1.0;
        else
            return Math.exp((solutionAleatoire.getValeur() - solutionCourante.getValeur()) / temperature);
    }

}
