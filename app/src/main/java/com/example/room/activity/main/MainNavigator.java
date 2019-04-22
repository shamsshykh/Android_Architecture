package com.example.room.activity.main;

import com.example.room.db.entity.Student;

public interface MainNavigator {

    void add(Student student);
    void dlt(Student student);
    void update(Student student);
}
