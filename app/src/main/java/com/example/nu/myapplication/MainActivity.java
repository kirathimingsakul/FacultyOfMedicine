package com.example.nu.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.nu.myapplication.contect.Contect_fragment;
import com.example.nu.myapplication.introduce.Introduce_Fragment;
import com.example.nu.myapplication.network.NetworkFragment;
import com.example.nu.myapplication.rdu.Rdu_Fragment;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ViewPager viewPager;
    CardView btn, btn2, btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        btn2 = findViewById(R.id.btn2);
        btn6 = findViewById(R.id.btn6);

        viewPager = findViewById(R.id.viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTinerTask(), 10000, 100000);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        Onclick_CardView

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Introduce_Fragment introduce_fragment = new Introduce_Fragment();
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.show, introduce_fragment, introduce_fragment.getTag()).commit();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NetworkFragment networkFragment = new NetworkFragment();
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.show, networkFragment, networkFragment.getTag()).commit();
            }
        });


        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contect_fragment contect_fragment = new Contect_fragment();
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.show, contect_fragment, contect_fragment.getTag()).commit();

            }
        });

    }

    @Override
    public void onBackPressed() {

            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("คุณต้องการออกจากระบบใช่หรือไม่");
            builder.setCancelable(true);
            builder.setNegativeButton("ใช่", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            builder.setPositiveButton("ไม่", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        } else if (id == R.id.introduction) {

            Introduce_Fragment introduce_fragment = new Introduce_Fragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.show, introduce_fragment, introduce_fragment.getTag()).commit();

        } else if (id == R.id.nav_slideshow) {
            NetworkFragment networkFragment = new NetworkFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.show, networkFragment, networkFragment.getTag()).commit();

        } else if (id == R.id.doctor) {

        } else if (id == R.id.rdu) {
            Rdu_Fragment rdu_fragment = new Rdu_Fragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.show, rdu_fragment, rdu_fragment.getTag()).commit();

        } else if (id == R.id.contact) {
            Contect_fragment contect_fragment = new Contect_fragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.show, contect_fragment, contect_fragment.getTag()).commit();
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public class MyTinerTask extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() == 0) {
                        viewPager.setCurrentItem(1);
                    } else if (viewPager.getCurrentItem() == 1) {
                        viewPager.setCurrentItem(2);
                    } else {
                        viewPager.setCurrentItem(1);
                    }
                }
            });
        }
    }


}
