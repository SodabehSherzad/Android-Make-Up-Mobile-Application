package com.example.makeupstyle;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;


public class DetailsPhoto extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewpager);

        ViewPager mViewPager = findViewById(R.id.viewPage);

        ArrayList<String> images = new ArrayList<>();
        images.addAll(getIntent().getStringArrayListExtra("images"));
        ImageAdapter adapterView = new ImageAdapter(this, images);
        mViewPager.setAdapter(adapterView);
        mViewPager.setCurrentItem(images.indexOf(getIntent().getStringExtra("image")));

    }

    public void goBack(View view){
        onBackPressed();
    }
}