package com.example.sql_lite_revision;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.view_holder>   {
    List<model> models = new ArrayList<>(); ;
    Context context;
    ON_item_click_lisner  on_item_click_lisner;

    public Adapter(List<model> models, Context context ,ON_item_click_lisner on_item_click_lisner) {
        this.models = models;
        this.context = context;
       this.on_item_click_lisner = on_item_click_lisner;
    }

    @NonNull
    @Override
    public view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        view_holder instance = new view_holder(view ,on_item_click_lisner);
        return instance;
    }

    @Override
    public void onBindViewHolder(@NonNull final view_holder holder, final int position) {
        holder.title.setText(models.get(position).getTitle());
        holder.desc.setText(models.get(position).getDesc());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                on_item_click_lisner.on_click_lisner(String.valueOf(position),view);
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    class view_holder extends RecyclerView.ViewHolder {
        TextView title ,desc;
        public view_holder(@NonNull View itemView , ON_item_click_lisner on_item_click_lisner) {
            super(itemView);

            title = itemView.findViewById(R.id.item_title);
            desc = itemView.findViewById(R.id.item_desc);
        }


    }


    interface ON_item_click_lisner{
       void on_click_lisner(String id , View view );
    }
}
