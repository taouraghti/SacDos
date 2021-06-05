package com.codewithanas;

import java.util.ArrayList;
import java.util.Collections;

public class SacDos {

    private ArrayList<Objet> objets;
    private int capacite;

    public SacDos(ArrayList<Objet> objets, int capacite) {
        this.objets = objets;
        this.capacite = capacite;
    }

    private boolean addInSac(ArrayList<Objet> objets, int indice, ArrayList<Double> rapport, int poids) {
        double r = (double)objets.get(indice).getValeur() / objets.get(indice).getPoids();
        if(r == Collections.max(rapport))
        {
            rapport.set(indice,0.0);
            if((poids + objets.get(indice).getPoids()) <= capacite)
                return true;
        }
        return false;
    }
    private boolean exitSac(int poids, ArrayList<Double> rapport)
    {
        for (int j = 0; j < this.objets.size(); j++) {
            if ((poids + this.objets.get(j).getPoids()) <= capacite && rapport.get(j) != 0.0)
                return false;
        }
        return true;
    }

    public Solution glouton1() {
        int poids = 0;
        Solution s = new Solution();
        ArrayList<Boolean> instance = new ArrayList<>();
        ArrayList<Double> rapport = new ArrayList<>();
        double value = 0.0;

        // initialiser les instances par false et la liste des rapports
        for (int j = 0; j < this.objets.size(); j++)
        {
            instance.add(false);
            rapport.add((double)objets.get(j).getValeur()/objets.get(j).getPoids());
        }

        while (poids < capacite && !exitSac(poids, rapport))
        {
            for (int j = 0; j < this.objets.size(); j++)
            {
                if(addInSac(objets,j,rapport,poids))
                {
                    poids += objets.get(j).getPoids();
                    value += this.objets.get(j).getValeur();
                    instance.set(j, true); // un objet est choisit
                    //Donner a l'objet choisit dernierement un poids plus grand que la capacite
                    //Pour ne pas choisir le meme objet une autre fois
                    //la meme chose pour les rapports on veut pas choisir un meme max deux fois
                }
                s.setValeur(value);
            }
        }
        s.setInstance(instance);
        return s;
    }
}
