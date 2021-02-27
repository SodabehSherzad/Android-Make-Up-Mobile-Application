package com.example.makeupstyle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DetailActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<ModelClass> arrayList;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_detail);
             recyclerView = findViewById(R.id.recyclerViewDetail);

            int id = getIntent().getIntExtra("makeup_id", 0);
            arrayList = MainActivity.databaseHelper.getDetails(id);
            ImageView  image = findViewById(R.id.detail_image);
            TextView name = findViewById(R.id.makeup_name_desc);

            String name_makeup = getIntent().getStringExtra("name");
            String img_makeup = getIntent().getStringExtra("img");
            String desc_makeup = getIntent().getStringExtra("desc");

            name.setText(name_makeup);
            int imageId = this.getResources().getIdentifier(img_makeup, "drawable", this.getPackageName());
            image.setImageResource(imageId);

            TextView desc = findViewById(R.id.desc);
            desc.setText(desc_makeup);

            DetailRecyclerAdapter adapter=new DetailRecyclerAdapter(this, arrayList);
            recyclerView.setAdapter(adapter);

            StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,
                    StaggeredGridLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(staggeredGridLayoutManager);


        }

        public void goBack(View view){
            super.onBackPressed();
        }
}
