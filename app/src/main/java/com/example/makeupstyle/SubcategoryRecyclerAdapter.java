package com.example.makeupstyle;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SubcategoryRecyclerAdapter extends RecyclerView.Adapter<SubcategoryRecyclerAdapter.ViewHolder> {
    List<ModelClass> data;
    Context context;
    int imageId;
    public SubcategoryRecyclerAdapter(Context context, List<ModelClass> data){
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public SubcategoryRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.subcategory_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubcategoryRecyclerAdapter.ViewHolder holder, int position) {
        imageId = context.getResources().getIdentifier(data.get(position).getImage_sub(), "drawable", context.getPackageName());
        holder.image.setImageResource(imageId);
        holder.name.setText(data.get(position).getName_sub());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        ImageView image;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_sub);
            name = itemView.findViewById(R.id.name_sub);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, MakeupActivity.class);
            intent.putExtra("sub_id", data.get(getAdapterPosition()).getId_sub());
            context.startActivity(intent);
        }
    }
}
