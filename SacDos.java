package com.codewithanas;

import java.util.ArrayList;
import java.util.Collections;

public class SacDos {

    private ArrayList<Objet> objets;
    private int capacite;

    private boolean addInSac(Objet objet, ArrayList<Double> rapport, int poids) {
        double r = (double)objet.getValeur()/objet.getPoids();
        if(r == Collections.max(rapport) && (poids + objet.getPoids()) <= capacite)
            return true;
        return false;
    }
    private boolean exitSac(int poids)
    {
        for (int j = 0; j < this.objets.size(); j++) {
            if ((poids + this.objets.get(j).getPoids()) <= capacite)
                return false;
        }
        return true;
    }
    public SacDos(ArrayList<Objet> objets, int capacite) {
        this.objets = objets;
        this.capacite = capacite;
    }

    public Solution glouton1() {
        int poids = 0;
        Solution s = new Solution();
        ArrayList<Boolean> instance = new ArrayList<>();
        ArrayList<Double> rappot = new ArrayList<>();

        for (int j = 0; j < this.objets.size(); j++) {
            instance.add(false);
            rappot.add((double)objets.get(j).getValeur()/objets.get(j).getPoids());
        }
        while (poids < capacite && !exitSac(poids))
        {
            for (int j = 0; j < this.objets.size(); j++)
            {
                if(addInSac(objets.get(j),rappot,poids))
                {
                    poids += this.objets.get(j).getPoids();
                    this.objets.get(j).setPoids(capacite + 1);
                    rappot.set(j,0.0);
                    instance.set(j, true);
                }
                s.setValeur(poids);
            }
        }
        s.setInstance(instance);
        return s;
    }
}
