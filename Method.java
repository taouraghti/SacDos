package com.codewithanas;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Method {

    protected ArrayList<Objet> objets;
    protected int capacite;

    public Method() {
        super();
    }
    public Method(ArrayList<Objet> objets, int capacite) {
        this.objets = objets;
        this.capacite = capacite;
    }

    protected Solution hammig(Solution s, int indice)
    {
        Solution v = new Solution();
        double value = 0.0;
        ArrayList<Boolean> temp= new ArrayList<>(s.getInstance());
        if(temp.get(indice) == true)
            temp.set(indice, false);
        else
            temp.set(indice, true);
        for (int i=0; i < temp.size(); i++)
        {
            if (temp.get(i) == true)
                value += this.objets.get(i).getValeur();
        }
        v.setInstance(temp);
        v.setValeur(value);
        return v;
    }
    protected double calculePoids(Solution s)
    {
        double poids = 0.0;
        for (int i=0; i < s.getInstance().size(); i++)
        {
            if (s.getInstance().get(i) == true)
                poids += this.objets.get(i).getPoids();
        }
        return poids;
    }
    protected ArrayList<Solution> getVoisins(Solution s)
    {
        ArrayList<Solution> voisins = new ArrayList<>();
        for(int i = 0; i < s.getInstance().size(); i++)
        {
            Solution v = hammig(s,i);
            if(calculePoids(v) <= this.capacite)
                voisins.add(hammig(s,i));
        }
        return voisins;
    }

    public abstract Solution solution();
}
