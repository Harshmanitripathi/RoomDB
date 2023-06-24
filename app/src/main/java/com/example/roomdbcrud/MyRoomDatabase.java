package com.example.roomdbcrud;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {Todo.class}, version = 1)
public abstract class MyRoomDatabase extends RoomDatabase {

    public abstract UserDao userDao();
    private static volatile MyRoomDatabase Instance;

    static MyRoomDatabase getInstance(Context context) {
        if (Instance == null) {
            synchronized (MyRoomDatabase.class) {
                if (Instance == null) {
                    Instance = Room.databaseBuilder(context.getApplicationContext(),MyRoomDatabase.class,"todo_table")
                            .build();
                }
            }
        }
        return Instance;
    }
//    @NonNull
//    @Override
//    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
//        return null;
//    }
//
//    @NonNull
//    @Override
//    protected InvalidationTracker createInvalidationTracker() {
//        return null;
//    }
//
//    @Override
//    public void clearAllTables() {
//
//    }
}
