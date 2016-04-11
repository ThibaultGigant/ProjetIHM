package com.example.restauclient;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class CartePlatsActivity extends AbstractCustomActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carte_plats);
        this.initialize();
        this.addListeners();
    }

    public void addListeners() {
        Button btn1 = (Button) findViewById(R.id.button_poisson1);
        Button btn2 = (Button) findViewById(R.id.button_poisson2);
        Button btn3 = (Button) findViewById(R.id.button_poisson3);
        Button btn4 = (Button) findViewById(R.id.button_viande1);
        Button btn5 = (Button) findViewById(R.id.button_viande2);
        Button btn6 = (Button) findViewById(R.id.button_viande3);
        Button btn7 = (Button) findViewById(R.id.button_pates1);
        Button btn8 = (Button) findViewById(R.id.button_pates2);
        Button btn9 = (Button) findViewById(R.id.button_pates3);

        ArrayList<Button> buttons = new ArrayList<Button>();
        buttons.add(btn1);
        buttons.add(btn2);
        buttons.add(btn3);
        buttons.add(btn4);
        buttons.add(btn5);
        buttons.add(btn6);
        buttons.add(btn7);
        buttons.add(btn8);
        buttons.add(btn9);

        for (Button btn : buttons) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getCommande().addPlat(v.getContentDescription().toString());
                    refreshRecap();
                }
            });
        }
    }
}