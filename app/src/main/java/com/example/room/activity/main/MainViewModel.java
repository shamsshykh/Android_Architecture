package com.example.room.activity.main;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.room.db.DbRepository;
import com.example.room.db.entity.Student;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private DbRepository dbRepository;
    private LiveData<List<Student>> listOfStudent;

    public MainViewModel(Application context){
        super(context);
        dbRepository=new DbRepository(context);
        listOfStudent=dbRepository.getAllStudents();
    }


    void add(Student student) {
        dbRepository.insertUser(student);
    }

    void dlt(Student student) {
        dbRepository.deleteUser(student);
    }

    void update(Student student) {
        dbRepository.updateUser(student);
    }

    LiveData<List<Student>> getListOfStudent(){
        return listOfStudent;
    }
}
