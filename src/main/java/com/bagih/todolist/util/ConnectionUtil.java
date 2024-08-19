package com.bagih.todolist.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionUtil {
    private static HikariDataSource hikariDataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/sk_todolist_db");
        config.setUsername("root");
        config.setPassword("mysql");

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(60_000);
        config.setMaxLifetime(10 * 60_000);

        hikariDataSource = new HikariDataSource(config);
    }

    public static HikariDataSource getDataSource(){
        return hikariDataSource;
    }
}
