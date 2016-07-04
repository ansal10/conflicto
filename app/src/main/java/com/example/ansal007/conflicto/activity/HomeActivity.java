package com.example.ansal007.conflicto.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.example.ansal007.conflicto.R;
import com.example.ansal007.conflicto.adapter.Topic;
import com.example.ansal007.conflicto.adapter.TopicAdapter;

import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private List<Topic> topicList = new ArrayList<>();
    private RecyclerView recyclerView;
    private TopicAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.topic_recycler_view);
        mAdapter = new TopicAdapter(topicList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareTopicData();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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

    private void prepareTopicData() {
        Topic topic;

        topic = new Topic("Daniel", "Are all Politicians Good", "Can we conclude that most politicians in india are better",
                23, 46, 87, 0,0, "2 min ago");
        topicList.add(topic);

        topic = new Topic("Monica", "Are all Politicians Good", "Is veg food better than non veg",
                23, 46, 871, 0,0, "2 min ago");
        topicList.add(topic);

        topic = new Topic("Sharewan", "Are all Politicians Good", "Chennai is a better place than delhi or not ??",
                23, 146, 87, 0,0, "2 min ago");
        topicList.add(topic);

        topic = new Topic("Rakshit", "Are all Politicians Good", "Do you think india can make living standards as high as singapore",
                223, 46, 87, 0,0, "2 min ago");
        topicList.add(topic);

        topic = new Topic("Demona", "Are all Politicians Good", "Django or Flask ? Which is better framework",
                23, 46, 87, 0,0, "2 min ago");
        topicList.add(topic);

        topic = new Topic("Lakshaya", "Are all Politicians Good", "Harry potter or Lord of rings ? which is considered better book",
                23, 46, 87, 0,0, "2 min ago");
        topicList.add(topic);

        topic = new Topic("Martin Luther", "Are all Politicians Good", "Can we conclude that most politicians in india are better",
                23, 46, 87, 0,0, "2 min ago");
        topicList.add(topic);

        topic = new Topic("Redclop", "Are all Politicians Good", "Can we conclude that most politicians in india are better",
                23, 46, 87, 0,0, "2 min ago");
        topicList.add(topic);

        topic = new Topic("Jharna mary beb", "Are all Politicians Good", "Can we conclude that most politicians in india are better",
                23, 46, 87, 0,0, "2 min ago");
        topicList.add(topic);
    }
}
