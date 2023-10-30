package com.app.yatra_app.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.yatra_app.Models.ItemsModel;
import com.app.yatra_app.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.viewHolder> {
    ArrayList<ItemsModel> list;
    DecimalFormat decimalFormat;
    Context context;

    public PopularAdapter(ArrayList<ItemsModel> list) {
        this.list = list;
        decimalFormat=new DecimalFormat("###,###,###,###");
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular,parent,false);
        context= parent.getContext();
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.textView.setText(list.get(position).getTitle());
        holder.textView2.setText(""+list.get(position).getScore());
        holder.textView3.setText(list.get(position).getLocation());

        int drawableResourceId=holder.itemView.getResources().getIdentifier(list.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(context)
                .load(drawableResourceId)
                .transform(new CenterCrop(),new GranularRoundedCorners(40,40,40,40))
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
        TextView textView,textView2,textView3;
        ImageView imageView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.titlePoputxt);
            textView2=itemView.findViewById(R.id.scoreTxtpopu);
            textView3=itemView.findViewById(R.id.locationTxt);
            imageView=itemView.findViewById(R.id.picImage);
        }
    }
}
