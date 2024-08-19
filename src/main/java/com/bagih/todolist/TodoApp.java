package com.bagih.todolist;

import com.bagih.todolist.repository.TodoRepositoryImpl;
import com.bagih.todolist.repository.TodoRepostory;
import com.bagih.todolist.service.TodoService;
import com.bagih.todolist.service.TodoServiceImpl;
import com.bagih.todolist.view.TodoView;

public class TodoApp {
    public static void main(String[] args) {
        TodoRepostory todoRepostory = new TodoRepositoryImpl();
        TodoService todoService = new TodoServiceImpl(todoRepostory);
        TodoView todoView = new TodoView(todoService);

        while (true){
            todoView.mainMenu();
        }
    }
}
