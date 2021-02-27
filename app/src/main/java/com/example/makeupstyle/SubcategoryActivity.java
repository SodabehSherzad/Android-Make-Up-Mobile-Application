package com.example.makeupstyle;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.List;

public class SubcategoryActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<ModelClass> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcategory);
//        if(MainActivity.name == "fa"){
//            this.setTitle("کتگوری ها");
//        }
        recyclerView=findViewById(R.id.recyclerViewSub);

        arrayList = MainActivity.databaseHelper.getSubcategory(MainActivity.imageIndex);

        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        SubcategoryRecyclerAdapter adapter = new SubcategoryRecyclerAdapter(this, arrayList);
        recyclerView.setAdapter(adapter);
        MainActivity.databaseHelper.close();
    }

}
