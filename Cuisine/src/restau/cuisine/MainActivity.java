package restau.cuisine;

import android.app.AlertDialog;
import android.os.Bundle;
import android.app.Activity;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;



public class MainActivity extends Activity{

    private ImageView[] chronoIcons = new ImageView[8];
    private int[] chronometersID = {R.id.chronometer1, R.id.chronometer2, R.id.chronometer3, R.id.chronometer4, R.id.chronometer5, R.id.chronometer6, R.id.chronometer7, R.id.chronometer8};
    private int[] textDishID = {R.id.entrees1_1, R.id.entrees1_2, R.id.plats1_1, R.id.plats1_2, R.id.desserts1_1, R.id.desserts1_2};

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
        startAllChronos(chronometersID);

        // TextView clickable
        multiTextClickable(textDishID);

        // Ajout des warnings
        setWarning(R.id.entrees1_1, "Avec supplément de sucre et de piment");

        // Mise en place du reset pour la table
        setupClear(R.id.textView1, R.id.scrollView1);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    private void startChrono(int id) {
        Chronometer timeElapsed = (Chronometer) findViewById(id);
        timeElapsed.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer cArg) {
                long time = SystemClock.elapsedRealtime() - cArg.getBase();
                int h   = (int)(time /3600000);
                int m = (int)(time - h*3600000)/60000;
                String mm = m < 10 ? "0"+m: m+"";
                mm += " minutes";
                cArg.setText(mm);
            }
        });
        timeElapsed.setBase(SystemClock.elapsedRealtime());
        timeElapsed.start();
    }


    private void startAllChronos(int[] id)
    {
        for(int i : id)
        {
            startChrono(i);
        }
    }

    private void textClickable(int id)
    {
        RelativeLayout lay = (RelativeLayout) findViewById(id);
        int count = lay.getChildCount();
        View v;
        TextView text = null;
        for(int i=0; i<count; i++) {
            v = lay.getChildAt(i);
            if(v instanceof TextView)
            {
                text = (TextView) v;
            }
        }

        if(text != null) {
            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu popup = new PopupMenu(getBaseContext(), v);
                    popup.getMenuInflater().inflate(R.menu.popup, popup.getMenu());
                    popup.setOnMenuItemClickListener(new OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            lay.removeAllViews();
                            return true;
                        }
                    });

                    popup.show();
                }
            });
        }
    }

    private void multiTextClickable(int[] id)
    {
        for(int i : id)
        {
            textClickable(i);
        }
    }


    private void setWarning(int idWarningLayout, String warning)
    {
        RelativeLayout warningLay = (RelativeLayout) findViewById(idWarningLayout);
        ImageView img = null;
        int count = warningLay.getChildCount();
        View v;
        TextView text = null;
        for(int i=0; i<count; i++) {
            v = warningLay.getChildAt(i);
            if(v instanceof TextView)
            {
                text = (TextView) v;
            }
            else if(v instanceof ImageView)
            {
                img = (ImageView) v;
            }
        }


        if (img != null) img.setImageResource(R.drawable.warning);
        String title = (text != null)? text.getText().toString() : "Attention";

        if (img != null) {
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                    builder.setMessage(warning)
                           .setTitle(title);

                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            });
        }

    }


    private void setupClear(int idTextView, int idScrollArea)
    {
        TextView text = (TextView) findViewById(idTextView);
        ScrollView scroll = (ScrollView) findViewById(idScrollArea);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(getBaseContext(), v);
                popup.getMenuInflater().inflate(R.menu.popupclear, popup.getMenu());

                popup.setOnMenuItemClickListener(new OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        scroll.removeAllViews();
                        return true;
                    }
                });

                popup.show();
            }
        });

    }

}
