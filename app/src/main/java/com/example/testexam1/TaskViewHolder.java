package com.example.testexam1;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskViewHolder extends RecyclerView.ViewHolder {

    private ImageView checked_task ;
    private TextView title_task;
    private TextView time_task;
    private LinearLayout root_element;
    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);
        checked_task = itemView.findViewById(R.id.checked_task);
        title_task = itemView.findViewById(R.id.title_task);
        time_task = itemView.findViewById(R.id.time_task);
        root_element = itemView.findViewById(R.id.root_element);
    }
    public LinearLayout getRoot_element(){
        return root_element;
    }
    public void setitems(String title , String time , boolean checked){
        title_task.setText(title);
        time_task.setText(time);
        if (checked){
            checked_task.setVisibility(View.VISIBLE);
        }else {
            checked_task.setVisibility(View.GONE);
        }

    }
}