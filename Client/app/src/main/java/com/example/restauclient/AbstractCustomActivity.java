package com.example.restauclient;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import java.util.HashMap;

/**
 * Created by Tigig on 10/04/2016.
 */
public class AbstractCustomActivity extends Activity {
    protected Commande commande;
    private HashMap<String, Double> pricesTable = new HashMap<String, Double>();

    public void initialize() {

        Intent intent = getIntent();
        if (intent == null)
            this.commande = new Commande();
        else
            this.commande = (Commande) intent.getSerializableExtra("commande");

        this.initialize_price();
        this.refreshRecap();
    }
    
    public void initialize_price() {
        String prix;
        
        /*
        Ajout boissons
         */
        prix = getString(R.string.boisson_alcool1_prix);
        pricesTable.put(getString(R.string.boisson_alcool1), Double.parseDouble(prix.substring(0, prix.length() - 1)));
        prix = getString(R.string.boisson_alcool2_prix);
        pricesTable.put(getString(R.string.boisson_alcool2), Double.parseDouble(prix.substring(0, prix.length() - 1)));
        prix = getString(R.string.boisson_alcool3_prix);
        pricesTable.put(getString(R.string.boisson_alcool3), Double.parseDouble(prix.substring(0, prix.length() - 1)));
        prix = getString(R.string.boisson_vin1_prix);
        pricesTable.put(getString(R.string.boisson_vin1), Double.parseDouble(prix.substring(0, prix.length() - 1)));
        prix = getString(R.string.boisson_vin2_prix);
        pricesTable.put(getString(R.string.boisson_vin2), Double.parseDouble(prix.substring(0, prix.length() - 1)));
        prix = getString(R.string.boisson_vin3_prix);
        pricesTable.put(getString(R.string.boisson_vin3), Double.parseDouble(prix.substring(0, prix.length() - 1)));
        prix = getString(R.string.boisson_soft1_prix);
        pricesTable.put(getString(R.string.boisson_soft1), Double.parseDouble(prix.substring(0, prix.length() - 1)));
        prix = getString(R.string.boisson_soft2_prix);
        pricesTable.put(getString(R.string.boisson_soft2), Double.parseDouble(prix.substring(0, prix.length() - 1)));
        prix = getString(R.string.boisson_soft3_prix);
        pricesTable.put(getString(R.string.boisson_soft3), Double.parseDouble(prix.substring(0, prix.length() - 1)));
        prix = getString(R.string.boisson_soft4_prix);
        pricesTable.put(getString(R.string.boisson_soft4), Double.parseDouble(prix.substring(0, prix.length() - 1)));

        /*
        Ajout Entrees
         */
        prix = getString(R.string.entree_charcuterie1_prix);
        pricesTable.put(getString(R.string.entree_charcuterie1), Double.parseDouble(prix.substring(0, prix.length() - 1)));
        prix = getString(R.string.entree_charcuterie2_prix);
        pricesTable.put(getString(R.string.entree_charcuterie2), Double.parseDouble(prix.substring(0, prix.length() - 1)));
        prix = getString(R.string.entree_charcuterie3_prix);
        pricesTable.put(getString(R.string.entree_charcuterie3), Double.parseDouble(prix.substring(0, prix.length() - 1)));
        prix = getString(R.string.entree_salade1_prix);
        pricesTable.put(getString(R.string.entree_salade1), Double.parseDouble(prix.substring(0, prix.length() - 1)));
        prix = getString(R.string.entree_salade2_prix);
        pricesTable.put(getString(R.string.entree_salade2), Double.parseDouble(prix.substring(0, prix.length() - 1)));
        prix = getString(R.string.entree_salade3_prix);
        pricesTable.put(getString(R.string.entree_salade3), Double.parseDouble(prix.substring(0, prix.length() - 1)));

        /*
        Ajout Plats
         */
        prix = getString(R.string.plat_poisson1_prix);
        pricesTable.put(getString(R.string.plat_poisson1), Double.parseDouble(prix.substring(0, prix.length() - 1)));
        prix = getString(R.string.plat_poisson2_prix);
        pricesTable.put(getString(R.string.plat_poisson2), Double.parseDouble(prix.substring(0, prix.length() - 1)));
        prix = getString(R.string.plat_poisson3_prix);
        pricesTable.put(getString(R.string.plat_poisson3), Double.parseDouble(prix.substring(0, prix.length() - 1)));
        prix = getString(R.string.plat_viande1_prix);
        pricesTable.put(getString(R.string.plat_viande1), Double.parseDouble(prix.substring(0, prix.length() - 1)));
        prix = getString(R.string.plat_viande2_prix);
        pricesTable.put(getString(R.string.plat_viande2), Double.parseDouble(prix.substring(0, prix.length() - 1)));
        prix = getString(R.string.plat_viande3_prix);
        pricesTable.put(getString(R.string.plat_viande3), Double.parseDouble(prix.substring(0, prix.length() - 1)));
        prix = getString(R.string.plat_pates1_prix);
        pricesTable.put(getString(R.string.plat_pates1), Double.parseDouble(prix.substring(0, prix.length() - 1)));
        prix = getString(R.string.plat_pates2_prix);
        pricesTable.put(getString(R.string.plat_pates2), Double.parseDouble(prix.substring(0, prix.length() - 1)));
        prix = getString(R.string.plat_pates3_prix);
        pricesTable.put(getString(R.string.plat_pates3), Double.parseDouble(prix.substring(0, prix.length() - 1)));

        /*
        Ajout Desserts
         */
        prix = getString(R.string.dessert_glace1_prix);
        pricesTable.put(getString(R.string.dessert_glace1), Double.parseDouble(prix.substring(0, prix.length() - 1)));
        prix = getString(R.string.dessert_glace2_prix);
        pricesTable.put(getString(R.string.dessert_glace2), Double.parseDouble(prix.substring(0, prix.length() - 1)));
        prix = getString(R.string.dessert_glace3_prix);
        pricesTable.put(getString(R.string.dessert_glace3), Double.parseDouble(prix.substring(0, prix.length() - 1)));

    }

