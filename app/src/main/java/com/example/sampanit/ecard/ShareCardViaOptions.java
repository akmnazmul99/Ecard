package com.example.sampanit.ecard;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
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
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class ShareCardViaOptions extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, BlueToothDialog.communicator {

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
        grid=(GridView)findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(ShareCardViaOptions.this, "You Clicked at " + id, Toast.LENGTH_SHORT).show();

                if (position == 0) {

                    FragmentManager manager = getFragmentManager();
                    BlueToothDialog blueToothDialog = new BlueToothDialog();
                    blueToothDialog.show(manager, "BlueToothDialog");



                   // onClickBluetoothListener();
                   // Intent bluetooth_intent = new Intent(ShareCardViaOptions.this, SignUp.class);
                  //  startActivity(bluetooth_intent);
                } else if (position == 1) {
                    //Intent email_intent = new Intent(ShareCardViaOptions.this, AllContacts.class);
                    //startActivity(email_intent);
                }  else if (position == 2) {
                    Intent facebook_intent = new Intent(ShareCardViaOptions.this, AllContacts.class);
                    startActivity(facebook_intent);
                } else if (position == 3) {
                    Intent gmail_intent = new Intent(ShareCardViaOptions.this, AllContacts.class);
                    startActivity(gmail_intent);
                } else if (position == 4) {
                    Intent google_plus_intent = new Intent(ShareCardViaOptions.this, AllContacts.class);
                    startActivity(google_plus_intent);
                }
                else if (position == 5) {
                    Intent messaging_intent = new Intent(ShareCardViaOptions.this, AllContacts.class);
                    startActivity(messaging_intent);
                }
            }
        });
    }

/*    public void onClickBluetoothListener(){
        grid_click_item = (GridView)findViewById(R.id.grid);
        grid_click_item.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder bluetooth_alert_dialog = new AlertDialog.Builder(ShareCardViaOptions.this);
                        bluetooth_alert_dialog.setMessage("This is a Test")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                         Intent bluetooth_intent = new Intent(ShareCardViaOptions.this, SignUp.class);
                                          startActivity(bluetooth_intent);
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alert_dialog = bluetooth_alert_dialog.create();
                        alert_dialog.setTitle("Alert!!!");
                        alert_dialog.show();
                    }
                }
        );
    }*/

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
            Intent nav_all_cantacts_intent = new Intent(ShareCardViaOptions.this, AllContacts.class);
            startActivity(nav_all_cantacts_intent);
        }
        else if (id == R.id.nav_all_cards) {

        }
        else if (id == R.id.nav_settings) {
            Intent nav_setting_intent = new Intent(ShareCardViaOptions.this, Settings.class);
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

    @Override
    public void dialogActivity() {
         Intent bluetooth_intent = new Intent(ShareCardViaOptions.this, SignUp.class);
          startActivity(bluetooth_intent);
    }
}
