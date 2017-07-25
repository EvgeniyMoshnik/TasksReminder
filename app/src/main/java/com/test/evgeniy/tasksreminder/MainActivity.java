package com.test.evgeniy.tasksreminder;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.test.evgeniy.tasksreminder.Adapters.PagerTabAdapter;
import com.test.evgeniy.tasksreminder.Dialogs.DialogCreateTask;
import com.test.evgeniy.tasksreminder.Fragments.CalendarFragment;
import com.test.evgeniy.tasksreminder.Fragments.MainFragment;
import com.test.evgeniy.tasksreminder.Fragments.SomethingFragment;
import com.test.evgeniy.tasksreminder.Fragments.SplashFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager fragmentManager;
    PreferenceHelper preferenceHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PreferenceHelper.getInstance().init(getApplicationContext());
        preferenceHelper = PreferenceHelper.getInstance();


        //set UI
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitleTextColor(getResources().getColor(R.color.colorText));
            setSupportActionBar(toolbar);
        }


        ViewPager pager = (ViewPager) findViewById(R.id.view_pager_m);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(pager);
        fragmentManager = getSupportFragmentManager();
        PagerTabAdapter pagerAdapter = new PagerTabAdapter(fragmentManager);
        pager.setAdapter(pagerAdapter);


        pagerAdapter.addFragment(new MainFragment(), getResources().getText(R.string.tab_task).toString());
        pagerAdapter.addFragment(new CalendarFragment(), getResources().getText(R.string.tab_calendar).toString());
        pagerAdapter.addFragment(new SomethingFragment(), getResources().getText(R.string.tab_something).toString());


        startSplash();





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogCreateTask dialogCreateTask = new DialogCreateTask();
                dialogCreateTask.show(getSupportFragmentManager(), "tag_dialog");
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void addTask(String task, String timeBefore, String time) {

    }

    public void startSplash() {
        if (!preferenceHelper.getBoolean(PreferenceHelper.SPLASH_IS_INVISIBLE)) {
            SplashFragment splashFragment = new SplashFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.frame_container, splashFragment, "splash")
                    .addToBackStack(null)
                    .commit();
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
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem splashItem = menu.findItem(R.id.splash_settings);
        splashItem.setChecked(preferenceHelper.getBoolean(PreferenceHelper.SPLASH_IS_INVISIBLE));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.splash_settings) {
            item.setChecked(!item.isChecked());
            preferenceHelper.putBoolean(PreferenceHelper.SPLASH_IS_INVISIBLE, item.isChecked());
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
