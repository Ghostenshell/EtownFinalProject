package com.example.awnet.convertcalc1_3;

/**
 * @StealthPavilion
 * @awnetworking
 *
 * Imports used for the main drawer menu.  Intent not used as action bar is not used and BubbleView
 *      cannot be instantiated.
 *      Bundle -- Handles passing of date.
 *      All other imports with the exception of ActionBar draw from the XML activity, content, and nav_header
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * @MainActivity -- All java code needs a Main or Main activity.  This activity extends App Compat which is part of the Fragment activity.
 *      The listener listens for the menu item clicked
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /**
     *
     * @param savedInstanceState -- overrides all savedInstances to produce the drawer bar on the left side.
     * Bundle used for the transfer of data between saved instances
     *      Fab button commented out due to producing an error in Main
     *      DrawerLayout references pre written java code or high level code.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        /*FloatingActionButton fab = (FloatingActionButton) findViewById( R.id.fab );
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make( view, "Replace with your own action", Snackbar.LENGTH_LONG )
                        .setAction( "Action", null ).show();
            }
        } );*/

        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
        drawer.addDrawerListener( toggle );
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById( R.id.nav_view );
        navigationView.setNavigationItemSelectedListener( this );

        if (savedInstanceState == null) {
         getSupportFragmentManager().beginTransaction().replace( R.id.fragment_container,
                    new CalculatorFragment() ).commit();
            navigationView.setCheckedItem( R.id.nav_calculator );
        }
    }

    /**
     * basic code.  If back button pressed on phone close drawer if drawer is open else do nothing
      */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        if (drawer.isDrawerOpen( GravityCompat.START )) {
            drawer.closeDrawer( GravityCompat.START );
        } else {
            super.onBackPressed();
        }
    }

    /**
     *
     * @param menu -- Action bar not used at this time
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.main, menu );
        return true;
    }

    /**
     *
     * @param item  -- if Item selected the go to Fragment if True
     * @return -- returns true if item is selected.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //no inspection Simplifiable If Statement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected( item );
    }

    /**
     *
     * @param item -- If True return Fragments
     * @return -- If True return Fragments
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

       //if (id == R.id.nav_bubbles) {
         // getSupportFragmentManager().beginTransaction().replace( R.id.fragment_container,
          // new BubbleView()).commit();
       //}
       if (id == R.id.nav_calculator) {
            // Handle the calculator action
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new CalculatorFragment()).commit();
        }else if (id == R.id.nav_kitchen) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new KitchenFragment()).commit();
        }else if (id == R.id.nav_amort) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new AmortFragment()).commit();
        }else if (id == R.id.nav_manage) {

        }else if (id == R.id.nav_share) {
            Toast.makeText( this, "@Facebook, @Twitter", Toast.LENGTH_SHORT ).show();

        }else if (id == R.id.nav_send) {
            Toast.makeText( this, "StealthPavilion@live.com", Toast.LENGTH_SHORT ).show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        drawer.closeDrawer( GravityCompat.START );
        return true;
    }
}
