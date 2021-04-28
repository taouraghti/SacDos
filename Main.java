package com.codewithanas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<Objet> objets = new ArrayList<>();
        Objet o1 = new Objet(6,2);
        Objet o2 = new Objet(4,3);
        Objet o3 = new Objet(3,1);
        Objet o4 = new Objet(1,4);
        objets.add(o1);
        objets.add(o2);
        objets.add(o3);
        objets.add(o4);
        SacDos sacDos = new SacDos(objets,4);
        System.out.println(sacDos.glouton1());
       // System.out.println(((double)o4.getValeur()/o4.getPoids()) - ((double)o3.getValeur()/o3.getPoids()));
    }
}
