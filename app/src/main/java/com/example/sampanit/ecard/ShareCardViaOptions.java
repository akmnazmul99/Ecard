package com.example.sampanit.ecard;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.ContextMenu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class ShareCardViaOptions extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    long btn;
    private String [] share_card_list_items;
    GridView grid;
    String[] grid_items = {
            "Bluetooth",
            "Email",
            "Facebook",
            "Gmail",
            "Google+",
            "Messaging"
    } ;
    int[] grid_image = {
            R.drawable.bluetooth,
            R.drawable.email,
            R.drawable.facebook,
            R.drawable.gmail,
            R.drawable.google_plus,
            R.drawable.messaging
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_card_via_options);
        Toolbar toolbar = (Toolbar) findViewById(R.id.share_card_via_options_toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.share_card_via_options_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        CustomGrid adapter = new CustomGrid(ShareCardViaOptions.this, grid_items, grid_image);
        grid=(GridView)findViewById(R.id.list);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch( position )
                {
                    case 0:
                        Intent bluetooth_intent = new Intent(ShareCardViaOptions.this, DisplayBluetoothDevices.class);
                        startActivity(bluetooth_intent);
                        break;
                    case 1:
                        Intent email_intent = new Intent(view.getContext(), EmailCompose.class);
                        startActivityForResult(email_intent, 0);
                        break;
                    case 2:
                        Toast.makeText(ShareCardViaOptions.this, "Facebook Feature is Not Available", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(ShareCardViaOptions.this, "Gmail Feature is Not Available", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(ShareCardViaOptions.this, "Google+ Feature is Not Available", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(ShareCardViaOptions.this, "Messaging Feature is Not Available", Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v.getId() == R.id.list){
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
            menu.setHeaderTitle(share_card_list_items[info.position]);
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
        getMenuInflater().inflate(R.menu.share_card_via_options, menu);
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
            Intent select_card_intent = new Intent(ShareCardViaOptions.this, AllCards.class);
            startActivity(select_card_intent);
        }
        else if(id == R.id.create_card){
            Intent create_card_intent = new Intent(ShareCardViaOptions.this, CardInfoManualUpdate.class);
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
            Intent nav_profile_intent = new Intent(ShareCardViaOptions.this, SingleContact.class);
            startActivity(nav_profile_intent);

        } else if (id == R.id.nav_all_cantacts) {
            Intent nav_all_cantacts_intent = new Intent(ShareCardViaOptions.this, AllContacts.class);
            startActivity(nav_all_cantacts_intent);
        }
        else if (id == R.id.nav_all_cards) {
            Intent nav_all_cards_intent = new Intent(ShareCardViaOptions.this, AllCards.class);
            startActivity(nav_all_cards_intent);
        }
        else if (id == R.id.nav_settings) {
            Intent nav_setting_intent = new Intent(ShareCardViaOptions.this, Settings.class);
            startActivity(nav_setting_intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
