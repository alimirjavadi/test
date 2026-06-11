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
    private TextView moretext;
    private TextView tvtime;
    public NameViewHolder(@NonNull View itemView) {
        super(itemView);
        image_item = itemView.findViewById(R.id.img_main);
        textView = itemView.findViewById(R.id.tv_main);
        moretext = itemView.findViewById(R.id.tvmore);
        tvtime = itemView.findViewById(R.id.tvtime);
    }
    public void setitems(String name , int imageid){
        textView.setText(name);
        image_item.setImageResource(imageid);

        moretext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertdialog = new AlertDialog.Builder(view.getContext());
                alertdialog.setTitle("some title from android");
                alertdialog.setMessage("some message from android");

                alertdialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                alertdialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                alertdialog.setCancelable(false);
                alertdialog.show();
            }
        });

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
