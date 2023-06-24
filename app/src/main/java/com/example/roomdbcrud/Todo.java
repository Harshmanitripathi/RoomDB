package com.example.roomdbcrud;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "todo_table")
public class Todo {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "_task")
    public String task;

    @ColumnInfo(name = "_completed")
    public boolean completed;

    public Todo(String task, boolean completed) {
        this.task = task;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "\nTodo{" +
                "uid=" + id +
                ", text='" + task + '\'' +
                ", completed=" + completed +
                '}';
    }
}
