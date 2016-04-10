package com.example.restauclient;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class CarteDessertsActivity extends AbstractCustomActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carte_desserts);
        this.initialize();
        this.addListeners();
    }

    public void addListeners() {
        Button btn1 = (Button) findViewById(R.id.button_glace1);
        Button btn2 = (Button) findViewById(R.id.button_glace2);
        Button btn3 = (Button) findViewById(R.id.button_glace3);

        ArrayList<Button> buttons = new ArrayList<>();
        buttons.add(btn1);
        buttons.add(btn2);
        buttons.add(btn3);

        for (Button btn : buttons) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getCommande().addDessert(btn.getContentDescription().toString());
                    refreshRecap();
                }
            });
        }
    }
}
