package com.example.roomdbcrud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.DialogTitle;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.nio.channels.AsynchronousChannelGroup;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void insertSingleTodo(View view) {
        Todo todo = new Todo("Yesterday we went to park...",true);
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
    }

    public void updateMultipleTodo(View view) {
    }

    public void deleteSingleTodo(View view) {
    }

    public void findCompletedTodo(View view) {
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