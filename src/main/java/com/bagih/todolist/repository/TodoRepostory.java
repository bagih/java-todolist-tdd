package com.bagih.todolist.repository;

import com.bagih.todolist.entity.Todo;

import java.util.List;

public interface TodoRepostory {
    List<Todo> getAllTodo();

    Todo getTodoById(int id);

    boolean addTodo(Todo todo);

    boolean removeTodo(int id);

}
