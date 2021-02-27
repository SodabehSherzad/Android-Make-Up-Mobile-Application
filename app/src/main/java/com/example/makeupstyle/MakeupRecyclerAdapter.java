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

  public class MakeupRecyclerAdapter extends RecyclerView.Adapter<MakeupRecyclerAdapter.ViewHolder> {
    List<ModelClass> data;
    Context context;
    public MakeupRecyclerAdapter(Context context, List<ModelClass> data){
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public MakeupRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.makeup_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MakeupRecyclerAdapter.ViewHolder holder, int position) {
        int imageId = context.getResources().getIdentifier(data.get(position).getImage_makeup(),
                "drawable", context.getPackageName());
        holder.image.setImageResource(imageId);
        holder.name.setText(data.get(position).getName_makeup());
        holder.desc.setText(data.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        ImageView image;
        TextView name, desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_makeup);
            name = itemView.findViewById(R.id.name_makeup);
            desc = itemView.findViewById(R.id.desc);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent=new Intent(context, DetailActivity.class);
            intent.putExtra("makeup_id", data.get(getAdapterPosition()).getId_makeup());
            intent.putExtra("name", data.get(getAdapterPosition()).getName_makeup());
            intent.putExtra("desc", data.get(getAdapterPosition()).getDesc());
            intent.putExtra("img", data.get(getAdapterPosition()).getImage_makeup());
            context.startActivity(intent);

        }
    }
}
