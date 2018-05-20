package com.example.putriyusandayani.mycollactactivity2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    // Within which the entire activity is enclosed
    private DrawerLayout mDrawerLayout;

    // ListView represents Navigation Drawer
    private ListView mDrawerList;

    // ActionBarDrawerToggle indicates the presence of Navigation Drawer in the action bar
    private ActionBarDrawerToggle mDrawerToggle;

    // Title of the action bar
    private String mTitle = "";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = "Jadwal Pelajaran";
        getActionBar().setTitle(mTitle);

        // Getting reference to the DrawerLayout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mDrawerList = (ListView) findViewById(R.id.drawer_list);

        // Getting reference to the ActionBarDrawerToggle
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_drawer, R.string.drawer_open,
                R.string.drawer_close) {

            /** Called when drawer is closed */
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu();

            }

            /** Called when a drawer is opened */
            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle("Jadwal Pelajaran");
                invalidateOptionsMenu();
            }

        };

        // Setting DrawerToggle on DrawerLayout
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        // Creating an ArrayAdapter to add items to the listview mDrawerList
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(),
                R.layout.drawer_list_item, getResources().getStringArray(R.array.menus));

        // Setting the adapter on mDrawerList
        mDrawerList.setAdapter(adapter);

        // Enabling Home button
        getActionBar().setHomeButtonEnabled(true);

        // Enabling Up navigation
        getActionBar().setDisplayHomeAsUpEnabled(true);

        // Setting item click listener for the listview mDrawerList
        mDrawerList.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // Getting an array of rivers
                String[] menuItems = getResources().getStringArray(R.array.menus);

                // Currently selected river
                mTitle = menuItems[position];
                if (mTitle.equals("Tambah Jadwal")){
                    FragmentTambahJadwal fragmentone = new FragmentTambahJadwal();
                    FragmentManager fragmentManager = getFragmentManager();

                    // Creating a fragment transaction
                    FragmentTransaction ft = fragmentManager.beginTransaction();

                    // Adding a fragment to the fragment transaction
                    ft.replace(R.id.content_frame, fragmentManager);

                    // Committing the transaction
                    ft.commit();

                }else{
                    // Creating a fragment object
                    ListFragment rFragment = new ListFragment();

                    // Passing selected item information to fragment
                    Bundle data = new Bundle();
                    data.putInt("position", position);
                    //data.putString("url", getUrl(position));
                    rFragment.setArguments(data);

                    // Getting reference to the FragmentManager
                    FragmentManager fragmentManager = getFragmentManager();

                    // Creating a fragment transaction
                    FragmentTransaction ft = fragmentManager.beginTransaction();

                    // Adding a fragment to the fragment transaction
                    ft.replace(R.id.content_frame, rFragment);

                    // Committing the transaction
                    ft.commit();
                }
                // Closing the drawer
                mDrawerLayout.closeDrawer(mDrawerList);

            }
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /** Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);

        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}