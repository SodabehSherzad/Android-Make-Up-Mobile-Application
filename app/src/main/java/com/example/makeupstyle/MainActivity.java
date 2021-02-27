package com.example.makeupstyle;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static DatabaseHelper databaseHelper;
    public static int imageIndex;
    NavigationView navigationView;
    DrawerLayout drawer;
//    Locale current = getResources().getConfiguration().locale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        String current = Locale.getDefault().getLanguage();
//        Locale current = getResources().getConfiguration().locale;
//        changeLanguage(current.toString());
        setContentView(R.layout.activity_home);
        navigationView = findViewById(R.id.nav_view);
        drawer = findViewById(R.id.drawer_layout);
        databaseHelper = new DatabaseHelper(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

//        SharedPreferences sharedPreferences1 = this.getSharedPreferences(this.getPackageName(), Context.MODE_PRIVATE);
//        name = sharedPreferences1.getString("language", "");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        saveLanguage();
        switch (item.getItemId()) {
            case R.id.english:
                changeLanguage("en");
                break;
            case R.id.persain:
                changeLanguage("fa");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
////        saveLanguage();
//        switch (item.getItemId()) {
//            case R.id.english:
//                name = "en";
//                changeLanguage("en");
////                setContentView(R.layout.activity_home);
////                face.setText("Face");
////                nail.setText("Nails");
////                hair.setText("Hair");
////                navigationView.getMenu().getItem(0).setTitle("Photos");
////                navigationView.getMenu().getItem(1).setTitle("About");
////                navigationView.getMenu().getItem(2).setTitle("Share");
////                MainActivity.this.setTitle("Home");
//                break;
//            case R.id.persain:
////                navigationView.getMenu().getItem(0).setTitle("گالری");
////                navigationView.getMenu().getItem(1).setTitle("درباره برنامه");
////                navigationView.getMenu().getItem(2).setTitle("به اشتراک گذاری");
//                name = "fa";
//                changeLanguage("fa");
////                MainActivity.this.setTitle("صفحه اصلی");
////                face.setText("آرایش صورت");
////                nail.setText("لاک ناخن");
////                hair.setText("مدل های مو");
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }

//    public void saveLanguage(){
//        SharedPreferences sharedPreferences = getSharedPreferences("myprefs", Context.MODE_PRIVATE);
////        sharedPreferences.edit().putBoolean("language", isChangingConfigurations());
//        sharedPreferences.edit().putString("language", name);
//        sharedPreferences.edit().apply();
//    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_photos) {
            Intent intent = new Intent(this, PhotosActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
        }else if (id == R.id.nav_share) {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Here is the share content body";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void addToList(View view){
        ImageView image = (ImageView) view;
        imageIndex = Integer.parseInt(image.getTag().toString()) + 1;
        if(imageIndex == 0){
            Intent intent = new Intent(this, SubcategoryActivity.class);
            startActivity(intent);
        }else if(imageIndex == 1){
            Intent intent = new Intent(this, SubcategoryActivity.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(this, SubcategoryActivity.class);
            startActivity(intent);
        }
    }

    public void changeLanguage(String lan){
        Locale locale = new Locale(lan);
        Locale.setDefault(locale);

        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
    }

    //        face = findViewById(R.id.face);
//        nail = findViewById(R.id.nail);
//        hair = findViewById(R.id.hair);
//        if(name == "fa"){
//            MainActivity.this.setTitle("صفحه اصلی");
//            face.setText("آرایش صورت");
//            nail.setText("لاک ناخن");
//            hair.setText("مدل های مو");
//        }
//        if(name == "fa"){
//            navigationView.getMenu().getItem(0).setTitle("گالری");
//            navigationView.getMenu().getItem(1).setTitle("درباره برنامه");
//            navigationView.getMenu().getItem(2).setTitle("به اشتراک گذاری");
//        }
//        else{
//            navigationView.getMenu().getItem(0).setTitle("Photos");
//            navigationView.getMenu().getItem(1).setTitle("About");
//            navigationView.getMenu().getItem(2).setTitle("Share");
//        }
//
//        if(name == "fa"){
//            MainActivity.this.setTitle("Home");
//        }
}
