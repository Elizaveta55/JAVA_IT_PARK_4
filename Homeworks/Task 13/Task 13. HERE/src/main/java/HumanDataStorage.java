import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class HumanDataStorage {


    private static final String URL = "jdbc:postgresql://localhost:5432/humans";
    private static final String USER = "postgres";
    private static final String PASSWORD = "HighLow11";

    private static final String SQL_INSERT_USER =
            "INSERT INTO humans(age, height, name) VALUES (?, ?, ?)";

    private static final String SQL_FIND_BY_ID =
            "SELECT * FROM humans WHERE id = ?";

    private static final String SQL_FILTER_age_LESS_20 =
            "SELECT * FROM humans WHERE age < 20";

    private static final String SQL_FILTER_height_MORE_165 =
            "SELECT * FROM humans WHERE HEIGHT > 165";


    public HumanDataStorage(DataSource dataSource){
    }


    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);
//        JdbcTemplate template = new JdbcTemplate(dataSource);
    }

}
