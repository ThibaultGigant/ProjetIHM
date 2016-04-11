package restau.cuisine;

import android.os.Bundle;
import android.app.Activity;
import android.os.SystemClock;
import android.view.Menu;
import android.widget.Chronometer;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private ImageView[] chronoIcons = new ImageView[8];
    private Chronometer[] chronometers = new Chronometer[8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Initialise et stocke les icones avant les chronometres
        chronoIcons[0] = (ImageView) findViewById(R.id.chronoIcon1);
        chronoIcons[1] = (ImageView) findViewById(R.id.chronoIcon2);
        chronoIcons[2] = (ImageView) findViewById(R.id.chronoIcon3);
        chronoIcons[3] = (ImageView) findViewById(R.id.chronoIcon4);
        chronoIcons[4] = (ImageView) findViewById(R.id.chronoIcon5);
        chronoIcons[5] = (ImageView) findViewById(R.id.chronoIcon6);
        chronoIcons[6] = (ImageView) findViewById(R.id.chronoIcon7);
        chronoIcons[7] = (ImageView) findViewById(R.id.chronoIcon8);

        for(ImageView img : chronoIcons)
        {
            img.setImageResource(R.drawable.clock);
        }

        // Initialise les chronometres
        startAllChronos();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    private void startChrono(int id)
    {
        Chronometer timeElapsed  = (Chronometer) findViewById(id);
        timeElapsed.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener(){
            @Override
            public void onChronometerTick(Chronometer cArg) {
                long time = SystemClock.elapsedRealtime() - cArg.getBase();
                int h   = (int)(time /3600000);
                int m = (int)(time - h*3600000)/60000;
                String mm = m < 10 ? "0"+m: m+"";
                cArg.setText(mm+" minutes");
            }
        });
        timeElapsed.setBase(SystemClock.elapsedRealtime());
        timeElapsed.start();
    }


    private void startAllChronos()
    {
        startChrono(R.id.chronometer1);
        startChrono(R.id.chronometer2);
        startChrono(R.id.chronometer3);
        startChrono(R.id.chronometer4);
        startChrono(R.id.chronometer5);
        startChrono(R.id.chronometer6);
        startChrono(R.id.chronometer7);
        startChrono(R.id.chronometer8);
    }
}
