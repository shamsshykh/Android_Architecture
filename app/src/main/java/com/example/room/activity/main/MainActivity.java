package com.example.room.activity.main;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.room.R;
import com.example.room.activity.base.BaseActivity;
import com.example.room.db.entity.Student;
import com.example.room.retrofit.RetrofitClient;

public class MainActivity extends BaseActivity {
    private String TAG=this.getClass().getSimpleName();
    EditText name,fname,batch;
    private MainViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        fname=findViewById(R.id.f_name);
        batch=findViewById(R.id.batch);
        model=ViewModelProviders.of(this).get(MainViewModel.class);
    }

    public void add(View view) {
        Student student=new Student(name.getText().toString(),fname.getText().toString(),batch.getText().toString());
        model.add(student);

    }


    public void update(View view) {
        Student student=new Student();
        student.set_id(5);
        student.setName(name.getText().toString());
        student.setF_name(fname.getText().toString());
        student.setBatch(batch.getText().toString());
        model.update(student);
    }

    public void dlt(View view) {
        Student student=new Student();
        student.set_id(6);
        model.dlt(student);
    }


    public void getAllStudent(){
        model.getListOfStudent().observe(this,students -> {
            Toast.makeText(this, ""+students, Toast.LENGTH_SHORT).show();
        });
    }

    public void getall(View view) {
        getAllStudent();
    }
}
