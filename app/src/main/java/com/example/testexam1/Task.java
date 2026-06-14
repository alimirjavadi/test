package com.example.testexam1;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Task implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name = "title")
    String title ;
    String time;
    boolean status;
    String desc;

    public Task(String title, String time, boolean status, String desc) {
        this.title = title;
        this.time = time;
        this.status = status;
        this.desc = desc;
    }

    protected Task(Parcel in) {
        id = in.readInt();
        title = in.readString();
        time = in.readString();
        status = in.readByte() != 0;
        desc = in.readString();
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(time);
        parcel.writeByte((byte) (status ? 1 : 0));
        parcel.writeString(desc);
    }
}
