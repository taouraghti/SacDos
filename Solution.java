package com.codewithanas;

import java.util.ArrayList;

public class Solution {
    private ArrayList<Boolean> instance = new ArrayList<>();
    private double valeur;

    public ArrayList<Boolean> getInstance() {
        return instance;
    }

    public void setInstance(ArrayList<Boolean> instance) {
        this.instance = instance;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "instance=" + instance +
                ", valeur=" + valeur +
                '}';
    }
}
