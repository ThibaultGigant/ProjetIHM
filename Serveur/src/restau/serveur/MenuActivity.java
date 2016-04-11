package restau.serveur;

import restau.serveur.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

/**
 * Created by 3364882 on 09/04/16.
 */
public class MenuActivity extends Activity {

    private int numberOfTable = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO get arguments
        Bundle extra = getIntent().getExtras();
        if (extra == null)
            finish();
        else
            numberOfTable = extra.getInt("numberOfTable");
        setContentView(R.layout.activity_menu);
        chargeMenu(numberOfTable);
    }

    protected void chargeMenu(int i) {
        try {
            XmlPullParserFactory xmlFactoryObject = XmlPullParserFactory.newInstance();
            XmlPullParser tableParser = xmlFactoryObject.newPullParser();

            InputStream inputstream = this.getResources().openRawResource(R.raw.menus);

            tableParser.setInput(inputstream, null);

            final TextView titleTextView = (TextView) findViewById(R.id.titleTextView);
            titleTextView.setText("Table " + numberOfTable + " :");

            int eventType = tableParser.getEventType();
            getRightMenu(tableParser, eventType);

            getMenu(tableParser, eventType);

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

    private void getMenu(XmlPullParser tableParser, int eventType) {
        String name;

        LinearLayout listeMenu = (LinearLayout) findViewById(R.id.listeMenu);
        LinearLayout listeEntrees = null;
        LinearLayout listePlats = null;
        LinearLayout listeDesserts = null;

        try {
            while (eventType != tableParser.END_DOCUMENT) {
                if (eventType == tableParser.START_TAG) {
                    System.out.println("Start tag " + tableParser.getName());

                    name = tableParser.getName();

                    if (name.equals("entrees")) {

                        listeEntrees = new LinearLayout(this);
                        listeEntrees.setOrientation(LinearLayout.VERTICAL);
                        listeMenu.addView(listeEntrees);

                    }
                    else if (name.equals("plats")) {
                        listePlats = new LinearLayout(this);
                        listePlats.setOrientation(LinearLayout.VERTICAL);
                        listeMenu.addView(listePlats);
                    }
                    else if (name.equals("desserts")) {
                        listeDesserts = new LinearLayout(this);
                        listeDesserts.setOrientation(LinearLayout.VERTICAL);
                        listeMenu.addView(listeDesserts);
                    }

                    else if (name.equals("entree") && listeEntrees != null) {
                        LinearLayout entree = new LinearLayout(this);
                        entree.setOrientation(LinearLayout.HORIZONTAL);

                        TextView nameEntree = new TextView(this);
                        nameEntree.setText(tableParser.getAttributeValue(tableParser.getNamespace(), "number") + "x " +
                                //getResId(tableParser.getAttributeValue(tableParser.getNamespace(), "name"), R.id.class));
                                tableParser.getAttributeValue(tableParser.getNamespace(), "name"));
                        nameEntree.setBackground(null);
                        nameEntree.setGravity(Gravity.LEFT);
                        entree.addView(nameEntree);

                        ImageView separator = new ImageView(this);

                        TextView priceEntree = new TextView(this);
                        priceEntree.setText("   " + tableParser.getAttributeValue(tableParser.getNamespace(), "price"));
                        //priceEntree.setText(getResId(tableParser.getAttributeValue(tableParser.getNamespace(), "price"), R.id.class));
                        priceEntree.setBackground(null);
                        priceEntree.setGravity(Gravity.RIGHT);
                        entree.addView(priceEntree);

                        listeEntrees.addView(entree);
                    }

                    //tableParser.getAttributeValue("menu");
                } else if (eventType == tableParser.END_TAG && tableParser.getName().equals("menu")) {
                    return;
                }
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

    private int getResId(String resName, Class<?> c) {

        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void suppression_mode() {
        LinearLayout listeMenu = (LinearLayout) findViewById(R.id.listeMenu);

        //listeMenu.getChildAt();
    }
}
