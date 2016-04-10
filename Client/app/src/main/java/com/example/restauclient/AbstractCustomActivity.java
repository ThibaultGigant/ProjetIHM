package com.example.restauclient;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by Tigig on 10/04/2016.
 */
public class AbstractCustomActivity extends Activity {
    protected Commande commande;

    public void initialize() {
        final ImageButton mFrame = (ImageButton) findViewById(R.id.popServeur);

        mFrame.post(new Runnable() {

            @Override
            public void run() {
                mFrame.setMinimumHeight(mFrame.getWidth());
            }
        });

        Intent intent = getIntent();
        System.out.println(intent);
        if (intent == null)
            this.commande = new Commande();
        else
            this.commande = (Commande) intent.getSerializableExtra("commande");
        System.out.println(this.commande);

        this.drawOrder();
    }

    public Commande getCommande() {
        return this.commande;
    }

    public void goToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("commande", this.commande);
        startActivity(intent);
    }

    public void goToMenus(View view) {
        Intent intent = new Intent(this, MenusActivity.class);
        intent.putExtra("commande", this.commande);
        startActivity(intent);
    }
    public void goToCarte(View view) {
        Intent intent = new Intent(this, CarteActivity.class);
        intent.putExtra("commande", this.commande);
        startActivity(intent);
    }

    public void goToBilan(View view) {
    }

    public void popServeur(View view) {
    }

    /**
     * Pour éviter que l'utilisateur n'efface tout ou partie de sa commande en appuyant sur le "back button"
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return keyCode != KeyEvent.KEYCODE_BACK && super.onKeyDown(keyCode, event);

    }

    public void refreshRecap() {
        ScrollView scrollView = (ScrollView) findViewById(R.id.scroll_recap);
        TableLayout tl = (TableLayout) findViewById(R.id.recapitulatif);
        tl.removeAllViews();
        this.drawOrder();
    }

    public void drawOrder() {
        /* Récupération du table layout */
        TableLayout tl = (TableLayout) findViewById(R.id.recapitulatif);
        TableRow tr;
        TextView label;
        TableRow.LayoutParams rowlayoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        //rowlayoutParams.setMargins(2, 2, 2, 2);
        TableLayout.LayoutParams tableLayoutParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT);

        /*
        Ajout des entrées
         */
        if (!this.commande.getListEntrees().isEmpty()) {
            /* Création de la nouvelle ligne à rajouter */
            tr = new TableRow(this);
            tr.setLayoutParams(rowlayoutParams);
            label = new TextView(this);
            label.setText(R.string.entree);
            label.setLayoutParams(rowlayoutParams);
            tr.addView(label);
            tl.addView(tr, tableLayoutParams);

            for (String key : this.getCommande().getListEntrees().keySet()) {
                tr = new TableRow(this);
                tr.setLayoutParams(rowlayoutParams);

                label = new TextView(this);
                label.setText(key);
                label.setLayoutParams(rowlayoutParams);
                tr.addView(label);

                label = new TextView(this);
                label.setText("x" + Integer.toString(this.getCommande().getListEntrees().get(key)));
                label.setLayoutParams(rowlayoutParams);
                tr.addView(label);

                ImageButton btn = new ImageButton(this);
                btn.setBackground(getResources().getDrawable(R.mipmap.minus));
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getCommande().removeEntree(key);
                        refreshRecap();
                    }
                });
                btn.setLayoutParams(rowlayoutParams);
                tr.addView(btn);

                tl.addView(tr, tableLayoutParams);
            }
        }

        /*
        Ajout des Boissons
         */
        if (!this.commande.getListBoissons().isEmpty()) {
            /* Création de la nouvelle ligne à rajouter */
            tr = new TableRow(this);
            tr.setLayoutParams(rowlayoutParams);
            label = new TextView(this);
            label.setText(R.string.boissons);
            label.setLayoutParams(rowlayoutParams);
            tr.addView(label);
            tl.addView(tr, tableLayoutParams);

            for (String key : this.getCommande().getListBoissons().keySet()) {
                tr = new TableRow(this);
                tr.setLayoutParams(rowlayoutParams);

                label = new TextView(this);
                label.setText(key);
                label.setLayoutParams(rowlayoutParams);
                tr.addView(label);

                label = new TextView(this);
                label.setText("x" + Integer.toString(this.getCommande().getListBoissons().get(key)));
                label.setLayoutParams(rowlayoutParams);
                tr.addView(label);

                ImageButton btn = new ImageButton(this);
                btn.setBackground(getResources().getDrawable(R.mipmap.minus));
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getCommande().removeBoisson(key);
                        refreshRecap();
                    }
                });
                btn.setLayoutParams(rowlayoutParams);
                tr.addView(btn);

                tl.addView(tr, tableLayoutParams);
            }
        }

        /*
        Ajout des Plats
         */
        if (!this.commande.getListPlats().isEmpty()) {
            /* Création de la nouvelle ligne à rajouter */
            tr = new TableRow(this);
            tr.setLayoutParams(rowlayoutParams);
            label = new TextView(this);
            label.setText(R.string.plats);
            label.setLayoutParams(rowlayoutParams);
            tr.addView(label);
            tl.addView(tr, tableLayoutParams);

            for (String key : this.getCommande().getListPlats().keySet()) {
                tr = new TableRow(this);
                tr.setLayoutParams(rowlayoutParams);

                label = new TextView(this);
                label.setText(key);
                label.setLayoutParams(rowlayoutParams);
                tr.addView(label);

                label = new TextView(this);
                label.setText("x" + Integer.toString(this.getCommande().getListPlats().get(key)));
                label.setLayoutParams(rowlayoutParams);
                tr.addView(label);

                ImageButton btn = new ImageButton(this);
                btn.setBackground(getResources().getDrawable(R.mipmap.minus));
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getCommande().removePlat(key);
                        refreshRecap();
                    }
                });
                btn.setLayoutParams(rowlayoutParams);
                tr.addView(btn);

                tl.addView(tr, tableLayoutParams);
            }
        }

        /*
        Ajout des Desserts
         */
        if (!this.commande.getListDesserts().isEmpty()) {
            /* Création de la nouvelle ligne à rajouter */
            tr = new TableRow(this);
            tr.setLayoutParams(rowlayoutParams);
            label = new TextView(this);
            label.setText(R.string.desserts);
            label.setLayoutParams(rowlayoutParams);
            tr.addView(label);
            tl.addView(tr, tableLayoutParams);

            for (String key : this.getCommande().getListDesserts().keySet()) {
                tr = new TableRow(this);
                tr.setLayoutParams(rowlayoutParams);

                label = new TextView(this);
                label.setText(key);
                label.setLayoutParams(rowlayoutParams);
                tr.addView(label);

                label = new TextView(this);
                label.setText("x" + Integer.toString(this.getCommande().getListDesserts().get(key)));
                label.setLayoutParams(rowlayoutParams);
                tr.addView(label);

                ImageButton btn = new ImageButton(this);
                btn.setBackground(getResources().getDrawable(R.mipmap.minus));
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getCommande().removeDessert(key);
                        refreshRecap();
                    }
                });
                btn.setLayoutParams(rowlayoutParams);
                tr.addView(btn);

                tl.addView(tr, tableLayoutParams);
            }
        }

    }
}
