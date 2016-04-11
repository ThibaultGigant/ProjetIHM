package com.example.restauclient;

import android.content.Intent;
import android.os.Bundle;
import android.util.EventLogTags;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.PrintStream;
import java.util.ArrayList;

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

        ArrayList<Button> buttons = new ArrayList<Button>();
        buttons.add(btn_entree1);
        buttons.add(btn_entree2);
        buttons.add(btn_entree3);
        buttons.add(btn_entree4);
        buttons.add(btn_entree5);
        buttons.add(btn_entree6);

        for (Button btn : buttons) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getCommande().addEntree(v.getContentDescription().toString());
                    refreshRecap();
                }
            });
        }
    }

    public void afficherDescription(View v){
        String desc = (String) v.getTag();
        String name = (String) ((TextView)v).getText();
        Intent intent = new Intent(this, DescriptionActivity.class);
        Bundle b = new Bundle();
        b.putString("desc", desc);
        b.putString("name", name);
        intent.putExtras(b);
        startActivity(intent);
    }
}
