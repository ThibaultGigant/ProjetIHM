package com.example.restauclient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tigig on 09/04/2016.
 */
public class Commande implements Serializable {
    private List<String> listEntrees = new ArrayList<String>();
    private List<String> listPlats = new ArrayList<String>();
    private List<String> listDesserts = new ArrayList<String>();
    private List<String> listBoissons = new ArrayList<String>();

    public List<String> getListEntrees() {
        return listEntrees;
    }

    public void setListEntrees(List<String> listEntrees) {
        this.listEntrees = listEntrees;
    }

    public List<String> getListPlats() {
        return listPlats;
    }

    public void setListPlats(List<String> listPlats) {
        this.listPlats = listPlats;
    }

    public List<String> getListDesserts() {
        return listDesserts;
    }

    public void setListDesserts(List<String> listDesserts) {
        this.listDesserts = listDesserts;
    }

    public List<String> getListBoissons() {
        return listBoissons;
    }

    public void setListBoissons(List<String> listBoissons) {
        this.listBoissons = listBoissons;
    }

    public void addEntree(String entree) {
        this.listEntrees.add(entree);
    }

    public void addPlat(String plat) {
        this.listPlats.add(plat);
    }

    public void addDessert(String dessert) {
        this.listDesserts.add(dessert);
    }

    public void addBoisson(String boisson) {
        this.listBoissons.add(boisson);
    }
}
