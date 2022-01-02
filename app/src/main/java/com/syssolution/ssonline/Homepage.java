package com.syssolution.ssonline;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Homepage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    LinearLayout about_us, bill_pay, contact_us, coverage_area, FTP, guide_book, live_tv, packages, special_offer;
    ImageView profile, notifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);


        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);


        about_us = findViewById(R.id.LL_about_us);
        bill_pay = findViewById(R.id.LL_Bill_pay);
        contact_us = findViewById(R.id.LL_contact_us);
        coverage_area = findViewById(R.id.LL_coverage_area);
        FTP = findViewById(R.id.LL_FTP);
        guide_book = findViewById(R.id.LL_guide_book);
        live_tv = findViewById(R.id.LL_live_tv);
        packages = findViewById(R.id.LL_packages);
        special_offer = findViewById(R.id.LL_special_offer);
        profile = findViewById(R.id.profile);
        notifications = findViewById(R.id.notification);


        about_us.setOnClickListener(this);
        bill_pay.setOnClickListener(this);
        contact_us.setOnClickListener(this);
        coverage_area.setOnClickListener(this);
        FTP.setOnClickListener(this);
        live_tv.setOnClickListener(this);
        packages.setOnClickListener(this);
        guide_book.setOnClickListener(this);
        profile.setOnClickListener(this);
        notifications.setOnClickListener(this);
        special_offer.setOnClickListener(this);

        setSupportActionBar(toolbar);



        navigationView.bringToFront();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_home);

    }


    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent intent = new Intent(this, Homepage.class);
                startActivity(intent);
            case R.id.nav_view:
                break;
            case R.id.website:
                gotoURL("https://ssonlinebd.com/#");
                Toast.makeText(Homepage.this, "SS Online", Toast.LENGTH_SHORT).show();
                break;
            case R.id.facebook:
                gotoURL("https://www.facebook.com/ssonline.isp/");
                break;
            case R.id.dev_by:
                Toast.makeText(Homepage.this, "Developed by SYS Solutions", Toast.LENGTH_SHORT).show();
                break;

            case R.id.about_us:
                Intent intent3 = new Intent(Homepage.this, about_us.class);
                startActivity(intent3);
                break;
            case R.id.profile:
                Intent intent4 = new Intent(Homepage.this, Profile.class);
                startActivity(intent4);
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.LL_about_us:
                Intent intent = new Intent(Homepage.this, about_us.class);
                startActivity(intent);
                break;
            case R.id.LL_Bill_pay:
                Intent intent2 = new Intent(this, Bill_pay.class);
                startActivity(intent2);
                break;
            case R.id.LL_coverage_area:
                Intent intent3 = new Intent(Homepage.this, Cov_Area.class);
                startActivity(intent3);
                break;
            case R.id.LL_contact_us:
                Intent intent4 = new Intent(Homepage.this, Contact_us.class);
                startActivity(intent4);
                break;
            case R.id.LL_live_tv:
                Intent intent5 = new Intent(Homepage.this, Live_tv.class);
                startActivity(intent5);
                break;
            case R.id.LL_FTP:
                Intent intent6 = new Intent(Homepage.this, FTP.class);
                startActivity(intent6);
                break;
            case R.id.LL_packages:
                Intent intent7 = new Intent(Homepage.this, Packages.class);
                startActivity(intent7);
                break;

            case R.id.LL_guide_book:
                Intent intent8 = new Intent(Homepage.this, Guide.class);
                startActivity(intent8);
                break;
            case R.id.profile:
                Intent intent9 = new Intent(Homepage.this, Profile.class);
                startActivity(intent9);
                break;
            case R.id.notification:
                Intent intent10 = new Intent(Homepage.this, Notification.class);
                startActivity(intent10);
                break;
            case R.id.LL_special_offer:
                Intent intent11 = new Intent(Homepage.this, Special_offer.class);
                startActivity(intent11);
                break;
        }
    }

    private void gotoURL(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}