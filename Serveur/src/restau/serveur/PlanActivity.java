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
import android.view.MotionEvent;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class PlanActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
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
}
