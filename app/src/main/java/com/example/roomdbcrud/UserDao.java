package com.example.roomdbcrud;

import static android.icu.text.MessagePattern.ArgType.SELECT;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insertTodo(Todo todo);

    @Query("SELECT * FROM todo_table")
    List<Todo> getTheTodos();


}
