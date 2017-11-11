package com.company;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Main {
    private static final String URL = "jdbc:postgresql://localhost:5432/try";
    private static final String USER = "postgres";
    private static final String PASSWORD = "HighLow11";

    private static final String SQL_INSERT_USER = "INSERT INTO users (id_user, name, age) VALUES (?, ?, ?)";

    private static final String SQL_SELECT_ALL = "SELECT * FROM owner";

    private static final String SQL_FIND_BY_ID = "SELECT * FROM owner WHERE id = ?";

    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);

        JdbcTemplate template = new JdbcTemplate(dataSource);

        //template.update(SQL_INSERT_USER, 4, "Nick", 23);
        template.update(SQL_INSERT_USER, 5, "Получилось!", 23);

    }
}
