package com.example.room.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.Cursor;

import com.example.room.db.entity.Student;
import com.example.room.db.entity.Teachers;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public  interface AppDao {

    @Insert(onConflict = REPLACE)  // onConflict replace the the data when kuch bh happend in inserting
    void insertUserQuery(Student userModel);  // mean trigger insert query

    @Update
    void updateUserQuery(Student userModel); // mean trigger Update query

    @Delete
    void dltUserQuery(Student id); // mean trigger Delete query

    @Query("DELETE from student")
    void dltAllStudentQuery();

    @Query("Select * from student")
    LiveData<List<Student>> getAllStudentQuery();

    @Query("SELECT * FROM student WHERE _id=:id")
    Student getteacherByID(int id);

    @Query("SELECT * FROM student WHERE name=:name LIMIT :max")
    List<Student> getReposByName(int max, String... name);

}
