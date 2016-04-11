package com.example.restauclient;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RecapitulatifActivity extends AbstractCustomActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recapitulatif);
        this.initialize();
    }
}
