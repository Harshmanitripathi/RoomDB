package com.example.roomdbcrud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.DialogTitle;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.nio.channels.AsynchronousChannelGroup;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void insertSingleTodo(View view) {
        Todo todo = new Todo("Park is fun",true);
        InsertTodo insertTodo = new InsertTodo();
        insertTodo.execute(todo);
    }

    public void getAllTodos(View view) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                List<Todo> todo = MyRoomDatabase.getInstance(getApplicationContext())
                        .userDao()
                        .getTheTodos();
                Log.d(TAG,todo.toString());
            }

        });
        thread.start();
    }
    public void insertAllTodo(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Todo> todoList = new ArrayList<>();
                Todo todo1 = new Todo("Football", true);
                Todo todo2 = new Todo("BasketBall", true);
                Todo todo3 = new Todo("Cricket", true);
                Todo todo4 = new Todo("Vollyball", false);
                Todo todo5 = new Todo("billiards", false);
                todoList.add(todo1);
                todoList.add(todo2);
                todoList.add(todo3);
                todoList.add(todo4);
                todoList.add(todo5);
                MyRoomDatabase.getInstance(getApplicationContext())
                        .userDao()
                        .insertAllTodo(todoList);
                Log.d(TAG,"Inserted All Todo List...");
            }
        }).start();
    }

    public void updateMultipleTodo(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Todo todo = MyRoomDatabase.getInstance(getApplicationContext())
                        .userDao()
                        .findTodoById(2);
                if (todo != null) {
                    todo.setCompleted(false);
                    MyRoomDatabase.getInstance(getApplicationContext())
                            .userDao()
                            .updateTodo(todo);
                }
            }
        }).start();
    }

    public void deleteSingleTodo(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Todo todo = MyRoomDatabase.getInstance(getApplicationContext())
                        .userDao()
                        .findTodoById(1);
                if (todo != null) {
                    MyRoomDatabase.getInstance(getApplicationContext())
                            .userDao()
                            .deleteTodo(todo);
                }
            }
        }).start();
    }

    public void findCompletedTodo(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Todo> todoList = MyRoomDatabase.getInstance(getApplicationContext())
                        .userDao()
                        .isCompleted();
                Log.d(TAG,todoList.toString());
            }
        }).start();
    }

    class InsertTodo extends AsyncTask<Todo, Void, Void> {
        @Override
        protected Void doInBackground(Todo... todo) {
            MyRoomDatabase.getInstance(getApplicationContext())
                    .userDao()
                    .insertTodo(todo[0]);

            return null;
        }
    }
}