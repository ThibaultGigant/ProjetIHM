package com.example.restauclient;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    public void switchToFrench(View v) {

    }

    public void switchToEnglish(View v) {

    }

    public void switchToItalian(View v) {

    }

    public void switchToGerman(View v) {

    }

    public void switchToSpanish(View v) {

    }

    public void goToCarte(View v) {
        Intent intent = new Intent(this, CarteActivity.class);
        startActivity(intent);
    }


}
