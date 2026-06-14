package com.example.testexam1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Task> tasks = new ArrayList<>();
    private RecyclerView rv_main ;
    private AdapterTask adapterTask;
    private TaskDao taskDao;

    public static Activity currentActivity;
    @Override
    protected void onResume() {
        super.onResume();
        adapterTask.setTasks( taskDao.getAll());
        currentActivity = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskDao = AppDatabase.getDatabase(this).getTaskDao();

        rv_main = findViewById(R.id.rv_main);
        View btnAddTask = findViewById(R.id.add_task);
        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this , ActivityAddTask.class);
                MainActivity.this.startActivity(intent);
            }
        });

         adapterTask = new AdapterTask(taskDao);

        for (int j = 0 ; j<20 ; j++){
            Task task = new Task("title:"+j , "20pm",false,"");
            tasks.add(task);
        }

        rv_main.setLayoutManager(new LinearLayoutManager(this));
        rv_main.setAdapter(adapterTask);
        adapterTask.setTasks(tasks);
    }
}