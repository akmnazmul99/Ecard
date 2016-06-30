package com.example.sampanit.ecard;

import android.content.Intent;
import android.graphics.Typeface;
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
import android.widget.RadioButton;

public class FontSelection extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static Button button_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_font_selection);
        Toolbar toolbar = (Toolbar) findViewById(R.id.font_selection_toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.font_selection_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        RadioButton rb_txt_1 = (RadioButton) findViewById(R.id.font_1);
        Typeface font_1 = Typeface.createFromAsset(getAssets(), "fonts/angelina.TTF");
        rb_txt_1.setTypeface(font_1);

        RadioButton rb_txt_2 = (RadioButton) findViewById(R.id.font_2);
        Typeface font_2 = Typeface.createFromAsset(getAssets(), "fonts/Army.ttf");
        rb_txt_2.setTypeface(font_2);

        RadioButton rb_txt_3 = (RadioButton) findViewById(R.id.font_3);
        Typeface font_3 = Typeface.createFromAsset(getAssets(), "fonts/Bellerose.ttf");
        rb_txt_3.setTypeface(font_3);

        RadioButton rb_txt_4 = (RadioButton) findViewById(R.id.font_4);
        Typeface font_4 = Typeface.createFromAsset(getAssets(), "fonts/CLOSCP__.TTF");
        rb_txt_4.setTypeface(font_4);

        RadioButton rb_txt_5 = (RadioButton) findViewById(R.id.font_5);
        Typeface font_5 = Typeface.createFromAsset(getAssets(), "fonts/DroidSans-Bold.ttf");
        rb_txt_5.setTypeface(font_5);

        RadioButton rb_txt_6 = (RadioButton) findViewById(R.id.font_6);
        Typeface font_6 = Typeface.createFromAsset(getAssets(), "fonts/FortuneCity.ttf");
        rb_txt_6.setTypeface(font_6);

        RadioButton rb_txt_7 = (RadioButton) findViewById(R.id.font_7);
        Typeface font_7 = Typeface.createFromAsset(getAssets(), "fonts/DroidSerif-Regular.ttf");
        rb_txt_7.setTypeface(font_7);

        RadioButton rb_txt_8 = (RadioButton) findViewById(R.id.font_8);
        Typeface font_8 = Typeface.createFromAsset(getAssets(), "fonts/DroidSerif-Bold.ttf");
        rb_txt_8.setTypeface(font_8);

        RadioButton rb_txt_9 = (RadioButton) findViewById(R.id.font_9);
        Typeface font_9 = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Bold.ttf");
        rb_txt_9.setTypeface(font_9);

        RadioButton rb_txt_10 = (RadioButton) findViewById(R.id.font_10);
        Typeface font_10 = Typeface.createFromAsset(getAssets(), "fonts/Quicksand-Bold.otf");
        rb_txt_10.setTypeface(font_10);

        RadioButton rb_txt_11 = (RadioButton) findViewById(R.id.font_11);
        Typeface font_11 = Typeface.createFromAsset(getAssets(), "fonts/Sansation_Bold.ttf");
        rb_txt_11.setTypeface(font_11);

        RadioButton rb_txt_12 = (RadioButton) findViewById(R.id.font_12);
        Typeface font_12 = Typeface.createFromAsset(getAssets(), "fonts/Walkway Black.ttf");
        rb_txt_12.setTypeface(font_12);

        RadioButton rb_txt_13 = (RadioButton) findViewById(R.id.font_13);
        Typeface font_13 = Typeface.createFromAsset(getAssets(), "fonts/Fun Raiser.ttf");
        rb_txt_13.setTypeface(font_13);

        RadioButton rb_txt_14 = (RadioButton) findViewById(R.id.font_14);
        Typeface font_14 = Typeface.createFromAsset(getAssets(), "fonts/smart watch.ttf");
        rb_txt_14.setTypeface(font_14);

        onClickGoToNextButtonListener();
    }
    public void onClickGoToNextButtonListener(){
        button_next = (Button)findViewById(R.id.next_button);
        button_next.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent select_card_intent = new Intent(FontSelection.this, AllCards.class);
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
        getMenuInflater().inflate(R.menu.font_selection, menu);
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
            Intent select_card_intent = new Intent(FontSelection.this, AllCards.class);
            startActivity(select_card_intent);
        }
        else if(id == R.id.create_card){
            Intent create_card_intent = new Intent(FontSelection.this, CardInfoManualUpdate.class);
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
            Intent nav_profile_intent = new Intent(FontSelection.this, SingleContact.class);
            startActivity(nav_profile_intent);

        } else if (id == R.id.nav_all_cantacts) {
            Intent nav_all_cantacts_intent = new Intent(FontSelection.this, AllContacts.class);
            startActivity(nav_all_cantacts_intent);
        }
        else if (id == R.id.nav_all_cards) {
            Intent nav_all_cards_intent = new Intent(FontSelection.this, AllCards.class);
            startActivity(nav_all_cards_intent);

        }
        else if (id == R.id.nav_settings) {
            Intent nav_setting_intent = new Intent(FontSelection.this, Settings.class);
            startActivity(nav_setting_intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
