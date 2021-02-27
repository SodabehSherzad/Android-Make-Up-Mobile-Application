package com.example.makeupstyle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.List;

public class PhotosActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<ModelClass> arrayList;
    @SuppressLint("LongLogTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        recyclerView = findViewById(R.id.photoRecyclerView);
//        if(MainActivity.name == "fa"){
//            this.setTitle("گالری");
//        }
        arrayList = MainActivity.databaseHelper.getPhotosTable();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PhotoRecyclerAdapter adapter = new PhotoRecyclerAdapter(this, arrayList);
        recyclerView.setAdapter(adapter);

    }

}
