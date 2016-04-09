package restau.serveur;

import restau.serveur.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 3364882 on 09/04/16.
 */
public class MenuActivity extends Activity {

    private int numberOfTable = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("Timon");
        super.onCreate(savedInstanceState);
        // TODO get arguments
        setContentView(R.layout.activity_menu);
        chargeMenu(numberOfTable);
    }

    protected void chargeMenu(int i) {
        try {
            XmlPullParserFactory xmlFactoryObject = XmlPullParserFactory.newInstance();
            XmlPullParser tableParser = xmlFactoryObject.newPullParser();

            InputStream inputstream = this.getResources().openRawResource(R.raw.menus);

            tableParser.setInput(inputstream, null);



            int eventType = tableParser.getEventType();
            getRightMenu(tableParser, eventType);

            while (eventType != tableParser.END_DOCUMENT) {
                if (eventType == tableParser.START_DOCUMENT) {
                    System.out.println("Start document");
                } else if (eventType == tableParser.END_DOCUMENT) {
                    System.out.println("End document");
                } else if (eventType == tableParser.START_TAG) {
                    System.out.println("Start tag " + tableParser.getName());
                    //tableParser.getAttributeValue("menu");
                } else if (eventType == tableParser.END_TAG) {
                    System.out.println("End tag " + tableParser.getName());
                } else if (eventType == tableParser.TEXT) {
                    System.out.println("Text " + tableParser.getText());
                }
                try {
                    eventType = tableParser.next();
                }
                catch (IOException e) {
                    System.out.println("IOException");
                }
            }
        }
        catch (XmlPullParserException e) {
            System.out.println("XmlPullParserException");
        }
    }


    // Avance le curseur de lecture sur le bon menu
    private void getRightMenu(XmlPullParser tableParser, int eventType) {
        try {
            while (eventType != tableParser.END_DOCUMENT) {
                if (eventType == tableParser.END_DOCUMENT)
                    finish(); // Mauvais ! Checker d'abord si un menu à été commandé sur cette table
                    // avant de créer cet activity
                else if (eventType == tableParser.START_TAG && tableParser.getName().equals("menu") &&
                tableParser.getAttributeValue(tableParser.getNamespace(), "name").equals("@string/Table" + numberOfTable))
                    break;
                try {
                    eventType = tableParser.next();
                } catch (IOException e) {
                    System.out.println("IOException");
                }
            }
        }
        catch (XmlPullParserException e) {
            System.out.println("XmlPullParserException");
        }
    }

}
