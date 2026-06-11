package com.example.testexam1;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NameViewHolder extends RecyclerView.ViewHolder {

    private ImageView image_item ;
    private TextView textView;
    private TextView tvdate;
    public NameViewHolder(@NonNull View itemView) {
        super(itemView);
        image_item = itemView.findViewById(R.id.img_main);
        textView = itemView.findViewById(R.id.tv_main);
        tvdate = itemView.findViewById(R.id.tvdate);
    }
    public void setitems(String name , int imageid){
        textView.setText(name);
        image_item.setImageResource(imageid);


        tvdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        Toast.makeText(view.getContext(),"year"+ year + "month"+month+"day"+day,Toast.LENGTH_SHORT).show();
                    }
                },2004,04,04);
                datePickerDialog.show();
            }
        });
    }
}
