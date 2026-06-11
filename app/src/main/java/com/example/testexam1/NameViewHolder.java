package com.example.testexam1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NameViewHolder extends RecyclerView.ViewHolder {

    private ImageView image_item ;
    private TextView textView;
    public NameViewHolder(@NonNull View itemView) {
        super(itemView);
        image_item = itemView.findViewById(R.id.img_main);
        textView = itemView.findViewById(R.id.tv_main);
    }
    public void setitems(String name , int imageid){
        textView.setText(name);
        image_item.setImageResource(imageid);
        image_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),name,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
