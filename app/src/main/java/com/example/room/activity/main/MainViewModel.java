package com.example.room.activity.main;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import com.example.room.db.DbRepository;
import com.example.room.db.entity.Student;

public class MainViewModel extends AndroidViewModel implements MainNavigator {

    private DbRepository dbRepository;
    private MainNavigator navigator;

    public MainViewModel(Application context){
        super(context);
        dbRepository=new DbRepository(context);
    }


    @Override
    public void add(Student student) {
        dbRepository.insertUser(student);
    }

    @Override
    public void dlt(Student student) {
        dbRepository.deleteUser(student);
    }

    @Override
    public void update(Student student) {
        dbRepository.updateUser(student);
    }
}
