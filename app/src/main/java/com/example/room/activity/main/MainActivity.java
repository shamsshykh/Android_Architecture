package com.example.room.activity.main;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.room.R;
import com.example.room.db.entity.Student;
import com.example.room.retrofit.ApiService;
import com.example.room.retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private String TAG=this.getClass().getSimpleName();
    EditText name,fname,batch;
    private MainViewModel model;
    private MainNavigator navigator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        fname=findViewById(R.id.f_name);
        batch=findViewById(R.id.batch);
        model=ViewModelProviders.of(this).get(MainViewModel.class);
        navigator=(MainNavigator) getApplication();
    }

    public void add(View view) {
        Student student=new Student(name.getText().toString(),fname.getText().toString(),batch.getText().toString());
        navigator.add(student);

    }


    public void update(View view) {
        Student student=new Student();
        student.set_id(5);
        student.setName(name.getText().toString());
        student.setF_name(fname.getText().toString());
        student.setBatch(batch.getText().toString());
        navigator.update(student);
    }

    public void dlt(View view) {
        Student student=new Student();
        student.set_id(6);
        navigator.dlt(student);
    }
}
