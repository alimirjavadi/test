package com.example.testexam1;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(version = 1, exportSchema = false, entities = {Task.class})
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase appDatabase;

    public static AppDatabase getDatabase(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "app_db").allowMainThreadQueries().build();
        }
        return appDatabase;
    }

    public abstract TaskDao getTaskDao();
}
