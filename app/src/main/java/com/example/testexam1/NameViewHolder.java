package com.example.testexam1;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NameViewHolder extends RecyclerView.ViewHolder {

    private ImageView image_item ;
    private TextView textView;
    private TextView tvtime;
    public NameViewHolder(@NonNull View itemView) {
        super(itemView);
        image_item = itemView.findViewById(R.id.img_main);
        textView = itemView.findViewById(R.id.tv_main);
        tvtime = itemView.findViewById(R.id.tvtime);
    }
    public void setitems(String name , int imageid){
        textView.setText(name);
        image_item.setImageResource(imageid);


        tvtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(view.getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourofday, int minute) {

                    }
                },23,01,true);
                timePickerDialog.show();
            }
        });
    }
}
