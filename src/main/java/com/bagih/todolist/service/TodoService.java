package com.bagih.todolist.service;

public interface TodoService {
    void getAllTodos();

    void addTodo(String todo);

    void removeTodo(int id);

    void getTodoById(int id);
}
