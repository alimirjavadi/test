package com.example.testexam1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterName extends RecyclerView.Adapter<NameViewHolder> {

    String[] name= {};
    int[] ids={};

    public AdapterName(){
        Templistitem templistitem = new Templistitem();
         name = templistitem.getname();
         ids = templistitem.getavatar();
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview,parent,false);
        return new NameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        holder.setitems(name[position],ids[position]);
    }

    @Override
    public int getItemCount() {
        return name.length;
    }
}
