package com.example.sampanit.ecard;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
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
import android.widget.ImageView;

public class ProfilePicture extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static Button button_image_download;
    private static ImageView profile_picture_image_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_picture);
        Toolbar toolbar = (Toolbar) findViewById(R.id.profile_picture_toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.profile_picture_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        button_image_download = (Button)findViewById(R.id.b_image_download);
        profile_picture_image_view = (ImageView)findViewById(R.id.iv_image);

        button_image_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent image_download = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                image_download.putExtra("crop","true");
                image_download.putExtra("aspectX", 1);
                image_download.putExtra("aspectY", 1);
                image_download.putExtra("outputX", 200);
                image_download.putExtra("outputY", 200);
                image_download.putExtra("return-data", true);
                startActivityForResult(image_download, 2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2 && resultCode == RESULT_OK && data != null){
            Bundle extras = data.getExtras();
            Bitmap bitmap_image = extras.getParcelable("data");
            profile_picture_image_view.setImageBitmap(bitmap_image);

        }
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
        getMenuInflater().inflate(R.menu.profile_picture, menu);
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
            Intent select_card_intent = new Intent(ProfilePicture.this, AllCards.class);
            startActivity(select_card_intent);
        }
        else if(id == R.id.create_card){
            Intent create_card_intent = new Intent(ProfilePicture.this, CardInfoManualUpdate.class);
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
            Intent nav_profile_intent = new Intent(ProfilePicture.this, SingleContact.class);
            startActivity(nav_profile_intent);

        } else if (id == R.id.nav_all_cantacts) {
            Intent nav_all_cantacts_intent = new Intent(ProfilePicture.this, AllContacts.class);
            startActivity(nav_all_cantacts_intent);
        }
        else if (id == R.id.nav_all_cards) {
            Intent nav_all_cards_intent = new Intent(ProfilePicture.this, AllCards.class);
            startActivity(nav_all_cards_intent);

        }
        else if (id == R.id.nav_settings) {
            Intent nav_setting_intent = new Intent(ProfilePicture.this, Settings.class);
            startActivity(nav_setting_intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
