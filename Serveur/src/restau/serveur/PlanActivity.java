package restau.serveur;

import restau.serveur.util.SystemUiHider;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class PlanActivity extends Activity {

    private int[] alertesId = {R.id.Alarme1, R.id.Alarme2, R.id.Alarme3, R.id.Alarme4, R.id.Alarme5, R.id.Alarme6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        multiTextClickable(alertesId);
    }


    
    public void viewTable1(View v) throws XmlPullParserException, IOException {
    	viewTable(1);
    }
    
    public void viewTable2(View v) throws XmlPullParserException, IOException {
    	viewTable(2);
    }
    
    public void viewTable3(View v) throws XmlPullParserException, IOException {
    	viewTable(3);
    }
    
    public void viewTable4(View v) throws XmlPullParserException, IOException {
    	viewTable(4);
    }
    
    public void viewTable5(View v) throws XmlPullParserException, IOException { viewTable(5); }
    
    public void viewTable(int i) throws XmlPullParserException, IOException {

        // TODO start MenuActivity with number of table
        //setContentView(R.layout.activity_menu);
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("numberOfTable", i);
        startActivity(intent);

    }

    private void textClickable(int id)
    {
        TextView alarme = (TextView) findViewById(id);

        if(alarme != null) {
            alarme.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu popup = new PopupMenu(getBaseContext(), v);
                    popup.getMenuInflater().inflate(R.menu.popup_accept, popup.getMenu());
                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            alarme.setVisibility(View.GONE);
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
}
