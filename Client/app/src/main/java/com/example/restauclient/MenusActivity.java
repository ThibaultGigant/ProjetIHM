package com.example.restauclient;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenusActivity extends AbstractCustomActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);
        this.initialize();
    }

    public void goToMenuA(View view) {

        Intent intent = new Intent(this, MenuAActivity.class);
        intent.putExtra("commande", this.commande);
        startActivity(intent);
    }
    public void goToMenuB(View view) {
        Intent intent = new Intent(this, MenuBActivity.class);
        intent.putExtra("commande", this.commande);
        startActivity(intent);
    }
    public void goToMenuC(View view) {
        Intent intent = new Intent(this, MenuCActivity.class);
        intent.putExtra("commande", this.commande);
        startActivity(intent);
    }
    public void goToMenuD(View view) {
        Intent intent = new Intent(this, MenuDActivity.class);
        intent.putExtra("commande", this.commande);
        startActivity(intent);
    }
}
