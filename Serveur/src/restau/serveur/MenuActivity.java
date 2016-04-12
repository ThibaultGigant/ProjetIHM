package restau.serveur;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
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

    protected int entreesId = -1;
    protected int dessertsId = -1;
    protected int platsId = -1;

    private boolean suppr_mode = false;

    private int tmpId;

    private int[] alertesId = {R.id.Alarme1, R.id.Alarme2, R.id.Alarme3, R.id.Alarme4, R.id.Alarme5, R.id.Alarme6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extra = getIntent().getExtras();
        if (extra == null)
            finish();
        else
            numberOfTable = extra.getInt("numberOfTable");
        setContentView(R.layout.activity_menu);
        chargeMenu(numberOfTable);
        multiTextClickable(alertesId);
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
        LinearLayout listeEntrees = (LinearLayout) findViewById(R.id.entrees); // null;
        LinearLayout listePlats = (LinearLayout) findViewById(R.id.plats); // null;
        LinearLayout listeDesserts = (LinearLayout) findViewById(R.id.desserts); // null;

        try {
            while (eventType != tableParser.END_DOCUMENT) {
                if (eventType == tableParser.START_TAG) {
                    System.out.println("Start tag " + tableParser.getName());

                    name = tableParser.getName();

                    /*if (name.equals("entrees")) {

                        listeEntrees = new LinearLayout(this);
                        this.entreesId = 11123; //View.generateViewId();
                        listeEntrees.setId(this.entreesId);
                        System.out.println(listeEntrees.getId());
                        listeEntrees.setOrientation(LinearLayout.VERTICAL);
                        listeMenu.addView(listeEntrees);

                    }
                    else if (name.equals("plats")) {
                        listePlats = new LinearLayout(this);
                        this.platsId = 11124;//View.generateViewId();
                        listeEntrees.setId(this.platsId);
                        listePlats.setOrientation(LinearLayout.VERTICAL);
                        listeMenu.addView(listePlats);
                    }
                    else if (name.equals("desserts")) {
                        listeDesserts = new LinearLayout(this);
                        this.dessertsId = 11125;//View.generateViewId();
                        listeEntrees.setId(this.dessertsId);
                        listeDesserts.setOrientation(LinearLayout.VERTICAL);
                        listeMenu.addView(listeDesserts);
                    }

                    else*/ if (name.equals("entree") && listeEntrees != null) {
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

    public void suppression_mode(View view) {

        if(suppr_mode)
            return;

        suppr_mode = true;

        LinearLayout listeMenu = (LinearLayout) findViewById(R.id.listeMenu);

        LinearLayout item;
        int nbChild;

        LinearLayout entrees = (LinearLayout) findViewById(R.id.entrees);
        nbChild = entrees.getChildCount();
        for(int i=0; i< nbChild ; i++) {
            item = (LinearLayout) entrees.getChildAt(i);
            if (item.getChildCount() == 0)
                continue;
            ImageView minus = new ImageView(this);
            minus.setBackground(getResources().getDrawable(R.mipmap.minus));
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            param.setMargins(10, 5, 0, 0);
            minus.setLayoutParams(param);
            item.addView(minus);
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //v.setVisibility(View.GONE);

                    PopupMenu popup = new PopupMenu(getBaseContext(), v);
                    popup.getMenuInflater().inflate(R.menu.popup_delete, popup.getMenu());
                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item2) {
                            ((LinearLayout) v).removeAllViews();// .setVisible(false);
                            return true;
                        }
                    });

                    popup.show();
                }
            });
        }

        LinearLayout desserts = (LinearLayout) findViewById(R.id.desserts);
        nbChild = desserts.getChildCount();
        for(int i=0; i<nbChild ; i++) {
            item = (LinearLayout) desserts.getChildAt(i);
            if (item.getChildCount() == 0)
                continue;
            ImageView minus = new ImageView(this);
            minus.setBackground(getResources().getDrawable(R.mipmap.minus));
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            param.setMargins(10, 5, 0, 0);
            minus.setLayoutParams(param);
            item.addView(minus);
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //v.setVisibility(View.GONE);

                    PopupMenu popup = new PopupMenu(getBaseContext(), v);
                    popup.getMenuInflater().inflate(R.menu.popup_delete, popup.getMenu());
                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item2) {
                            ((LinearLayout) v).removeAllViews();// .setVisible(false);
                            return true;
                        }
                    });

                    popup.show();
                }
            });
        }

        LinearLayout plats = (LinearLayout) findViewById(R.id.plats);
        nbChild = plats.getChildCount();
        for(int i=0; i<nbChild ; i++) {
            item = (LinearLayout) plats.getChildAt(i);
            if (item.getChildCount() == 0)
                continue;

            ImageView minus = new ImageView(this);
            minus.setBackground(getResources().getDrawable(R.mipmap.minus));
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            param.setMargins(10, 5, 0, 0);
            minus.setLayoutParams(param);

            item.addView(minus);
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //v.setVisibility(View.GONE);

                    PopupMenu popup = new PopupMenu(getBaseContext(), v);
                    popup.getMenuInflater().inflate(R.menu.popup_delete, popup.getMenu());
                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item2) {
                            ((LinearLayout) v).removeAllViews();// .setVisible(false);
                            return true;
                        }
                    });

                    popup.show();
                }
            });
        }

        //listeMenu.getChildAt();
    }

    public void valid(View view) {

        if(!suppr_mode)
            return;

        suppr_mode = false;

        LinearLayout item;
        int nbChild;

        LinearLayout entrees = (LinearLayout) findViewById(R.id.entrees);
        nbChild = entrees.getChildCount();
        for(int i=0; i< nbChild ; i++) {
            item = (LinearLayout) entrees.getChildAt(i);
            if (item.getChildAt(item.getChildCount() - 1) != null)
                ((ImageView) item.getChildAt(item.getChildCount() - 1)).setVisibility(View.GONE);
        }

        LinearLayout desserts = (LinearLayout) findViewById(R.id.desserts);
        nbChild = desserts.getChildCount();
        for(int i=0; i<nbChild ; i++) {
            item = (LinearLayout) desserts.getChildAt(i);
            if (item.getChildAt(item.getChildCount() - 1) != null)
                ((ImageView)item.getChildAt(item.getChildCount() - 1)).setVisibility(View.GONE);
        }

        LinearLayout plats = (LinearLayout) findViewById(R.id.plats);
        nbChild = plats.getChildCount();
        for(int i=0; i<nbChild ; i++) {
            item = (LinearLayout) plats.getChildAt(i);
            if (item.getChildAt(item.getChildCount() - 1) != null)
                ((ImageView)item.getChildAt(item.getChildCount() - 1)).setVisibility(View.GONE);
        }
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
