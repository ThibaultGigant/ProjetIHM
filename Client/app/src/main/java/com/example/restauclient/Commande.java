package com.example.restauclient;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Tigig on 09/04/2016.
 */
public class Commande implements Serializable {
    private HashMap<String, Integer> listEntrees = new HashMap<String,Integer>();
    private HashMap<String, Integer> listPlats = new HashMap<String,Integer>();
    private HashMap<String, Integer> listDesserts = new HashMap<String,Integer>();
    private HashMap<String, Integer> listBoissons = new HashMap<String,Integer>();
    private Double price = new Double(0);
    private HashMap<String, Double> pricesTable = new HashMap<String, Double>();

    private boolean call_for_water = false;
    private boolean call_for_bread = false;
    private boolean call_for_waiter = false;

    public Commande() {
    }

    private HashMap<String, Integer> listMenus = new HashMap<String,Integer>();

    public HashMap<String, Integer> getListEntrees() {
        return listEntrees;
    }

    public void setListEntrees(HashMap<String, Integer> listEntrees) {
        this.listEntrees = listEntrees;
    }

    public HashMap<String, Integer> getListPlats() {
        return listPlats;
    }

    public void setListPlats(HashMap<String, Integer> listPlats) {
        this.listPlats = listPlats;
    }

    public HashMap<String, Integer> getListDesserts() {
        return listDesserts;
    }

    public void setListDesserts(HashMap<String, Integer> listDesserts) {
        this.listDesserts = listDesserts;
    }

    public HashMap<String, Integer> getListBoissons() {
        return listBoissons;
    }

    public HashMap<String, Integer> getListMenus() {
        return listMenus;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setListBoissons(HashMap<String, Integer> listBoissons) {
        this.listBoissons = listBoissons;
    }

    public void addEntree(String entree) {
        if (this.listEntrees.containsKey(entree)) {
            this.listEntrees.put(entree, this.listEntrees.get(entree) + 1);
        }
        else {
            this.listEntrees.put(entree, 1);
        }
    }

    public void addPlat(String plat) {
        if (this.listPlats.containsKey(plat)) {
            this.listPlats.put(plat, this.listPlats.get(plat) + 1);
        }
        else {
            this.listPlats.put(plat, 1);
        }
    }

    public void addDessert(String dessert) {
        if (this.listDesserts.containsKey(dessert)) {
            this.listDesserts.put(dessert, this.listDesserts.get(dessert) + 1);
        }
        else {
            this.listDesserts.put(dessert, 1);
        }
    }

    public void addBoisson(String boisson) {
        if (this.listBoissons.containsKey(boisson)) {
            this.listBoissons.put(boisson, this.listBoissons.get(boisson) + 1);
        }
        else {
            this.listBoissons.put(boisson, 1);
        }
    }

    public void addMenu(String menu) {
        if (this.listMenus.containsKey(menu)) {
            this.listMenus.put(menu, this.listMenus.get(menu) + 1);
        }
        else {
            this.listMenus.put(menu, 1);
        }
    }

    public void removeEntree(String entree) {
        if (this.listEntrees.containsKey(entree)) {
            if (this.listEntrees.get(entree) > 1)
                this.listEntrees.put(entree, this.listEntrees.get(entree) - 1);
            else
                this.listEntrees.remove(entree);
        }
    }

    public void removePlat(String plat) {
        if (this.listPlats.containsKey(plat)) {
            if (this.listPlats.get(plat) > 1)
                this.listPlats.put(plat, this.listPlats.get(plat) - 1);
            else
                this.listPlats.remove(plat);
        }
    }

    public void removeDessert(String dessert) {
        if (this.listDesserts.containsKey(dessert)) {
            if (this.listDesserts.get(dessert) > 1)
                this.listDesserts.put(dessert, this.listDesserts.get(dessert) - 1);
            else
                this.listDesserts.remove(dessert);
        }
    }

    public void removeBoisson(String boisson) {
        if (this.listBoissons.containsKey(boisson)) {
            if (this.listBoissons.get(boisson) > 1)
                this.listBoissons.put(boisson, this.listBoissons.get(boisson) - 1);
            else
                this.listBoissons.remove(boisson);
        }
    }

    public void removeMenu(String menu) {
        if (this.listMenus.containsKey(menu)) {
            if (this.listMenus.get(menu) > 1)
                this.listMenus.put(menu, this.listMenus.get(menu) - 1);
            else
                this.listMenus.remove(menu);
        }
    }

    public void addToPrice(Double d) {
        this.price += d;
    }

    public void substractToPrice(Double d) {
        this.price -= d;
    }

    public void ajoutMenuA(String s) {
        this.pricesTable.put(s, 15d);
        this.price += 15;
    }

    public void ajoutMenuB(String s) {
        this.pricesTable.put(s, 22d);
        this.price += 22;
    }

    public void ajoutMenuC(String s) {
        this.pricesTable.put(s, 25d);
        this.price += 25;
    }

    public void ajoutMenuD(String s) {
        this.pricesTable.put(s, 35d);
        this.price += 35;
    }

    public void substractMenu(String s) {
        this.price -= this.pricesTable.get(s);
    }

    public boolean isCallWater() {
        return this.call_for_water;
    }

    public void setCallWater(boolean bool) {
        this.call_for_water = bool;
    }

    public boolean isCallWaiter() {
        return this.call_for_waiter;
    }

    public void setCallWaiter(boolean bool) {
        this.call_for_waiter = bool;
    }

    public boolean isCallBread() {
        return this.call_for_bread;
    }

    public void setCallBread(boolean bool) {
        this.call_for_bread = bool;
    }

}
