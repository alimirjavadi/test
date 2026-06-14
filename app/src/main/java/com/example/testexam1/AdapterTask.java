package com.example.testexam1;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterTask extends RecyclerView.Adapter<TaskViewHolder> {

    private TaskDao taskDao;
    public AdapterTask(TaskDao dao) {
        taskDao = dao;
    }

    private List<Task> tasks;

    public void setTasks(List<Task> inputTasks) {
        tasks = inputTasks;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_main_item, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.setitems(tasks.get(position).title.toString(), tasks.get(position).time.toString(), tasks.get(position).status);

        holder.getRoot_element().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                taskDao.Delete(tasks.get(holder.getAdapterPosition()));
                tasks.remove(tasks.get(holder.getAdapterPosition()));
                notifyItemRemoved(holder.getAdapterPosition());
                return false;
            }
        });

        holder.getRoot_element().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.currentActivity , ActivityAddTask.class);
                intent.putExtra("task", tasks.get(holder.getAdapterPosition()));
                MainActivity.currentActivity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }
}