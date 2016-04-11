package com.example.restauclient;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CarteActivity extends AbstractCustomActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carte);
        this.initialize();
    }

    public void goToCarteEntrees(View view) {
        Intent intent = new Intent(this, CarteEntreesActivity.class);
        intent.putExtra("commande", this.commande);
        startActivity(intent);
    }
    public void goToCartePlats(View view) {
        Intent intent = new Intent(this, CartePlatsActivity.class);
        intent.putExtra("commande", this.commande);
        startActivity(intent);
    }
    public void goToCarteDesserts(View view) {
        Intent intent = new Intent(this, CarteDessertsActivity.class);
        intent.putExtra("commande", this.commande);
        startActivity(intent);
    }
    public void goToCarteBoissons(View view) {
        Intent intent = new Intent(this, CarteBoissonsActivity.class);
        intent.putExtra("commande", this.commande);
        startActivity(intent);
    }
}
