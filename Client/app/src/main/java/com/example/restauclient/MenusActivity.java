package com.example.restauclient;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

public class MenusActivity extends Activity {
    Commande commande;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);
        final ImageButton mFrame = (ImageButton) findViewById(R.id.popServeur);

        mFrame.post(new Runnable() {

            @Override
            public void run() {
                mFrame.setMinimumHeight(mFrame.getWidth());
            }
        });

        Intent intent = getIntent();
        if (intent == null)
            this.commande = new Commande();
        else
            this.commande = (Commande) intent.getSerializableExtra("commande");
    }

    public void goToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goToMenus(View view) {
    }

    public void goToCarte(View view) {
        Intent intent = new Intent(this, CarteActivity.class);
        startActivity(intent);
    }

    public void goToMenuA(View view) {
    }
    public void goToMenuB(View view) {
    }
    public void goToMenuC(View view) {
    }
    public void goToMenuD(View view) {
    }

    public void popServeur(View view) {
    }

    public void goToBilan(View view) {
    }
}
