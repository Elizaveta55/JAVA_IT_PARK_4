import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class Main {
    private static final String URL = "jdbc:postgresql://localhost:5432/humanAndAuto";
    private static final String USER = "postgres";
    private static final String PASSWORD = "HighLow11";

    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);

        HumansDao humansDao = new HumanDaoJdbcTemplate(dataSource);

        HumanService humanService = new HumanService(humansDao);

        Human human = Human.builder()
                .age(22)
                .name("Рак высокогорный")
                .build();

        humanService.registerUser(human);
    }
}
