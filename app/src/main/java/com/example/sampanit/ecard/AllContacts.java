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
import android.widget.ImageView;
import android.widget.LinearLayout;

public class AllContacts extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ImageView imageViewRound;
    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_contacts);
        Toolbar toolbar = (Toolbar) findViewById(R.id.all_contacts_toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.all_contacts_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        imageViewRound =(ImageView)findViewById(R.id.contact_imageView_round_1);
        imageViewRound =(ImageView)findViewById(R.id.contact_imageView_round_2);
        imageViewRound =(ImageView)findViewById(R.id.contact_imageView_round_3);
        imageViewRound =(ImageView)findViewById(R.id.contact_imageView_round_4);
        imageViewRound =(ImageView)findViewById(R.id.contact_imageView_round_5);
        imageViewRound =(ImageView)findViewById(R.id.contact_imageView_round_6);
        imageViewRound =(ImageView)findViewById(R.id.contact_imageView_round_7);
        imageViewRound =(ImageView)findViewById(R.id.contact_imageView_round_8);
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
        getMenuInflater().inflate(R.menu.all_contacts, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_profile) {

        } else if (id == R.id.nav_all_cantacts) {
            Intent nav_all_cantacts_intent = new Intent(AllContacts.this, AllContacts.class);
            startActivity(nav_all_cantacts_intent);
        }
        else if (id == R.id.nav_all_cards) {

        }
        else if (id == R.id.nav_settings) {
            Intent nav_setting_intent = new Intent(AllContacts.this, Settings.class);
            startActivity(nav_setting_intent);
        }
//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
