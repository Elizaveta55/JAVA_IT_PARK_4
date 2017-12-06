import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class HumanDaoJdbc implements HumansDao {

    private static final String SQL_FIND_BY_NAME =
            "SELECT * FROM humans WHERE name = ?";

    private static final String SQL_FIND_BY_ID =
            "SELECT * FROM humans WHERE id = ?";

    private static final String SQL_FIND_ALL =
            "SELECT * FROM humans";

    private static final String SQL_DELETE_BY_ID =
            "DELETE FROM humans WHERE id = ?";

    private static final String SQL_UPDATE_BY_ID =
            "UPDATE humans" + " SET name = ?, age = ? WHERE id = ?";

    private static final String SQL_INSERT_USER =
            "INSERT INTO humans(age, name) VALUES (?, ?)";


    private Properties properties;

    private org.springframework.jdbc.core.RowMapper<Human> rowMapper = (resultSet, rowNum) -> {
        Human result = Human.builder()
                .id(resultSet.getLong("id"))
                .age(resultSet.getInt("age"))
                .name(resultSet.getString("name"))
                .build();

        return result;
    };

    public HumanDaoJdbc(DataSource dataSource) {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("application.properties"));
        } catch (IOException e){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Human findOneByName(String name){
        Human thatHuman;
        try {
            Connection connection = DriverManager.getConnection(properties.getProperty("database.url"), properties.getProperty("database.username"), properties.getProperty("database.password"));
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_FIND_BY_NAME);
            if (resultSet != null) {
                Long id = resultSet.getLong("id");
                int age = resultSet.getInt("age");
                thatHuman = new Human(id, age, name);
                return thatHuman;
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return null;
    }

    @Override
    public void save(Human model) {
        try {
            Connection connection = DriverManager.getConnection(properties.getProperty("database.url"), properties.getProperty("database.username"), properties.getProperty("database.password"));
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_USER);
//            preparedStatement.setLong(0, model.getId());
            preparedStatement.setInt(1, model.getAge());
            preparedStatement.setString(2, model.getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Human find(Long id) {
        Human thatHuman;
        try {
            Connection connection = DriverManager.getConnection(properties.getProperty("database.url"), properties.getProperty("database.username"), properties.getProperty("database.password"));
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_FIND_BY_ID);
            if (resultSet != null) {
                int age = resultSet.getInt("age");
                String name = resultSet.getString("name");
                thatHuman = new Human(id, age, name);
                return thatHuman;
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return null;
    }

    @Override
    public void update(Human model) {
        try {
            Connection connection = DriverManager.getConnection(properties.getProperty("database.url"), properties.getProperty("database.username"), properties.getProperty("database.password"));
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_BY_ID);
            preparedStatement.setString(1, model.getName());
            preparedStatement.setInt(2, model.getAge());
            preparedStatement.setLong(3, model.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            Connection connection = DriverManager.getConnection(properties.getProperty("database.url"), properties.getProperty("database.username"), properties.getProperty("database.password"));
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_BY_ID);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new IllegalArgumentException();
        }
   }

    @Override
    public List<Human> findAll() {
        List<Human> humans = null;
        try {
            Connection connection = DriverManager.getConnection(properties.getProperty("database.url"), properties.getProperty("database.username"), properties.getProperty("database.password"));
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL);
            int i=0;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int age = resultSet.getInt("age");
                String name = resultSet.getString("name");
//                humans = new Human(id, age, name);
                i++;
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return humans;
    }

}
