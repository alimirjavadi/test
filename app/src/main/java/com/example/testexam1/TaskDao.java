package com.example.testexam1;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TaskDao {
    @Query("SELECT * FROM Task")
    List<Task> getAll();

    @Insert
    void InsertTask(Task task);

    @Delete
    void Delete(Task task);


    @Update
    void update(Task task);
}
