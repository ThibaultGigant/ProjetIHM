package com.example.restauclient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class CarteEntreesActivity extends AbstractCustomActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carte_entrees);
        this.initialize();
        this.addListeners();
    }

    public void addListeners() {
        Button btn_entree1 = (Button) findViewById(R.id.button_charcuterie1);
        Button btn_entree2 = (Button) findViewById(R.id.button_charcuterie2);
        Button btn_entree3 = (Button) findViewById(R.id.button_charcuterie3);
        Button btn_entree4 = (Button) findViewById(R.id.button_salade1);
        Button btn_entree5 = (Button) findViewById(R.id.button_salade2);
        Button btn_entree6 = (Button) findViewById(R.id.button_salade3);

        System.out.println(this.getCommande());
        System.out.println(this.getCommande().getListEntrees().keySet());
        System.out.println(this.getCommande().getListEntrees().values());

        btn_entree1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCommande().addEntree(getString(R.string.entree_charcuterie1));
                refreshRecap();
            }
        });

        btn_entree2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCommande().addEntree(getString(R.string.entree_charcuterie2));
                refreshRecap();
            }
        });

        btn_entree3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCommande().addEntree(getString(R.string.entree_charcuterie3));
                refreshRecap();
            }
        });

        btn_entree4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCommande().addEntree(getString(R.string.entree_salade1));
                refreshRecap();
            }
        });

        btn_entree5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCommande().addEntree(getString(R.string.entree_salade2));
                refreshRecap();
            }
        });

        btn_entree6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCommande().addEntree(getString(R.string.entree_salade3));
                refreshRecap();
            }
        });

    }
}
