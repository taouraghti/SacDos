package com.codewithanas;

import java.util.ArrayList;

public class Main {

    public static ArrayList<Objet> generateObjets(int n)
    {
        ArrayList<Objet> objets = new ArrayList<>();
        double v = 100.0;
        for (int i = 0; i < n ; i++)
        {
            Objet o = new Objet();
            o.setValeur(0);
            o.setPoids(0);
            while (o.getPoids() == 0)
                o.setPoids((int)Math.floor(Math.random() * 10));
            while (o.getValeur() == 0)
                o.setValeur((int)Math.floor(Math.random() * 100));
            objets.add(o);
        }
        return objets;
    }
    public static void main(String[] args) {
	// write your code here
        /*ArrayList<Objet> objets = new ArrayList<>();
        Objet o1 = new Objet(3,2);
        Objet o2 = new Objet(4,3);
        Objet o3 = new Objet(6,1);
        Objet o4 = new Objet(1,4);
        Objet o5 = new Objet(3,2);
        Objet o6 = new Objet(4,3);
        Objet o7 = new Objet(6,1);
        Objet o8 = new Objet(1,4);
        Objet o9 = new Objet(3,2);
        Objet o10 = new Objet(4,3);
        Objet o11 = new Objet(6,1);
        Objet o12 = new Objet(1,4);
        objets.add(o1);
        objets.add(o2);
        objets.add(o3);
        objets.add(o4);
        objets.add(o5);
        objets.add(o6);
        objets.add(o7);
        objets.add(o8);
        objets.add(o9);
        objets.add(o10);
        objets.add(o11);
        objets.add(o12);*/

        ArrayList<Objet> objets = generateObjets(300);
        SacDos sacDos = new SacDos(objets,10);
        System.out.println(sacDos.glouton1());
        RecuitSimule d = new RecuitSimule(objets, 10);
        System.out.println(d.solution().toString());
       // System.out.println(((double)o4.getValeur()/o4.getPoids()) - ((double)o3.getValeur()/o3.getPoids()));
    }
}
