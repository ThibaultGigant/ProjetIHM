package com.example.restauclient;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class CarteDessertsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carte_desserts);
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
}
