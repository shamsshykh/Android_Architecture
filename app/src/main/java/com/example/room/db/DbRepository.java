package com.example.room.db;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.example.room.db.entity.Student;
import com.example.room.db.entity.Teachers;

import java.util.List;

public class DbRepository extends AndroidViewModel {
    private AppDao appDao;

    public DbRepository(Application context){
        super(context);
        AppNameDataBase.getInstance(context).appDao();
        AppNameDataBase dataBase=AppNameDataBase.getInstance(context);
        appDao = dataBase.appDao();
    }

    public void insertUser(Student student){
        new InsertAsyncTask(appDao).execute(student);
    }

    public void updateUser(Student student){
        new UpdateAsyncTask(appDao).execute(student);
    }

    public void deleteUser(Student id){
        new DeleteAsyncTask(appDao).execute(id);
    }


    private static class InsertAsyncTask extends AsyncTask<Student,Void,Void> {
        AppDao mAsyncTaskDao;
        private InsertAsyncTask(AppDao appDao) {
            this.mAsyncTaskDao=appDao;
        }


        @Override
        protected Void doInBackground(Student... students) {
            mAsyncTaskDao.insertUserQuery(students[0]);
            return null;
        }
    }

    private static class UpdateAsyncTask extends AsyncTask<Student,Void,Void> {
        AppDao mAsyncTaskDao;

        public UpdateAsyncTask(AppDao appDao) {
            this.mAsyncTaskDao=appDao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            mAsyncTaskDao.updateUserQuery(students[0]);
            return null;
        }
    }

    private static class DeleteAsyncTask extends AsyncTask<Student,Void,Void> {
        AppDao mAsyncTaskDao;

        private DeleteAsyncTask(AppDao appDao) {
            this.mAsyncTaskDao=appDao;
        }


        @Override
        protected Void doInBackground(Student... integers) {
            mAsyncTaskDao.dltUserQuery(integers[0]);
            return null;
        }
    }








}
