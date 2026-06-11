package com.example.testexam1;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
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

    private ImageView image_item;
    private TextView textView;
    private TextView dialogsimple;

    public NameViewHolder(@NonNull View itemView) {
        super(itemView);
        image_item = itemView.findViewById(R.id.img_main);
        textView = itemView.findViewById(R.id.tv_main);
        dialogsimple = itemView.findViewById(R.id.dialogsimple);
    }

    public void setitems(String name, int imageid) {
        textView.setText(name);
        image_item.setImageResource(imageid);
        dialogsimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(view.getContext());
                dialog.setContentView(R.layout.dialog_layout);
                TextView btn_yes = dialog.findViewById(R.id.Yesbtn);
                TextView btn_no = dialog.findViewById(R.id.Nobtn);
                dialog.show();
                btn_yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(view.getContext(), "You Click on YES", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                btn_no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(view.getContext(), "You Click on NO", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
            }
        });
    }

}
