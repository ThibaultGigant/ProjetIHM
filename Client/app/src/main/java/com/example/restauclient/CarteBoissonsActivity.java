package com.example.restauclient;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class CarteBoissonsActivity extends AbstractCustomActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carte_boissons);
        this.initialize();
        this.addListeners();
    }

    public void addListeners() {
        Button btn_boisson1 = (Button) findViewById(R.id.button_alcool1);
        Button btn_boisson2 = (Button) findViewById(R.id.button_alcool2);
        Button btn_boisson3 = (Button) findViewById(R.id.button_alcool3);
        Button btn_boisson4 = (Button) findViewById(R.id.button_vin1);
        Button btn_boisson5 = (Button) findViewById(R.id.button_vin2);
        Button btn_boisson6 = (Button) findViewById(R.id.button_vin3);

        ArrayList<Button> buttons = new ArrayList<Button>();
        buttons.add(btn_boisson1);
        buttons.add(btn_boisson2);
        buttons.add(btn_boisson3);
        buttons.add(btn_boisson4);
        buttons.add(btn_boisson5);
        buttons.add(btn_boisson6);

        for (Button btn : buttons) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getCommande().addBoisson(v.getContentDescription().toString());
                    refreshRecap();
                }
            });
        }
    }
}
