package com.bagih.todolist.util;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtilTest {
    @Test
    void testGetDataSource() {
        try(Connection connection = ConnectionUtil.getDataSource().getConnection()){
            System.out.println("sukses membuat connection");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
