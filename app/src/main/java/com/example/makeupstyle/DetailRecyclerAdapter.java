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

import java.util.ArrayList;
import java.util.List;

public class DetailRecyclerAdapter extends RecyclerView.Adapter<DetailRecyclerAdapter.ViewHolder> {
    List<ModelClass> data;
    Context context;
    ArrayList<String> images = new ArrayList<>();

    public DetailRecyclerAdapter(Context context, List<ModelClass> data) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public DetailRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.detail_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailRecyclerAdapter.ViewHolder holder, int position) {
        int imageId = context.getResources().getIdentifier(data.get(position).getPhase_image(), "drawable", context.getPackageName());
        images.add(position, data.get(position).getPhase_image());
        holder.image.setImageResource(imageId);
        holder.number.setText((position + 1) + "");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        TextView number;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
            number = itemView.findViewById(R.id.number);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, DetailsPhoto.class);
            intent.putStringArrayListExtra("images", images);
            intent.putExtra("image", data.get(getAdapterPosition()).getPhase_image());
            context.startActivity(intent);
        }
    }

}

