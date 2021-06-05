package com.codewithanas;

import java.util.ArrayList;
import java.util.Collections;

public class Descente  extends Method{

    public Descente()
    {
        super();
    }

    public Descente(ArrayList<Objet> objets, int capacite) {
        super(objets,capacite);
    }

    private Solution getMaxVoisin(ArrayList<Solution> voisins)
    {
        double max = voisins.get(0).getValeur();
        int indice = 0;
        for (int i = 0; i < voisins.size(); i++)
        {
            if (voisins.get(i).getValeur() > max)
            {
                max = voisins.get(i).getValeur();
                indice = i;
            }
        }
        return voisins.get(indice);
    }

    public Solution solution()
    {
        SacDos sac = new SacDos(this.objets,this.capacite);
        Solution solution = sac.glouton1();

        while (true)
        {
            System.out.println("initial : " + solution.toString());
            ArrayList<Solution> voisins = getVoisins(solution);
            Solution maxVoisin = getMaxVoisin(voisins);
            if(solution.getValeur() >=  maxVoisin.getValeur())
                break;
            else
                solution = maxVoisin;
        }
        return solution;
    }

}