    public Commande getCommande() {
        return this.commande;
    }

    public HashMap<String, Double> getPricesTable() {
        return pricesTable;
    }

    public void goToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("commande", this.commande);
        startActivity(intent);
    }

    public void goToMenus(View view) {
        if (!this.getClass().equals(MenusActivity.class)) {
            Intent intent = new Intent(this, MenusActivity.class);
            intent.putExtra("commande", this.commande);
            startActivity(intent);
        }
    }
    public void goToCarte(View view) {
        if (!this.getClass().equals(CarteActivity.class)) {
            Intent intent = new Intent(this, CarteActivity.class);
            intent.putExtra("commande", this.commande);
            startActivity(intent);
        }
    }

    public void goToBilan(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(getString(R.string.sure));
        alertDialogBuilder.setPositiveButton(getString(R.string.yes),new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int id) {
                Intent intent = new Intent(getApplicationContext(), RecapitulatifActivity.class);
                intent.putExtra("commande", getCommande());
                startActivity(intent);
            }

        });
        alertDialogBuilder.setNegativeButton(getString(R.string.no),new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int id) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

    public void popServeur(View view) {
        setTickPain();
        setTickEau();
        setTickServeur();

        FrameLayout popUpPap = (FrameLayout) findViewById(R.id.popUpPap);
        popUpPap.setVisibility(View.VISIBLE);
    }

    public void unPopServeur(View view) {
        FrameLayout popUpPap = (FrameLayout) findViewById(R.id.popUpPap);
        popUpPap.setVisibility(View.INVISIBLE);
    }

    public void tickEau(View view) {
        this.commande.setCallWater(true);
        setTickEau();
    }

    private void setTickEau() {
        if (this.commande.isCallWater()) {
            ImageView tick = new ImageView(this);
            tick.setBackground(getResources().getDrawable(R.mipmap.ic_tick));
            FrameLayout frame = (FrameLayout) findViewById(R.id.pin_eau);
            frame.addView(tick);
        }
    }

    public void tickPain(View view) {
        this.commande.setCallBread(true);
        setTickPain();
    }

    private void setTickPain() {
        if (this.commande.isCallBread()) {
            ImageView tick = new ImageView(this);
            tick.setBackground(getResources().getDrawable(R.mipmap.ic_tick));
            FrameLayout frame = (FrameLayout) findViewById(R.id.pin_pain);
            frame.addView(tick);
        }
    }

    public void tickServeur(View view) {
        this.commande.setCallWaiter(true);
        setTickServeur();
    }

    private void setTickServeur() {
        if (this.commande.isCallWaiter()) {
            ImageView tick = new ImageView(this);
            tick.setBackground(getResources().getDrawable(R.mipmap.ic_tick));
            FrameLayout frame = (FrameLayout) findViewById(R.id.pin_serveur);
            frame.addView(tick);
        }
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
        TableLayout tl = (TableLayout) findViewById(R.id.recapitulatif);
        tl.removeAllViews();
        this.drawOrder();

        TextView totalPrice = (TextView) findViewById(R.id.total_price);
        totalPrice.setText(String.format("%.2f", getCommande().getPrice()) + "€");
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void drawOrder() {
        /* Récupération du table layout */
        TableLayout tl = (TableLayout) findViewById(R.id.recapitulatif);
        TableRow tr;
        TextView label;

        TableRow.LayoutParams rowlayoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        rowlayoutParams.setMargins(5, 5, 5, 5);
        TableLayout.LayoutParams tableLayoutParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT);

        TableRow.LayoutParams imageLayoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        int marginTopBottom = getResources().getDrawable(R.mipmap.minus).getMinimumHeight() / 5;
        imageLayoutParams.setMargins(5,-marginTopBottom,5,-marginTopBottom);

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
            label.setTextSize(20);
            tr.addView(label);
            tl.addView(tr, tableLayoutParams);

            for (final String key : this.getCommande().getListEntrees().keySet()) {
                tr = new TableRow(this);
                tr.setLayoutParams(rowlayoutParams);

                label = new TextView(this);
                label.setText(key);
                label.setLayoutParams(rowlayoutParams);
                tr.addView(label);

                label = new TextView(this);
                label.setText(" (x" + Integer.toString(this.getCommande().getListEntrees().get(key)) + ") ");
                label.setLayoutParams(rowlayoutParams);
                tr.addView(label);

                ImageButton btn = new ImageButton(this);
                btn.setBackground(getResources().getDrawable(R.mipmap.minus));
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getCommande().removeEntree(key);
                        getCommande().substractToPrice(getPricesTable().get(key));
                        refreshRecap();
                    }
                });
                btn.setLayoutParams(imageLayoutParams);
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
            label.setTextSize(20);
            tr.addView(label);
            tl.addView(tr, tableLayoutParams);

            for (final String key : this.getCommande().getListPlats().keySet()) {
                tr = new TableRow(this);
                tr.setLayoutParams(rowlayoutParams);

                label = new TextView(this);
                label.setText(key);
                label.setLayoutParams(rowlayoutParams);
                tr.addView(label);

                label = new TextView(this);
                label.setText(" (x" + Integer.toString(this.getCommande().getListPlats().get(key))+ ")");
                label.setLayoutParams(rowlayoutParams);
                tr.addView(label);

                ImageButton btn = new ImageButton(this);
                btn.setBackground(getResources().getDrawable(R.mipmap.minus));
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getCommande().removePlat(key);
                        getCommande().substractToPrice(getPricesTable().get(key));
                        refreshRecap();
                    }
                });
                btn.setLayoutParams(imageLayoutParams);
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
            label.setTextSize(20);
            tr.addView(label);
            tl.addView(tr, tableLayoutParams);

            for (final String key : this.getCommande().getListDesserts().keySet()) {
                tr = new TableRow(this);
                tr.setLayoutParams(rowlayoutParams);

                label = new TextView(this);
                label.setText(key);
                label.setLayoutParams(rowlayoutParams);
                tr.addView(label);

                label = new TextView(this);
                label.setText(" (x" + Integer.toString(this.getCommande().getListDesserts().get(key))+")");
                label.setLayoutParams(rowlayoutParams);
                tr.addView(label);

                ImageButton btn = new ImageButton(this);
                btn.setBackground(getResources().getDrawable(R.mipmap.minus));
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getCommande().removeDessert(key);
                        getCommande().substractToPrice(getPricesTable().get(key));
                        refreshRecap();
                    }
                });
                btn.setLayoutParams(imageLayoutParams);
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
            label.setTextSize(20);
            label.setLayoutParams(rowlayoutParams);
            tr.addView(label);
            tl.addView(tr, tableLayoutParams);

            for (final String key : this.getCommande().getListBoissons().keySet()) {
                tr = new TableRow(this);
                tr.setLayoutParams(rowlayoutParams);

                label = new TextView(this);
                label.setText(key);
                label.setLayoutParams(rowlayoutParams);
                tr.addView(label);

                label = new TextView(this);
                label.setText(" (x" + Integer.toString(this.getCommande().getListBoissons().get(key))+")");
                label.setLayoutParams(rowlayoutParams);
                tr.addView(label);

                ImageButton btn = new ImageButton(this);
                btn.setBackground(getResources().getDrawable(R.mipmap.minus));
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getCommande().removeBoisson(key);
                        getCommande().substractToPrice(getPricesTable().get(key));
                        refreshRecap();
                    }
                });
                btn.setLayoutParams(imageLayoutParams);
                tr.addView(btn);

                tl.addView(tr, tableLayoutParams);
            }
        }

        /*
        Ajout des Menus
         */
        if (!this.commande.getListMenus().isEmpty()) {
            /* Création de la nouvelle ligne à rajouter */
            tr = new TableRow(this);
            tr.setLayoutParams(rowlayoutParams);
            label = new TextView(this);
            label.setText(R.string.text_menus);
            label.setTextSize(20);
            label.setLayoutParams(rowlayoutParams);
            tr.addView(label);
            tl.addView(tr, tableLayoutParams);

            for (final String key : this.getCommande().getListMenus().keySet()) {
                tr = new TableRow(this);
                tr.setLayoutParams(rowlayoutParams);

                label = new TextView(this);
                label.setText(key);
                label.setLayoutParams(rowlayoutParams);
                tr.addView(label);

                label = new TextView(this);
                label.setText(" (x" + Integer.toString(this.getCommande().getListMenus().get(key))+")");
                label.setLayoutParams(rowlayoutParams);
                tr.addView(label);

                ImageButton btn = new ImageButton(this);
                btn.setBackground(getResources().getDrawable(R.mipmap.minus));
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getCommande().removeMenu(key);
                        getCommande().substractMenu(key);
                        refreshRecap();
                    }
                });
                btn.setLayoutParams(imageLayoutParams);
                tr.addView(btn);

                tl.addView(tr, tableLayoutParams);
            }
        }
    }
}
