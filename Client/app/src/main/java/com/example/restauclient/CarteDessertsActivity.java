package com.example.restauclient;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;

/**
 * Created by cc on 09/04/16.
 */
public class CarteDessertsActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ImageButton mFrame = (ImageButton) findViewById(R.id.popServeur);

        mFrame.post(new Runnable() {

            @Override
            public void run() {
                mFrame.setMinimumHeight(mFrame.getWidth());
            }
        });
    }
}
