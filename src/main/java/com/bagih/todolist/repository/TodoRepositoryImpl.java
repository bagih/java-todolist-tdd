package com.bagih.todolist.repository;

import com.bagih.todolist.entity.Todo;
import com.bagih.todolist.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoRepositoryImpl implements TodoRepostory{


    @Override
    public List<Todo> getAllTodo() {
        String sql = "SELECT * FROM todos";
        List<Todo> todoList = new ArrayList<>();

        try(Connection connection = ConnectionUtil.getDataSource().getConnection();
            Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                todoList.add(new Todo(resultSet.getString("todo"), resultSet.getInt("id")));
            }
            resultSet.close();
            return todoList;
        } catch (SQLException e) {
            return List.of();
        }
    }

    @Override
    public Todo getTodoById(int id) {
        String sql = "SELECT * FROM todos WHERE id = ?";
        try(Connection connection = ConnectionUtil.getDataSource().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return new Todo(resultSet.getString("todo"), resultSet.getInt("id"));
            }
            resultSet.close();
            return null;
        } catch (SQLException e){
            return null;
        }
    }

    @Override
    public boolean addTodo(Todo todo) {
        String sql = "INSERT INTO todos(todo) VALUES(?)";
        try(Connection connection = ConnectionUtil.getDataSource().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, todo.getTodo());

            int result = statement.executeUpdate();
            return result != 0;

        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean removeTodo(int id) {
        String sql = "DELETE FROM todos WHERE id = ?";

        try(Connection connection = ConnectionUtil.getDataSource().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            int result = statement.executeUpdate();

            return result != 0;

        } catch (SQLException e) {
            return false;
        }
    }
}
