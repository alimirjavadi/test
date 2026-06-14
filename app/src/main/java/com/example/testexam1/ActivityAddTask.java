package com.example.testexam1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

public class ActivityAddTask extends AppCompatActivity {

    private TaskDao taskDao;
    private Task task;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        taskDao = AppDatabase.getDatabase(this).getTaskDao();
        AppCompatEditText titleTask = findViewById(R.id.edt_title_task);
        EditText time_task = findViewById(R.id.edt_time_task);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            task = extras.getParcelable("task");
            titleTask.setText(task.title);
            time_task.setText(task.time);
        }

        findViewById(R.id.add_task).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (extras != null) {
                    task.title = titleTask.getText().toString();
                    task.time = time_task.getText().toString();
                    taskDao.update(task);
                    finish();
                } else {
                    Task newTask = new Task(titleTask.getText().toString(), time_task.getText().toString(), false, "");
                    taskDao.InsertTask(newTask);
                    finish();
                }

            }
        });
    }
}
