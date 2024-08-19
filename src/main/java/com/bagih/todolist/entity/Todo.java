package com.bagih.todolist.entity;

public class Todo {
    private String todo;
    private Integer id;

    public Todo() {
    }

    public Todo(String todo, Integer id) {
        this.todo = todo;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Todo(String todo) {
        this.todo = todo;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }
}
