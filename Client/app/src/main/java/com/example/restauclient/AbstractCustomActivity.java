package com.example.restauclient;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Tigig on 10/04/2016.
 */
public class AbstractCustomActivity extends Activity {
    protected Commande commande;

    public void initialize() {
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
        intent.putExtra("commande", this.commande);
        startActivity(intent);
    }

    public void goToMenus(View view) {
        Intent intent = new Intent(this, MenusActivity.class);
        intent.putExtra("commande", this.commande);
        startActivity(intent);
    }
    public void goToCarte(View view) {
        Intent intent = new Intent(this, CarteActivity.class);
        intent.putExtra("commande", this.commande);
        startActivity(intent);
    }

    public void goToBilan(View view) {
    }

    public void popServeur(View view) {
    }
}
