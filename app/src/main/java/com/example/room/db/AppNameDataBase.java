package com.example.room.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.room.utils.Constants;
import com.example.room.db.entity.Student;
import com.example.room.db.entity.Teachers;


// entities mean table off database
@Database(entities = {Student.class, Teachers.class}, version = 1 , exportSchema = false)
public abstract class AppNameDataBase extends RoomDatabase {

    abstract AppDao appDao();
    private static AppNameDataBase instance;
    private static Context context;

    /**
     * Create SingleTon class with activityContext
     */
    static synchronized AppNameDataBase getInstance(Context activityContext) {
        context = activityContext;
        if (instance == null) {
            instance = buildDatabaseInstance(context);
        }
        return instance;
    }


    /**
     * Create SingleTon class with Existing activityContext
     */
    public static synchronized AppNameDataBase getInstance() {
        if (null == instance) {
            instance = buildDatabaseInstance(context);
        }
        return instance;
    }

    /**
     * Create Database here
     */
    private static AppNameDataBase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context, AppNameDataBase.class, Constants.DB_NAME)
          //      .allowMainThreadQueries() // allow you to execute Db operation on MainThread. BTW it not a good approch
                .fallbackToDestructiveMigration() // Migrate to the new schema when change the build version of DB it will dlt over db and create new illegal Schema Exception
                .build();
    }


    public void cleanUp(){
        instance = null;
    }

}


