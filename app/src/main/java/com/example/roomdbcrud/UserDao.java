package com.example.roomdbcrud;

import static android.icu.text.MessagePattern.ArgType.SELECT;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insertTodo(Todo todo);

    @Query("SELECT * FROM todo_table")
    List<Todo> getTheTodos();

    @Query("SELECT * FROM todo_table WHERE id = :uid")
    Todo findTodoById(int uid);

    @Delete
    void deleteTodo(Todo todo);

    @Update
    void updateTodo(Todo todo);

    @Insert
    void insertAllTodo(List<Todo> todoList);

    @Query("SELECT * FROM todo_table WHERE completed = 1")
    List<Todo> isCompleted();

}
