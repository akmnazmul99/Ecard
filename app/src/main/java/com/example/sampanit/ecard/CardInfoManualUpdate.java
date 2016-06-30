package com.example.sampanit.ecard;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class CardInfoManualUpdate extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static Button button_select_card, button_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_info_manual_update);
        Toolbar toolbar = (Toolbar) findViewById(R.id.card_info_manual_update_toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.card_info_manual_update_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        onClickSelectCardButtonListener();
        onClickGoToNextButtonListener();
    }

    public void onClickSelectCardButtonListener(){
        button_select_card = (Button)findViewById(R.id.select_card_button);
        button_select_card.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent select_card_intent = new Intent(CardInfoManualUpdate.this, AllCards.class);
                        startActivity(select_card_intent);
                    }
                }
        );
    }

    public void onClickGoToNextButtonListener(){
        button_next = (Button)findViewById(R.id.next_button);
        button_next.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent select_card_intent = new Intent(CardInfoManualUpdate.this, FontSelection.class);
                        startActivity(select_card_intent);
                    }
                }
        );
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.card_info_manual_update, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.card_search) {
            //return true;
        }
        else if(id == R.id.select_card){
            Intent select_card_intent = new Intent(CardInfoManualUpdate.this, AllCards.class);
            startActivity(select_card_intent);
        }
        else if(id == R.id.create_card){
            Intent create_card_intent = new Intent(CardInfoManualUpdate.this, CardInfoManualUpdate.class);
            startActivity(create_card_intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            Intent nav_profile_intent = new Intent(CardInfoManualUpdate.this, SingleContact.class);
            startActivity(nav_profile_intent);
        } else if (id == R.id.nav_all_cantacts) {
            Intent nav_all_cantacts_intent = new Intent(CardInfoManualUpdate.this, AllContacts.class);
            startActivity(nav_all_cantacts_intent);
        }
        else if (id == R.id.nav_all_cards) {
            Intent nav_all_cards_intent = new Intent(CardInfoManualUpdate.this, AllCards.class);
            startActivity(nav_all_cards_intent);
        }
        else if (id == R.id.nav_settings) {
            Intent nav_setting_intent = new Intent(CardInfoManualUpdate.this, Settings.class);
            startActivity(nav_setting_intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
