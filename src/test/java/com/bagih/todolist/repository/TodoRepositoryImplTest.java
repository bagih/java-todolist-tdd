package com.bagih.todolist.repository;

import com.bagih.todolist.entity.Todo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

public class TodoRepositoryImplTest {


    @Test
    void testAddTodo() {
        TodoRepositoryImpl todoRepository = new TodoRepositoryImpl();
        Todo todo = new Todo("Belajar java");

        Assertions.assertTrue(todoRepository.addTodo(todo));

    }

    @Test
    void testAddTodoFailed() {
        TodoRepositoryImpl todoRepository = new TodoRepositoryImpl();
        Todo todo = new Todo();

        Assertions.assertFalse(todoRepository.addTodo(todo));
    }

    @Test
    void testGetAllTodo() {
        TodoRepositoryImpl todoRepository = new TodoRepositoryImpl();

        Assertions.assertNotEquals(0, todoRepository.getAllTodo().size());
    }

    @Test
    void testGetTodoById() {
        TodoRepositoryImpl todoRepository = new TodoRepositoryImpl();

        Assertions.assertEquals("Belajar java", todoRepository.getTodoById(1).getTodo());
    }

    @Test
    void testGetTodoByIdFailed() {
        TodoRepositoryImpl todoRepository = new TodoRepositoryImpl();

        Assertions.assertNull(todoRepository.getTodoById(100000));
    }

    @Test
    void testRemoveTodo() {
        TodoRepositoryImpl todoRepository = new TodoRepositoryImpl();
        int id = todoRepository.getAllTodo().getLast().getId();

        Assertions.assertTrue(todoRepository.removeTodo(id));
    }

    @Test
    void testRemoveTodoFailed() {
        TodoRepositoryImpl todoRepository = new TodoRepositoryImpl();
        int id = todoRepository.getAllTodo().getLast().getId() + 1;

        Assertions.assertFalse(todoRepository.removeTodo(id));
    }
}
