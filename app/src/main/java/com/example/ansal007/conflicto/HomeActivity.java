package com.example.ansal007.conflicto;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ansal007.conflicto.fragments.PostFragment;
import com.example.ansal007.conflicto.fragments.TrendingPostFragment;
import com.example.ansal007.conflicto.utilis.UIUtils;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String HOME_FRAGMENT_CONTAINER_TAG = "HOME_FRAGMENT_CONTAINER";
    private final String NEWS_FEED = "News Feed";
    private final String TRENDING_POST = "Trending Post";
    private final String MY_POST = "My Post";
    private final String FOLLOWING_POST = "Following Post";

    private PostFragment postFragment;
    private ProgressDialog progressDialog;
    TrendingPostFragment trendingPostFragment ;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setNewPostFloatingButton();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        progressDialog = UIUtils.getProgressDialogBar(this, ProgressDialog.STYLE_SPINNER, "Loading...........");
        progressDialog.show();
        postFragment = new PostFragment();
        fragmentManager = getFragmentManager();
        attachFragment( R.id.home_fragment_container, postFragment, HOME_FRAGMENT_CONTAINER_TAG);
    }

    private void attachFragment(int id, PostFragment trendingPostFragment,  String tagname) {
        progressDialog.show();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(id, trendingPostFragment, tagname);
        transaction.commit();
        progressDialog.hide();
    }



    private void setNewPostFloatingButton() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

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
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.following_menu) {

            attachFragment(R.id.home_fragment_container, postFragment, HOME_FRAGMENT_CONTAINER_TAG );
            setTitle(FOLLOWING_POST);

        } else if (id == R.id.my_post_menu) {

            attachFragment(R.id.home_fragment_container, postFragment, HOME_FRAGMENT_CONTAINER_TAG );
            setTitle(MY_POST);

        } else if (id == R.id.news_feed_menu) {

            attachFragment(R.id.home_fragment_container, postFragment, HOME_FRAGMENT_CONTAINER_TAG );
            setTitle(NEWS_FEED);

        } else if (id == R.id.top_trending_menu) {

            attachFragment(R.id.home_fragment_container, postFragment, HOME_FRAGMENT_CONTAINER_TAG );
            setTitle(TRENDING_POST);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
