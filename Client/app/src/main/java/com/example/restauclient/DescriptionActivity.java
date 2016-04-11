package com.example.restauclient;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;


public class DescriptionActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getIntent().getExtras();
        setContentView(R.layout.description);
        TextView name = (TextView) findViewById(R.id.descname);
        TextView desc = (TextView) findViewById(R.id.desc);
        name.setText(b.getString("name"));
        desc.setText(b.getString("desc"));

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width*.7),(int) (height*.5));
    }
}
