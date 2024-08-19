package com.bagih.todolist.service;

import com.bagih.todolist.entity.Todo;
import com.bagih.todolist.repository.TodoRepostory;

import java.util.List;

public class TodoServiceImpl implements TodoService{
    private TodoRepostory todoRepostory;

    public TodoServiceImpl(TodoRepostory todoRepostory) {
        this.todoRepostory = todoRepostory;
    }

    @Override
    public void getAllTodos() {
        List<Todo> todos = todoRepostory.getAllTodo();
        System.out.println("\n===========ALL TODOS==========");
//        for (int i = 0; i < todos.toArray().length; i++) {
//            System.out.printf("%d. %s%n", i, todos.get(i).getTodo());
//        }
        todos.forEach(todo -> {
            System.out.printf("%d. %s%n", todo.getId(), todo.getTodo());
        });
        System.out.println("===========END TODO===========\n");
    }

    @Override
    public void addTodo(String todo) {
        boolean isSuccess = todoRepostory.addTodo(new Todo(todo));
        if(isSuccess) {
            System.out.println("Todo successfully added");
        } else {
            System.out.println("failed to add todo");
        }

    }

    @Override
    public void removeTodo(int id) {
        boolean isSuccess = todoRepostory.removeTodo(id);
        if(isSuccess) {
            System.out.println("Todo successfully removed");
        } else {
            System.out.println("failed to remove todo");
        }
    }

    @Override
    public void getTodoById(int id) {
        Todo todoFounded = todoRepostory.getTodoById(id);
        if (todoFounded == null){
            System.out.println("Todo not found");
        } else {
            System.out.println(todoFounded.getTodo());
        }
    }
}
