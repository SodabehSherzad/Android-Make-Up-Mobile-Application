package com.example.makeupstyle;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class MakeupActivity extends AppCompatActivity {

    List<ModelClass> arrayList;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makeup);
        recyclerView=findViewById(R.id.recyclerViewMakeup);

        int id = getIntent().getIntExtra("sub_id", 0);

        arrayList = MainActivity.databaseHelper.getMakeup(id);
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        MakeupRecyclerAdapter adapter=new MakeupRecyclerAdapter(this, arrayList);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}







