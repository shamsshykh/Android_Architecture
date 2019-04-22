package com.example.room.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "teachersInfo")
public class Teachers {

    @PrimaryKey(autoGenerate = true)
    public int _id;
    @ColumnInfo(name = "student_name") // now column will be "user_name"
    public String name;
    public String f_name;
    public String classess;
}
