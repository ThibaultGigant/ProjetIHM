package com.example.restauclient;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;

public class CarteActivity extends Activity {
    Commande commande;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carte);
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
        Intent intent = new Intent(this, MenusActivity.class);
        startActivity(intent);
    }
    public void goToCarte(View view) {
        Intent intent = new Intent(this, CarteActivity.class);
        startActivity(intent);
    }

    public void goToCarteEntrees(View view) {
        Intent intent = new Intent(this, CarteEntreesActivity.class);
        startActivity(intent);
    }
    public void goToCartePlats(View view) {
        Intent intent = new Intent(this, CartePlatsActivity.class);
        startActivity(intent);
    }
    public void goToCarteDesserts(View view) {
        Intent intent = new Intent(this, CarteDessertsActivity.class);
        startActivity(intent);
    }
    public void goToCarteBoissons(View view) {
        Intent intent = new Intent(this, CarteBoissonsActivity.class);
        startActivity(intent);
    }

    public void goToBilan(View view) {
    }

    public void popServeur(View view) {
    }
}
